CREATE DATABASE IF NOT EXISTS MakeBeauty1;
USE MakeBeauty1;

CREATE TABLE IF NOT EXISTS makeBeauty(
  id INT AUTO_INCREMENT PRIMARY KEY,
  marca VARCHAR(50) NOT NULL,
  nome_produto VARCHAR(100) NOT NULL UNIQUE,
  preco DOUBLE NOT NULL,
  data_valid DATE
);

CREATE TABLE IF NOT EXISTS cuidado_capilar(
  id INT PRIMARY KEY,
  tratamento VARCHAR(100),
  finalizador VARCHAR(100),
  limpeza VARCHAR(100),
  
  FOREIGN KEY (id) REFERENCES makeBeauty(id)
);

CREATE TABLE IF NOT EXISTS maquiagem(
  id INT PRIMARY KEY,
  labios VARCHAR(100),
  rosto VARCHAR(100),
  olhos VARCHAR(100),
  preparacao VARCHAR(100),
  
  FOREIGN KEY (id) REFERENCES makeBeauty(id)
);

CREATE TABLE IF NOT EXISTS cuidado_corporal(
  id INT PRIMARY KEY,
  higiene_corporal VARCHAR(100),
  body_care VARCHAR (100),
  nail_care VARCHAR(100),
  skin_care VARCHAR(100),
  
  FOREIGN KEY (id) REFERENCES makeBeauty(id)
);

SELECT*FROM makeBeauty;



  
  


