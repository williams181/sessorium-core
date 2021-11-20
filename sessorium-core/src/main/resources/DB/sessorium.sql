create database sessorium;
use sessorium;

create table aluno (
    nome varchar(50),
    matricula varchar(15),
    email varchar(50),
    felefone varchar(11),
    cpf varchar(11),
    dataNascimento varchar(10),
    pais varchar(50),
    obs varchar(200),
    ped varchar(3),
    descricao varchar(100)
);

create table pais (
    aluno varchar(50),
    email varchar(50),
    felefone varchar(11),
    cpf varchar(11),
    dataNascimento varchar(10)
);

create table professor (
    aluno varchar(50),
    email varchar(50),
    felefone varchar(11),
    cpf varchar(11),
    dataNascimento varchar(10),
    formacao varchar(40),
    curso varchar (40),
    instituto varchar(50)
);

create table cordenador (
    aluno varchar(50),
    email varchar(50),
    felefone varchar(11),
    cpf varchar(11),
    dataNascimento varchar(10),
    formacao varchar(40),
    curso varchar (40),
    instituto varchar(50)
);

create table escola (
    nome varchar(50),
    cnpj varchar(25),
    endereco varchar(50),
    telefone varchar(11),
    categoria varchar(30),
    codigo int
);

create table turma (
    nome varchar(40),
    ano int,
    turno varchar(20)
);

create table materias (
    nome varchar(50),
    professor varchar(50),
    conteudo varchar(50),
    cargaHoraria int
);