package codes;

import java.util.Scanner;

public class Employee {
	
	private String firstName;
	private String lastName;
	
	private static final String company = "Company";
	
	private String department;
	
	private String generatedPassword;
	private String password;
	
	private int mailBoxCapacity;
	private String generatedEmailId;
	private String alternateEmailId;
	private int defaultPasswordLength = 10;
	
		
	public Employee(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
		// initially generating the email id
		this.generatedEmailId = generateEmailId(this.firstName, this.lastName);
		System.out.println(" Generated Email ID = "+ generatedEmailId);
		
		// getting the random password for this generated email id
		this.password = generateRandomPassword(this.defaultPasswordLength);
		System.out.println("Generated Random Password : "+password);
		
		
		System.out.println("Do you wish to set your own password ? enter y for YES or n for NO");
		Scanner sc = new Scanner(System.in);
		String choicePassword =  sc.nextLine();
		
		
		if("Y".equalsIgnoreCase(choicePassword)) {
			this.password = changePassword(sc);
			System.out.println("Your Password is : "+ this.password);
		}
		
		
		// taking the department input
		this.department = getDepartmentFromUser(sc);
		System.out.println(" Your Department is  "+ this.department);
		
		// take alternate email id
		System.out.println(" Enter your alternate Email ID");		
		this.alternateEmailId = takeAlternateEmailId();
		System.out.println("Your alternate email Id is : "+this.alternateEmailId );
		
	}

	// generate Email ID
	public String generateEmailId(String firstName, String lastName) {
		return firstName + "." +lastName + "@"+department + "." + company + ".com";
	}

	
	// Determine the Department
	public String getDepartmentFromUser(Scanner sc) {
		System.out.print("Department Codes \n 1 for Computer Science \n 2 for Electronics \n 3 for Civil \n 4 for None");
		System.out.println("\n Enter the Department : ");
		int dept = sc.nextInt();
		if(dept == 1) {
			return "CSE";
		}else if(dept == 2) {
			return "EEE";
		} else if(dept == 3) {
			return "Civil";
		} else {
			return "Not valid";
		}
	}
	
	// Generate a random Password
	public String generateRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$";
		char[] password =  new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int)( Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password); 
	}
	
	
	// change password
	
	public String changePassword(Scanner sc) {
		System.out.println(" Enter your new password : ");
		this.password = sc.nextLine();
		return this.password;
	}
	
	// set Mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	// alternate email address
	public String takeAlternateEmailId() {
		Scanner sc = new Scanner(System.in);
		return this.alternateEmailId = sc.nextLine();
	}

	// getters -> name, email, mailbox capacity
	public String getGeneratedEmailId() {
		return generatedEmailId;
	}

	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}
	
	public String getName() {
		return firstName+ " " + lastName;
	}
	
	
}
