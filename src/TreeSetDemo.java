
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
//Created a class named EmployeeDemo
public class TreeSetDemo {
//Main method
    public static void main(String[] args) {
    	//Creating Object of Employee class
        Employee employee1 = new Employee("Arun Thakur", "Trainer", 5000);
        Employee employee2 = new Employee("Manish Kumar", "Developer", 20000);
        Employee employee3 = new Employee("Mithun Burman", "Associate", 5000);
        Employee employee4 = new Employee("Naina Kumari", "Team Leader", 8000);
        
          //Creating object of TreeSet and making it generic for Employee
        TreeSet<Employee> treeSet = new TreeSet<Employee>(new EmployeeChainedComparator(
                new NameComparator(), new DesignationComparator()
                ));
        //Using add method and adding the references of Employee class
        treeSet.add(employee1);
        treeSet.add(employee2);
        treeSet.add(employee3);
        treeSet.add(employee4);
      //Applying for each loop to iterate
        for(Employee el : treeSet){
            System.out.println(el.toString());
        }
    }

}

class SalaryComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee a1, Employee a2) {
        if(a1.getSalary() > a2.getSalary()){
            return 1;
        }else{
            return -1;
        }
    }
    
}

//Creating a class NameComparator and implementing comparator
class NameComparator implements Comparator<Employee>{
    //Also using compareTo
    @Override
    public int compare(Employee a1, Employee a2) {
        return a1.getName().compareTo(a2.getName());  
    }
    
}
//Creating a class DesignationComparator and implementing comparator
class DesignationComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee a1, Employee a2) {
        return a1.getDesignation().compareTo(a2.getDesignation());  
    }
    
}
 //Creating a class EmployeeChainedComparator it implements  Comparator
class EmployeeChainedComparator implements Comparator<Employee> {
     
    private List<Comparator<Employee>> listComparators;
 
    @SafeVarargs
    public EmployeeChainedComparator(Comparator<Employee>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Employee emp1, Employee emp2) {
    	//For each loop
        for (Comparator<Employee> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}