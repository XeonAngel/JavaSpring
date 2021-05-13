-- Insert Into Angajati(Id_Angajat,Nume,Prenume,Data_Nastere, Id_Grad,Id_Ocupatie,Id_Specializare) Values (1,'Kendrick ','Begum',To_Date('1960/02/03', 'yyyy/mm/dd'),1,1,1);
-- Insert Into Angajati(Id_Angajat,Nume,Prenume,Data_Nastere, Id_Grad,Id_Ocupatie,Id_Specializare) Values (2,'Rose ','Delaney',To_Date('1980/04/07', 'yyyy/mm/dd'),2,2,2);
-- Insert Into Angajati(Id_Angajat,Nume,Prenume,Data_Nastere, Id_Grad,Id_Ocupatie,Id_Specializare) Values (3,'Nicholas ','Burch',To_Date('1995/06/15', 'yyyy/mm/dd'),3,3,3);
-- Insert Into Angajati(Id_Angajat,Nume,Prenume,Data_Nastere, Id_Grad,Id_Ocupatie,Id_Specializare) Values (4,'Kayleigh ','Graves',To_Date('1990/08/22', 'yyyy/mm/dd'),4,4,4);
-- Insert Into Angajati(Id_Angajat,Nume,Prenume,Data_Nastere, Id_Grad,Id_Ocupatie,Id_Specializare) Values (5,'Jaxson ','Fountain',To_Date('1975/10/12', 'yyyy/mm/dd'),2,2,5);
--
-- Insert Into Pacienti(Id_Pacient,Nume,Prenume,Data_Nastere,Id_Supervisor) Values (1,'Thalia','Thorne',To_Date('17/12/1983','dd/mm/yyyy'),2);
-- Insert Into Pacienti(Id_Pacient,Nume,Prenume,Data_Nastere,Id_Supervisor) Values (2,'Veronika','Barrow',To_Date('23/3/1935','dd/mm/yyyy'),5);
-- Insert Into Pacienti(Id_Pacient,Nume,Prenume,Data_Nastere,Id_Supervisor) Values (3,'Sion','Seymour',To_Date('3/10/1992','dd/mm/yyyy'),2);
-- Insert Into Pacienti(Id_Pacient,Nume,Prenume,Data_Nastere,Id_Supervisor) Values (4,'Rayan','French',To_Date('6/1/1970','dd/mm/yyyy'),5);
-- Insert Into Pacienti(Id_Pacient,Nume,Prenume,Data_Nastere,Id_Supervisor) Values (5,'Eshaal','Winters',To_Date('29/8/1994','dd/mm/yyyy'),3);

Insert Into staff(last_name,first_name,birth_day, staff_rank) Values ('Kendrick','Begum','1960/02/03',1);
Insert Into staff(last_name,first_name,birth_day, staff_rank) Values ('Rose','Delaney','1980/04/07',2);
Insert Into staff(last_name,first_name,birth_day, staff_rank) Values ('Nicholas','Burch','1995/06/15',3);
Insert Into staff(last_name,first_name,birth_day, staff_rank) Values ('Kayleigh','Graves','1990/08/22',3);
Insert Into staff(last_name,first_name,birth_day, staff_rank) Values ('Jaxson','Fountain','1975/10/12',4);

Insert Into Patient(last_name,first_name,birth_day,blood_type) Values ('Thalia','Thorne',str_to_date('17/12/1983','%d/%m/%Y'),0);
Insert Into Patient(last_name,first_name,birth_day,blood_type) Values ('Veronika','Barrow',str_to_date('23/3/1935','%d/%m/%Y'),1);
Insert Into Patient(last_name,first_name,birth_day,blood_type) Values ('Sion','Seymour',str_to_date('3/10/1992','%d/%m/%Y'),1);
Insert Into Patient(last_name,first_name,birth_day,blood_type) Values ('Rayan','French',str_to_date('6/1/1970','%d/%m/%Y'),2);
Insert Into Patient(last_name,first_name,birth_day,blood_type) Values ('Eshaal','Winters',str_to_date('29/8/1994','%d/%m/%Y'),3);