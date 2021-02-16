package com.iot.model.dao.implementation;


import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Song;
import com.iot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDAO implements GeneralDAO<Song> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Song> findAll() {
        List<Song> songs = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            songs = session.createQuery("from Song").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

    @Override
    public Song findOne(Integer id) throws SQLException {
        Song song = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            song = session.get(Song.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return song;
    }

    @Override
    public void create(Song song) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(song);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  Song song) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(song);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Song song = session.get(Song.class, id);
            if (song != null) {
                session.delete(song);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
