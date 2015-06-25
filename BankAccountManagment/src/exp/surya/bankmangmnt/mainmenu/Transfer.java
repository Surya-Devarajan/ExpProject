package exp.surya.bankmangmnt.mainmenu;

import java.util.Scanner;

import exp.surya.bankmangmnt.dao.TransferDAO;

public class Transfer {
	public void transferAmount(TransferDAO transferDAO)
	{
		Integer sndAcno;
		Integer recAcno;
		Float amount;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Account number :");
		sndAcno=sc.nextInt();
		System.out.println("Enter Account number of recevier :");
		recAcno=sc.nextInt();
		System.out.println("Enter the amount to transfer :");
		amount=sc.nextFloat();
		transferDAO.transferMoney(sndAcno, recAcno, amount);
		
	}

}
