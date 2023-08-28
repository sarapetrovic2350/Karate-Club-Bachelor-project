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
VALUES ('Coach', default, 'Petar', 'Perovic', '2510993800106', 'petar@gmail.com', '$2y$12$Wm7c0bzr1uu1rKjtU8qGCedUmDUjRjkW.AZFMbKPgRh3.vwycR7Wa', '98oZRNi4sHgZxXx+7aVbBS==', 'MALE', '+381613368954','A2574HDj5', 'COACH', '5', '1', '2', true);

--4 COACH 2 email: mila@gmail.com password: milako Klub NIPPON
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Mila', 'Milakovic', '2610996805047', 'mila@gmail.com', '$2a$12$LpafCaCvDzZQroPZU5cZXu1G2xPKtpTr.864PgzW1AUtdgYeZX0e2', 'Ff7dDRIQzQdjX7fJuAvQrQ==', 'FEMALE', '+381642253449','M334dNf77Y', 'COACH', '6', '1', '2', true);

--5 COACH 3 email: nebojsa@gmail.com password: milako Klub MLADOST
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Nebojsa', 'Milakovic', '0610996800047', 'nebojsa@gmail.com', '$2a$12$LpafCaCvDzZQroPZU5cZXu1G2xPKtpTr.864PgzW1AUtdgYeZX0e2', 'FN7dDRIQzQdjX7fJuAvQrQ==', 'MALE', '+381612353479','N214dNf77Y', 'COACH', '4', '2', '2', true);


INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Pioniri','PIONEERS', '3');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Kadeti','CADETS', '4');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori G1','JUNIORS', '3');
--4 Grupa juniori Klub Mladost
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori G2','JUNIORS', '5');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Mladji seniori','SENIORS', '4');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Stariji seniori','SENIORS', '3');

--6 STUDENT email: marija@gmail.com password: marija Juniori G1, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Marija', 'Nikolic', '0308005805039', 'marija@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'ETk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381642258974', 'STUDENT','RED', '4', '1','3', '3', true);

--7 STUDENT email: filip@gmail.com password: gfilip Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Filip', 'Grbic', '1309996800018', 'filip@gmail.com','$2a$12$3xaKzUuZGGhs6YXmet0drOvP0CpF8w3GBvT9jOrGZzbp/5Llt6Ty2', 'YoG3rNtjgcSRNxwyYpOwDQ==', 'MALE', '+381612458944', 'STUDENT','BROWN', '5', '1','5', '3', true);

--8 STUDENT email: ivana@gmail.com password: iivana Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Ivana', 'Ivanovic', '1210000805018', 'ivana@gmail.com','$2a$12$TqCDOZ5kPi90w1TOVD5aOuIIqquVboW/tkxlk8gQE8g18zaubbM0q', '5mMgcmWfxa+FCNxZBHnqzg==', 'FEMALE', '+381648454877', 'STUDENT','BROWN', '5', '1','5', '3', true);

--9 STUDENT email: ana@gmail.com password: marija Juniori G2, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Ana Marija', 'Lukic', '2305006805045', 'ana@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'EYk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381611585875', 'STUDENT','RED', '4', '1','3', '3', true);

--10 STUDENT email: perica@gmail.com password: perica Juniori G2, Klub Mladost
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Perica', 'Ilic', '2505005800085', 'perica@gmail.com','$2a$12$cyRtSVodfntEj.1VSLGO6u/F8lNhQFsSaMjD0u52N7Bgn0T6NIig6', 'GuUWzK6i4OHZJm4Eb2H9nQ==', 'MALE', '+381641585875', 'STUDENT','GREEN', '4', '2','4', '3', true);


INSERT INTO public.membership_fees (membership_fee_id, membership_fee_name, payment_date, price, is_paid_for_month, student_id, club_id) VALUES (default, 'Mesecna clanarina u Karate klubu Nippon', null, 2900, false, '7', '1');
INSERT INTO public.membership_fees (membership_fee_id, membership_fee_name, payment_date, price, is_paid_for_month, student_id, club_id) VALUES (default, 'Mesecna clanarina u Karate klubu Nippon', '2023-07-27', 2900, true, '6', '1');
INSERT INTO public.membership_fees (membership_fee_id, membership_fee_name, payment_date, price, is_paid_for_month, student_id, club_id) VALUES (default, 'Mesecna clanarina Klub Mladost', '2023-08-15', 2700, true, '10', '2');
INSERT INTO public.membership_fees (membership_fee_id, membership_fee_name, payment_date, price, is_paid_for_month, student_id, club_id) VALUES (default, 'Mesecna clanarina u Karate klubu Nippon', '2023-08-05', 2900, true, '8', '1');

INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'KUP VOJVODINE','Kup Vojvodine za kadete/kinje i juniore/ke odrzace se u Sportskoj hali- Novi Becej.', '2023-09-15', 'Novi Becej, Srbija', 'karate1.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'World Senior Championships','The magnificent Papp Laszlo Sports Arena in Budapest will host the 26th World Senior Championships', '2023-10-09', 'Budapest, Hungary', 'senior.png');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Prvenstvo Balkana 2023','Prvenstvo Balkana za seniore i juniore u Porecu', '2023-10-17', 'Porec, Hrvatska', 'porec.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'JKA – WSKA OTVORENI MILOŠ KUP','Miloš Kup 2023 odrzace se u Hali sprotova u Trsteniku.', '2023-10-25', 'Trstenik, Srbija', 'karate2.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Mediterranean Karate Championships','The 29th edition of the Mediterranean Karate Championships in Tunis', '2023-11-12', 'Tunis, Tunisia', 'tunis.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'BALKANSKO PRVENSTVO','Balkansko prvenstvo za pionire i kadete', '2023-11-22', 'Skopje, Makedonija', 'karate3.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Prvenstvo Evrope','Prvenstvo Evrope za seniore/ke i juniore/ke odrzace se u Bratislavi.', '2023-05-25', 'Bratislava, Slovacka', null);

INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('1', '2');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('1', '3');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('2', '3');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('1', '1');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('7', '1');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('6', '1');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('6', '2');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('5', '1');

INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'JUNIORS', null, '1');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'JUNIORS', null, '1');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'CADETS', null, '1');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'CADETS', null, '1');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'MALE', 'SENIORS', '-75kg', '5');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'JUNIORS', '-48kg', '1');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'SENIORS', null, '5');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'CADETS', null, '2');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'SENIORS', null, '6');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'SENIORS', null, '6');

--DISCIPLINE NA ODRZANIM TAKMICENJIMA
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'FEMALE', 'JUNIORS', null, '7');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KATA', 'MALE', 'SENIORS', null, '7');
INSERT INTO public.disciplines(discipline_id, discipline_type, gender_category, group_category, weight_category, competition_id) VALUES (default, 'KUMITE', 'FEMALE', 'SENIORS', '-62kg', '7');

INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('1', '6'); --marija, kate junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('1', '9'); --ana-marija, kate junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('2', '10'); --perica,kate, junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('5', '7'); --filip,kumite, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('6', '6'); --marija, kumite junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('9', '8'); --ivana, kate, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('10', '7'); --filip,kate, senior



--ZA ODRZANA TAKMICENJA:
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('11', '6'); --marija,kate, junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('12', '7'); --filip,kate, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('13', '8'); --ivana,kumite, senior

INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Zlatna medalja Evropsko prvenstvo', 'GOLD', '6', '11');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Srebrna medalja Evropsko prvenstvo', 'SILVER', '7', '12');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Bronzana medalja Evropsko prvenstvo', 'BRONZE', '8', '13');