
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
	alimentador VARCHAR(15),
	estufa VARCHAR(15),
	tonner VARCHAR(50),
	solucao VARCHAR(255),
	similaridade double precision
);

ALTER TABLE caso ADD PRIMARY KEY (id);
--0
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Não', 'Cheio', 'Sim', 'Não há tonner', 'Adquira um tonner para esta impressora e insira na impressora.');
--1
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Aceso', 'Não', 'Sim', 'Cheio', 'Sim', 'Cheio', 'Reinstale o driver de impressão em seu computador.');
--2
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Piscando', 'Apagado', 'Sim', 'Não', 'Cheio', 'Sim', 'Cheio', 'Troque a fonte. Problema de tensão.');
--3
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Não', 'Desligado', 'Desligado', 'Apagado', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Ligue a impressora a uma fonte 220v para 110v.');
--4
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Não', 'Cheio', 'Não', 'Pouca carga', 'Troque o tonner/fita por um cheio.');
--5
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Piscando', 'Não possui', 'Impressão falhada', 'Não', 'Cheio', 'Sim', 'Cheio', 'Troque o cabo paralelo. Os dados estão corrompendo.');
--6
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'USB', 'Sim', 'Ligado', 'Desligado', 'Não possui', 'Não', 'Não', 'Cheio', 'Não', 'Cheio', 'Reinstale o driver de impressão em seu computador.');
--7
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Não', 'Desligado', 'Desligado', 'Não possui', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Ligue a impressora a uma fonte 220v para 110v.');
--8
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Sim', 'Cheio', 'Sim', 'Cheio', 'Atualize o firmware da impressora, depois religue-a.');
--9
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Ligado', 'Não possui', 'Não', 'Não', 'Vazio', 'Não', 'Cheio', 'Alimente a bandeja de papel.');
--10
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Apagado', 'Não', 'Não', 'Cheio', 'Não', 'Cheio', 'Troque o cabo USB. Os dados não estão chegando.');
--11
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Desligado', 'Desligado', 'Apagado', 'Não', 'Não', 'Sim', 'Sim', 'Cheio', 'Ligue a impressora no botão power.');
--12
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Desligado', 'Não possui', 'Não', 'Não', 'Poucas folhas', 'Não', 'Cheio', 'Conecte o cabo paralelo ao computador.');
--13
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Não', 'Cheio', 'Não', 'Cheio', 'Há um papel atolado no fusor. Remover folha trancada.');
--14
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Não possui', 'Imprime em branco', 'Não', 'Cheio', 'Não', 'Pouca carga', 'Troque o tonner por um cheio.');
--15
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Apagado', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Spool de impressão pausado. Reiniciar impressão.');
--16
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Não', 'Desligado', 'Desligado', 'Não possui', 'Sim', 'Não', 'Cheio', 'Sim', 'Cheio', 'Ligue a impressora a uma fonte 220v para 110v.');
--17
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Piscando', 'Piscando', 'Não possui', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Tonner com problema. Substituir tonner.');
--18
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Piscando', 'Aceso', 'Sim', 'Sim', 'Cheio', 'Sim', 'Cheio', 'Limpe a fila de impressão ou reinicie o computador.');
--19
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Ligado', 'Não possui', 'Sim', 'Não', 'Cheio', 'Sim', 'Cheio', 'Limpe a fila de impressão ou reinicie o computador.');
