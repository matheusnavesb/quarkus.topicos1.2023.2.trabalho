-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into usuario (nome, login , senha,perfil) values('Joao Silva', 'joao','O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',1);

insert into usuario (nome, login , senha,perfil) values('Jose Andrade', 'jose','O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2);

insert into telefone (codigoArea, numero) values('63', '9999-9999' );
insert into telefone (codigoArea, numero) values('62', '8888-8888' );
insert into telefone (codigoArea, numero) values('61', '7777-7777' );
insert into telefone (codigoArea, numero) values('55', '6666-6666' );

insert into usuario_telefone (id_usuario, id_telefone) values(1, 1 );
insert into usuario_telefone (id_usuario, id_telefone) values(1, 2 );
insert into usuario_telefone (id_usuario, id_telefone) values(2, 3 );
insert into usuario_telefone (id_usuario, id_telefone) values(2, 4 );


--INSERT INTO produto (nome, descricao, 1, preco, estoque) VALUES ('Produto 1', 'Kit mecanica', 999.99, 10);
--INSERT INTO produto (nome, descricao, 2, preco, estoque) VALUES ('Produto 2', 'Kit suspensao', 2999.99, 5);
--INSERT INTO produto (nome, descricao, 3, preco, estoque) VALUES ('Produto 3', 'Kit direcao', 4999.99, 2);
--INSERT INTO produto (nome, descricao, 4, preco, estoque) VALUES ('Produto 4', 'Kit estetica', 3499.99, 20);
--INSERT INTO produto (nome, descricao, 5, preco, estoque) VALUES ('Produto 5', 'Kit eletrico', 1499.99, 20);




