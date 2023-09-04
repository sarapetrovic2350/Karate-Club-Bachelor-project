INSERT INTO public.authority (name) VALUES ('ROLE_ADMINISTRATOR');
INSERT INTO public.authority (name) VALUES ('ROLE_COACH');
INSERT INTO public.authority (name) VALUES ('ROLE_STUDENT');

INSERT INTO public.address (city, country, street, street_number) VALUES ('Beograd', 'Srbija', 'Vitanovačka', '42');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Novi Sad', 'Srbija', 'Bulevar Oslobodjenja', '21');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Novi Sad', 'Srbija', 'Strazilovska', '52');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Temerin', 'Srbija', 'Novosadska', '371');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Novi Sad', 'Srbija', 'Maksima Gorkog', '84');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Novi Sad', 'Srbija', 'Pascanova', '159');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Budapest', 'Hungary', 'Stefania Ut 2.', '1143');

INSERT INTO public.clubs (club_id, name, phone_number,address_id) VALUES (default, 'Karate Klub Nippon', '+3810603981759', '1');
INSERT INTO public.clubs (club_id, name, phone_number, address_id) VALUES (default, 'Karate Klub Mladost', '+3810615931726', '2');
INSERT INTO public.clubs (club_id, name, phone_number, address_id) VALUES (default, 'Karate Klub Grande', '+3610615931726', '7');

--1 ADMINISTRATOR 1 email: sara@gmail.com password: sarap Klub NIPPON
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Administrator', default, 'Sara', 'Petrovic', '0802988800032', 'sara@gmail.com','$2y$12$RU7O/mGpTgy4lD1GH2mf7.9bM54T2eoDlP7YbrU1P8lurHe3dQ/4q', 'K+IsDJLi43-jlR+Fiap1mG==', 'FEMALE', '+381642258974', 'ADMINISTRATOR', '3', '1', '1', true);

--2 ADMINISTRATOR 2 email: nikola@gmail.com password: nikola Klub MLADOST
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Administrator', default, 'Nikola', 'Nikolic', '1802987800032', 'nikola@gmail.com','$2a$12$tnNNNQ4roAkuqWvfJUclZuioKoM6V9cMVn4.keyJQ7EzbAeUGcFWu', 'vvRw9+GxyQa5qZ+vInc42A==', 'MALE', '+381612281244', 'ADMINISTRATOR', '3', '2', '1', true);

--3 COACH 1 email: petar@gmail.com password: petar Klub NIPPON
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Petar', 'Perovic', '2510993800106', 'petar@gmail.com', '$2y$12$Wm7c0bzr1uu1rKjtU8qGCedUmDUjRjkW.AZFMbKPgRh3.vwycR7Wa', '98oZRNi4sHgZxXx+7aVbBS==', 'MALE', '+381613368954','A2574HDj5P', 'COACH', '5', '1', '2', true);

--4 COACH 2 email: mila@gmail.com password: milako Klub NIPPON
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Mila', 'Milakovic', '2610996805047', 'mila@gmail.com', '$2a$12$LpafCaCvDzZQroPZU5cZXu1G2xPKtpTr.864PgzW1AUtdgYeZX0e2', 'Ff7dDRIQzQdjX7fJuAvQrQ==', 'FEMALE', '+381642253449','M334dNf77Y', 'COACH', '6', '1', '2', true);

--5 COACH 3 email: kristina@gmail.com password: kristina Klub NIPPON
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Kristina', 'Obradovic', '1809991805817', 'kristina@gmail.com', '$2a$12$LpafCaCvDzZQroPZU5cZXu1G2xPKtpTr.864PgzW1AUtdgYeZX0e2', 'Kf7dDRIQzQdjX7fJuAvQrQ==', 'FEMALE', '+381645336734','LX234CyHJD', 'COACH', '6', '1', '2', true);

--6 COACH 4 email: nebojsa@gmail.com password: milako Klub MLADOST
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Nebojsa', 'Milakovic', '0610996800047', 'nebojsa@gmail.com', '$2a$12$LpafCaCvDzZQroPZU5cZXu1G2xPKtpTr.864PgzW1AUtdgYeZX0e2', 'FN7dDRIQzQdjX7fJuAvQrQ==', 'MALE', '+381612353479','TJ7IjCLUYz', 'COACH', '4', '2', '2', true);

