public class EmployeeService{
    public static void main(String[] args){
    
    Employee employee =
            new Employee(101, "Sahasra");

        EmpSalaryService salaryService =
            new EmpSalaryService();

        EmpDatabaseService repository =
            new EmpDatabaseService();

        salaryService.calculateSalary(employee);

        repository.saveEmployee(employee);
    }
}

//Employee Entity
class Employee{
    int id;
    String name;
    
    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}

//EmpSalaryService
class EmpSalaryService{
    public void calculateSalary(Employee emp){
        System.out.println("Calculate salary of " + emp.getName());
    }
}


//EmpDatabaseService
class EmpDatabaseService{
    public void saveEmployee(Employee emp){
         System.out.println("save " + emp.getName() + " to database");
    }
}
