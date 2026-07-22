# Schema Design

## MySQL Database Design

### Table: patients

| Column | Data Type | Constraints |
|--------|-----------|-------------|
| patient_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| first_name | VARCHAR(100) | NOT NULL |
| last_name | VARCHAR(100) | NOT NULL |
| email | VARCHAR(255) | UNIQUE, NOT NULL |
| phone | VARCHAR(20) | NOT NULL |
| date_of_birth | DATE | NOT NULL |

---

### Table: doctors

| Column | Data Type | Constraints |
|--------|-----------|-------------|
| doctor_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| first_name | VARCHAR(100) | NOT NULL |
| last_name | VARCHAR(100) | NOT NULL |
| specialization | VARCHAR(100) | NOT NULL |
| email | VARCHAR(255) | UNIQUE, NOT NULL |
| phone | VARCHAR(20) | NOT NULL |

---

### Table: appointments

| Column | Data Type | Constraints |
|--------|-----------|-------------|
| appointment_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| patient_id | INT | FOREIGN KEY REFERENCES patients(patient_id), NOT NULL |
| doctor_id | INT | FOREIGN KEY REFERENCES doctors(doctor_id), NOT NULL |
| appointment_date | DATETIME | NOT NULL |
| status | VARCHAR(30) | NOT NULL |

---

### Table: admin

| Column | Data Type | Constraints |
|--------|-----------|-------------|
| admin_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| username | VARCHAR(100) | UNIQUE, NOT NULL |
| password | VARCHAR(255) | NOT NULL |
| email | VARCHAR(255) | UNIQUE, NOT NULL |

---

## MongoDB Collection Design

### Collection: prescriptions

```json
{
  "_id": "66fd123456789",
  "patientId": 12,
  "doctorId": 5,
  "appointmentId": 30,
  "date": "2026-07-22",
  "medications": [
    {
      "name": "Ibuprofen",
      "dosage": "400mg",
      "frequency": "Twice a day",
      "duration": "5 days"
    },
    {
      "name": "Amoxicillin",
      "dosage": "500mg",
      "frequency": "Three times a day",
      "duration": "7 days"
    }
  ],
  "notes": "Take medications after meals.",
  "followUp": {
    "required": true,
    "date": "2026-08-01"
  }
}
```

### Design Decisions

- MySQL is used for structured data with clear relationships between patients, doctors, appointments, and administrators.
- Foreign keys ensure referential integrity between related tables.
- MongoDB is used for prescriptions because prescription data can vary in length and structure.
- Nested objects and arrays allow multiple medications and follow-up information to be stored in a single document.