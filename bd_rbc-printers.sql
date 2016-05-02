
SET CLIENT_ENCODING TO 'UTF8';

CREATE TABLE caso (
	id SERIAL,
	tipo_impressora VARCHAR(15),
	cabeamento VARCHAR(10),
	fonte VARCHAR(5),
	led_power VARCHAR(10),
	led_processamento VARCHAR(10),
	iluminador_scanner VARCHAR(15),
	imprimindo VARCHAR(50),
	scanner VARCHAR(15),
	alimentador VARCHAR(5),
	estufa VARCHAR(5),
	tonner VARCHAR(50),
	solucao VARCHAR(255),
	similaridade double precision
);

ALTER TABLE caso ADD PRIMARY KEY (id);

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Não', 'Cheio', 'Sim', 'Não há tonner', 'Adquira um tonner para esta impressora e insira na impressora.');

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Apagado', 'Aceso', 'Não', 'Sim', 'Cheio', 'Sim', 'Cheio', 'Reinstale o driver de impressão em seu computador.');

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Piscando', 'Apagado', 'Sim', 'Não', 'Cheio', 'Sim', 'Cheio', 'Troque a fonte. Problema de tensão.');

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Não', 'Desligado', 'Apagado', 'Apagado', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Ligue a impressora a uma fonte 220v para 110v.');

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Não', 'Cheio', 'Não', 'Vazio', 'Troque o tonner/fita por um cheio.');

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Piscando', 'Não possui', 'Impressão falhada', 'Não', 'Cheio', 'Sim', 'Cheio', 'Troque o cabo paralelo. Os dados estão corrompendo.');

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'USB', 'Sim', 'Ligado', 'Apagado', 'Não possui', 'Não', 'Não', 'Cheio', 'Não', 'Cheio', 'Reinstale o driver de impressão em seu computador.');

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Não', 'Desligado', 'Apagado', 'Não possui', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Ligue a impressora a uma fonte 220v para 110v.');

INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Sim', 'Cheio', 'Sim', 'Cheio', 'Atualize o firmware da impressora, depois religue-a.');
