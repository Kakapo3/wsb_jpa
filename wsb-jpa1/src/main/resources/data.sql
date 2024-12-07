-- ADDRESS --

insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'add1wr', 'add2wr', 'Wroclaw', '12-345');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (2, 'add1wa', 'add2wa', 'Warszawa', '69-420');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (3, 'add1op', 'add2op', 'Opole', '77-777');

-- DOCTOR --

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address)
            values (1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@gmail.com', '123', 'Okulista', 1);

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address)
            values (2, 'Anna', 'Nowak', '111222333', 'anna.nowak@o2.com', '125', 'Laryngolog', 1);

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address)
            values (3, 'Adam', 'Mlynarz', '123123123', 'adam.mlynarz@gmail.com', '134', 'Dentysta', 3);


-- PATIENT --

insert into patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address)
            values (1, '1995-01-01', 'bartosz.nowak@gmail.com', 'Bartosz', 'Nowak', '111', '123654789', 2);

insert into patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address)
            values (2, '1992-08-21', 'jp2@gmail.com', 'Karol', 'Wojtyla', '133', '132465798', 3);

-- VISIT --

insert into visit (id, description, time, doctor, patient)
            values (1, 'Opis wizyty 1', '2023-12-01 10:00:00', 1, 1);

insert into visit (id, description, time, doctor, patient)
            values (2, 'Opis wizyty 2', '2023-12-05 15:30:00', 2, 1);

insert into visit (id, description, time, doctor, patient)
            values (3, 'Opis wizyty 3', '2023-12-07 09:00:00', 1, 2);

-- MEDICAL TREATMENT --

insert into medical_treatment (id, description, type, visit)
            values (1, 'Opis leczenia 1', 'USG', 1);

insert into medical_treatment (id, description, type, visit)
            values (2, 'Opis leczenia 2', 'EKG', 2);

insert into medical_treatment (id, description, type, visit)
            values (3, 'Opis leczenia 3.1', 'RTG', 3);

insert into medical_treatment (id, description, type, visit)
            values (4, 'Opis leczenia 3.2', 'USG', 3);