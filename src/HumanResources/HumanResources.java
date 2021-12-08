/*
    This program was developed to create a simple application called HumanResources.
    The application allows user to choose different functions to fulfil tasks such as display staff information,
    display department information, add new staff, search staff by id or name, calculate and display salary table in
    ascending and descending order
*/

package HumanResources;

// import relevant classes in java.util package
import java.util.Scanner;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HumanResources {

    // create new scanner object
    public static final Scanner sc = new Scanner(System.in);

    // main method
    public static void main (String [] args) {
        switchMenu();
    }

    // create ArrayList to manage staff information
    public static ArrayList createStaffList () {
        ArrayList <Staff> staffList = new ArrayList<>();

        // create new staff objects using constructors
        Staff e1 = new Employee ("Nguyen Van A", 25, 1.5, "14-11-2015", "Sales", 5, 8);
        Staff e2 = new Employee ("Nguyen Van B", 24, 1.0, "16-10-2016", "IT", 5, 7);
        Staff e3 = new Employee ("Nguyen Van C", 27, 2.0, "03-09-2013", "HR", 5, 6);
        Staff e4 = new Employee ("Nguyen Van D", 28, 3.0, "10-12-2010", "Finance", 5, 5);
        Staff e5 = new Employee ("Nguyen Van E", 29, 2.0, "11-08-2010", "IT", 5, 8);
        Staff e6 = new Manager ("Nguyen Van F", 29, 2.0, "11-08-2010", "HR","Business Leader", 5);

        // add objects into array list
        staffList.add(e1);
        staffList.add(e2);
        staffList.add(e3);
        staffList.add(e4);
        staffList.add(e5);
        staffList.add(e6);
        return staffList;
    }

    // create ArrayList to department information
    public static ArrayList createDeptList () {
        ArrayList <Department> departments = new ArrayList<>();

        // create new department objects using constructors
        Department d1 = new Department (1, "HR", 2);
        Department d2 = new Department (2, "Finance", 1);
        Department d3 = new Department (3, "Sales", 1);
        Department d4 = new Department (4, "IT", 2);

        // add objects into array list
        departments.add(d1);
        departments.add(d2);
        departments.add(d3);
        departments.add(d4);
        return departments;
    }

    // create menu to display list of functions
    public static void menu () {
        System.out.println("=========START=========");
        System.out.println("HUMAN RESOURCES MANAGEMENT");
        System.out.println("1. STAFF INFORMATION");
        System.out.println("2. DEPARTMENT INFORMATION");
        System.out.println("3. LIST STAFF BY DEPARTMENT");
        System.out.println("4. ADD NEW STAFF");
        System.out.println("5. SEARCH STAFF");
        System.out.println("6. DISPLAY SALARY IN ASCENDING ORDER");
        System.out.println("7. DISPLAY SALARY IN DESCENDING ORDER");
        System.out.println("8. EXIT");
    }

    // attach functions into the menu
    public static void switchMenu() {

        // create two arrayLists named staffList and departments using createStaffList and createDeptList methods
        ArrayList <Staff> staffList = createStaffList();
        ArrayList <Department> departments = createDeptList();

        // initiate selectFunction variable to start the do while loop
        int selectFunction = 0;

        // run the code until the user decide to stop the program by choosing exit
        do {
            // print out menu and message to prompt user input
            menu();
            System.out.print("Select function: ");

            // execute the code and catch exceptions when it occurs
            try {
                selectFunction = sc.nextInt();
                switch (selectFunction) {
                    case 1:
                        staffInformation(staffList);
                        break;
                    case 2:
                        departmentInformation(departments);
                        break;
                    case 3:
                        staffInformationByDept(staffList);
                        break;
                    case 4:
                        addNewStaff(staffList, departments);
                        break;
                    case 5:
                        searchStaff(staffList);
                        break;
                    case 6:
                        displaySalaryAscending(staffList);
                        break;
                    case 7:
                        displaySalaryDescending(staffList);
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Please enter a number from 1 to 8 to select function");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid input! Please try again!");
                System.out.println("Please enter a number from 1 to 8 to select function");
            }
        } while (selectFunction != 8);
    }

    // method to display staff information
    public static void staffInformation (ArrayList <Staff> staffList) {
        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-30s%-5s\n", "Id", "Name", "Age", "Department" ,
                "Title", "Start Date", "Paid leave", "Salary Coefficient", "Overtime", "Salary");
        for (Staff o : staffList) {
            o.displayInformation();
        }
    }

    // method to display department information
    public static void departmentInformation(ArrayList <Department> departments) {
        // display department information
        System.out.printf("%-10s%-20s%-5s\n", "DeptID", "Department name", "Number of employees");
        for (Department o: departments) {
            System.out.println(o);
        }
    }

    // method to display staff information by chosen department
    public static void staffInformationByDept (ArrayList <Staff> staffList) {

        // display staff information by chosen department
        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-30s%-5s\n", "Id", "Name", "Age", "Department" ,
                "Title", "Start Date", "Paid leave", "Salary Coefficient", "Overtime", "Salary");

        for (Staff o : staffList) {
            if (o.getDept().equals("HR")) {
                o.displayInformation();
            }
        }
        for (Staff o : staffList) {
            if (o.getDept().equals("Sales")) {
                o.displayInformation();
            }
        }
        for (Staff o : staffList) {
            if (o.getDept().equals("Finance")) {
                o.displayInformation();
            }
        }
        for (Staff o : staffList) {
            if (o.getDept().equals("IT")) {
                o.displayInformation();
            }
        }
    }

    // method to add new staff
    public static void addNewStaff (ArrayList <Staff> staffList, ArrayList <Department> departments) {

        // print message to prompt user input
        System.out.print("Select staff types to be added (1 = Manager, 2 = Employee): ");
        int selectStaffTypes = sc.nextInt();

        // run the code if the user enters valid input
        if (selectStaffTypes == 1 || selectStaffTypes == 2) {

            // clear unfinished line from previous nextInt
            sc.nextLine();

            // user inputs for common attributes
            System.out.print("Input name: ");
            String name = sc.nextLine();

            System.out.print("Input age: ");
            int age = sc.nextInt();

            System.out.print("Input department: ");
            sc.nextLine();
            String dept = sc.nextLine();

            System.out.print("Input start date: ");
            String startDate = sc.nextLine();
            // regex obtained from https://regexlib.com/DisplayPatterns.aspx?cattabindex=4&categoryid=5&p=2
            String regex = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(startDate);

            System.out.print("Input paid leave: ");
            int paidLeave = sc.nextInt();

            System.out.print("Input salary coefficient: ");
            sc.nextLine();
            double salaryCoefficient = sc.nextDouble();

            boolean b = dept.equals("HR") || dept.equals("Finance") || dept.equals("Sales") || dept.equals("IT");
            if (selectStaffTypes == 1) {

                // clear unfinished line from previous nextDouble
                sc.nextLine();
                System.out.print("Input title: ");
                String title = sc.nextLine();

                // validate user inputs before create new staff object and add new staff into staffList
                if ((title.equals("Business Leader") || title.equals("Technical Leader") || title.equals("Project Leader"))
                        && b && matcher.matches()) {
                    Staff newManager = new Manager (name, age, salaryCoefficient, startDate, dept, title, paidLeave);
                    staffList.add(newManager);

                    // update department list
                    int updatedInfo = 0;
                    switch (newManager.getDept()){
                        case "HR":
                            updatedInfo = departments.get(0).getNoEmployee() + 1;
                            departments.get(0).setNoEmployee(updatedInfo);
                            break;
                        case "Finance":
                            updatedInfo = departments.get(1).getNoEmployee() + 1;
                            departments.get(1).setNoEmployee(updatedInfo);
                            break;
                        case "Sales":
                            updatedInfo = departments.get(2).getNoEmployee() + 1;
                            departments.get(2).setNoEmployee(updatedInfo);
                            break;
                        case "IT":
                            updatedInfo = departments.get(3).getNoEmployee() + 1;
                            departments.get(3).setNoEmployee(updatedInfo);
                            break;
                    }
                } else {
                    // print out notification if the user enters invalid input
                    System.out.println("Invalid input! Please try again!");
                }
            }   else if (selectStaffTypes == 2) {
                // clear unfinished line from previous nextDouble
                sc.nextLine();
                System.out.print("Input overtime: ");
                int overtime = sc.nextInt();

                // validate user inputs before create new staff object and add new staff into staffList
                if (b && matcher.matches()) {
                    Staff newEmployee = new Employee (name, age, salaryCoefficient, startDate, dept, paidLeave, overtime);
                    staffList.add(newEmployee);

                    // update department list
                    int updatedInfo;
                    switch (newEmployee.getDept()) {
                        case "HR" -> {
                            updatedInfo = departments.get(0).getNoEmployee() + 1;
                            departments.get(0).setNoEmployee(updatedInfo);
                        }
                        case "Finance" -> {
                            updatedInfo = departments.get(1).getNoEmployee() + 1;
                            departments.get(1).setNoEmployee(updatedInfo);
                        }
                        case "Sales" -> {
                            updatedInfo = departments.get(2).getNoEmployee() + 1;
                            departments.get(2).setNoEmployee(updatedInfo);
                        }
                        case "IT" -> {
                            updatedInfo = departments.get(3).getNoEmployee() + 1;
                            departments.get(3).setNoEmployee(updatedInfo);
                        }
                    }
                } else {
                    // print out notification if the user enters invalid input
                    System.out.println("Invalid input! Please try again!");
                }
            }
        } else {
            // print out notification if the user enters invalid input
            System.out.println("Invalid input! Please try again!");
        }

    }

    // method to search staff by id or name
    public static void searchStaff (ArrayList <Staff> staffList) {

        // print message to prompt user input
        System.out.print("Select search parameter (1 = Staff ID, 2 = Staff Name): ");
        int selectParameter = sc.nextInt();

        // clear unfinished line from previous nextInt
        sc.nextLine();


        if (selectParameter == 1) {
            // search staff based on Id
            System.out.print("Please input staff ID: ");
            int searchID = sc.nextInt();

            // initiate variable to count number of matches
            int matches = 0;

            // print out staff information if searchID entered by the user matched with staffId
            System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-30s%-5s\n", "Id", "Name", "Age", "Department" ,
                    "Title", "Start Date", "Paid leave", "Salary Coefficient", "Overtime", "Salary");
            for (Staff o : staffList) {
                if (o.getId() == searchID) {
                    o.displayInformation();
                    // change matches value to skip the next code block
                    matches++;
                }
            }
            // print out message to notify user that no result is found
            if (matches == 0) {
                System.out.println("No result found");
            }
        } else if (selectParameter == 2) {
            // search staff based on name
            System.out.print("Please input staff name: ");
            String searchKeyword = sc.nextLine();

            // initiate variable to count number of matches
            int matches = 0;

            // print out staff information if searchKeyword entered by the user matched with staffName
            System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-30s%-5s\n", "Id", "Name", "Age", "Department" ,
                    "Title", "Start Date", "Paid leave", "Salary Coefficient", "Overtime", "Salary");
            for (Staff o : staffList) {
                if (o.getName().equalsIgnoreCase(searchKeyword)) {
                    o.displayInformation();
                    // change matches value to skip the next code block
                    matches++;
                }
            }
            if (matches == 0) {
                System.out.println("No result found");
            }
        } else {
            // print out notification if the user enters invalid input
            System.out.println("Invalid input! Please try again!");
        }
    }

    // method to display salary table in ascending order
    public static void displaySalaryAscending (ArrayList <Staff> staffList) {

        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                double o1Salary = 0;
                double o2Salary = 0;
                if (o1 instanceof Employee) {
                    o1Salary = ((Employee) o1).calculateSalary();
                } else if (o1 instanceof Manager) {
                    o1Salary = ((Manager) o1).calculateSalary();
                }

                if (o2 instanceof Employee) {
                    o2Salary = ((Employee) o2).calculateSalary();
                } else if (o2 instanceof Manager) {
                    o2Salary = ((Manager) o2).calculateSalary();
                }
                return (int) (o1Salary - o2Salary);
            }
        });

        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-30s%-5s\n", "Id", "Name", "Age", "Department" ,
                "Title", "Start Date", "Paid leave", "Salary Coefficient", "Overtime", "Salary");
        for (Staff o : staffList) {
            o.displayInformation();
        }
    }

    // method to display salary table in descending order
    public static void displaySalaryDescending (ArrayList <Staff> staffList) {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                double o1Salary = 0;
                double o2Salary = 0;
                if (o1 instanceof Employee) {
                    o1Salary = ((Employee) o1).calculateSalary();
                } else if (o1 instanceof Manager) {
                    o1Salary = ((Manager) o1).calculateSalary();
                }

                if (o2 instanceof Employee) {
                    o2Salary = ((Employee) o2).calculateSalary();
                } else if (o2 instanceof Manager) {
                    o2Salary = ((Manager) o2).calculateSalary();
                }
                return (int) (o2Salary - o1Salary);
            }
        });

        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-30s%-5s\n", "Id", "Name", "Age", "Department" ,
                "Title", "Start Date", "Paid leave", "Salary Coefficient", "Overtime", "Salary");
        for (Staff o : staffList) {
            o.displayInformation();
        }
    }
}