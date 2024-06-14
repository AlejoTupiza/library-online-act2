-- Insertar autores
INSERT INTO author (name, last_name) VALUES ('F. Scott', 'Fitzgerald');
INSERT INTO author (name, last_name) VALUES ('J.D.', 'Salinger');
INSERT INTO author (name, last_name) VALUES ('Harper', 'Lee');
INSERT INTO author (name, last_name) VALUES ('George', 'Orwell');
INSERT INTO author (name, last_name) VALUES ('Gabriel', 'García Márquez');
INSERT INTO author (name, last_name) VALUES ('Miguel de', 'Cervantes Saavedra');
INSERT INTO author (name, last_name) VALUES ('Juan', 'Rulfo');
INSERT INTO author (name, last_name) VALUES ('Isabel', 'Allende');
INSERT INTO author (name, last_name) VALUES ('Laura', 'Esquivel');
INSERT INTO author (name, last_name) VALUES ('Arturo', 'Pérez-Reverte');
INSERT INTO author (name, last_name) VALUES ('Patrick', 'Süskind');
INSERT INTO author (name, last_name) VALUES ('Carlos', 'Ruiz Zafón');
INSERT INTO author (name, last_name) VALUES ('Patrick', 'Rothfuss');

-- Insertar géneros (añade más si es necesario)
INSERT INTO gender (name) VALUES ('Ficción');
INSERT INTO gender (name) VALUES ('Novela');
INSERT INTO gender (name) VALUES ('Fantasía');
INSERT INTO gender (name) VALUES ('Realismo Mágico');
INSERT INTO gender (name) VALUES ('Histórico');

