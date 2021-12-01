package HumanResources;

// Create class department
public class Department {

    // declare variables
    private int deptId;
    private String deptName;
    private int noEmployee;

    // constructors
    public Department() {
    }

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    // getters & setters
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getNoEmployee() {
        return noEmployee;
    }

    public void setNoEmployee(int noEmployee) {
        this.noEmployee = noEmployee;
    }

    // toString method helps represent any object as a string
    @Override
    public String toString () {
        return String.format("%-10d%-20s%-5d", getDeptId(), getDeptName(), getNoEmployee());
    }
}
