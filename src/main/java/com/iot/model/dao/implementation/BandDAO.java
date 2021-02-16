package com.iot.model.dao.implementation;


import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Band;
import com.iot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BandDAO implements GeneralDAO<Band> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Band> findAll() {
        List<Band> bands = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            bands = session.createQuery("from Band").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bands;
    }

    @Override
    public Band findOne(Integer id) throws SQLException {
        Band band = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            band = session.get(Band.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return band;
    }

    @Override
    public void create(Band band) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(band);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  Band band) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(band);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Band band = session.get(Band.class, id);
            if (band != null) {
                session.delete(band);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
