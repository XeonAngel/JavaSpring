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

Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Kendrick','Begum',str_to_date('1960/02/03','%Y/%m/%d'),1,1,1);
Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Rose','Delaney',str_to_date('1980/04/07','%Y/%m/%d'),2,2,2);
Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Nicholas','Burch',str_to_date('1995/06/15','%Y/%m/%d'),3,3,3);
Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Kayleigh','Graves',str_to_date('1990/08/22','%Y/%m/%d'),3,4,4);
Insert Into staff(last_name,first_name,birth_day, staff_rank,occupation_id,specialization_id) Values ('Jaxson','Fountain',str_to_date('1975/10/12','%Y/%m/%d'),2,2,5);

Insert Into patient(last_name,first_name,birth_day,blood_type) Values ('Thalia','Thorne',str_to_date('17/12/1983','%d/%m/%Y'),0);
Insert Into patient(last_name,first_name,birth_day,blood_type) Values ('Veronika','Barrow',str_to_date('23/3/1935','%d/%m/%Y'),1);
Insert Into patient(last_name,first_name,birth_day,blood_type) Values ('Sion','Seymour',str_to_date('3/10/1992','%d/%m/%Y'),1);
Insert Into patient(last_name,first_name,birth_day,blood_type) Values ('Rayan','French',str_to_date('6/1/1970','%d/%m/%Y'),2);
Insert Into patient(last_name,first_name,birth_day,blood_type) Values ('Eshaal','Winters',str_to_date('29/8/1994','%d/%m/%Y'),3);

Insert Into distributor(name) Values ('MadiPlus');
Insert Into distributor(name) Values ('FarmExpert');
Insert Into distributor(name) Values ('Fildas');
Insert Into distributor(name) Values ('Pfizer');

Insert Into drug(name,price,stock,distributor_id,drug_category) Values ('Flucovim',20,200,1,1);
Insert Into drug(name,price,stock,distributor_id,drug_category) Values ('Omeprazol',39,150,2,1);
Insert Into drug(name,price,stock,distributor_id,drug_category) Values ('NovoPone',15,200,3,1);
Insert Into drug(name,price,stock,distributor_id,drug_category) Values ('Vitamina C',12,400,4,3);

Insert Into consultation(created, doctor_id, patient_id) Values (CURDATE(),2,1);
Insert Into consultation(created, doctor_id, patient_id) Values (CURDATE(),5,2);
Insert Into consultation(created, doctor_id, patient_id) Values (CURDATE(),2,3);
Insert Into consultation(created, doctor_id, patient_id) Values (CURDATE(),2,1);

Insert Into consultation_drug(consultation_id, drug_id) Values (1,1);
Insert Into consultation_drug(consultation_id, drug_id) Values (1,2);
Insert Into consultation_drug(consultation_id, drug_id) Values (2,2);
Insert Into consultation_drug(consultation_id, drug_id) Values (2,4);
Insert Into consultation_drug(consultation_id, drug_id) Values (3,1);
Insert Into consultation_drug(consultation_id, drug_id) Values (3,2);
Insert Into consultation_drug(consultation_id, drug_id) Values (3,4);
Insert Into consultation_drug(consultation_id, drug_id) Values (4,4);