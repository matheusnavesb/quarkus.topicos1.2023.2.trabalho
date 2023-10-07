-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO marca (nome, descricao) VALUES ('Chevrolet', 'Origem Americana, ha mais de 50 anos no mercado');
INSERT INTO marca (nome, descricao) VALUES ('Gurgel', 'Origem Brasileira, ha mais de 20 anos no mercado');
INSERT INTO marca (nome, descricao) VALUES ('Jaguar', 'Origem Inglesa, ha mais de 40 anos no mercado');
INSERT INTO marca (nome, descricao) VALUES ('Honda', 'Origem Japonesa, ha mais de 30 anos no mercado');

INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 1', 'Kit mecanica Chevy', 2999.99, 10);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 2', 'Kit mecanica Gurgel', 999.99, 5);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 3', 'Kit mecanica Jaguar', 4999.99, 2);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 4', 'Kit mecanica Honda', 3499.99, 20);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 5', 'Caixa de direcao Onix', 1499.99, 20);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 6', 'Motor Honda 1.5 flex', 32999.99, 2);


INSERT INTO marca_produto (id_marca, id_produto) VALUES (1, 1);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (2, 2);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (3, 3);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (4, 4);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (1, 5);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (4, 6);

