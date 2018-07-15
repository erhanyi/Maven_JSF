package com.erhan.dao;

import com.erhan.model.DersPuan;
import com.erhan.model.Kullanici;
import com.erhan.model.Okulders;
import com.erhan.model.Puan;
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
            puanList = session.createSQLQuery("SELECT * FROM OKUL O, okulders OD, "
                    + " okulsinav OS LEFT JOIN sinavpuan SP ON SP.OKULSINAVID=OS.OKULSINAVID, sinav S "
                    + " WHERE O.okulid=OD.okul "
                    + " AND O.okulid= " + okulId
                    + " AND OS.OKUL=O.okulid "
                    + " AND S.SINAVID=OS.SINAVID")
                    .addScalar("okulid", StandardBasicTypes.INTEGER)
                    .addScalar("okuladi", StandardBasicTypes.STRING)
                    .addScalar("DERSID", StandardBasicTypes.INTEGER)
                    .addScalar("DERSADI", StandardBasicTypes.STRING)
                    .addScalar("OKULSINAVID", StandardBasicTypes.INTEGER)
                    .addScalar("SINAVID", StandardBasicTypes.INTEGER)
                    .addScalar("SINAVPUANID", StandardBasicTypes.INTEGER)
                    .addScalar("PUAN", StandardBasicTypes.BIG_DECIMAL)
                    .addScalar("SINAVADI", StandardBasicTypes.STRING)
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

}
