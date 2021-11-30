package HumanResources;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class HumanResources {

    public static final Scanner sc = new Scanner(System.in);

    public static void main (String [] args) {
        try {
            switchMenu();
        } catch (Exception e) {
            System.out.println("Please try again with valid input");
            switchMenu();
        }
    }

    public static ArrayList createStaffList (){
        ArrayList <Staff> staffList = new ArrayList<>();

        Staff e1 = new Employee ("Nguyen Van A", 25, 1.5, "14-11-2015", "Sales", 5, 8);
        Staff e2 = new Employee ("Nguyen Van B", 24, 1.0, "16-10-2016", "IT", 5, 7);
        Staff e3 = new Employee ("Nguyen Van C", 27, 2.0, "03-09-2013", "HR", 5, 6);
        Staff e4 = new Employee ("Nguyen Van D", 28, 3.0, "10-12-2010", "Finance", 5, 5);
        Staff e5 = new Employee ("Nguyen Van E", 29, 2.0, "11-08-2010", "IT", 5, 8);
        Staff e6 = new Manager ("Nguyen Van F", 29, 2.0, "11-08-2010", "HR","Business Leader", 5);

        staffList.add(e1);
        staffList.add(e2);
        staffList.add(e3);
        staffList.add(e4);
        staffList.add(e5);
        staffList.add(e6);
        return staffList;
    }

    public static ArrayList createDeptList () {
        ArrayList <Department> departments = new ArrayList<>();
        Department d1 = new Department ();
        d1.setDeptName("HR");
        d1.setDeptId(1);
        Department d2 = new Department ();
        d2.setDeptName("Finance");
        d2.setDeptId(2);
        Department d3 = new Department ();
        d3.setDeptName("Sales");
        d3.setDeptId(3);
        Department d4 = new Department ();
        d4.setDeptName("IT");
        d4.setDeptId(4);

        departments.add(d1);
        departments.add(d2);
        departments.add(d3);
        departments.add(d4);
        return departments;
    }

    public static void menu () {
        System.out.println("HUMAN RESOURCES MANAGEMENT");
        System.out.println("1. STAFF INFORMATION");
        System.out.println("2. DEPARTMENT INFORMATION");
        System.out.println("3. LIST STAFF BY DEPARTMENT");
        System.out.println("4. ADD NEW STAFF");
        System.out.println("5. SEARCH STAFF");
        System.out.println("6. DISPLAY SALARY IN ASCENDING ORDER");
        System.out.println("7. DISPLAY SALARY IN DESCENDING ORDER");
        System.out.println("0. EXIT");
    }

    public static void switchMenu() {
        ArrayList <Staff> staffList = createStaffList();
        ArrayList <Department> departments = createDeptList();
        int selectFunction = 10;
        do {
            menu();
            System.out.print("Select function: ");
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
                    default:
                        System.out.println("Please enter a number from 1 to 7 to select function");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please enter a number to select function");
            }
        } while (selectFunction != 0);
    }

    public static void staffInformation (ArrayList <Staff> staffList) {
        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-5s\n", "Id", "Name", "Age", "Department" , "Title", "Start Date", "Paid leave", "Salary Coefficient", "Salary");
        for (Staff o : staffList) {
            o.displayInformation();
        }
    }

    public static void departmentInformation(ArrayList <Staff> staffList, ArrayList <Department> departments) {
        int countHR = 0;
        int countFinance = 0;
        int countSales = 0;
        int countIT = 0;

        for (Staff o: staffList) {
            switch (o.getDept()) {
                case "HR" -> countHR++;
                case "Finance" -> countFinance++;
                case "Sales" -> countSales++;
                case "IT" -> countIT++;
            }
        }
        departments.get(0).setNoEmployee(countHR);
        departments.get(1).setNoEmployee(countFinance);
        departments.get(2).setNoEmployee(countSales);
        departments.get(3).setNoEmployee(countIT);

        System.out.printf("%-10s%-20s%-5s\n", "DeptID", "Department name", "Number of employees");
        for (Department o: departments) {
            System.out.println(o);
        }
    }

    public static void staffInformationByDept (ArrayList <Staff> staffList) {
        System.out.print("Select department to display information (1 = HR, 2 = Finance, 3 = Sales, 4 = IT): ");
        int selectDepartment = sc.nextInt();
        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-5s\n", "Id", "Name", "Age", "Department" , "Title", "Start Date", "Paid leave", "Salary Coefficient", "Salary");
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
                System.out.println("No department found. Please try again with valid input");
            }
         }

    public static void addNewStaff (ArrayList <Staff> staffList) {
        System.out.print("Select staff types to be added (1 = Manager, 2 = Employee): ");
        int selectStaffTypes = sc.nextInt();
        if (selectStaffTypes == 1 || selectStaffTypes == 2) {
            sc.nextLine();
            System.out.print("Input name: ");
            String name = sc.nextLine();
            System.out.print("Input age: ");
            int age = sc.nextInt();
            System.out.print("Input department: ");
            sc.nextLine();
            String dept = sc.nextLine();
            System.out.print("Input start date: ");
            String startDate = sc.nextLine();
            System.out.print("Input paid leave: ");
            int paidLeave = sc.nextInt();
            System.out.print("Input salary coefficient: ");
            sc.nextLine();
            double salaryCoefficient = sc.nextDouble();
            if (selectStaffTypes == 1) {
                sc.nextLine();
                System.out.print("Input title: ");
                String title = sc.nextLine();
                Staff newManager = new Manager (name, age, salaryCoefficient, startDate, dept, title, paidLeave);
                staffList.add(newManager);
            }  else if (selectStaffTypes == 2) {
                sc.nextLine();
                System.out.print("Input overtime: ");
                int overtime = sc.nextInt();
                Staff newEmployee = new Employee (name, age, salaryCoefficient, startDate, dept, paidLeave, overtime);
                staffList.add(newEmployee);
            }
        } else {
            System.out.println("Please try again with valid input");
        }

    }

    public static void searchStaff (ArrayList <Staff> staffList) {
        System.out.print("Select search parameter (1 = Staff ID, 2 = Staff Name): ");
        int selectParameter = sc.nextInt();
        sc.nextLine();
        if (selectParameter == 1) {
            System.out.print("Please input staff ID: ");
            int searchID = sc.nextInt();
            int matches = 0;
            System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-5s\n", "Id", "Name", "Age", "Department" , "Title", "Start Date", "Paid leave", "Salary Coefficient", "Salary");
            for (Staff o : staffList) {
                if (o.getId() == searchID) {
                    o.displayInformation();
                    matches++;
                }
            }
            if (matches == 0) {
                System.out.println("No result found");
            }
        }

        if (selectParameter == 2) {
            System.out.print("Please input staff name: ");
            String searchKeyword = sc.nextLine();
            int matches = 0;
            System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-5s\n", "Id", "Name", "Age", "Department" , "Title", "Start Date", "Paid leave", "Salary Coefficient", "Salary");
            for (Staff o : staffList) {
                if (o.getName().equalsIgnoreCase(searchKeyword)) {
                    o.displayInformation();
                    matches++;
                }
            }
            if (matches == 0) {
                System.out.println("No result found");
            }
        }
    }

    public static void displaySalaryAscending (ArrayList <Staff> staffList) {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) (o1.calculateSalary() - o2.calculateSalary());
            }
        });
        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-5s\n", "Id", "Name", "Age", "Department" , "Title", "Start Date", "Paid leave", "Salary Coefficient", "Salary");
        for (Staff o : staffList) {
            o.displayInformation();
        }
    }

    public static void displaySalaryDescending (ArrayList <Staff> staffList) {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) (o2.calculateSalary() - o1.calculateSalary());
            }
        });
        System.out.printf("%-5s%-20s%-10s%-15s%-20s%-13s%-15s%-28s%-5s\n", "Id", "Name", "Age", "Department" , "Title", "Start Date", "Paid leave", "Salary Coefficient", "Salary");
        for (Staff o : staffList) {
            o.displayInformation();
        }
    }


}
