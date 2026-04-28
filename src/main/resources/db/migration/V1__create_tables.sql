CREATE TABLE patient (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          last_name VARCHAR(50) NOT NULL,
                          first_name VARCHAR(50) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          phone VARCHAR(15),
                          birth_date DATE
);

CREATE TABLE doctor (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          specialty VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          phone VARCHAR(15)
);

CREATE TABLE medical_file (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          diagnosis TEXT,
                          observations TEXT,
                          creation_date DATE DEFAULT (CURRENT_DATE),
                          patient_id BIGINT NOT NULL UNIQUE,
                          CONSTRAINT fk_folder_patient FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE
);

CREATE TABLE appointment (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         appointment_date DATETIME NOT NULL,
                         status VARCHAR(20) NOT NULL,
                         patient_id BIGINT NOT NULL,
                         doctor_id BIGINT NOT NULL,
                         CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE,
                         CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES medecin(id) ON DELETE CASCADE
);