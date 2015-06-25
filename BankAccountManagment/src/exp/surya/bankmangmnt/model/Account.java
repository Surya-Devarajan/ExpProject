package exp.surya.bankmangmnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountDetails")
public class Account {

	private Integer id;
	private Float Balance;

	@Id
	@Column(name = "AccNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Balance")
	public Float getBalance() {
		return Balance;
	}

	public void setBalance(Float balance) {
		Balance = balance;
	}

}
