package exp.surya.bankmangmnt.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		        {
		        	String text = p.getDOB();
		        	  Date date;
		        	  Date today = new Date();
		        	  Integer age;
		        	  try {
		        	   date = new SimpleDateFormat("dd-MM-yyyy").parse(text);

		        	   age = (int) (today.getYear() - date.getYear());
		        	   System.out.println(p + ",Age=" + age);
		        	  } catch (ParseException e) {
		        	   // TODO Auto-generated catch block
		        	   e.printStackTrace();
		        	  }
		        }
		        	
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
        session.close();
		}
		
	}

}
