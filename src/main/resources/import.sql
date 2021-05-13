Insert Into department(name) Values ('Boli interne');
Insert Into department(name) Values ('Boli externe');
Insert Into department(name) Values ('General');
Insert Into department(name) Values ('Boli infectioase');

Insert Into specialization(name,department_id) Values ('Neurologie',1);
Insert Into specialization(name,department_id) Values ('Urologie',1);
Insert Into specialization(name,department_id) Values ('Pshihologie',3);
Insert Into specialization(name,department_id) Values ('Pediatrie',3);
Insert Into specialization(name,department_id) Values ('Dermatologie',2);

Insert Into occupation(name,base_salary) Values ('Manager',4230);
Insert Into occupation(name,base_salary) Values ('Doctor',3300);
Insert Into occupation(name,base_salary) Values ('Asistent Medical',2500);
Insert Into occupation(name,base_salary) Values ('Bracardier',1800);

Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Kendrick','Begum',PARSEDATETIME('1960/02/03','yyyy/mm/dd'),1,1,1);
Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Rose','Delaney',PARSEDATETIME('1980/04/07','yyyy/mm/dd'),2,2,2);
Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Nicholas','Burch',PARSEDATETIME('1995/06/15','yyyy/mm/dd'),3,3,3);
Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Kayleigh','Graves',PARSEDATETIME('1990/08/22','yyyy/mm/dd'),3,4,4);
Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Jaxson','Fountain',PARSEDATETIME('1975/10/12','yyyy/mm/dd'),2,2,5);