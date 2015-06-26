package exp.surya.bankmangmnt.mainmenu;

import java.util.Scanner;

import exp.surya.bankmangmnt.dao.UpdateDAO;

public class UpdateDetails {
	
	public void updateAccount(UpdateDAO updateDAO)
	{
		Integer acno=null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your account no to update details :");
		String acnostr = sc.nextLine();
		while(acnostr.isEmpty())
		{
			System.out.println("Please enter an account no to view details");
			acnostr = sc.nextLine();
		}
		acno=Integer.valueOf(acnostr);
		updateDAO.getDetails(acno);
		
	}
	

}
