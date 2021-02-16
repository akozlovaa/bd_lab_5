package com.iot.model.dao.implementation;


import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Album;
import com.iot.model.entity.Artist;
import com.iot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO implements GeneralDAO<Artist> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Artist> findAll() {
        List<Artist> artists = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            artists = session.createQuery("from Artist").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artists;
    }

    @Override
    public Artist findOne(Integer id) throws SQLException {
        Artist artist = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            artist = session.get(Artist.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artist;
    }

    @Override
    public void create(Artist artist) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(artist);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  Artist artist) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(artist);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Artist artist = session.get(Artist.class, id);
            if (artist != null) {
                session.delete(artist);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}