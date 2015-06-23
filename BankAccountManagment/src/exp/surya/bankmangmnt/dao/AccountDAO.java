package exp.surya.bankmangmnt.dao;

import java.util.List;

import exp.surya.bankmangmnt.model.Account;
import exp.surya.bankmangmnt.model.Person;

public interface AccountDAO {
	
public void save(Account a,Person p);
    
    public List<Account> list();

}
