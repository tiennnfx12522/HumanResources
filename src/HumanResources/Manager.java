package HumanResources;

public class Manager extends Staff {

    private String title;
    private double salary;

    public Manager() {
    }

    public Manager(String name, int age, double salaryCoefficient, String startDate, String dept, String title, int paidLeave) {
        super(name, age, salaryCoefficient, startDate, dept, paidLeave);
        this.title = title;
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
        switch (getTitle()) {
            case "Business Leader":
                salary = getSalaryCoefficient() * 5000000 + 8000000;
                break;
            case "Project Leader":
                salary = getSalaryCoefficient() * 5000000 + 5000000;
                break;
            case "Technical Leader":
                salary = getSalaryCoefficient() * 5000000 + 6000000;
                break;
        }
        return salary;
    }
}
