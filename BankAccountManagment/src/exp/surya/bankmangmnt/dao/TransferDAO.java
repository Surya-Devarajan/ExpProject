package exp.surya.bankmangmnt.dao;

public interface TransferDAO {
	public void transferMoney(Integer sendersAcno,Integer receiversAcno, Float amount);

}
