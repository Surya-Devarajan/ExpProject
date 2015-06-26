package exp.surya.bankmangmnt.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TransferDAOImpl implements TransferDAO {
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	@Override
	public void transferMoney(Integer sendersAcno,Integer receiversAcno, Float amount)
	{
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Query query1=session.createQuery("select account.balance from Person where account=:accNO");
			query1.setInteger("accNO", sendersAcno);
			Query query2=session.createQuery("select account.balance from Person where account=:accNO");
			query2.setInteger("accNO", receiversAcno);
			if(query1.uniqueResult()==null && query2.uniqueResult()==null){
				System.out.println("The account number you have entered is invalid");
			}
			else
			{
				Float sndBalance=(Float)query1.uniqueResult();
				
				Float recBalance=(Float)query1.uniqueResult();
				
				Query query3 =session.createQuery("Update Account a set a.balance=:balance where id=:acNO");
				query3.setInteger("acNO", sendersAcno);
				Float newsndBalance=sndBalance-amount;
				query3.setFloat("balance", newsndBalance);
				query3.executeUpdate();
				Query query4 =session.createQuery("Update Account a set a.balance=:balance where id=:accNO");
				query4.setInteger("accNO", receiversAcno);
				Float newrecBalance=recBalance+amount;
				query4.setFloat("balance", newrecBalance);
				query4.executeUpdate();
				
				 System.out.println("Transfer succesufully");
			        tx.commit(); 
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
	    session.close();
		}
	}

}
