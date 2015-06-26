package exp.surya.bankmangmnt.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			if (person==null)
				System.out.println("The aacount no you have entered is invalid");
			String text = person.getDOB();
			  Date date;
			  Date today = new Date();
			  Integer age;
			  try {
			   date = new SimpleDateFormat("dd-MM-yyyy").parse(text);

			   age = (int) (today.getYear() - date.getYear());
			   System.out.println(person + ",Age=" + age);
			  } catch (ParseException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
        session.close();
		}
	}

}
