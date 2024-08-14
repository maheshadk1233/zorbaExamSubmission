package org.example.entity;

import java.util.Set;

public class Employee {
    int employeeId;
    String employeeName;
    String employeeAddress;
    String employeeEmail;
    int employeeExperience;
Set<Skill> skills;
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public int getEmployeeExperience() {
        return employeeExperience;
    }

    public void setEmployeeExperience(int employeeExperience) {
        this.employeeExperience = employeeExperience;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeExperience=" + employeeExperience +
                '}';
    }
}
