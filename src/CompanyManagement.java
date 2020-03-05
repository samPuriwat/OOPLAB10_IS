import java.util.List;
import java.util.Scanner;

public class CompanyManagement {

    public static void main(String[] args) {
        //create instance
        EmployeeDAOImpl dao = EmployeeDAOImpl.getInstance();
        //display all employee
        displayAllEmployee(dao);
        //add new employee
        addNewEmployee(dao);




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
