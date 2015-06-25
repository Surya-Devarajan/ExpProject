package exp.surya.bankmangmnt.main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import exp.surya.bankmangmnt.mainmenu.CreateAccount;
import exp.surya.bankmangmnt.mainmenu.Deposit;
import exp.surya.bankmangmnt.mainmenu.ShowAccounts;
import exp.surya.bankmangmnt.mainmenu.Transfer;
import exp.surya.bankmangmnt.mainmenu.UpdateDetails;
import exp.surya.bankmangmnt.mainmenu.ViewaAccount;
import exp.surya.bankmangmnt.model.Account;
import exp.surya.bankmangmnt.model.Person;
import exp.surya.bankmangmnt.dao.*;


public class BankAccountManagment {
	 public static void main(String[] args) throws IOException {
		 
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernateConf.xml");
	         
	 
	        AccountDAO accountDAO=(AccountDAO) context.getBean("accountDAO");
	        UpdateDAO updateDAO=(UpdateDAO) context.getBean("updateDAO");
	        ViewDAO viewDAO=(ViewDAO) context.getBean("viewDAO");
	        ShowDAO showDAO=(ShowDAO) context.getBean("showDAO");
	        DepositDAO depositDAO=(DepositDAO) context.getBean("depositDAO");
	        TransferDAO transferDAO=(TransferDAO) context.getBean("transferDAO");
	        
	        
	        System.out.println("1. Create Account");
	        System.out.println("2. Updtae Account");
	        System.out.println("3. View a Account details");
	        System.out.println("4. Show all Account details");
	        System.out.println("5. Deposit ");
	        System.out.println("6. Transfer Amount");
	        Scanner sc= new Scanner(System.in);
		  
	        int a=0;
	        
	        a=sc.nextInt();
	        switch (a) {
	        case 1:
			  CreateAccount CA= new CreateAccount();
			  CA.createAccount(accountDAO);
			break;
	        case 2:
			  UpdateDetails UA=new UpdateDetails();
			  UA.updateAccount(updateDAO);
			 break;
			 case 3:
				 ViewaAccount VA=new ViewaAccount();
			  	 VA.viewaAccount(viewDAO);
			  break;
			 case 4:
				 ShowAccounts SA=new ShowAccounts();
				 SA.showAccounts(showDAO);
			 break;
			case 5:
				 Deposit DP=new Deposit();
				 DP.depositAmount(depositDAO);
			 break;
			case 6:
				Transfer TR=new Transfer();
				TR.transferAmount(transferDAO);
			break;
				
	        default:
			break;
		}  
	   }

}
