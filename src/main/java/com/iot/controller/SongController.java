package com.iot.controller;

import com.iot.model.dao.implementation.SongDAO;
import com.iot.model.entity.Song;

import java.sql.SQLException;
import java.util.List;

public class SongController implements GeneralController<Song> {
    SongDAO dao =new SongDAO();
    @Override
    public List<Song> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Song findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }


    @Override
    public void create(Song entity) throws SQLException {
        dao.create(entity);

    }

    @Override
    public void update(Integer id, Song entity) throws SQLException {
        dao.update(id,entity);

    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}
