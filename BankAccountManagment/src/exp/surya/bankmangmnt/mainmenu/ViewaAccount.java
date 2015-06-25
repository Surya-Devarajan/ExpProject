package exp.surya.bankmangmnt.mainmenu;

import java.util.Scanner;

import exp.surya.bankmangmnt.dao.ViewDAO;

public class ViewaAccount {
	public void viewaAccount(ViewDAO viewDAO)
	{
		Integer acno=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number to view details:");
		acno = sc.nextInt();
		viewDAO.viewDetails(acno);
	}
	

}
