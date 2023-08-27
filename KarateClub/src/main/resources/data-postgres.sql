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

-- ADMINISTRATOR email: sara@gmail.com password: sarap
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Administrator', default, 'Sara', 'Petrovic', '0802988800032', 'sara@gmail.com','$2y$12$RU7O/mGpTgy4lD1GH2mf7.9bM54T2eoDlP7YbrU1P8lurHe3dQ/4q', 'K+IsDJLi43-jlR+Fiap1mG==', 'FEMALE', '+381642258974', 'ADMINISTRATOR', '3', '1', '1', true);

-- COACH 1 email: petar@gmail.com password: petar
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Petar', 'Perovic', '2510993800106', 'petar@gmail.com', '$2y$12$Wm7c0bzr1uu1rKjtU8qGCedUmDUjRjkW.AZFMbKPgRh3.vwycR7Wa', '98oZRNi4sHgZxXx+7aVbBS==', 'MALE', '+381613368954','A2574HDj5', 'COACH', '5', '1', '2', true);

-- COACH 2 email: mila@gmail.com password: milako
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Mila', 'Milakovic', '2610996805047', 'mila@gmail.com', '$2a$12$LpafCaCvDzZQroPZU5cZXu1G2xPKtpTr.864PgzW1AUtdgYeZX0e2', 'Ff7dDRIQzQdjX7fJuAvQrQ==', 'FEMALE', '+381642253449','M334dNf77Y', 'COACH', '6', '1', '2', true);

INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Pioniri','PIONEERS', '2');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Kadeti','CADETS', '3');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori G1','JUNIORS', '3');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori G2','JUNIORS', '2');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Mladji seniori','SENIORS', '2');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Stariji seniori','SENIORS', null);

-- STUDENT email: marija@gmail.com password: marija Juniori G1, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Marija', 'Nikolic', '0308005805039', 'marija@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'ETk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381642258974', 'STUDENT','RED', '4', '1','3', '3', true);

-- STUDENT email: filip@gmail.com password: gfilip Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Filip', 'Grbic', '1309996800018', 'filip@gmail.com','$2a$12$3xaKzUuZGGhs6YXmet0drOvP0CpF8w3GBvT9jOrGZzbp/5Llt6Ty2', 'YoG3rNtjgcSRNxwyYpOwDQ==', 'MALE', '+381612458944', 'STUDENT','BROWN', '5', '1','5', '3', true);

-- STUDENT email: ivana@gmail.com password: iivana Mladji seniori, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Ivana', 'Ivanovic', '1210000805018', 'ivana@gmail.com','$2a$12$TqCDOZ5kPi90w1TOVD5aOuIIqquVboW/tkxlk8gQE8g18zaubbM0q', '5mMgcmWfxa+FCNxZBHnqzg==', 'FEMALE', '+381648454877', 'STUDENT','BROWN', '5', '1','5', '3', true);

-- STUDENT email: ana@gmail.com password: marija Juniori G2, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Ana Marija', 'Lukic', '2305006805045', 'ana@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'EYk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381611585875', 'STUDENT','RED', '4', '1','4', '3', true);

INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'KUP VOJVODINE','Kup Vojvodine za kadete/kinje i juniore/ke odrzace se u Sportskoj hali- Novi Becej.', '2023-09-15', 'Novi Becej, Srbija', 'karate1.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'BALKANSKO PRVENSTVO','Balkansko prvenstvo za pionire i kadete', '2023-09-22', 'Skopje, Makedonija', 'karate3.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Prvenstvo Balkana 2023','Prvenstvo Balkana za seniore i juniore u Porecu', '2023-10-17', 'Porec, Hrvatska', 'porec.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'JKA – WSKA OTVORENI MILOŠ KUP','Miloš Kup 2023 odrzace se u Hali sprotova u Trsteniku.', '2023-10-15', 'Trstenik, Srbija', 'karate2.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Mediterranean Karate Championships','The 29th edition of the Mediterranean Karate Championships in Tunis', '2023-10-05', 'Tunis, Tunisia', 'tunis.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'World Senior Championships','The magnificent Papp Laszlo Sports Arena in Budapest will host the 26th World Senior Championships', '2023-11-26', 'Budapest, Hungary', 'karate1.jpg');
INSERT INTO public.competitions (competition_id, competition_name, description, date, place, image) VALUES (default, 'Prvenstvo Evrope','Prvenstvo Evrope za seniore/ke i juniore/ke odrzace se u Bratislavi.', '2023-05-25', 'Bratislava, Slovacka', 'karate1.jpg');

INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('1', '2');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('1', '3');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('2', '3');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('1', '1');
INSERT INTO public.competitions_clubs(competition_id, club_id) VALUES ('7', '1');

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

INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('1', '4'); --marija, kate junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('1', '7'); --ana-marija, kate junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('6', '4'); --marija, kumite junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('9', '6'); --ivana, kate, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('10', '5'); --filip,kate, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('5', '5'); --filip,kumite, senior

--ZA ODRZANA TAKMICENJA:
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('11', '4'); --marija,kate, junior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('12', '5'); --filip,kate, senior
INSERT INTO public.disciplines_users(discipline_id, student_id) VALUES ('13', '6'); --ivana,kumite, senior

INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Zlatna medalja Evropsko prvenstvo', 'GOLD', '4', '11');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Srebrna medalja Evropsko prvenstvo', 'SILVER', '5', '12');
INSERT INTO public.medals(medal_id, medal_name, medal_type, student_id, discipline_id) VALUES (default, 'Bronzana medalja Evropsko prvenstvo', 'BRONZE', '6', '13');