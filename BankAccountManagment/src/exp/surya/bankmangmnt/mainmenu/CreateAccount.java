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
	
	
	 /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernateConf.xml");
     
	  
	 	AccountDAO accountDAO=(AccountDAO) context.getBean("accountDAO");*/
     
	 	/*Resource resource= new ClassPathResource("personXml.xml");
		BeanFactory factory= new XmlBeanFactory(resource);					// input details through beans
      
		Account account=(Account)factory.getBean("accountbean1") ;
		Person person=(Person)factory.getBean("personbean1");
		*/
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
		System.out.println("Enter your last name :");
		lastname=sc.nextLine();
		System.out.println("Enter your date of birth :");
		dob=sc.nextLine();
		System.out.println("Enter your address :");
		address=sc.nextLine();
		System.out.println("Enter your gender :");
		gender=sc.nextLine();
		System.out.println("Enter your pin :");
		pin=sc.nextLong();
		System.out.println("Enter amount :");
		balance=sc.nextFloat();
		
		

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
