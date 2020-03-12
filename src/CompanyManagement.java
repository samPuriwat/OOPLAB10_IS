import java.util.List;
import java.util.Scanner;

public class CompanyManagement {

    public static void main(String[] args) {
        //create instance
        EmployeeDAOImpl dao = EmployeeDAOImpl.getInstance();
        //display all employee
        displayAllEmployee(dao);
        //add new employee
            //addNewEmployee(dao);
        //find employee by ID
            //findEmployeeByID(dao);
        //update employee by ID
            //updateEmployeeByID(dao);
        //delete employee by ID
        deleteEmployeeByID(dao);




    }

    private static void deleteEmployeeByID(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee ID that you want to delete: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deleteEmp(id);
    }

    private static void updateEmployeeByID(EmployeeDAOImpl dao) {
        //Search employee ID
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        if (emp != null){
            System.out.println(emp.toString());
        }
        //get new data
        System.out.print("Enter new salary for employee ID "
                +emp.getEmpID()+":");
        double ns = Double.parseDouble(sc.nextLine().trim());
        //edit data
        emp.setSalary(ns);
        //update data into database
        dao.updateEmp(emp);
    }

    private static void findEmployeeByID(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        if (emp != null){
            System.out.println(emp.toString());
        }

    }

    private static void addNewEmployee(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee id: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter employee position: ");
        String position = sc.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = Double.parseDouble(sc.nextLine().trim());

        dao.addEmp(new Employee(id,name,position,salary));
    }

    private static void displayAllEmployee(EmployeeDAOImpl dao) {
        List<Employee> emp = dao.getAllEmp();
        for (Employee e:emp) {
            System.out.println(e.toString());
        }
    }



}
