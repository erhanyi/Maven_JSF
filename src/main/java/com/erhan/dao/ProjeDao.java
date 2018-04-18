package com.erhan.dao;

import com.erhan.model.Kullanici;
import com.erhan.util.HibernateUtil;
import javax.ejb.Stateless;
import org.hibernate.Session;

/**
 *
 * @author erhan
 */
@Stateless
public class ProjeDao extends TemelDao{
   
   public Kullanici getirKullaniciTCyeGore(String tckimlikno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Kullanici result;
        try {
            result = (Kullanici) session.createQuery("from Kullanici k where k.tckimlikno=:tckimlikno")
                    .setParameter("tckimlikno", tckimlikno)
                    .uniqueResult();
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
