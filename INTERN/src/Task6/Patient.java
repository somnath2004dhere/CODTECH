package Task6;

import java.io.Serializable;


import java.util.UUID;

public class Patient implements Serializable {
    private String patientID;
    private String name;
    private int age;
    private String contactNumber;
    private String healthIssue;

    public Patient(String name, int age, String contactNumber, String healthIssue) {
        this.patientID = UUID.randomUUID().toString(); // Generate unique ID
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.healthIssue = healthIssue;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getHealthIssue() {
        return healthIssue;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Health Issue: " + healthIssue);
    }
}


