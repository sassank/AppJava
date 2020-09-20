DROP DATABASE IF EXISTS PPS11;

CREATE DATABASE IF NOT EXISTS PPS11;
USE PPS11;
# -----------------------------------------------------------------------------
#       TABLE : REPRESENTANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REPRESENTANT
 (
   IDR INT NOT NULL AUTO_INCREMENT,
   NOMR CHAR(32) NULL  ,
   PRENOMR CHAR(32) NULL  
   , PRIMARY KEY (IDR) 
 );

# -----------------------------------------------------------------------------
#       TABLE : HABITATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS HABITATION
 (
   IDH INT DEFAULT NOT NULL  AUTO_INCREMENT,
   NOMH CHAR(50) NULL  ,
   ADRH CHAR(50) NULL  ,
   NUMEROH INTEGER NULL  ,
   CPH INTEGER NULL  ,
   VILLEH CHAR(50) NULL  
   , PRIMARY KEY (IDH) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       TABLE : SAISON
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SAISON
 (
   IDS INT NOT NULL  AUTO_INCREMENT,
   REFERENCEC INT NOT NULL  ,
   DATEDEBS DATE NULL  ,
   DATEFINS DATE NULL  
   , PRIMARY KEY (IDS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE SAISON
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_SAISON_CONTRAT
     ON SAISON (REFERENCEC ASC);

# -----------------------------------------------------------------------------
#       TABLE : PROPRIETAIRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROPRIETAIRE
 (
    IDPROPRIETAIRE INTEGER NOT NULL  AUTO_INCREMENT,
    NOMP CHAR(50) NULL  ,
    PRENOMP CHAR(50) NULL  ,
    MDPP CHAR (50) NULL,
    MAILP CHAR (50) NULL,
    VILLEP CHAR(50) NULL  ,
    DATENAISSANCEP DATE NULL  ,
    PRIMARY KEY (IDPROPRIETAIRE) 
) ;
 
# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PROPRIETAIRE
# -----------------------------------------------------------------------------



# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
  IDC INTEGER NOT NULL  AUTO_INCREMENT ,
  NOMC CHAR(32) NULL  ,
  PRENOMC CHAR(32) NULL  ,
  MDPC CHAR (32) NULL,
  MAILC CHAR (32) NULL,
   DATENAISSC INTEGER NULL  ,
  PRIMARY KEY  (IDC)
) ;


# -----------------------------------------------------------------------------
#       TABLE : APPARTEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS APPARTEMENT
 (
   IDH INTEGER NOT NULL  ,
   NUMETAGE CHAR(32) NULL  ,
   NOMH CHAR(50) NULL  ,
   ADRH CHAR(50) NULL  ,
   NUMEROH INTEGER NULL  ,
   CPH INTEGER NULL  ,
   VILLEH CHAR(50) NULL  
   , PRIMARY KEY (IDH) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CONTRAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONTRAT
 (
   REFERENCEC INTEGER NOT NULL  AUTO_INCREMENT,
   IDPROPRIETAIRE INTEGER NOT NULL  ,
   IDH INT NOT NULL  ,
   OBJETC CHAR(50) NULL  ,
   DATEDEBUTC DATE NULL  ,
   DATEFINC DATE NULL  
   , PRIMARY KEY (REFERENCEC) 
 ) 
 comment = "";



# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONTRAT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONTRAT_PROPRIETAIRE
     ON CONTRAT (IDPROPRIETAIRE ASC);

CREATE  INDEX I_FK_CONTRAT_HABITATION
     ON CONTRAT (IDH ASC);

# -----------------------------------------------------------------------------
#       TABLE : CONTRATCLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONTRATCLIENT
 (
   REFEENCECC INTEGER NOT NULL AUTO_INCREMENT ,
   IDH INTEGER NOT NULL  ,
   IDR INT NOT NULL  ,
   IDPROPRIETAIRE INT NULL  ,
   OBJETCC CHAR(32) NULL  ,
   DATEDEBCC DATE NULL  ,
   DATEFINCC DATE NULL  ,
   DATESIGNCC DATE NULL  
   , PRIMARY KEY (REFEENCECC) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONTRATCLIENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONTRATCLIENT_HABITATION
     ON CONTRATCLIENT (IDH ASC);

CREATE UNIQUE INDEX I_FK_CONTRATCLIENT_RESERVATION
     ON CONTRATCLIENT (IDR ASC);

 CREATE UNIQUE INDEX I_FK_CONTRATCLIENT_HABITATION
     ON CONTRATCLIENT (IDPROPRIETAIRE ASC);

# -----------------------------------------------------------------------------
#       TABLE : RESERVATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RESERVATION
 (
   IDR INTEGER NOT NULL  AUTO_INCREMENT ,
   IDC INT NOT NULL  ,
   DATER DATE NULL  ,
   DATEDEBR DATE NULL  ,
   DATEFINR CHAR(32) NULL  ,
   ETATR CHAR(32) NULL  
   , PRIMARY KEY (IDR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE RESERVATION
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_RESERVATION_CLIENT
     ON RESERVATION (IDC ASC);

# -----------------------------------------------------------------------------
#       TABLE : MAISON
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MAISON
 (
   IDH INTEGER NOT NULL  ,
   SUPERFICIEEXTERNE CHAR(50) NULL  ,
   SUPERFICIEINTERNE CHAR(32) NULL  ,
   NOMH CHAR(50) NULL  ,
   ADRH CHAR(50) NULL  ,
   NUMEROH INTEGER NULL  ,
   CPH INTEGER NULL  ,
   VILLEH CHAR(50) NULL  
   , PRIMARY KEY (IDH) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       TABLE : MEMBRES
# ----------------------------------------------------------------------------- 

CREATE TABLE IF NOT EXISTS membres(
  id  INT NOT NULL PRIMARY KEY  AUTO_INCREMENT ,
  pseudo VARCHAR(255) NOT NULL ,
  mail VARCHAR(255) NOT NULL ,
  motdepasse TEXT NOT NULL ,
  droits enum("admin", "user", "autre")
  );



# -----------------------------------------------------------------------------
#       TABLE : MATERIEL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MATERIEL
 (
   IDM INT NOT NULL AUTO_INCREMENT ,
   IDC INT NOT NULL  ,
   IDC_1 CHAR(32) NOT NULL  ,
   NOMM CHAR(32) NULL  ,
   QUANTITEDISPO INTEGER NULL  ,
   PRIXJOURNALIER INTEGER NULL  
   , PRIMARY KEY (IDM) 
 ) 
 comment = "";

create table reservation_materiel
  (
    IDRM INT NOT NULL AUTO_INCREMENT ,
    IDM INT NOT NULL  ,
    DATER DATE NULL  ,
    DATEDEBR DATE NULL  ,
    DATEFINR CHAR(32) NULL  ,
    ETATR CHAR(32) NULL  
   , PRIMARY KEY (IDRM) 

  );

  create index I_FK_reservation_materiel_MATERIEL
    ON reservation_materiel (IDM ASC);
a# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE MATERIEL
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_MATERIEL_CLIENT
     ON MATERIEL (IDC ASC);




# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE SAISON 
  ADD FOREIGN KEY FK_SAISON_CONTRAT (REFERENCEC)
      REFERENCES CONTRAT (REFERENCEC) ;




ALTER TABLE APPARTEMENT 
  ADD FOREIGN KEY FK_APPARTEMENT_HABITATION (IDH)
      REFERENCES HABITATION (IDH) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_PROPRIETAIRE (IDPROPRIETAIRE)
      REFERENCES PROPRIETAIRE (IDPROPRIETAIRE) ;


ALTER TABLE CONTRATCLIENT 
  ADD FOREIGN KEY FK_CONTRATCLIENT_HABITATION (IDH)
      REFERENCES HABITATION (IDH) ;

ALTER TABLE CONTRATCLIENT 
  ADD FOREIGN KEY FK_CONTRATCLIENT_PROPRIETAIRE (IDPROPRIETAIRE)
      REFERENCES PROPRIETAIRE (IDPROPRIETAIRE) ;

      ALTER TABLE CONTRATCLIENT 
  ADD FOREIGN KEY FK_CONTRATCLIENT_RESERVATION (IDR)
      REFERENCES RESERVATION (IDR);


ALTER TABLE RESERVATION 
  ADD FOREIGN KEY FK_RESERVATION_CLIENT (IDC)
      REFERENCES CLIENT (IDC) ;


ALTER TABLE MAISON 
  ADD FOREIGN KEY FK_MAISON_HABITATION (IDH)
      REFERENCES HABITATION (IDH) ;

ALTER TABLE MATERIEL 
  ADD FOREIGN KEY FK_MATERIEL_CLIENT (IDC)
      REFERENCES CLIENT (IDC) ;

ALTER TABLE reservation_materiel 
ADD FOREIGN KEY I_FK_reservation_materiel_MATERIEL(IDM) 
  REFERENCES MATERIEL (IDM);


insert into client values (null, "client", "clientfamille", "ruede", "93600", "aulnay", "1997");


insert into habitation values ("1", "neige", "3rueTAREK", "2", "93600", "asb");


insert into membres values (null, "dje", "dje@gmail.com", "123", "admin");


insert into client values ("1", "client", "clientfamille", "ruede", "93600", "1997");
  


create table archive_materiel as select * from materiel;

drop procedure if exists verif_materiel;
delimiter //
create procedure verif_materiel (NumM int(4))
begin
declare nomMateriel varchar, quantitedispom int;
select nomM,quantitedispo into nomMateriel,quantitedispom from materiel, client where
c.idc =  m.idc and m.idm = numM;
if (quantitedispo < 1 )
then
  insert into archive_materiel
  select * from materiel
   where idM = numM;
  end if;
  end //
  delimiter;