--Grupe Klub Nippon
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Pioniri','PIONEERS', '5');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori G1','JUNIORS', '3');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori G2','JUNIORS', '5');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Mladji seniori','SENIORS', '4');
--5 Grupa juniori Klub Mladost
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori Mladost','SENIORS', '6');


--7 STUDENT email: marija@gmail.com password: marija Juniori G1, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Marija', 'Nikolic', '0308005805039', 'marija@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'ETk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381642258974', 'STUDENT','RED', '4', '1','2', '3', true, 47.5);

--8 STUDENT Juniori G1, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Nemanja', 'Madic', '2706004800071', 'nemanja@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'NMj76xQWhz1JOKRDzp/CDQ==', 'MALE', '+381648051018', 'STUDENT','GREEN', '5', '1','2', '3', true, 58);
--9 Juniori G1, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Svetlana', 'Vidic', '1503005805145', 'vidic@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'SVk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381615857154', 'STUDENT','BLUE', '5', '1','2', '3', true, 60.5);
--10 Juniori G1, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Mladen', 'Stojanovic', '1708005800173', 'mladen@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'MLs76xQWhz1JOKRDzp/CDQ==', 'MALE', '+381645963478', 'STUDENT','BLUE', '5', '1','2', '3', true, 73);
--11 Juniori G1, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Zoran', 'Plavsic', '1802006800853', 'plavsic@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'HJN76xQWhz1JOKRDzp/CDQ==', 'MALE', '+381641524117', 'STUDENT','GREEN', '5', '1','2', '3', true, 55);

--12 STUDENT email: filip@gmail.com password: gfilip Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Filip', 'Grbic', '1309996800018', 'filip@gmail.com','$2a$12$3xaKzUuZGGhs6YXmet0drOvP0CpF8w3GBvT9jOrGZzbp/5Llt6Ty2', 'YoG3rNtjgcSRNxwyYpOwDQ==', 'MALE', '+381612458944', 'STUDENT','BROWN', '5', '1','4', '3', true, 76.2);

--13 STUDENT email: ivana@gmail.com password: iivana Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Ivana', 'Ivanovic', '1210000805018', 'ivana@gmail.com','$2a$12$TqCDOZ5kPi90w1TOVD5aOuIIqquVboW/tkxlk8gQE8g18zaubbM0q', '5mMgcmWfxa+FCNxZBHnqzg==', 'FEMALE', '+381648454877', 'STUDENT','PURPLE', '5', '1','4', '3', true, 58.4);


--14 STUDENT  Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Nevena', 'Vasic', '1712005805067', 'nevena@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'NYk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381616895421', 'STUDENT','PURPLE', '5', '1','4', '3', true, 57.5);
--15 STUDENT  Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Nemanja', 'Lovric', '2110000800034', 'lovric@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'NLv36xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381611825186', 'STUDENT','BROWN', '5', '1','4', '3', true, 61);
--16 STUDENT Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Petar', 'Mazic', '0603999800198', 'mazic@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'M456xQWhz1JOKRDzp/CDQ==', 'MALE', '+381647856745', 'STUDENT','BLACK', '5', '1','4', '3', true, 77);
--17 STUDENT Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Marko', 'Lozajic', '2908001800952', 'markol@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'NYk76xQWhz1JOKRDml/CDQ==', 'MALE', '+381616895421', 'STUDENT','PURPLE', '5', '1','4', '3', true, 68);
--18 STUDENT Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Nikoleta', 'Jaksic', '1206002805365', 'jaksic@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'NYk76xNKsz1JOKRDzp/CDQ==', 'FEMALE', '+381618036487', 'STUDENT','BLUE', '5', '1','4', '3', true, 52);


--19 STUDENT email: ana@gmail.com password: marija Juniori G2, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Ana Marija', 'Lukic', '2305006805045', 'ana@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'EYk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381611585875', 'STUDENT','RED', '4', '1','3', '3', true, 44);

--20 STUDENT Juniori G2, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Masa', 'Antic', '0712005805036', 'antic@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'MAk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381643362354', 'STUDENT','GREEN', '4', '1','3', '3', true, 45.8);
--21 STUDENT Juniori G2, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Nikola', 'Vasilic', '1503006800165', 'nikolav@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'NVl76xQWhz1JOKRDzp/CDQ==', 'MALE', '+381645093212', 'STUDENT','GREEN', '4', '1','3', '3', true, 52);
--22 STUDENT Juniori G2, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Uros', 'Zivkovic', '0112006800458', 'uros@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'UZk76xQWhz1JOKRDzp/CDQ==', 'MALE', '+381611585875', 'STUDENT','GREEN', '4', '1','3', '3', true, 56.9);
--23 STUDENT Juniori G2, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Lara', 'Zivkovic', '2609005805149', 'laraziv@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'LZv76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381643369874', 'STUDENT','RED', '4', '1','3', '3', true, 50.5);

