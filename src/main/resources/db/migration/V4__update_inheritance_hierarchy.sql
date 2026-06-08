ALTER TABLE medical_file DROP FOREIGN KEY fk_folder_patient;
ALTER TABLE appointment DROP FOREIGN KEY fk_appointment_patient;
ALTER TABLE appointment DROP FOREIGN KEY fk_appointment_doctor;

ALTER TABLE patient DROP COLUMN email;
ALTER TABLE doctor DROP COLUMN email;

ALTER TABLE patient MODIFY id BIGINT NOT NULL;
ALTER TABLE doctor MODIFY id BIGINT NOT NULL;

ALTER TABLE patient ADD CONSTRAINT fk_patient_users FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE;
ALTER TABLE doctor ADD CONSTRAINT fk_doctor_users FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE medical_file ADD CONSTRAINT fk_folder_patient FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE;
ALTER TABLE appointment ADD CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE;
ALTER TABLE appointment ADD CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE CASCADE;