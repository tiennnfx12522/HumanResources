package HumanResources;

public class Department {
    private static int Counter = 1;
    private int deptId;
    private String deptName;
    private int noEmployee;

    public Department() {
        this.deptId = Counter++;
    }

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

    @Override
    public String toString () {
        return String.format("%-10d%-20s%-5d", getDeptId(), getDeptName(), getNoEmployee());
    }
}
