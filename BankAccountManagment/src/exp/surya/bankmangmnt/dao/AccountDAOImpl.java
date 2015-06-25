package exp.surya.bankmangmnt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import exp.surya.bankmangmnt.model.Account;
import exp.surya.bankmangmnt.model.Person;

public class AccountDAOImpl implements AccountDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	
	@Override
	public void save(Account a,Person p){
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        p.setAccount(a);
        session.save(p);
        tx.commit();
        session.close();
	}
	
	@SuppressWarnings("unchecked")
    @Override
    public List<Account> list() {
        Session session = this.sessionFactory.openSession();
        List<Account> accountList = session.createQuery("from Account").list();
        session.close();
        return accountList;
    }
	
	

}
