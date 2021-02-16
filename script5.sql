CREATE DATABASE IF NOT EXISTS spotify
CHARACTER SET utf8
COLLATE utf8_general_ci;
USE spotify;


DROP TABLE IF EXISTS Song;
DROP TABLE IF EXISTS Album;
DROP TABLE IF EXISTS Artist;
DROP TABLE IF EXISTS Label;
DROP TABLE IF EXISTS Band;
DROP TABLE IF EXISTS Genre;




CREATE TABLE Label (
	id INT  AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) UNIQUE NOT NULL
)ENGINE = INNODB;
CREATE TABLE Band (
	id INT  AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    num_of_artists INT 
)ENGINE = INNODB;
CREATE TABLE Artist (
	id INT  AUTO_INCREMENT PRIMARY KEY,
    label_id INT,
    band_id INT,
    name VARCHAR(100) NOT NULL,
    monthly_listens INT NOT NULL,
    followers INT NOT NULL
)ENGINE = INNODB;
CREATE TABLE Album (
    id INT AUTO_INCREMENT PRIMARY KEY,
    artist_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    number_of_songs INT NOT NULL
)ENGINE = INNODB;
CREATE TABLE Genre (
	id INT  AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) UNIQUE NOT NULL
)ENGINE = INNODB;
CREATE TABLE Song (
    id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
    album_id INT NOT NULL,
    artist_id INT NOT NULL,
    genre_id INT NOT NULL,
    duration_in_seconds INT NOT NULL
)ENGINE = INNODB;




ALTER TABLE Artist
	ADD CONSTRAINT FK_artist_label
	FOREIGN KEY (label_id)
	REFERENCES Label (id),
    ADD CONSTRAINT FK_artist_band
	FOREIGN KEY (band_id)
	REFERENCES Band(id);
ALTER TABLE Album
	ADD CONSTRAINT FK_album_artist
	FOREIGN KEY (artist_id)
	REFERENCES Artist (id);
ALTER TABLE Song
	ADD CONSTRAINT FK_song_album
	FOREIGN KEY (album_id)
	REFERENCES Album (id),
    ADD CONSTRAINT FK_song_artist
	FOREIGN KEY (artist_id)
	REFERENCES Artist(id),
    ADD CONSTRAINT FK_song_genre
	FOREIGN KEY (genre_id)
	REFERENCES Genre(id);

	

INSERT INTO Label( name) VALUES

("Soft Serve"),
("Abet"),
("Alligator Records"),
("Lava"),
("Legacy"),
("Rhino"),
("Interscope"),
("Hollywood records"),
("Immortal"),
("Red records");

INSERT INTO Band(name,num_of_artists) VALUES
("Skillet", 4),
("Oomph", 3),
("Rammstein", 3),
("Arctic Monkey", 4),
("The Neighbourhood", 4),
("Coldplay", 2),
("Cage the elephant", 6),
("Green Day", 3),
("Metallica", 5),
("Imagine Dragons", 4);

INSERT INTO Artist(label_id,band_id, name,monthly_listens,followers) VALUES
(null, null,"Michael Jackson",100000,100234),
(10, 2,"Dero Goi",200000,26000),
(8, null,"Lady Gaga",700000,230000),
(4, null,"Nicki Minaj",870000,230400),
(2, null,"Melanie Martinez",234567,100900),
(null, null,"Megan Three Stallion",450000,500000),
(1, 6,"John Cooper ",236000,126000),
(8, null,"Bruno Mars",343000,236000),
(3, null,"Girl in red",342000,130000),
(8, null,"Lana Del Rey",459000,120000);

INSERT INTO Genre(name)  VALUES
("rap"),
("rock"),
("trap"),
("rnb"),
("pop"),
("metal"),
("alt-rock"),
("jazz"),
("indie"),
("blues");

INSERT INTO Album(artist_id, name,number_of_songs) VALUES
(1, "Invincible",12),
(1, "Xscape",17),
(2, "Truth or dare",16),
(3, "The Fame",15),
(5, "Cry Baby",16),
(7, "Comatose",11),
(10, "Born to die",12),
(6, "Good News",17),
(9, "Chapter 1",5),
(4, "Queen",20);





INSERT INTO Song(name,album_id,artist_id,genre_id,duration_in_seconds) VALUES
("Chun-Li",10,4,1,210),
("Coco Chanel",10,1,1,219),
("Whispers in the dark",6,2,2,226),
("Body",8,6,1,197),
("i'll die anyway",9,9,3,234),
("Play date",5,5,3,210),
("Cry Baby",5,5,3,231),
("You rock my world",1,1,1,187),
("Loving you",1,1,1,246),
("Off to the races",7,10,7,209);


