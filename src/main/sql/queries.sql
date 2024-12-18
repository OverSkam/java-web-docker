create table users
(
    id      serial
        constraint pk primary key,
    login   text,
    pass    text,
    cookie  text,
    name    text,
    surname text,
    age     int,
    about   text
);

create table likes
(
    who  int,
    whom int
);

create table chatHistory
(
    chat_id  int,
    sender   int,
    receiver int,
    message_id serial constraint pk_2 primary key,
    message  text
);

create table chatRelations
(
    chat_id  serial
        constraint pk_1 primary key,
    id1      int,
    id2      int
);

INSERT INTO chatRelations (chat_id, id1, id2) values (1, 1, 2);
INSERT INTO likes (who, whom) VALUES (1,2);
INSERT INTO likes (who, whom) VALUES (2,1);


INSERT INTO users (cookie)
values ('m fdmn sfdmn') WHERE id=1;

SELECT count(1) > 0
FROM users
WHERE login = '1';

INSERT INTO users (login, pass, name, surname, age, about)
VALUES (('1','1','1','1',1,'1'),
        ('2','2','2','2',2,'2'),
        ('jdoe1', 'password123', 'John', 'Doe', 28, 'A software engineer with a passion for hiking.'),
        ('asmith1', 'securePass1', 'Alice', 'Smith', 35, 'Loves painting and reading mystery novels.'),
        ('bwright2', 'passW0rd!', 'Brian', 'Wright', 42, 'Enjoys cycling and outdoor adventures.'),
        ('mjohnson3', 'pa55word', 'Maria', 'Johnson', 31, 'Graphic designer and coffee enthusiast.'),
        ('kjames4', 'mypassword', 'Kevin', 'James', 25, 'Aspiring musician and chess player.'),
        ('lkhan5', 'kh@np@ss', 'Lila', 'Khan', 29, 'Avid traveler and foodie.'),
        ('tclark6', 'tr3kking', 'Thomas', 'Clark', 40, 'Mountain climber and history buff.'),
        ('sanders7', 'sandpass', 'Sophie', 'Anders', 33, 'Digital marketer and yoga practitioner.'),
        ('rgreen8', 'greengrass', 'Robert', 'Green', 37, 'Tech enthusiast and gamer.'),
        ('nhall9', 'hallpass99', 'Nina', 'Hall', 22, 'Undergraduate student in computer science.'),
        ('bturner10', 'turnPass1!', 'Ben', 'Turner', 45, 'Fitness trainer and health advocate.'),
        ('alucas11', 'luc@123', 'Anna', 'Lucas', 28, 'Avid reader and community volunteer.'),
        ('gsmith12', 'smithy', 'Greg', 'Smith', 36, 'Wildlife photographer and nature lover.'),
        ('kwilliams13', 'kwill2023', 'Kara', 'Williams', 30, 'Data analyst and puzzle solver.'),
        ('dlee14', 'leemypass', 'Daniel', 'Lee', 38, 'Chef who specializes in Italian cuisine.'),
        ('mvargas15', 'vargas1234', 'Martha', 'Vargas', 26, 'Event planner and karaoke fan.'),
        ('hjackson16', 'jacksonPa$$', 'Hannah', 'Jackson', 32, 'Runs a small bakery and loves dogs.'),
        ('cperez17', 'perezP@ss', 'Carlos', 'Perez', 41, 'Mechanic and aspiring inventor.'),
        ('mwilson18', 'wilsonKey!', 'Michelle', 'Wilson', 34, 'Marketing manager and podcast creator.'),
        ('flin19', 'linL0ve', 'Felix', 'Lin', 23, 'Junior web developer and basketball player.'),
        ('slopez20', 'l0pez2023', 'Sandra', 'Lopez', 27, 'Fashion designer and travel enthusiast.'),
        ('rwhite21', 'whiteStar', 'Ryan', 'White', 39, 'Film producer and art collector.'),
        ('jrogers22', 'rogerP@ss!', 'Julia', 'Rogers', 31, 'Environmental scientist and blogger.'),
        ('charris23', 'harris2023', 'Chris', 'Harris', 44, 'Entrepreneur with a love for tennis.'),
        ('tadams24', 'adamKey', 'Tina', 'Adams', 24, 'Graduate student and language learner.'),
        ('jharris25', 'h@rrisJ', 'Jason', 'Harris', 29, 'Tech support specialist and movie buff.'),
        ('mwong26', 'Wongster', 'Megan', 'Wong', 35, 'Urban planner and sketch artist.'),
        ('cgray27', 'gr@Yl0ve', 'Cameron', 'Gray', 43, 'Public relations expert and swimmer.'),
        ('llopez28', 'L0pezLife', 'Liam', 'Lopez', 21, 'College athlete and aspiring physicist.'),
        ('hramos29', 'r@m0sHero', 'Heather', 'Ramos', 26, 'Copywriter and theater enthusiast.'),
        ('jperez30', 'PerezTime', 'Juan', 'Perez', 34, 'Journalist and documentary filmmaker.'),
        ('zrobinson31', 'robinZone', 'Zoe', 'Robinson', 38, 'Freelance writer and gardening expert.'),
        ('gthomas32', 'thom@sD', 'George', 'Thomas', 27, 'Bartender and amateur stand-up comedian.'),
        ('ejenkins33', 'jenk33n', 'Emily', 'Jenkins', 28, 'Software tester and bird watcher.'),
        ('jramos34', 'r@m0s2023', 'Jacob', 'Ramos', 33, 'Research scientist and puzzle master.'),
        ('mwright35', 'wRightnow', 'Melissa', 'Wright', 36, 'Fitness enthusiast and health blogger.'),
        ('cortiz36', 'Ort1zCh', 'Carlos', 'Ortiz', 40, 'Construction foreman and guitarist.'),
        ('jsanders37', 'sandersJ!', 'Julia', 'Sanders', 25, 'Intern in graphic design and dog lover.'),
        ('kwalker38', 'w@lkerNow', 'Kevin', 'Walker', 37, 'Team leader and board game aficionado.'),
        ('adavis39', 'dav@Life', 'Alex', 'Davis', 32, 'Illustrator and mountain biker.'),
        ('ewilson40', 'WilsonE#', 'Eric', 'Wilson', 45, 'Retired teacher and chess coach.'),
        ('nmiller41', 'mill2023', 'Nora', 'Miller', 26, 'Photographer and graphic designer.'),
        ('pjohnson42', 'johnsOnP', 'Peter', 'Johnson', 44, 'Electrician and classic car restorer.'),
        ('sreyes43', 'reyesS!', 'Sara', 'Reyes', 29, 'UX designer and sketch artist.'),
        ('awright44', 'wright@A', 'Aaron', 'Wright', 30, 'Freelancer and language enthusiast.'),
        ('kmorris45', 'morris2Go', 'Karen', 'Morris', 33, 'Architect and city planner.');
