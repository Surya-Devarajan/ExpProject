package exp.surya.bankmangmnt.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import exp.surya.bankmangmnt.model.Person;

public class ViewDAOImpl implements ViewDAO{
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	@Override
	public void viewDetails(Integer acno)
	{
		Session session = this.sessionFactory.openSession();
		try {
		
			Transaction tx = session.beginTransaction();
			Query query =session.createQuery("from Person where account=:accNO");
			query.setInteger("accNO", acno);
			Person person = (Person) query.uniqueResult();
			System.out.println(person);
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
        session.close();
		}
	}

}
