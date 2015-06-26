package exp.surya.bankmangmnt.mainmenu;


import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import exp.surya.bankmangmnt.dao.AccountDAO;
import exp.surya.bankmangmnt.model.Account;
import exp.surya.bankmangmnt.model.Person;

public class CreateAccount {
	
	public void createAccount(AccountDAO accountDAO) throws IOException{
	
	 	String firstname=null;
	 	String lastname=null;
	 	String dob=null;
	 	String address=null;
	 	String gender=null;
	 	Long pin=null;
	 	Float balance=null;
	 	
	 	Scanner sc = new Scanner(System.in);
	 	System.out.println("Enter your first name :");
		firstname=sc.nextLine();
		while(firstname.isEmpty())
		{
			System.out.println("Please enter your first name :");
			firstname=sc.nextLine();
		}
		System.out.println("Enter your last name :");
		lastname=sc.nextLine();
		while(lastname.isEmpty())
		{
			System.out.println("Please enter your last name :");
			lastname=sc.nextLine();
		}
		System.out.println("Enter your date of birth (Eg: dd/mm/yyyy):");
		dob=sc.nextLine();
		while(dob.isEmpty() ||! dob.matches("\\d{2}-\\d{2}-\\d{4}"))
		{
			System.out.println("Please enter your date of birth in valid format (Eg: dd/mm/yyyy):");
			dob=sc.nextLine();
		}
		System.out.println("Enter your address :");
		address=sc.nextLine();
		while(address.isEmpty())
		{
			System.out.println("Please enter your address:");
			address=sc.nextLine();
		}
		System.out.println("Enter your gender :");
		gender=sc.nextLine();
		while(gender.isEmpty())
		{
			System.out.println("Please enter your gender :");
			gender=sc.nextLine();
		}
		System.out.println("Enter your pin :");
		String pinstr=sc.nextLine();
		
		while(pinstr.isEmpty() || !pinstr.matches("\\d+"))
		{
			System.out.println("Please enter a valid pin no (Eg: 4565215)  :");
			pinstr=sc.nextLine();
			
		}
		pin=Long.valueOf(pinstr);
		System.out.println("Enter amount :");
		String balancestr=sc.nextLine();
		while(balancestr.isEmpty()|| !balancestr.matches("\\d+"))
		{
			System.out.println("Please enter your amount :");
			balancestr=sc.nextLine();
		}
		
		balance=Float.valueOf(balancestr);
        Account account = new Account();
        Person person = new Person();

        person.setFName(firstname);
        person.setLName(lastname);
        person.setDOB(dob);
        person.setAddress(address);
        person.setGender(gender);
        person.setPin(pin);
        
        account.setBalance(balance);
        
		accountDAO.save(account,person); 
        System.out.println("Person::"+person);
        
        
        
	}

}
