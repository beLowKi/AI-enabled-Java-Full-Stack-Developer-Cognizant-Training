import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;
import com.cts.service.EmployeeService;

public class EmployeeServiceTest {

	// Creates a mock object of EmployeeRepository
	@Mock
	private EmployeeRepository empRepo;

	// Injects mock repository into EmployeeService
	@InjectMocks
	private EmployeeService empService;


	// MockitoAnnotations-Initialize Mockito annotations
	@BeforeEach
	public void setup() {
		// openMocks -Identifies and initializes Mockito 
		// annotations in the current test class.
		MockitoAnnotations.openMocks( this );
	}
	
	
	@Test
	public void testFindAllEmployees() {
		
		Employee e1 = new Employee( 1L, "Malcolm", "Trainee", 10.0d );
		Employee e2 = new Employee( 2L, "Malcolm II", "Trainee", 10.0d );
		
		Employee[] emps = {e1, e2}; 
		
		when(empRepo.findAllEmployees())
        	.thenReturn(emps);
		
		Employee[] result = empService.getAllEmployees();
		
		assertNotNull( result );
		assertEquals(2, result.length);
		
		assertEquals(e1, result[0]);
		assertEquals( e2, result[1] );
		assertEquals("Malcolm", result[0].getName());
		assertEquals("Malcolm II", result[1].getName());
		
	}
	
	
	@Test
	public void testSaveEmployee() {
		
		Employee e1 = new Employee( 1L, "Malcolm", "Trainee", 10.0d );
		
		empService.saveEmployee( e1 );
		
		verify( empRepo, times( 1 ) ).saveEmployee(e1);
		
	}
	
}
