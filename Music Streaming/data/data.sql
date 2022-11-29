-- user
insert into users(email, password, role) values
('admin', '$2a$12$X5K/wQD7FjSQypVmqaioBesL3iaQXMfS9bdW2oep0FuX7A/H5iEgO', 'ADMIN'),
('test', '$2a$12$X5K/wQD7FjSQypVmqaioBesL3iaQXMfS9bdW2oep0FuX7A/H5iEgO', 'USER');


-- genre
insert into genres(name) values
('Blues'),
('Country'),
('Easy listening'),
('Electronic'),
('Contemporary folk'),
('Hip hop'),
('Jazz'),
('Pop'),
('R&B and soul'),
('Rock'),
('Metal'),
('Punk'),
('Regional'),
('Religious');


-- artist 
insert into artists(name) values
('Maroon5'),
('Ed Sheeran'),
('Wiz Khalifa'),
('Punyarb'),
('Zentyarb'),
('Musketeers'),
('YourMOOD'),
('Blackbean'),
('YEW'),
('Safeplanet');

-- musics 
insert into musics(name, release_date, artists, genres) values
('Sugar', '2015-01-14', 1, 8),
('Payphone', '2012-05-11', 1, 8),
('Girl like you', '2018-05-31', 1, 8),
('Memories', '2019-10-08', 1, 8),
('Animals', '2014-09-29', 1, 8),
('Maps', '2014-06-24', 1, 8),
('Shape of you', '2017-01-30', 2, 8),
('One more night', '2012-06-26', 1, 8),
('See you again ft. Charlie Puth', '2015-04-07', 3, 6),
('Move like jagger', '2011-08-09', 1, 8),
('คำถาม', '2021-07-10', 4, 6),
('ฉบับปรับปรุง  x Punyarb ft. lazyloxy', '2022-01-29', 5, 6),
('KRYPTONITE', '2021-07-29', 4, 8),
('พิจารณา', '2022-09-08', 6, 8),
('ลาก่อน', '2020-11-05',7, 8),
('wish', '2019-06-19', 8, 8),
('Dance With Me', '2019-03-19', 8, 8),
('About love', '2020-02-13', 8, 8),
('Moon', '2018-04-29', 8, 8),
('ลมแล้ง', '2020-12-10', 9, 8),
('จะมอบความรัก (wish)', '2019-11-19', 9, 8),
('ลมที่ลา (wind)', '2018-10-18', 9, 8),
('ข้างกาย (with you)', '2019-05-06', 10, 8),
('คำตอบ (Answer)', '2018-09-29', 10, 8),
('ห้องกระจก (Mirror Room)', '2016-09-22', 10, 8),
('ระบาย (PAINT)', '2015-12-14', 10, 8),
('เพียงเธอ ( Always )', '2019-06-17', 10, 8),
('ถ้าเธอได้รู้ ( The Secret ∆ )', '2020-11-19', 10, 8),
('สิ่งที่เธอฝากไว้ ( The Maze )', '2020-03-06', 10, 8),
('โลกใบใหม่ ( NEW WORLD )', '2021-07-06', 10, 8); 


-- fav
insert into fav(users, musics) values
(1, 1),
(1, 5),
(2, 3),
(2, 4);


-- playlist
insert into playlists(users, name) values
(1, 'Listen when break up.'),
(1, '#Electric wavy in my heart#'),
(2, 'Check later.');
-- playlist_music
insert into playlist_music(playlists, musics) values
(1, 3),
(2, 1),
(3, 2),
(2, 4);


-- album
insert into albums(artists, name) values
(1, 'V');
-- album_music
insert into album_music(albums, musics) values
(1, 1),
(1, 6);
