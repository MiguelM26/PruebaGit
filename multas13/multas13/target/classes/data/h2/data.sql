INSERT INTO SECUENCIAS (NOMBRE, VALOR) VALUES
('MULTAS_SEQ', 10000),
('AGENTES_SEQ', 10000);

INSERT INTO AGENTES (CODIGO, NOMBRE, APELLIDO1, APELLIDO2) VALUES
('46778234R','Pepín','Gálvez','Ridruejo'),
('27855059S','Honorio','Martín','Salvador'),
('34011983T','Carlota','Cifuentes','Merino');

INSERT INTO MULTAS (CODIGO, CODIGO_AGENTE, FECHA_HORA, MATRICULA, IMPORTE, INFRACCION, LUGAR, OBSERVACIONES) VALUES
(100, '46778234R', '2018-11-28 23:59:59', 'A6536XX', 250.00, 'Se salto semaforo en rojo', 'Ronda hispanidad', 'El infractor no quiere colaborar'),
(101,'27855059S', '2018-09-15 21:00:00', 'B3536XX', 100.00, 'Aparco en carga y descarga', 'calle Predicadores', ''),
(102, '34011983T', '2018-09-15 21:00:00', 'B3536XX', 100.00, 'Compro tabaco a un menor', 'Paseo independencia', '');






