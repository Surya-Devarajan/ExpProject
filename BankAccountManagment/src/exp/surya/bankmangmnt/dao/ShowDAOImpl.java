package exp.surya.bankmangmnt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import exp.surya.bankmangmnt.model.Account;
import exp.surya.bankmangmnt.model.Person;

public class ShowDAOImpl implements ShowDAO{
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	@Override
	public void showAllAccountDetails()
	{
		Session session = this.sessionFactory.openSession();
		try {
		
		        List<Person> accList = session.createQuery("from Person").list();
		        for(Person p: accList)
		        	System.out.println(p);
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
        session.close();
		}
		
	}

}
