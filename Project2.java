import java.util.*;


public class Project2 {
	
	static int n = 100;

	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);

    //made an array of type Person
    Person[] person = new Person[n];
    int numberOfPeopleEntered = 0;
    boolean exit = false;
    
    System.out.println("\t\tWelcome to my Personal Management Program\n\n");
    
    while(!exit)
    {
      String input;
      //Dealing with multiple situations so switch cases seemed optimal
      switch (menu(scnr)) 
      {
        // Enter faculty
        case 1:
          if(numberOfPeopleEntered >= 100)
          {
            System.out.println("You already have 100 people filled in. All out of memory. Type yes to proceed.");
            input = scnr.nextLine();
            
            if (!input.toLowerCase().equals("yes"))
              break;
          }
          Faculty faculty = new Faculty();

          if (fillInFacultyInfo(faculty, scnr)){
            person[numberOfPeopleEntered] = faculty;
            numberOfPeopleEntered++;
            System.out.print("\n\n\tFaculty successfully added!\n");
          } 
          break;
        //Enter the information of the two students
        case 2:
          if(numberOfPeopleEntered >= 100)
          {
            System.out.println("You already have 100 people filled in. All out of memory. Type yes to proceed.");
            input = scnr.nextLine();
            
            if (!input.toLowerCase().equals("yes"))
              break;
          }
          Student student = new Student();
          if(fillInStudentInfo(student, scnr)){
            person[numberOfPeopleEntered] = student;
            numberOfPeopleEntered++;
            System.out.print("\nStudent Added!\n");
          }
          break;

        // print tuition invoice
        case 3:

          System.out.println("Enter student's id:" );
          input = scnr.nextLine();
          Person p = findPerson(input, person);
          if(p == null){
            System.out.println("No student matched!");
          }else{
            p.print();
          }
          break;
        //print faculty information
        case 4:
          System.out.println("Enter faculty's id:" );
          input = scnr.nextLine();
          p = findPerson(input, person);
          if(p == null){
            System.out.println("No faculty matched!");
          }else{
            p.print();
          }
          break;

        //Enters the information of the staff member
        case 5:
          if(numberOfPeopleEntered >= 100)
          {
            System.out.println("You already have 100 people filled in. All out of memory. Type yes to proceed.");
            input = scnr.nextLine();
            
            if (!input.toLowerCase().equals("yes"))
              break;
          }
          Staff staff = new Staff();

          if (fillInStaffInfo(staff, scnr)){
            person[numberOfPeopleEntered] = staff;
            numberOfPeopleEntered++;
            System.out.print("\n\n\tStaff member added!\n");
          } 
          break;
        
        // print information of a staff member
        case 6:
          System.out.println("Enter staff's id:" );
          input = scnr.nextLine();
          p = findPerson(input, person);
          if(p == null){
            System.out.println("No staff member matched!");
          }else{
            p.print();
          }
          break;

        // exit
        case 7:
          System.out.println("\n\nGoodbye!\n");
          
          exit = true;
          
          break;
        }
    }
	}

	public static int menu(Scanner scnr) 
  {	
    //printing menu and giving options
		System.out.println("Choose one of the options:\n");
		System.out.println("1 - Enter the information of the faculty");
		System.out.println("2 - Enter the information of the two students");
		System.out.println("3 - Print tuition invoice");
		System.out.println("4 - Print faculty information");
		System.out.println("5 - Enter the information of the staff member");
		System.out.println("6 - Print the information of the staff member");
		System.out.println("7 - Exit program\n");
		
		System.out.print("\tEnter your selection: ");
	    int response = 0;
      // added try catch block to catch invalid inputs
		try {
			response = Integer.parseInt(scnr.nextLine());
		}catch (NumberFormatException e) {
	      System.out.print("Invalid Input\n");
	    }
			return response;
	}
	
	public static boolean fillInFacultyInfo(Faculty faculty, Scanner scnr) 
  {	
		System.out.print("\nEnter faculty info:\n\n");
		System.out.print("\tName of the faculty: ");
		faculty.setName(scnr.nextLine());
		
		
		System.out.print("\n\tID: ");
		faculty.setId(scnr.nextLine());

		// force user to enter correct input
		boolean exit = false;

		while(!exit)
		{
			System.out.print("\n\tRank: ");
			faculty.setRank(scnr.nextLine());
			
      if(!(faculty.getRank().toLowerCase().equals("professor")|| faculty.getRank().toLowerCase().equals("adjunct")) )
      {
        System.out.print("Invalid entry - please try again\n");
      }   
      else
        exit = true;
		}
	
		exit = false;
		
    while(!exit)
		{
			System.out.print("\n\tDepartment: ");
			faculty.setDepartment(scnr.nextLine());
			
			if(!(faculty.getDepartment().toLowerCase().equals("mathematics") || faculty.getDepartment().toLowerCase().equals("engineering") || faculty.getDepartment().toLowerCase().equals("english")) )
		  {
		    System.out.print("Invalid entry - please try again\n");
		  }
		  else
		    exit = true;
		}
		
		return true;
	}

	public static boolean fillInStudentInfo(Student student, Scanner scnr) {
		try {
			System.out.print("\nEnter student 1 info:\n\n");
      
			System.out.print("\tName of Student: ");
			student.setName(scnr.nextLine());
	      
			System.out.print("\n\tID: ");
			student.setId(scnr.nextLine());
	      
			System.out.print("\n\tGpa: ");
			student.setGpa(Double.parseDouble(scnr.nextLine()));
	      
			System.out.print("\n\tCredit hours: ");
			student.setCredits(Integer.parseInt(scnr.nextLine())); 
      
		}catch (NumberFormatException e) {
			System.out.print("Invalid Input\n");
			return false;
		}
		return true;
	}

  public static Person findPerson(String id, Person[] person){
    for(int i = 0; i < n; i++){
      if(person[i] != null){
        Person p = person[i];
        if(p.getId().equals(id)){
          return p;
        }
      }
    }
    return null;
  }

	public static boolean fillInStaffInfo(Staff staff, Scanner scnr) 
	{
	    System.out.print("\nEnter staff member info:\n\n");
	
	    System.out.print("\tName of Staff member: ");
	    staff.setName(scnr.nextLine());
	
	    System.out.print("\n\tEnter the id: ");
	    staff.setId(scnr.nextLine());

    
	    boolean exit = false;
    
	    while(!exit)
	    {
	    	System.out.print("\n\tDepartment: ");
	        staff.setDepartment(scnr.nextLine());
	        
	        if(!(staff.getDepartment().toLowerCase().equals("mathematics") || staff.getDepartment().toLowerCase().equals("engineering") || staff.getDepartment().toLowerCase().equals("english")) )
	        {
	            System.out.print("Invalid entry - please try again\n");
	        }
	        else
		        exit = true;
	    }
    
	    exit = false;
	    
	    while(!exit)
	    {
	    	System.out.print("\n\nStatus, enter P for part time or enter F for full time: ");
	        staff.setStatus(scnr.nextLine());
	
	        if(!(staff.getStatus().equals("P") ||  staff.getStatus().equals("p") ||  staff.getStatus().equals("F") || staff.getStatus().equals("f"))) {
	        	System.out.print("Invalid entry- please try again\n");
	        }
	        else
	        	exit = true;
	    }
	
	    return true;
	}
} 


