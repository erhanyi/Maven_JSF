package com.erhan.dao;

import com.erhan.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author erhan
 */
public abstract class TemelDao {
    
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public void kaydetObje(Object object) {
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void kaydetVeyaGuncelleObje(Object object) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void silObje(Object object) {
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void kaydetObjeList(List<Object> objectList) {
        try {
            session.beginTransaction();
            objectList.forEach((object) -> {
                session.save(object);
            });
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void kaydetVeyaGuncelleObjeList(List<Object> objectList) {
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

    public <T> T getirObje(Class<T> c, String id) {
        T result;
        try {
            result = c.cast(session.get(c, id));
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return result;
    }
}
