package Task6;

import java.io.Serializable;

public class Staff implements Serializable {
    private String staffID;
    private String name;
    private String role;
    private String department;

    public Staff(String staffID, String name, String role, String department) {
        this.staffID = staffID;
        this.name = name;
        this.role = role;
        this.department = department;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public void displayStaffDetails() {
        System.out.println("Staff ID: " + staffID);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Department: " + department);
    }
}

