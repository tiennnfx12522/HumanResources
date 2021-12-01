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
        Department d1 = new Department (1, "HR");
        Department d2 = new Department (2, "Finance");
        Department d3 = new Department (3, "Sales");
        Department d4 = new Department (4, "IT");

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
                        departmentInformation(staffList, departments);
                        break;
                    case 3:
                        staffInformationByDept(staffList);
                        break;
                    case 4:
                        addNewStaff(staffList);
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
    public static void departmentInformation(ArrayList <Staff> staffList, ArrayList <Department> departments) {

        // initiate variables to store staff count for each department
        int countHR = 0;
        int countFinance = 0;
        int countSales = 0;
        int countIT = 0;

        // iterate staffList to count number of staff in each department
        for (Staff o: staffList) {
            switch (o.getDept()) {
                case "HR" -> countHR++;
                case "Finance" -> countFinance++;
                case "Sales" -> countSales++;
                case "IT" -> countIT++;
            }
        }

        // update staff count for all departments
        departments.get(0).setNoEmployee(countHR);
        departments.get(1).setNoEmployee(countFinance);
        departments.get(2).setNoEmployee(countSales);
        departments.get(3).setNoEmployee(countIT);

        // display department information
        System.out.printf("%-10s%-20s%-5s\n", "DeptID", "Department name", "Number of employees");
        for (Department o: departments) {
            System.out.println(o);
        }
    }

    // method to display staff information by chosen department
    public static void staffInformationByDept (ArrayList <Staff> staffList) {

        // print message to prompt user input
        System.out.print("Select department to display information (1 = HR, 2 = Finance, 3 = Sales, 4 = IT): ");
        int selectDepartment = sc.nextInt();

        // display staff information by chosen department
        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-30s%-5s\n", "Id", "Name", "Age", "Department" ,
                "Title", "Start Date", "Paid leave", "Salary Coefficient", "Overtime", "Salary");
        switch (selectDepartment) {
            case 1:
                for (Staff o : staffList) {
                    if (o.getDept().equals("HR")) {
                        o.displayInformation();
                    }
                }
                break;
            case 2:
                for (Staff o : staffList) {
                    if (o.getDept().equals("Finance")) {
                        o.displayInformation();
                    }
                }
                break;
            case 3:
                for (Staff o : staffList) {
                    if (o.getDept().equals("Sales")) {
                        o.displayInformation();
                    }
                }
                break;
            case 4:
                for (Staff o : staffList) {
                    if (o.getDept().equals("IT")) {
                        o.displayInformation();
                    }
                }
                break;
            default:
                System.out.println("No department found. Please try again with valid input.");
            }
         }

    // method to add new staff
    public static void addNewStaff (ArrayList <Staff> staffList) {

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

            if (selectStaffTypes == 1) {

                // clear unfinished line from previous nextDouble
                sc.nextLine();
                System.out.print("Input title: ");
                String title = sc.nextLine();

                // validate user inputs before create new staff object and add new staff into staffList
                if ((title.equals("Business Leader") || title.equals("Technical Leader") || title.equals("Project Leader"))
                        && (dept.equals("HR") || dept.equals("Finance") || dept.equals("Sales") || dept.equals("IT")) && matcher.matches()) {
                    Staff newManager = new Manager (name, age, salaryCoefficient, startDate, dept, title, paidLeave);
                    staffList.add(newManager);
                } else {
                    // print out notification if the user enters invalid input
                    System.out.println("Invalid input! Please try again!");
                }
            }  else if (selectStaffTypes == 2) {
                // clear unfinished line from previous nextDouble
                sc.nextLine();
                System.out.print("Input overtime: ");
                int overtime = sc.nextInt();

                // validate user inputs before create new staff object and add new staff into staffList
                if (dept.equals("HR") || dept.equals("Finance") || dept.equals("Sales") || dept.equals("IT") && matcher.matches()) {
                    Staff newEmployee = new Employee (name, age, salaryCoefficient, startDate, dept, paidLeave, overtime);
                    staffList.add(newEmployee);
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
                return (int) (o1.calculateSalary() - o2.calculateSalary());
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
                return (int) (o2.calculateSalary() - o1.calculateSalary());
            }
        });
        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-30s%-5s\n", "Id", "Name", "Age", "Department" ,
                "Title", "Start Date", "Paid leave", "Salary Coefficient", "Overtime", "Salary");
        for (Staff o : staffList) {
            o.displayInformation();
        }
    }
}
