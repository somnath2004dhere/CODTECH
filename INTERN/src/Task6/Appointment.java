package Task6;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
    private String appointmentID;
    private String patientID;
    private String doctorName;
    private Date appointmentDate;

    public Appointment(String appointmentID, String patientID, String doctorName, Date appointmentDate) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void displayAppointmentDetails() {
        System.out.println("Appointment ID: " + appointmentID);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Doctor Name: " + doctorName);
        System.out.println("Appointment Date: " + appointmentDate);
    }
}


