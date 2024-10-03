package Task6;

import java.util.Scanner;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHospital Management System:");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Add Electronic Health Record (EHR)");
            System.out.println("4. Create Bill");
            System.out.println("5. Add Inventory Item");
            System.out.println("6. Add Staff Member");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.println("Enter health issue: ");
                    String healthIssue = scanner.nextLine();
                    Patient patient = new Patient(name, age, contactNumber, healthIssue);
                    hms.registerPatient(patient);
                    break;
                case 2:
                    System.out.println("Enter appointment ID: ");
                    String appointmentID = scanner.nextLine();
                    System.out.println("Enter patient ID: ");
                    String patientID = scanner.nextLine();
                    System.out.println("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    Date appointmentDate = new Date(); // Default current date
                    Appointment appointment = new Appointment(appointmentID, patientID, doctorName, appointmentDate);
                    hms.scheduleAppointment(appointment);
                    break;
                case 3:
                    System.out.println("Enter patient ID: ");
                    String ehrPatientID = scanner.nextLine();
                    System.out.println("Enter medical history: ");
                    String medicalHistory = scanner.nextLine();
                    System.out.println("Enter prescriptions: ");
                    String prescriptions = scanner.nextLine();
                    EHR ehr = new EHR(ehrPatientID, medicalHistory, prescriptions);
                    hms.addEHR(ehr);
                    break;
                case 4:
                    System.out.println("Enter bill ID: ");
                    String billID = scanner.nextLine();
                    System.out.println("Enter patient ID: ");
                    String billPatientID = scanner.nextLine();
                    System.out.println("Enter consultation fees: ");
                    double consultationFees = scanner.nextDouble();
                    System.out.println("Enter medicine charges: ");
                    double medicineCharges = scanner.nextDouble();
                    Bill bill = new Bill(billID, billPatientID, consultationFees, medicineCharges);
                    hms.createBill(bill);
                    break;
                case 5:
                    System.out.println("Enter inventory item name: ");
                    String itemName = scanner.nextLine();
                    System.out.println("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter supplier name: ");
                    String supplier = scanner.nextLine();
                    InventoryItem item = new InventoryItem(itemName, quantity, supplier);
                    hms.addInventoryItem(item);
                    break;
                case 6:
                    System.out.println("Enter staff ID: ");
                    String staffID = scanner.nextLine();
                    System.out.println("Enter staff name: ");
                    String staffName = scanner.nextLine();
                    System.out.println("Enter staff role: ");
                    String role = scanner.nextLine();
                    System.out.println("Enter department: ");
                    String department = scanner.nextLine();
                    Staff staffMember = new Staff(staffID, staffName, role, department);
                    hms.addStaff(staffMember);
                    break;
                case 7:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

