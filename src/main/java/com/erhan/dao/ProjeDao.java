package com.erhan.dao;

import com.erhan.model.DersPuan;
import com.erhan.model.Kullanici;
import com.erhan.model.Okulders;
import com.erhan.model.Puan;
import com.erhan.model.Sinavpuan;
import com.erhan.util.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

/**
 *
 * @author erhan
 */
@Stateless
public class ProjeDao extends TemelDao {

    //private final Session session = HibernateUtil.getSessionFactory().openSession(); 
    public Kullanici getirKullaniciIdyeGore(Integer kullaniciId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Kullanici result;
        try {
            result = (Kullanici) session.getNamedQuery("Kullanici.findByKullaniciid")
                    .setParameter("kullaniciid", kullaniciId)
                    .uniqueResult();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public Kullanici getirKullaniciArabaListesi(Integer kullaniciId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Kullanici result;
        try {
            result = (Kullanici) session.createQuery("SELECT k FROM Kullanici k JOIN FETCH k.arabaListesi h WHERE k.kullaniciid = :kullaniciid and h.arabamarka='HONDA'")
                    .setParameter("kullaniciid", kullaniciId)
                    .uniqueResult();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public List<Puan> getirPuanListesi(Integer okulId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Puan> puanList;
        try {
            puanList = session.createSQLQuery("SELECT aa.DERSID, aa.DERSADI, aa.SINAVID, aa.SINAVADI, aa.OKULSINAVID, sp.SINAVPUANID, sp.PUAN FROM ( SELECT od.DERSID, od.DERSADI, s.SINAVID, s.SINAVADI, os.OKULSINAVID FROM okulders OD, okulsinav OS, sinav S WHERE Os.okul = OD.okul AND Os.okul = "+okulId+" AND S.SINAVID = OS.SINAVID ) aa LEFT JOIN sinavpuan sp ON aa.okulsinavid = sp.OKULSINAVID AND aa.dersadi = sp.DERS")
                    .addScalar("dersid", StandardBasicTypes.INTEGER)
                    .addScalar("dersadi", StandardBasicTypes.STRING)
                    .addScalar("sinavid", StandardBasicTypes.INTEGER)
                    .addScalar("sinavadi", StandardBasicTypes.STRING)
                    .addScalar("okulsinavid", StandardBasicTypes.INTEGER)
                    .addScalar("sinavpuanid", StandardBasicTypes.INTEGER)
                    .addScalar("puan", StandardBasicTypes.BIG_DECIMAL)
                    .setResultTransformer(Transformers.aliasToBean(Puan.class)).list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return puanList;
    }

    public List<Okulders> getirDersListesi(Integer okulId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Okulders> resultList;
        try {
            resultList = session.getNamedQuery("Okulders.findByOkul")
                    .setParameter("okul", okulId).list();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return resultList;
    }

    public List<DersPuan> getirDersSinavPuanListesi(Integer okulId, Integer dersId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<DersPuan> dersPuanList;
        try {
            dersPuanList = session.createSQLQuery("select s.SINAVID, s.SINAVADI, os.OKULSINAVID, "
                    + " sp.SINAVPUANID, sp.PUAN from sinav s, "
                    + " okulsinav os LEFT JOIN sinavpuan sp "
                    + " on os.OKULSINAVID=sp.OKULSINAVID and sp.DERS= " + dersId
                    + " where s.SINAVID=os.SINAVID and os.OKUL=" + okulId + "")
                    .addScalar("sinavid", StandardBasicTypes.INTEGER)
                    .addScalar("sinavadi", StandardBasicTypes.STRING)
                    .addScalar("okulsinavid", StandardBasicTypes.INTEGER)
                    .addScalar("sinavpuanid", StandardBasicTypes.INTEGER)
                    .addScalar("puan", StandardBasicTypes.BIG_DECIMAL)
                    .setResultTransformer(Transformers.aliasToBean(DersPuan.class)).list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return dersPuanList;
    }
    
    public void kaydetVeyaGuncelleSinavPuanList(List<Sinavpuan> objectList) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            objectList.forEach((object) -> {
                session.saveOrUpdate(object);
            });
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
