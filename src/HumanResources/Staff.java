package HumanResources;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Create abstract class Staff
public abstract class Staff implements ICalculator {

    //declare variables
    private static int Counter = 1;
    private int Id;
    private String name;
    private int age;
    private double salaryCoefficient;
    private String startDate;
    private String dept;
    private int paidLeave;

    //constructors
    public Staff () {
    }

    public Staff(String name, int age, double salaryCoefficient, String startDate, String dept, int paidLeave) {
        this.Id = Counter++;
        this.name = name;
        this.age = age;
        this.salaryCoefficient = salaryCoefficient;

        // Validate input for date
        String regex = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(startDate);
        if (startDate.trim().equals("")) {
            throw new NullPointerException("This cannot be null");
        } else if (matcher.matches()){
            this.startDate = startDate;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }

        // Validate input for department
        if (dept.equals("IT") || dept.equals("Finance") || dept.equals("HR") || dept.equals("Sales")) {
            this.dept = dept;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
        this.paidLeave = paidLeave;
    }

    //getters and setters
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

    public abstract void displayInformation();

}

