-- uplaylist_musicser
insert into users(email, password, role) values
('admin',				'$2a$12$X5K/wQD7FjSQypVmqaioBesL3iaQXMfS9bdW2oep0FuX7A/H5iEgO',	'ADMIN'),
('tester@gmail.com',	'$2a$12$X5K/wQD7FjSQypVmqaioBesL3iaQXMfS9bdW2oep0FuX7A/H5iEgO',	'USER');


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
('Safeplanet'),
('Tattoo Colour'),
('Bigass'),
('COCKTAIL');


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
('โลกใบใหม่ ( NEW WORLD )', '2021-07-06', 10, 8),
('โกหก', '2014-09-08', 11, 10),
('โอกาสสุดท้าย', '2013-03-25', 11, 10),
('จำทำไม', '2013-03-25', 11, 10),
('ขาหมู', '2013-03-25', 11, 10),
('Cinderella', '2017-03-28', 11, 10),
('นกน้อย', '2016-03-04', 11, 10),
('ฉันรักเธอ', '2013-03-25', 11, 10),
('เปิดเพลงไหน เปิดเมื่อไหร่ ก็ยังสวยงาม', '2013-03-25', 11, 10),
('อย่างน้อย', '2015-09-03', 12, 10),
('เล่นของสูง', '2015-05-07', 12, 10),
('ทางผ่าน', '2013-09-16', 12, 10),
('ก่อนตาย', '2013-09-16', 12, 10),
('ดีแต่ปาก', '2015-05-13', 12, 10),
('ข้าน้อยสมควรตาย', '2015-08-03', 12, 10),
('ลมเปลี่ยนทิศ', '2013-02-01', 12, 10),
('ฝุ่น', '2009-01-16', 12, 10),
('คู่ชีวิต', '2015-03-12', 13, 10),
('น้ำตาสุดท้าย', '2013-03-29', 13, 10),
('โปรดเถิดรัก', '2013-09-12', 13, 10),
('คุกเข่า', '2012-11-08', 13, 10),
('เธอ', '2014-05-05', 13, 10),
('ชั่วชีวิต', '2021-04-02', 13, 10),
('เรื่องธรรมดา', '2021-11-16', 13, 10),
('ดึงดัน', '2020-10-22', 13, 10),
('อภิสิทธิ์ชน', '2021-06-25', 13, 10);


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
(1, 'V'),
(1, 'Overexposed Track by Track'),
(1, 'Jordi(Deluxe)'),
(10, 'Safeboy'),
(10, 'Cap, Capo, Cigarettes & Beer'), 
(8, 'You (Are) Mean a Lot to Me'),
(11, 'ชุดที่ 8 จงเพราะ'),
(12, 'LOVE'),
(12, 'Seven'),
(12, 'Not Bad'),
(12, 'XL'),
(12, 'Begins'),
(12, 'แดนเนรมิตร'),
(13, 'The lords of misery'),
(13, 'Fade alpha');


-- album_music
insert into album_music(albums, musics) values
(1, 1),
(1, 5),
(1, 6),
(2, 2),
(2, 8),
(3, 4),
(4, 23),
(4, 24),
(4, 25),
(4, 26),
(4, 27),
(5, 28),
(5, 29),
(5, 30),
(6, 16),
(6, 17),
(6, 18),
(6, 19),
(7, 31),
(7, 32),
(7, 33),
(7, 34),
(7, 35),
(7, 36),
(7, 37),
(7, 38),
(8, 39),
(8, 46),
(9, 40),
(10, 41),
(11, 42),
(12, 44),
(13, 45),
(14, 47),
(14, 48),
(14, 49),
(14, 50),
(14, 51),
(15, 52),
(15, 53),
(15, 54),
(15, 55);


