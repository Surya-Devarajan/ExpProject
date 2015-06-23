package exp.surya.bankmangmnt.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import exp.surya.bankmangmnt.mainmenu.CreateAccount;
import exp.surya.bankmangmnt.model.Account;
import exp.surya.bankmangmnt.model.Person;
import exp.surya.bankmangmnt.dao.*;


public class BankAccountManagment {
	 public static void main(String[] args) {
		 
	        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernateConf.xml");
	         
	  /werwt3uyh9aw8oepwLGEFHURE;BGEWQLIGIUUOEQEIOQOUFDWHUFUFHIHFIFHWOJK
	   * DBCEAIDHUEAWQHUIDJ
	   * HUDOFDEFHIJC
	   * 
	   * 
	        AccountDAO accountDAO=(AccountDAO) context.getBean("accountDAO");
	        
	        Resource resource= new ClassPathResource("personXml.xml");
			BeanFactory factory= new XmlBeanFactory(resource);
	         
			Account account=(Account)factory.getBean("accountbean1") ;
			Person person=(Person)factory.getBean("personbean1");
	        
	        Account account = new Account();
	        Person person = new Person();

	        person.setFName("Vishnu");
	        person.setLName("G");
	        person.setDOB("29-03-1989");
	        person.setAddress("some address,some address");
	        person.setGender("M");
	        person.setPin((long)69887);
	        
	        account.setBalance((double)500);
	        
	        
			accountDAO.save(account,person); 
	        System.out.println("Person::"+person);
	         
	        
	        List<Account> acclist =accountDAO.list();
	        for(Person p : prsnlist){
	            System.out.println("Person List::"+p);
	        }
	        //close resources
	        context.close();*/  
		  System.out.println("1. Create Account");
		  Scanner sc= new Scanner(System.in);
		  
		  int a=0;
		  a=sc.nextInt();
		  switch (a) {
		case 1:
			CreateAccount CA= new CreateAccount();
			CA.createAccount();
			
			break;

		default:
			break;
		}
		  
	    }

}
