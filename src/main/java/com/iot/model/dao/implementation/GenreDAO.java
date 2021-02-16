package com.iot.model.dao.implementation;

import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Genre;
import com.iot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements GeneralDAO<Genre> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            genres = session.createQuery("from Genre").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genres;
    }

    @Override
    public Genre findOne(Integer id) throws SQLException {
        Genre genre = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            genre = session.get(Genre.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genre;
    }

    @Override
    public void create(Genre genre) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  Genre genre) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(genre);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Genre genre = session.get(Genre.class, id);
            if (genre != null) {
                session.delete(genre);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}