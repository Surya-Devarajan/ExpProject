package exp.surya.bankmangmnt.mainmenu;

import java.util.Scanner;

import exp.surya.bankmangmnt.dao.DepositDAO;

public class Deposit {
	public void depositAmount(DepositDAO depositDAO)
	{
		Integer acNo;
		Float amount;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the accountno to deposit money");
		acNo=sc.nextInt();
		System.out.println("Enter the amount");
		amount=sc.nextFloat();
		depositDAO.depositMoney(acNo, amount);
	}

}
