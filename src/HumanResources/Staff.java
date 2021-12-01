package HumanResources;

// Create abstract class Staff and implements interface ICalculator
public abstract class Staff implements ICalculator {

    // declare variables
    private static int Counter = 1;
    private int Id;
    private String name;
    private int age;
    private double salaryCoefficient;
    private String startDate;
    private String dept;
    private int paidLeave;

    // constructors
    public Staff () {
    }

    public Staff(String name, int age, double salaryCoefficient, String startDate, String dept, int paidLeave) {
        this.Id = Counter++;
        this.name = name;
        this.age = age;
        this.salaryCoefficient = salaryCoefficient;
        this.startDate = startDate;
        this.dept = dept;
        this.paidLeave = paidLeave;
    }

    // getters and setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getPaidLeave() {
        return paidLeave;
    }

    public void setPaidLeave(int paidLeave) {
        this.paidLeave = paidLeave;
    }

    // displayInformation function
    public abstract void displayInformation();

}