abstract class Person {
  protected String name;
  protected String id;
  
  abstract void print();
  
  Person(){
    name = "Not given";
    id = "Not given";
  }

  Person(String name){
    this.name = name;
    id = "Not given";
  }

  Person(String name, String id){
    this.name = name;
    this.id = id;
  }

  void setName(String name) {
    this.name = name;
  }
  
  String getName() {
    return this.name;
  }
  
  void setId(String id) {
    this.id = id;
  }
  
  String getId() {
    return this.id;
  }
}
	
	
class Student extends Person{
  private double gpa;
  private int credit_hours;
  
  Student(){}

  Student(String name, String id, double gpa){
    super(name, id);
    this.gpa = gpa;
  }

  Student(String name, String id, double gpa, int credit_hours){
    super(name, id);
    this.gpa = gpa;
    this.credit_hours = credit_hours;
  }

  void setGpa(double gpa) {
    this.gpa = gpa;
  }
  
  double getGpa() {
    return this.gpa;
  }
  
  void setCredits(int hours) {
    this.credit_hours = hours;
  }
  
  int getCredits() {
    return this.credit_hours;
  }

  void print(){
    System.out.printf("\n---------------------------------------------------------------------------\n");
    System.out.printf("%s\t\t%s\n", this.name, this.id);
    System.out.printf("Credit Hours:%d  (236.45/credit hour)\n", this.credit_hours);
    System.out.println("Fees: $52\n\n");
    
    double total_payment = 236.45 * this.credit_hours + 52;
    double discount = 0;
    
    if (this.gpa >= 3.85){
      discount = .25 * total_payment;
      total_payment = total_payment - discount;
    }
    
    System.out.printf("Total Payment (after discount): %.2f\t\t ($%.2f discount applied)\n", total_payment, discount);
    System.out.printf("---------------------------------------------------------------------------\n");
  }
}
	
abstract class Employee extends Person {
  protected String department;

  Employee(){}
  Employee(String name, String id, String dept){
    super(name, id);
    this.department = dept;
  }
  
  void setDepartment(String dept) {
    this.department = dept;
  }
  
  String getDepartment() {
    return this.department;
  }
}
	
	
class Faculty extends Employee{
  private String rank;

  Faculty(){}
  
  Faculty(String name, String id, String dept, String rank){
    super(name, id, dept);
    this.rank = rank;
  }
  
  void setRank(String rank) {
    this.rank = rank;
  }
  
  String getRank() {
    return this.rank;
  }

  void print(){
    System.out.print("\n---------------------------------------------------------------------------\n");
	  System.out.printf("%s\t\t%s\n", this.name, this.id);
	  System.out.printf("%s Department, %s\n", (this.department.substring(0, 1).toUpperCase() + this.department.substring(1).toLowerCase()), this.rank);
	  System.out.print("---------------------------------------------------------------------------\n");
    
  }
}

class Staff extends Employee{
  private String status;

  Staff(){}
  
  Staff (String name, String id, String dept, String status){
    super(name, id, dept);
    this.status = status;
  }
  
  void setStatus(String status) {
    this.status = status;
  }
  
  String getStatus() {
    return this.status;
  }
    
  void print(){
    System.out.print("\n--------------------------------------------------");
	
    System.out.print("\n" + this.name + "\t\t"+ this.id);

    System.out.print("\n" + (this.department.substring(0, 1).toUpperCase() + this.department.substring(1).toLowerCase()) + " Department, ");
    
    if(this.status.equals("p") || this.status.equals("P")){
      System.out.print("Part Time");
    }else if(this.status.equals("f") || this.status.equals("F")){
      System.out.print("Full Time");
    }
    System.out.print("\n--------------------------------------------------\n");
  }
}
