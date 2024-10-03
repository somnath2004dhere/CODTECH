package Task6;

import java.io.Serializable;

public class Doctor implements Serializable {
    private String doctorID;
    private String name;
    private String specialty;

    public Doctor(String doctorID, String name, String specialty) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialty = specialty;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void displayDetails() {
        System.out.println("Doctor ID: " + doctorID);
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
    }
}