--24 STUDENT email: perica@gmail.com password: perica Juniori, Klub Mladost
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Perica', 'Ilic', '2505005800085', 'perica@gmail.com','$2a$12$cyRtSVodfntEj.1VSLGO6u/F8lNhQFsSaMjD0u52N7Bgn0T6NIig6', 'GuUWzK6i4OHZJm4Eb2H9nQ==', 'MALE', '+381641585875', 'STUDENT','GREEN', '4', '2','5', '3', true, 60.7);
--25 STUDENT Juniori, Klub Mladost
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Stasa', 'Lukic', '1105006805143', 'lukic@gmail.com','$2a$12$cyRtSVodfntEj.1VSLGO6u/F8lNhQFsSaMjD0u52N7Bgn0T6NIig6', 'SLUWzK6i4OHZJm4Eb2H9nQ==', 'FEMALE', '+381641585875', 'STUDENT','RED', '4', '2','5', '3', true, 48);
--26 STUDENT Juniori, Klub Mladost
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Uros', 'Ilic', '1903006800123', 'ukiilic@gmail.com','$2a$12$cyRtSVodfntEj.1VSLGO6u/F8lNhQFsSaMjD0u52N7Bgn0T6NIig6', 'ULlWzK6i4OHZJm4Eb2H9nQ==', 'MALE', '+38161458061', 'STUDENT','RED', '4', '2','5', '3', true, 53);

--27 STUDENT Pioniri, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Mihajlo', 'Protic', '2410010800145', 'mihajlo@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'MPk76xQWhz1JOKRDzp/CDQ==', 'MALE', '+381648009575', 'STUDENT','ORANGE', '5', '1','1', '3', true, 50);
--28 STUDENT Pioniri, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Lana', 'Lazic', '2611009805088', 'lana@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'LLk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381615886254', 'STUDENT','RED', '5', '1','1', '3', true, 48);
--29 STUDENT Pioniri, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Slavko', 'Jezdic', '1107005805067', 'slavko@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'SJk76xQWhz1JOKRDzp/CDQ==', 'MALE', '+381647548244', 'STUDENT','RED', '3', '1','1', '3', true, 51.6);
--30 STUDENT Pioniri, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Zorana', 'Ivic', '08090108051321', 'zorana@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'ZIk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381617753692', 'STUDENT','ORANGE', '4', '1','1', '3', true, 46.6);
--31 STUDENT Pioniri, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled, weight)
VALUES ('Student', default, 'Vukasin', 'Vasic', '2504009800326', 'vasicv@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'VLk76xQWhz1JOKRDzp/CDQ==', 'MALE', '+381645218875', 'STUDENT','RED', '5', '1','1', '3', true, 54.5);



INSERT INTO public.membership_fees (membership_fee_id, membership_fee_name, payment_date, price, is_paid_for_month, student_id, club_id) VALUES (default, 'Mesecna clanarina u Karate klubu Nippon', null, 2900, false, '8', '1');
INSERT INTO public.membership_fees (membership_fee_id, membership_fee_name, payment_date, price, is_paid_for_month, student_id, club_id) VALUES (default, 'Mesecna clanarina u Karate klubu Nippon', '2023-07-27', 2900, true, '7', '1');
INSERT INTO public.membership_fees (membership_fee_id, membership_fee_name, payment_date, price, is_paid_for_month, student_id, club_id) VALUES (default, 'Mesecna clanarina Klub Mladost', '2023-08-15', 2700, true, '11', '2');
INSERT INTO public.membership_fees (membership_fee_id, membership_fee_name, payment_date, price, is_paid_for_month, student_id, club_id) VALUES (default, 'Mesecna clanarina u Karate klubu Nippon', '2023-08-05', 2900, true, '9', '1');

INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'KUP VOJVODINE','Competition for cadets and juniors both in kata and kumite will take place in Novi Becej.', '2023-09-12', 'Novi Becej, Serbia', 'karate.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'BALKANSKO PRVENSTVO 2023','Seniors and juniors competition will take place in Skopje.', '2023-09-23', 'Skopje, Makedonija', 'balkan.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'World Senior Championships','The magnificent Papp Laszlo Sports Arena will host the 26th World Senior Championships.', '2023-10-05', 'Budapest, Hungary', 'senior.png');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'JKA – WSKA OTVORENI MILOŠ KUP','Miloš Kup 2023 competition in kata for pioneers and cadets will take place in Trstenik.', '2023-10-20', 'Trstenik, Serbia', 'kid.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Mediterranean Karate Championships','The 29th edition of the Mediterranean Karate Seniors Championships in Tunis.', '2023-11-12', 'Tunis, Tunisia', 'karate2.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Balkan Karate Championships for Children','Championships for pioneers in kata disciplines will take place in Bar.', '2023-11-22', 'Bar, Montenegro', 'karate3.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Prvenstvo Evrope 2023','Prvenstvo Evrope for juniors and seniors will take place in Bratislava.', '2023-05-25', 'Bratislava, Slovakia', null);
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Commonwealth Karate Championships 2022','The 2022 Commonwealth Karate Championships for juniors and seniors will take place in London.', '2022-04-28', 'London, UK', null);

INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('1', '1');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('5', '1');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('7', '1');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('8', '1');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('1', '2');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('2', '2');

--KUP VOJVODINE DISCIPLINE
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'JUNIORS', null, '1'); --1
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'JUNIORS', null, '1'); --2
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'CADETS', null, '1'); --3
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'CADETS', null, '1'); --4
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'JUNIORS', '-48kg', '1'); --5
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'JUNIORS', '-62kg', '1'); --6

INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'SENIORS', null, '5'); --7
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'SENIORS', '-75kg', '5'); --8
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'SENIORS', '+75kg', '5'); --9
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'SENIORS', null, '5'); --10

INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'JUNIORS', null, '2'); --11
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'JUNIORS', null, '2'); --12
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'SENIORS', null, '2'); --13
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'SENIORS', null, '2'); --14
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'JUNIORS', '-51kg', '2'); --15
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'SENIORS', '-62kg', '2'); --16
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'JUNIORS', '-61kg', '2'); --17
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'SENIORS', '-75kg', '2'); --18

INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'SENIORS', null, '3'); --19
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'SENIORS', null, '3'); --20
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'SENIORS', '-77kg', '3'); --21
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'SENIORS', '+78kg', '3'); --22
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'SENIORS', '-60kg', '3'); --23
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'SENIORS', '+61kg', '3'); --24

INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'PIONEERS', null, '6'); --25
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'PIONEERS', null, '6'); --26

INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'PIONEERS', null, '4'); --27
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'PIONEERS', null, '4'); --28
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'CADETS', null, '4'); --29
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'CADETS', null, '4'); --30
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'CADETS', '-58kg', '4'); --31
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'CADETS', '-48kg', '4'); --32

--DISCIPLINE NA ODRZANIM TAKMICENJIMA
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'JUNIORS', null, '7'); --33
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'SENIORS', null, '7');  --34
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'SENIORS', '-62kg', '7');  --35

INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'SENIORS', null, '8');  --36
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'JUNIORS', '-62kg', '8');  --37

--KUP VOJVODINE
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('1', '7'); --marija, kate junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('1', '19'); --ana-marija, kate junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('2', '8'); --nemanja, kate junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('6', '10'); --mladen, kumite junior

INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('7', '12'); --kata, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('7', '15'); --kata, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('8', '16'); --kumite, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('10', '14'); --kata, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('10', '13'); --ivana, kate, senior


--ZA ODRZANA TAKMICENJA:
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('33', '7');
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('34', '12');
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('34', '15');
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('35', '14');
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('36', '18');
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('37', '10');

INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Zlatna medalja Evropsko prvenstvo', 'GOLD', '7', '33');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Srebrna medalja Evropsko prvenstvo', 'GOLD', '12', '34');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Srebrna medalja Evropsko prvenstvo', 'SILVER', '15', '34');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Bronzana medalja Evropsko prvenstvo', 'BRONZE', '14', '35');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Srebrna medalja Evropsko prvenstvo', 'SILVER', '18', '36');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Bronzana medalja Evropsko prvenstvo', 'BRONZE', '10', '37');