package com.iot.view;

import com.iot.controller.*;
import com.iot.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class View {
    private  final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private final AlbumController albumController = new AlbumController();
    private final BandController bandController = new BandController();
    private final ArtistController artistController = new ArtistController();
  private final SongController songController = new SongController();
    private final LabelController labelController  = new LabelController();
    private final GenreController genreController= new GenreController();
//
    public View() throws SQLException {
        //CHOOSE
        menu.put("11", this::getAllAlbums);
        menu.put("12", this::getAlbumByID);
        menu.put("13", this::createAlbum);
        menu.put("14", this::updateAlbum);
        menu.put("15", this::deleteAlbum);
        menu.put("21", this::getAllArtists);
        menu.put("22", this::getArtistByID);
        menu.put("23", this::createArtist);
        menu.put("24", this::updateArtist);
        menu.put("25", this::deleteArtist);
        menu.put("31", this::getAllBands);
        menu.put("32", this::getBandByID);
        menu.put("33", this::createBand);
        menu.put("34", this::updateBand);
        menu.put("35", this::deleteBand);
        menu.put("41", this::getAllGenres);
        menu.put("42", this::getGenreByID);
        menu.put("43", this::createGenre);
        menu.put("44", this::updateGenre);
        menu.put("45", this::deleteGenre);
        menu.put("51", this::getAllLabels);
        menu.put("52", this::getLabelByID);
        menu.put("53", this::createLabel);
        menu.put("54", this::updateLabel);
        menu.put("55", this::deleteLabel);
        menu.put("61", this::getAllSongs);
        menu.put("62", this::getSongByID);
        menu.put("63", this::createSong);
        menu.put("64", this::updateSong);
        menu.put("65", this::deleteSong);

    }
    //-----------------------------------------------
//                Albums
// ----------------------------------------------
    private void getAllAlbums() throws SQLException {
        System.out.println("\n--Getting all albums--");
        System.out.println(albumController.findAll() + "\n");
    }

    private void getAlbumByID() throws SQLException {
        System.out.println("\n--Getting specific album.Enter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(albumController.findOne(id) + "\n");
    }


    private Album getAlbumInputs() throws SQLException {
        System.out.println("\nEnter artist id: ");
        Integer  id = SCANNER.nextInt();
        Artist artist = artistController.findOne(id);
        System.out.println("\nEnter album name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter number of songs: ");
        Integer numberOfSongs = Integer.valueOf(SCANNER.next());
        return new Album(artist,name,numberOfSongs);
    }

    private void createAlbum() throws SQLException {
        System.out.println("\n--Creating album--");
        Album album = getAlbumInputs();
        albumController.create(album);
        System.out.println("--Album created--\n");
    }

    private void updateAlbum() throws SQLException {
        System.out.println("\n--Updating album.Enter id:");
        Integer id = SCANNER.nextInt();
        Album album = getAlbumInputs();
        album.setId(id);

        albumController.update(album.getId(), album);
        System.out.println("Updated album with id=" + id + "\n");
    }

    private void deleteAlbum() throws SQLException {
        System.out.println("\n--Deleting album.Enter id:");
        int id = SCANNER.nextInt();

        albumController.delete(id);
        System.out.println("--Deleted album with id=" + id + "\n");
    }


    //-----------------------------------------------
//                Artists
// ----------------------------------------------
    private void getAllArtists() throws SQLException {
        System.out.println("\n--Getting all artists--");
        System.out.println(artistController.findAll() + "\n");
    }

    private void getArtistByID() throws SQLException {
        System.out.println("\n--Getting specific artist.Enter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(artistController.findOne(id) + "\n");
    }


    private Artist getArtistInputs() throws SQLException {
        System.out.println("\nEnter label id: ");
        Integer  labelId = SCANNER.nextInt();
        Label label = labelController.findOne(labelId);
        System.out.println("\nEnter band id: ");
        Integer  bandId = SCANNER.nextInt();
        Band band = bandController.findOne(bandId);
        System.out.println("\nEnter artist name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter number of monthly listens: ");
        Integer monthlyListens = Integer.valueOf(SCANNER.next());
        System.out.println("\nEnter number of songs: ");
        Integer followers = Integer.valueOf(SCANNER.next());
        return new Artist(label,band,name,monthlyListens,followers);
    }

    private void createArtist() throws SQLException {
        System.out.println("\n--Creating artist--");
        Artist artist = getArtistInputs();
        artistController.create(artist);
        System.out.println("--Artist created--\n");
    }

    private void updateArtist() throws SQLException {
        System.out.println("\n--Updating artist.Enter id:");
        Integer id = SCANNER.nextInt();
        Artist artist = getArtistInputs();
        artist.setId(id);

        artistController.update(artist.getId(), artist);
        System.out.println("Updated artist with id=" + id + "\n");
    }

    private void deleteArtist() throws SQLException {
        System.out.println("\n--Deleting artist.Enter id:");
        int id = SCANNER.nextInt();

        artistController.delete(id);
        System.out.println("--Deleted artist with id=" + id + "\n");
    }

    //--------------------------------------
//                 Band
//---------------------------------------
    private void getAllBands() throws SQLException {
        System.out.println("\n--Getting all bands--");
        System.out.println(bandController.findAll() + "\n");
    }

    private void getBandByID() throws SQLException {
        System.out.println("\n--Getting specific band.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(bandController.findOne(id) + "\n");
    }

    private Band getBandInputs() throws SQLException {
        System.out.println("\nEnter band name:");
        String name = SCANNER.next();
        System.out.println("\nEnter number of artists:");
        Integer numOfArtists = Integer.valueOf(SCANNER.next());
        return new Band(name,numOfArtists);
    }
    private void createBand() throws SQLException {
        System.out.println("\n--Creating band--");
        Band band = getBandInputs();
        bandController.create(band);
        System.out.println("--Band created--\n");
    }

    private void updateBand() throws SQLException {
        System.out.println("\n--Updating band.Enter id:");
        Integer id = SCANNER.nextInt();
        Band band = getBandInputs();
        band.setId(id);

        bandController.update(band.getId(), band);
        System.out.println("Updated band with id=" + id + "\n");
    }

    private void deleteBand() throws SQLException {
        System.out.println("\n--Deleting band.Enter id:");
        int id = SCANNER.nextInt();

        bandController.delete(id);
        System.out.println("--Deleted band with id=" + id + "\n");
    }

    //--------------------------------------
//                 Genre
//---------------------------------------
    private void getAllGenres() throws SQLException {
        System.out.println("\n--Getting all genres--");
        System.out.println(genreController.findAll() + "\n");
    }

    private void getGenreByID() throws SQLException {
        System.out.println("\n--Getting specific genre.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(genreController.findOne(id) + "\n");
    }

    private Genre getGenresInputs() throws SQLException {
        System.out.println("\nEnter genre  name:");
        String name = SCANNER.next();
        return new Genre(name);
    }

    private void createGenre() throws SQLException {
        System.out.println("\n--Creating genre--");
        Genre genre = getGenresInputs();
        genreController.create(genre);
        System.out.println("--Genre created--\n");
    }

    private void updateGenre() throws SQLException {
        System.out.println("\n--Updating genre.Enter id:");
        Integer id = SCANNER.nextInt();
        Genre genre = getGenresInputs();
        genre.setId(id);

        genreController.update(genre.getId(), genre);
        System.out.println("Updated genre with id=" + id + "\n");
    }

    private void deleteGenre() throws SQLException {
        System.out.println("\n--Deleting genre.Enter id:");
        int id = SCANNER.nextInt();
        genreController.delete(id);
        System.out.println("--Deleted genre with id=" + id + "\n");

    }
    //--------------------------------------
//                 Label
//---------------------------------------
    private void getAllLabels() throws SQLException {
        System.out.println("\n--Getting all labels--");
        System.out.println(labelController.findAll() + "\n");
    }

    private void getLabelByID() throws SQLException {
        System.out.println("\n--Getting specific label.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(labelController.findOne(id) + "\n");
    }

    private Label getLabelInputs() throws SQLException {
        System.out.println("\nEnter Label name:");
        String name = SCANNER.next();
        return new Label(name);
    }
    private void createLabel() throws SQLException {
        System.out.println("\n--Creating label--");
        Label label = getLabelInputs();
        labelController.create(label);
        System.out.println("--Label created--\n");
    }

    private void updateLabel() throws SQLException {
        System.out.println("\n--Updating label.Enter id:");
        Integer id = SCANNER.nextInt();
        Label label = getLabelInputs();
        label.setId(id);

        labelController.update(label.getId(), label);
        System.out.println("Updated label with id=" + id + "\n");
    }

    private void deleteLabel() throws SQLException {
        System.out.println("\n--Deleting label.Enter id:");
        int id = SCANNER.nextInt();

        labelController.delete(id);
        System.out.println("--Deleted label with id=" + id + "\n");
    }
    //--------------------------------------
//                 Song
//---------------------------------------
    private void getAllSongs() throws SQLException {
        System.out.println("\n--Getting all songs--");
        System.out.println(songController.findAll() + "\n");
    }

    private void getSongByID() throws SQLException {
        System.out.println("\n--Getting specific song.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(songController.findOne(id) + "\n");
    }

    private Song getSongsInputs() throws SQLException {
        System.out.println("\nEnter album id:");
        Integer  albumId = SCANNER.nextInt();
        Album album= albumController.findOne(albumId);
        System.out.println("\nEnter artist id:");
        Integer  artistId = SCANNER.nextInt();
        Artist artist= artistController.findOne(artistId);
        System.out.println("\nEnter genre id:");
        Integer  genreId = SCANNER.nextInt();
        Genre genre= genreController.findOne(genreId);
        System.out.println("\nEnter name of song:");
        String name = SCANNER.next();
        System.out.println("\nEnter duration in seconds:");
        Integer durationInSeconds = Integer.valueOf(SCANNER.next());
        return new Song(album,artist, genre,name,durationInSeconds);
    }

    private void createSong() throws SQLException {
        System.out.println("\n--Creating song--");
        Song song = getSongsInputs();
        songController.create(song);
        System.out.println("--Song created--\n");
    }

    private void updateSong() throws SQLException {
        System.out.println("\n--Updating song.Enter id:");
        Integer id = SCANNER.nextInt();
        Song song = getSongsInputs();
        song.setId(id);

        songController.update(song.getId(), song);
        System.out.println("Updated gong with id=" + id + "\n");
    }

    private void deleteSong() throws SQLException {
        System.out.println("\n--Deleting song.Enter id:");
        int id = SCANNER.nextInt();
        songController.delete(id);
        System.out.println("--Deleted song with id=" + id + "\n");
    }
    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nchoose command?:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }
}