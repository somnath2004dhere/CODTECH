package Task6;

import java.util.*;
import java.io.*;

public class HospitalManagementSystem {
    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<EHR> healthRecords;
    private List<Bill> bills;
    private List<InventoryItem> inventory;
    private List<Staff> staff;
    private static final String FILE_NAME = "hospital_data.ser";

    public HospitalManagementSystem() {
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        healthRecords = new ArrayList<>();
        bills = new ArrayList<>();
        inventory = new ArrayList<>();
        staff = new ArrayList<>();
        loadData();
    }

    public void registerPatient(Patient patient) {
        patients.add(patient);
        saveData();
    }

    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
        saveData();
    }

    public void addEHR(EHR ehr) {
        healthRecords.add(ehr);
        saveData();
    }

    public void createBill(Bill bill) {
        bills.add(bill);
        saveData();
    }

    public void addInventoryItem(InventoryItem item) {
        inventory.add(item);
        saveData();
    }

    public void addStaff(Staff staffMember) {
        staff.add(staffMember);
        saveData();
    }

    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(patients);
            out.writeObject(appointments);
            out.writeObject(healthRecords);
            out.writeObject(bills);
            out.writeObject(inventory);
            out.writeObject(staff);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            patients = (List<Patient>) in.readObject();
            appointments = (List<Appointment>) in.readObject();
            healthRecords = (List<EHR>) in.readObject();
            bills = (List<Bill>) in.readObject();
            inventory = (List<InventoryItem>) in.readObject();
            staff = (List<Staff>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Add methods for displaying data, updating details, etc.
}
