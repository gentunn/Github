package EmpDeptProgram;

public class ObjectsEmpDeptProgram {
	  public static void main(String[] args) {
	        Department firstDepartment = new Department(10, "Sales");
	        Department secondDepartment = new Department(20, "Music");
	        
	        Employee[] employeeArray = {
	                new Employee("John Doe", "john@abc.com", firstDepartment),
	                new Employee("Hank Marvin", "hank@abc.com", secondDepartment),
	                new Employee("Joan Baez", "joan@abc.com", secondDepartment)};
	        
	        for (Employee employee : employeeArray) {
	            System.out.println(employee);
	        }
	        
	        employeeArray[0].setDepartment(secondDepartment);
	        System.out.println();
	        
	        for (Employee employee : employeeArray) {
	            System.out.println(employee);
	        }
	    }
}
