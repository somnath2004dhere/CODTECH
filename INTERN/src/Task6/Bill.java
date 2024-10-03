package Task6;

import java.io.Serializable;

public class Bill implements Serializable {
    private String billID;
    private String patientID;
    private double consultationFees;
    private double medicineCharges;
    private double totalAmount;

    public Bill(String billID, String patientID, double consultationFees, double medicineCharges) {
        this.billID = billID;
        this.patientID = patientID;
        this.consultationFees = consultationFees;
        this.medicineCharges = medicineCharges;
        this.totalAmount = consultationFees + medicineCharges;
    }

    public String getBillID() {
        return billID;
    }

    public String getPatientID() {
        return patientID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void displayBillDetails() {
        System.out.println("Bill ID: " + billID);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Consultation Fees: $" + consultationFees);
        System.out.println("Medicine Charges: $" + medicineCharges);
        System.out.println("Total Amount: $" + totalAmount);
    }
}


