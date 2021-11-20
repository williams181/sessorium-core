create database sessorium;
use sessorium;

create table aluno (
    nome varchar(50),
    matricula varchar(15),
    email varchar(50),
    felefone varchar(11),
    dataNascimento Date,
    pais varchar(50),
    obs varchar(600),
    pcd boolean,
    descricao varchar(200)
);

create table pais (
    aluno varchar(50),
    email varchar(50),
    felefone varchar(11),
    cpf varchar(11),
    dataNascimento Date
);

create table professor (
    nome varchar(50),
    email varchar(50),
    felefone varchar(11),
    cpf varchar(11),
    dataNascimento Date,
    formacao varchar(100),
    curso varchar (100),
    instituto varchar(100)
);

create table cordenador (
    nome varchar(50),
    email varchar(50),
    felefone varchar(11),
    cpf varchar(11),
    dataNascimento Date,
    formacao varchar(100),
    curso varchar (100),
    instituto varchar(100)
);

create table escola (
    nome varchar(100),
    cnpj varchar(25),
    endereco varchar(100),
    telefone varchar(11),
    categoria varchar(100),
    codigo int
);

create table turma (
    nome varchar(100),
    ano int,
    turno varchar(50)
);

create table materias (
    nome varchar(100),
    professor varchar(50),
    conteudo varchar(600),
    cargaHoraria int
);