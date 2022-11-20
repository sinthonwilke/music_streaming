-- user
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
('Medeon'),
('Jakubi'),
('Cyberpunk 2077'),
('Steelix');


-- musics 
insert into musics(name, release_date, artists, genres) values
('No Fear No More', 					'2020-01-01', 1, 4),
('I Really Want To Stay At Your House', '2020-02-02', 3, 4),
('Lay it down', 						'2020-03-03', 4, 8),
('Couch Potato', 						'2020-04-04', 2, 8),
('Heavy With Hoping', 					'2020-05-05', 1, 4);


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
(1, 'Good Faith');
-- album_music
insert into album_music(albums, musics) values
(1, 1),
(1, 5);
