package FileHandling;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	int empId;
	String empName;
	String department;
	double salary;


	public Employee() {}


	/**
	 * @param empId
	 * @param empName
	 * @param department
	 * @param salary
	 */
	public Employee( int empId, String empName, String department, double salary ) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.salary = salary;
	}


	@Override
	public String toString() {
		return empId + " | " + empName + " | " + department + " | " + salary;
	}

}
