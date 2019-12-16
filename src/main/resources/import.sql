INSERT INTO avales(id_aval,nombre)VALUES(1,'Esneca Business School');
INSERT INTO avales(id_aval,nombre)VALUES(2,'FormaInfancia European School');
INSERT INTO avales(id_aval,nombre)VALUES(3,'Universidad Técnica del Norte');
INSERT INTO avales(id_aval,nombre)VALUES(4,'Universidad Técnica de Cotopaxi');
INSERT INTO avales(id_aval,nombre)VALUES(5,'Formación Bambalinas');

INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(1,'Cuantificadores','Todos, alguno, ninguno, tantos, como, igual que');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(2,'Números','1,2,3,4,5 y 6 | Primero, Segundo, Tercero');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(3,'Colores','Todos, mezclas básicas');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(4,'Figuras','Cuadrado, rectángulo, círculo');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(5,'Seriaciones','De 3 elementos y hasta con 3 atributos');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(6,'Conceptos','Fino-grueso, todo-nada');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(7,'Nociones espaciales','A un lado, al otro lado, derecha, al lado de, en medio de, alrededor');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(8,'Nociones temporales','Ahora, antes, después, meses del año');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(9,'Grafomotricidad','Cruz, espiral, onda, trazo arriba, trazo abajo');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(10,'Lecto escritura','Nombre y apellido (copiando), Letras en mayúsculas');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(11,'Plástica','Collage, recortado, punteado, pintura con pincel');
INSERT INTO tipo_destrezas(id_tipo_destreza,definicion, descripcion)VALUES(12,'Música','Pulso, ecos rítmicos, contacto con los instrumentos, respiración, ritmo');

INSERT INTO tipo_vacunas(id_tipo_vacuna, enfermedad, nombre, numero_dosis, dosis, via, edades)VALUES(1,'Tuberculosis','BCG', 1, '0,1 ml', 'Intradérmica','Recién nacido');
INSERT INTO tipo_vacunas(id_tipo_vacuna, enfermedad, nombre, numero_dosis, dosis, via, edades)VALUES(2,'Poliomielitis','Antipolio', 2, '2 gotas', 'Vía oral','2 meses, 4 meses, 6 meses. Refuerzo: 18 meses, 5 años');


INSERT INTO estudiantes(id_persona,nombre,cedula,fecha_nacimiento,sexo,fecha_ingreso,procedencia,observacion,lateralidad)VALUES(1,'Tamia Casachini','0123456780','2014-08-14','M','2017-09-03','Ludoteca','Ninguna','D');
INSERT INTO estudiantes(id_persona,nombre,cedula,fecha_nacimiento,sexo,fecha_ingreso,procedencia,observacion,lateralidad)VALUES(2,'Daniel García','0123456781','2014-02-27','H','2017-09-03','Primer registro escolar','Vive únicamente con la madre','D');

INSERT INTO docentes(id_persona,nombre,cedula,fecha_nacimiento,sexo,fecha_ingreso,email,grado,institucion)VALUES(1,'Carla Rueda','0502456780','1985-07-17','M','2010-09-03','crueda@unidadeducativa.com','Maestra Parvularia','Universidad Técnica de Ambato');
INSERT INTO docentes(id_persona,nombre,cedula,fecha_nacimiento,sexo,fecha_ingreso,email,grado,institucion)VALUES(2,'Karina Castro','0502456781','1979-10-31','M','2014-09-01','kcastro@unidadeducativa.com','Maestra Parvularia','Universidad Técnica de Cotopaxi');
