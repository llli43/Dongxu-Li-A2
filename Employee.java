public class Employee extends Person {
    private String employeeId;
    private String department;
    private boolean isAvailable;
    
    // Default constructor
    public Employee() {
        super();
    }
    
    // Parameterized constructor
    public Employee(String name, int age, String contactNumber, String employeeId, String department) {
        super(name, age, contactNumber);
        this.employeeId = employeeId;
        this.department = department;
        this.isAvailable = true;
    }
    
    // Getters and setters
    public String getEmployeeId() { 
        return employeeId; 
    }
    
    public void setEmployeeId(String employeeId) { 
        this.employeeId = employeeId; 
    }
    
    public String getDepartment() { 
        return department; 
    }
    
    public void setDepartment(String department) { 
        this.department = department; 
    }
    
    public boolean isAvailable() { 
        return isAvailable; 
    }
    
    public void setAvailable(boolean available) { 
        isAvailable = available; 
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + employeeId + ", Department: " + department + ", Available: " + isAvailable;
    }
}
