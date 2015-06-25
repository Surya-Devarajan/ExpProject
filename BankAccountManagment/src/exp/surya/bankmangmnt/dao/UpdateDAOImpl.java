package exp.surya.bankmangmnt.dao;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import exp.surya.bankmangmnt.model.Person;

public class UpdateDAOImpl implements UpdateDAO{
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	@Override
	public void getDetails(Integer acno)
	{
		Session session = this.sessionFactory.openSession();
		try {
			
		
        Transaction tx = session.beginTransaction();
       //Person p = (Person) session.load(Person.class, acno);
       Query query =session.createQuery("from Person where account=:accNO");
       query.setInteger("accNO", acno);
       Person p = (Person) query.uniqueResult();
        Scanner sc = new Scanner(System.in);
		System.out.println("Your First name is :"+ p.getFName());
		System.out.println("Update your first name if don't want to update press enter :");
		String fname;
		fname=sc.nextLine();
		System.out.println("entering"+fname);
		if(!fname.equals("")){
			p.setFName(fname);}
		System.out.println("Your last name is :"+ p.getLName());
		System.out.println("Update your last name if don't want to update press enter :");
		String lname=sc.nextLine();
		if(!lname.equals(""))
			p.setLName(lname);
		System.out.println("Your Address is :"+ p.getAddress());
		System.out.println("Update your address if don't want to update press enter:");
		String address=sc.nextLine();
		if(!address.equals(""))
			p.setAddress(address);
		System.out.println("Your DOB is :"+ p.getDOB());
		System.out.println("Update your DOB if don't want to update press enter:");
		String dob=sc.nextLine();
		if(!dob.equals(""))
			p.setDOB(dob);
		System.out.println("Your PIN is :"+ p.getPin());
		System.out.println("Update your pin no if don't want to update press enter:");
		Long pin=sc.nextLong();
		if(!pin.equals("")){
			p.setPin(pin);
		}
        session.save(p);
        System.out.println("Data Updated");
        tx.commit(); 
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
        session.close();
		}
	}
	

}
