INSERT INTO public.authority (name) VALUES ('ADMINISTRATOR');
INSERT INTO public.authority (name) VALUES ('COACH');
INSERT INTO public.authority (name) VALUES ('STUDENT');

INSERT INTO public.address (city, country, street, street_number) VALUES ('Beograd', 'Srbija', 'Vitanovačka', '42');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Novi Sad', 'Srbija', 'Bulevar Oslobodjenja', '21');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Novi Sad', 'Srbija', 'Strazilovska', '52');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Temerin', 'Srbija', 'Novosadska', '371');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Novi Sad', 'Srbija', 'Maksima Gorkog', '84');
INSERT INTO public.address (city, country, street, street_number) VALUES ('Novi Sad', 'Srbija', 'Pascanova', '159');

INSERT INTO public.karate_clubs (club_id, name, phone_number,address_id) VALUES (default, 'Karate Klub Nippon', '+3810603981759', '1');
INSERT INTO public.karate_clubs (club_id, name, phone_number, address_id) VALUES (default, 'Karate Klub Mladost', '+3810615931726', '2');

-- ADMINISTRATOR email: sara@gmail.com password: sarap
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Administrator', default, 'Sara', 'Petrovic', '0802988800032', 'sara@gmail.com','$2y$12$RU7O/mGpTgy4lD1GH2mf7.9bM54T2eoDlP7YbrU1P8lurHe3dQ/4q', 'K+IsDJLi43-jlR+Fiap1mG==', 'FEMALE', '+381642258974', 'ADMINISTRATOR', '3', '1', '1', true);

-- COACH 1 email: petar@gmail.com password: petar
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Petar', 'Perovic', '2510993800106', 'petar@gmail.com', '$2y$12$Wm7c0bzr1uu1rKjtU8qGCedUmDUjRjkW.AZFMbKPgRh3.vwycR7Wa', '98oZRNi4sHgZxXx+7aVbBS==', 'MALE', '+381613368954','A2574HDj5', 'COACH', '5', '1', '2', true);

-- COACH 1 email: mila@gmail.com password: milako
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, licence_number, user_type, address_id, club_id, authority_id, enabled)
VALUES ('Coach', default, 'Mila', 'Milakovic', '2610996805047', 'mila@gmail.com', '$2a$12$LpafCaCvDzZQroPZU5cZXu1G2xPKtpTr.864PgzW1AUtdgYeZX0e2', 'Ff7dDRIQzQdjX7fJuAvQrQ==', 'FEMALE', '+381642253449','M334dNf77Y', 'COACH', '6', '1', '2', true);

INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Pioniri','PIONEERS', '2');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Kadeti','CADETS', '3');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori G1','JUNIORS', '3');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Juniori G2','JUNIORS', '2');
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Mladji seniori','SENIORS', null);
INSERT INTO public.groups (group_id, group_name, group_category, coach_id) VALUES (default, 'Stariji seniori','SENIORS', null);

-- STUDENT email: marija@gmail.com password: marija Juniori G1, Klub Nippon
INSERT INTO public.user (dtype, user_id, name, surname, jmbg, email, password, salt, gender, phone_number, user_type, belt_color, address_id, club_id, group_id, authority_id, enabled)
VALUES ('Student', default, 'Marija', 'Nikolic', '03080058805039', 'marija@gmail.com','$2a$12$wXFNJnK0zCqqCQdeR1b3PuJ27Aoho0yCNmNT0vDgvtrY0QWggOoDG', 'ETk76xQWhz1JOKRDzp/CDQ==', 'FEMALE', '+381642258974', 'STUDENT','RED', '4', '1','3', '3', true);
