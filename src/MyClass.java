import java.util.Comparator;

public class MyClass implements Comparator<Employee> {

	@Override
	//This methode is used to short based on integer
	public int compare(Employee e1, Employee e2) {
		if(e1.getSalary()<e2.getSalary()){
			return 1;
		}
		else {
			return -1;
		}
	}

	

}
