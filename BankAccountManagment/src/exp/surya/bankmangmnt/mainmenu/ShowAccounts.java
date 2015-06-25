package exp.surya.bankmangmnt.mainmenu;

import exp.surya.bankmangmnt.dao.ShowDAO;

public class ShowAccounts {
	
	public void showAccounts(ShowDAO showDAO)
	{
		showDAO.showAllAccountDetails();
	}
	
	
}
