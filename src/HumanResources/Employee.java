package HumanResources;

public class Employee extends Staff {

    private int overtime;
    private String title;
    private double salary;

    public Employee() {
    }

    public Employee (String name, int age, double salaryCoefficient, String date, String dept, int paidLeave, int overtime) {
        super(name, age, salaryCoefficient, date, dept, paidLeave);
        this.overtime = overtime;
        this.title = "Employee";
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return calculateSalary();
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-5d%-20s%-10d%-15s%-20s%-13s%-15d%.2f%30.0f\n", getId(), getName(), getAge(), getDept(), getTitle(), getStartDate(), getPaidLeave(), getSalaryCoefficient(), calculateSalary());
    }

    @Override
    public double calculateSalary() {
        salary = getSalaryCoefficient() * 3000000 + getOvertime() * 200000;
        return salary;
    }
}