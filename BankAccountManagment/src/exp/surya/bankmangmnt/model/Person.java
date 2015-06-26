package exp.surya.bankmangmnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persondetails")
public class Person {

	private int Id;

	private String FName;
	private String LName;
	private String Gender;
	private String Address;
	private String DOB;
	private Long Pin;

	private Account account;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Column(name = "FName")
	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	@Column(name = "LName")
	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	@Column(name = "Gender")
	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Column(name = "Address")
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Column(name = "DOB")
	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	@Column(name = "Pin")
	public Long getPin() {
		return Pin;
	}

	public void setPin(Long pin) {
		Pin = pin;
	}

	@ManyToOne
	@JoinColumn(name = "AccNo")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString()
	{
		return("PersonId: "+ Id +",AccNo:"+account.getId()+ " FirstName: "+FName+", LastName: "+LName+", Address: "+Address+", Gender: "+Gender+"," +
				" Date of birth: "+DOB+", Pin: "+Pin+", Balance: "+account.getBalance());
	}
}
