DROP TABLE IF EXISTS WORKER, HABILITAÇÕES, SALES, DEPARTAMENTO, FORNECEDOR, CLIENTE,ARMAZEM,FORNECE,ENTREGA;

CREATE TABLE WORKER(
	Id 			INT PRIMARY KEY AUTO_INCREMENT,
	Email 		VARCHAR(64) NOT NULL,
	
	Name 		VARCHAR(128) NOT NULL,
	Sexo 		ENUM('M','F') NOT NULL,
	DataNasc	DATE NOT NULL,

	Rua 		VARCHAR(168) NOT NULL,
	Num 		INT NOT NULL,
	Andar 		INT DEFAULT NULL,
	Cidade 		VARCHAR(64) NOT NULL,
	NumTele 	INT NOT NULL,
	Supervisor	INT DEFAULT NULL,
	
	Salario 	INT NOT NULL,
	IdDep 		INT NOT NULL,

	FOREIGN KEY (Supervisor) REFERENCES WORKER(Id)
);

CREATE TABLE CLIENTE (
	Email 		VARCHAR(64) NOT NULL,
	NomeCliente VARCHAR(128) DEFAULT NULL,
	NomeEmpresa VARCHAR(128) NOT NULL,

	Rua 		VARCHAR(168) NOT NULL,
	Num 		INT NOT NULL,
	Andar 		INT DEFAULT NULL,
	Cidade 		VARCHAR(64) NOT NULL,
	
	DataInicio 	DATE NOT NULL,
	NumTele 	INT NOT NULL,

	PRIMARY KEY(Email)
);

CREATE TABLE SALES (
	Id 			INT PRIMARY KEY AUTO_INCREMENT,
	Email 		VARCHAR(64) NOT NULL,
	EmailCliente VARCHAR(64) DEFAULT NULL,
	
	Name 		VARCHAR(128) NOT NULL,
	DataNasc 	DATE NOT NULL,
	Sexo 		ENUM('M','F') NOT NULL,
	
	Rua 		VARCHAR(168) NOT NULL,
	Num 		INT NOT NULL,
	Andar 		INT DEFAULT NULL,
	Cidade 		VARCHAR(64) NOT NULL,
	NumTele 	INT NOT NULL,
	
	Salario 	INT NOT NULL,
	Vendas 		INT NOT NULL,
	Bonus 		INT NOT NULL,
	FOREIGN KEY (EmailCliente) REFERENCES CLIENTE(Email)

);

CREATE TABLE HABILITAÇÕES (
	Sales 		INT NOT NULL,
	
	Grau 		VARCHAR(64) NOT NULL,
	Instituição VARCHAR(64) NOT NULL,
	Ano 		INT NOT NULL,
	
	PRIMARY KEY (Sales,Grau,Instituição,Ano),
	FOREIGN KEY (Sales) REFERENCES SALES(Id)
);

CREATE TABLE DEPARTAMENTO (
	IdDep 		INT PRIMARY KEY AUTO_INCREMENT,
	Sala VARCHAR(64)
);

INSERT INTO
	DEPARTAMENTO(IdDep,Sala)
VALUES
	(1,'Sala princial'),
	(2,'Sala 1.15'),
	(3,'Secretaria');

ALTER TABLE HABILITAÇÕES ADD FOREIGN KEY(Sales) REFERENCES SALES(Id);
INSERT INTO 
 	WORKER(Id,Email,Name,Sexo,DataNasc,Rua,Num,Andar,Cidade,NumTele,Supervisor,Salario,IdDep)
VALUES
 	(1, 'bestbossever@dundermifflin.com','Michael Scott', 'M','1965-02-15','Kellum Court', 42, NULL, 'Scranton', 1111111111, NULL,3500,1),
 	(2, 'stanleyhudson@dundermifflin.com','Stanley Hudson', 'M','1958-02-19','Kellum Court', 43, NULL, 'Scranton', 1111111112, 1,3400,2),
 	(3, 'pambeesly@dundermifflin.com','Pamela Beesly', 'F','1979-03-25','Calvert Street', 13831, NULL, 'Scranton', 1111111113, 1,3400,3);

ALTER TABLE WORKER ADD FOREIGN KEY(IdDep) REFERENCES DEPARTAMENTO(IdDep); 
ALTER TABLE DEPARTAMENTO ADD FOREIGN KEY (IdDep) REFERENCES WORKER(Id);


CREATE TABLE FORNECEDOR (
	
	Nome VARCHAR(128) NOT NULL,

	Rua 		VARCHAR(168) NOT NULL,
	Num 		INT NOT NULL,
	Andar 		INT DEFAULT NULL,
	Cidade 		VARCHAR(64) NOT NULL,

	PRIMARY KEY(Nome)
);

INSERT INTO
	FORNECEDOR(Nome,Rua,Num,Andar,Cidade)
VALUES
	('Papel','rua papel',43,NULL,'PaperTown');


CREATE TABLE ARMAZEM (
	Nome 		VARCHAR(128) NOT NULL,

	Rua 		VARCHAR(168) NOT NULL,
	Num 		INT NOT NULL,
	Andar 		INT DEFAULT NULL,
	Cidade 		VARCHAR(64) NOT NULL,

	Gerente 	INT NOT NULL,

	PRIMARY KEY(Nome,Gerente),
	FOREIGN KEY(Gerente) REFERENCES WORKER(Id)
);

INSERT INTO
	ARMAZEM(Nome,Rua,Num,Andar,Cidade,Gerente)
VALUES
	('Scranton','Slough Avenue',1725,NULL,'Scraton',2);


CREATE TABLE FORNECE (
	Fornecedor 	VARCHAR(128) NOT NULL,
	Armazem 	VARCHAR(128) NOT NULL,

	PRIMARY KEY(Fornecedor,Armazem),
	FOREIGN KEY(Fornecedor) REFERENCES FORNECEDOR(Nome),
	FOREIGN KEY(Armazem) REFERENCES ARMAZEM(Nome)
);

INSERT INTO
	FORNECE(Fornecedor,Armazem)
VALUES
	('Papel','Scranton');


CREATE TABLE ENTREGA (
	Armazem 	VARCHAR(128) NOT NULL,
	Cliente 	VARCHAR(64) NOT NULL,

	PRIMARY KEY(Armazem,CLiente),

	FOREIGN KEY(Armazem) REFERENCES ARMAZEM(Nome),
	FOREIGN KEY(Cliente) REFERENCES CLIENTE(Email)
);

INSERT INTO
	CLIENTE(Email,NomeCliente,NomeEmpresa,Rua,Num,Andar,Cidade,DataInicio,NumTele)
VALUES
	('ilikestrangling@scraton.com','The Strangler','Strangling business','Calvert Street', 138, NULL, 'Scranton','2008-10-5',111111);

INSERT INTO
	SALES(Id,Email,EmailCliente,Name,Sexo,DataNasc,Rua,Num,Andar,Cidade,NumTele,Salario,Vendas,Bonus)
VALUES
	(4,'jimhalpert@dundermifflin.com','ilikestrangling@scraton.com', 'Jim Halpert','M','1978-10-1','Calvert Street', 13831, NULL, 'Scranton',111112	,3500,50,500);

INSERT INTO
	ENTREGA
VALUES
	('Scranton','ilikestrangling@scraton.com');

INSERT INTO 
	HABILITAÇÕES(Sales,Grau,Instituição,Ano)
VALUES
	(4,'Bachelor','Scranton Uni',1998);



	
 





