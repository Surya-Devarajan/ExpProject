package exp.surya.bankmangmnt.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import exp.surya.bankmangmnt.model.Account;
import exp.surya.bankmangmnt.model.Person;

public class DepositDAOImpl implements DepositDAO {
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	@Override
	public void depositMoney(Integer acNo, Float amount){
		Session session = sessionFactory.openSession();
		try {
			System.out.println("am here");
			Transaction tx = session.beginTransaction();
			
			Query query1=session.createQuery("select account.balance from Person where account=:accNO");
			query1.setInteger("accNO", acNo);
			Float bal=(Float)query1.uniqueResult();
			try
			{
			Query query =session.createQuery("Update Account a set a.balance=:balance where id=:accNO");
			query.setInteger("accNO", acNo);
			Float upBalance=amount+bal;
			query.setFloat("balance", upBalance);
			query.executeUpdate();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
	        System.out.println("Deposit Sucessfully");
	        tx.commit(); 
			
	}catch (Exception e) {
		// TODO: handle exception
	}finally{
    session.close();
	}
		
	}

}
