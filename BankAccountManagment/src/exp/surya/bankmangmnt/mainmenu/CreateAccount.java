package exp.surya.bankmangmnt.mainmenu;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import exp.surya.bankmangmnt.dao.AccountDAO;
import exp.surya.bankmangmnt.model.Account;
import exp.surya.bankmangmnt.model.Person;

public class CreateAccount {
	
	public void createAccount(){
	
	
	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernateConf.xml");
     
	  
     AccountDAO accountDAO=(AccountDAO) context.getBean("accountDAO");
     
     Resource resource= new ClassPathResource("personXml.xml");
		BeanFactory factory= new XmlBeanFactory(resource);
      
		Account account=(Account)factory.getBean("accountbean1") ;
		Person person=(Person)factory.getBean("personbean1");
		accountDAO.save(account,person); 
        System.out.println("Person::"+person);
        
        context.close(); 
        
	}

}
