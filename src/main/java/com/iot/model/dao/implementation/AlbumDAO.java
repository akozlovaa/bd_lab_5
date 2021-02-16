package com.iot.model.dao.implementation;


import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Album;
import com.iot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO implements GeneralDAO<Album> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Album> findAll() {
        List<Album> albums = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            albums = session.createQuery("from Album").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albums;
    }

    @Override
    public Album findOne(Integer id) throws SQLException {
        Album album = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            album = session.get(Album.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public void create(Album album) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(album);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  Album album) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(album);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Album album = session.get(Album.class, id);
            if (album != null) {
                session.delete(album);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}