-- Insertar libros
INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
VALUES (9783161484100, 'The Great Gatsby', 1, 1, 'The_Great_Gatsby.jpg', 1925, 10, 'La historia hace referencia principalmente al joven y misterioso millonario Jay Gatsby, su pasión quijotesca y la obsesión por la hermosa ex debutante Daisy Buchanan.', 'Considerada como la obra maestra de Fitzgerald, El gran Gatsby explora los temas de decadencia, idealismo, resistencia al cambio, agitación social y el exceso.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9783161484101, 'The Catcher in the Rye', 2, 1, 'The_Catcher_in_the_Rye.jpg', 1951, 10, 'La novela cuenta la historia de Holden Caulfield, un joven neoyorquino de 16 años que acaba de ser expulsado de Pencey Prep, su instituto.', 'Esta novela ha tenido una influencia duradera ya que sigue siendo tanto un bestseller como uno de los libros más cuestionados en Estados Unidos.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9783161484102, 'To Kill a Mockingbird', 3, 1, 'To_Kill_a_Mockingbird.jpg', 1960, 10, 'La novela está inspirada en las observaciones de la autora sobre su familia y sus vecinos, así como en un incidente ocurrido cerca de su ciudad en 1936, cuando tenía diez años de edad.', 'To Kill a Mockingbird es una novela de gran importancia contemporánea nacional');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9783161484103, '1984', 4, 1, '1984.jpg', 1949, 10, 'El personaje principal de la novela es Winston Smith, que trabaja en el Ministerio de la Verdad. Su cometido es reescribir la historia, ironizando así el ideal declarado en el nombre del Ministerio.', 'Los libros como los de Orwell son severas advertencias, y sería lamentable que el lector interpretara presuntuosamente a 1984 como otra descripción más de la barbarie stalinista, y no viera que también está dirigida a nosotros.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788420663681, 'Cien años de soledad', 5, 4, 'Cien_anio_de_soledad.jpg', 1967, 10, 'Cien años de soledad narra la historia de la familia Buendía a lo largo de siete generaciones, desde su llegada a Macondo hasta su desaparición.', 'Cien años de soledad es una obra maestra de la literatura universal, que ha sido traducida a más de 30 idiomas y ha vendido más de 40 millones de copias. La novela ha sido elogiada por su belleza, su imaginación y su profundidad psicológica.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788467231529, 'El ingenioso hidalgo Don Quijote de la Mancha', 6, 2, 'Don_Quijote.jpg', 1605, 10, 'La novela narra las aventuras de Alonso Quijano, un hidalgo manchego que, tras leer demasiados libros de caballerías, se vuelve loco y cree ser un caballero andante. Don Quijote sale en busca de aventuras junto a su escudero Sancho Panza, y juntos viven una serie de cómicas y desventuras.', 'El ingenioso hidalgo Don Quijote de la Mancha es una obra maestra de la sátira y la parodia. La novela ha sido elogiada por su humor, su ingenio y su profundidad filosófica.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788439706725, 'El Llano en llamas', 7, 4, 'el_llano_en_llamas.jpg', 1953, 10, 'Los cuentos de Rulfo son breves y poéticos, y están llenos de simbolismo y ambigüedad. La violencia y la muerte son temas recurrentes en la obra, pero también hay espacio para la esperanza y la belleza.', 'El Llano en llamas es una obra maestra de la literatura mexicana. Los cuentos de Rulfo han sido elogiados por su realismo mágico, su belleza lírica y su profunda comprensión de la naturaleza humana.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788420619478, 'El amor en los tiempos del cólera', 5, 4, 'el_amor_en_los_tiempos_del_colera.jpg', 1985, 10, 'La novela narra la historia de Florentino Ariza, quien está enamorado de Fermina Daza desde que era un niño. A lo largo de los años, Florentino intenta ganarse el amor de Fermina, pero ella siempre lo rechaza. A pesar de los obstáculos, Florentino nunca se rinde y su amor por Fermina sigue siendo fuerte incluso después de décadas.', 'El amor en los tiempos del cólera es una obra maestra de la literatura latinoamericana que ha sido elogiada por su belleza lírica, su realismo mágico y su profunda exploración del amor y la pasión.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788437626977, 'Pedro Páramo', 7, 4, 'pedro_paramo.jpg', 1955, 10, 'Pedro Páramo es una novela que narra la historia de Juan Preciado, un joven que viaja a Comala en busca de su padre, Pedro Páramo. Al llegar a Comala, Juan Preciado se encuentra con un pueblo fantasma y con una serie de personajes extraños y solitarios. La novela es una exploración del amor, la muerte y la memoria.', 'Pedro Páramo es una obra maestra de la literatura mexicana.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788439702305, 'La casa de los espíritus', 8, 4, 'casa_de_los_espiritus.jpg', 1982, 10, 'La casa de los espíritus es una novela que narra la historia de la familia Trueba a lo largo de cuatro generaciones. La novela está ambientada en Chile y está llena de elementos mágicos y realistas. La casa de los espíritus es una historia de amor, pérdida y esperanza.', 'La casa de los espíritus es una obra maestra de la literatura latinoamericana que ha cautivado a lectores de todo el mundo.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788439702442, 'Como agua para chocolate', 9, 4, 'como_agua_para_chocolate.jpg', 1985, 10, 'Como agua para chocolate es una novela mágica realista que narra la historia de Tita, una joven que nació el día de la Revolución Mexicana y que está condenada a no amar porque si lo hace, matará a la persona que ama. Tita aprende a cocinar con su madre, Mamá Elena, y descubre que sus recetas tienen un poder mágico.', 'Como agua para chocolate es una obra maestra de la literatura latinoamericana que ha sido elogiada por su belleza poética, su realismo mágico.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788467232542, 'La ciudad de las estrellas', 10, 5, 'ciudad_de_las_estrellas.jpg', 2016, 10, 'La ciudad de las estrellas es una novela histórica que narra la historia de Simón Bolívar, el Libertador de América. La novela está ambientada en la Venezuela del siglo XIX y sigue a Bolívar desde su juventud hasta su muerte.', 'La ciudad de las estrellas es una obra maestra de la literatura hispanoamericana que ha sido elogiada por su rigor histórico, su narrativa apasionante y su retrato complejo de Simón Bolívar.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788420616622, 'El perfume', 11, 3, 'perfume.jpg', 1985, 10, 'El perfume es una novela histórica que narra la historia de Jean-Baptiste Grenouille, un hombre nacido sin sentido del olfato que desarrolla una extraordinaria capacidad para oler. Grenouille está obsesionado con crear el perfume perfecto y, para ello, no duda en asesinar a jóvenes mujeres para obtener su esencia.', 'El perfume es una obra maestra de la literatura alemana que ha sido elogiada por su originalidad, su atmósfera inquietante y su exploración de la naturaleza humana.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788466336389, 'La sombra del viento', 12, 2, 'la_sombra_del_viento.jpg', 2001, 10, 'La sombra del viento es una novela gótica que narra la historia de Daniel Sempere, un joven que descubre un libro misterioso en el Cementerio de los Libros Olvidados.', 'La sombra del viento es una obra maestra de la literatura española que ha sido elogiada por su belleza literaria, su atmósfera mágica y su historia apasionante.');

INSERT INTO book (isbn, title, author_id, gender_id, img_book, year_publication, stock, synopsis, criticism)
values (9788467233078, 'El nombre del viento', 13, 3, 'nombre_de_viento.jpg', 2007, 10, 'El nombre del viento es una novela de fantasía épica que narra la historia de Kvothe, un mago legendario que cuenta su propia historia desde su infancia hasta su juventud. Kvothe es un huérfano que se une a una compañía de artistas itinerantes y aprende a tocar la laúd, a hacer malabares y a contar historias. Con el tiempo, Kvothe descubre que tiene un talento natural para la magia y decide convertirse en mago.', 'El nombre del viento es una obra maestra de la literatura fantástica que ha sido elogiada por su narrativa apasionante, sus personajes complejos y su mundo mágico bien desarrollado.');
