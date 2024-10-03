package Task6;

import java.io.Serializable;

public class EHR implements Serializable {
    private String patientID;
    private String medicalHistory;
    private String prescriptions;

    public EHR(String patientID, String medicalHistory, String prescriptions) {
        this.patientID = patientID;
        this.medicalHistory = medicalHistory;
        this.prescriptions = prescriptions;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void displayEHRDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Prescriptions: " + prescriptions);
    }
}

