package exp.surya.bankmangmnt.mainmenu;

import java.util.Scanner;

import exp.surya.bankmangmnt.dao.UpdateDAO;

public class UpdateDetails {
	
	public void updateAccount(UpdateDAO updateDAO)
	{
		Integer acno=null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your account no to update details :");
		acno = sc.nextInt();
		
		updateDAO.getDetails(acno);
		
	}
	

}
