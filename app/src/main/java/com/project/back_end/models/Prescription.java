package com.project.back_end.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Prescription {

  // @Document annotation:
//    - Marks the class as a MongoDB document (a collection in MongoDB).
//    - The collection name is specified as "prescriptions" to map this class to the "prescriptions" collection in MongoDB.

// 1. 'id' field:
//    - Type: private String
//    - Description:
//      - Represents the unique identifier for each prescription.
//      - The @Id annotation marks it as the primary key in the MongoDB collection.
//      - The id is of type String, which is commonly used for MongoDB's ObjectId as it stores IDs as strings in the database.
@Id
private String id;
// 2. 'patientName' field:
//    - Type: private String
//    - Description:
//      - Represents the name of the patient receiving the prescription.
//      - The @NotNull annotation ensures that the patient name is required.
//      - The @Size(min = 3, max = 100) annotation ensures that the name length is between 3 and 100 characters, ensuring a reasonable name length.
@NotNull
@Size(min=3,max=100)
private String patientName;
// 3. 'appointmentId' field:
//    - Type: private Long
//    - Description:
//      - Represents the ID of the associated appointment where the prescription was given.
//      - The @NotNull annotation ensures that the appointment ID is required for the prescription.
@NotNull
private Long appointmentId;
// 4. 'medication' field:
//    - Type: private String
//    - Description:
//      - Represents the medication prescribed to the patient.
//      - The @NotNull annotation ensures that the medication name is required.
//      - The @Size(min = 3, max = 100) annotation ensures that the medication name is between 3 and 100 characters, which ensures meaningful medication names.
@NotNull
@Size(min=3,max=100)
private String medication;
// 5. 'dosage' field:
//    - Type: private String
//    - Description:
//      - Represents the dosage information for the prescribed medication.
//      - The @NotNull annotation ensures that the dosage information is provided.
@NotNull
private String dosage;
// 6. 'doctorNotes' field:
//    - Type: private String
//    - Description:
//      - Represents any additional notes or instructions from the doctor regarding the prescription.
//      - The @Size(max = 200) annotation ensures that the doctor's notes do not exceed 200 characters, providing a reasonable limit for additional notes.
@Size(max=200)
private String doctorNotes;

//Constructors

public Prescription() {
}

public Prescription(String patientName, String medication, String dosage,
                    String doctorNotes, Long appointmentId) {
    this.patientName = patientName;
    this.medication = medication;
    this.dosage = dosage;
    this.doctorNotes = doctorNotes;
    this.appointmentId = appointmentId;
}

//Getters and Setters
public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getPatientName() {
    return patientName;
}

public void setPatientName(String patientName) {
    this.patientName = patientName;
}

public Long getAppointmentId() {
    return appointmentId;
}

public void setAppointmentId(Long appointmentId) {
    this.appointmentId = appointmentId;
}

public String getMedication() {
    return medication;
}

public void setMedication(String medication) {
    this.medication = medication;
}

public String getDosage() {
    return dosage;
}

public void setDosage(String dosage) {
    this.dosage = dosage;
}

public String getDoctorNotes() {
    return doctorNotes;
}

public void setDoctorNotes(String doctorNotes) {
    this.doctorNotes = doctorNotes;
}

}
