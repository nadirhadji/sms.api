package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="numbers")
public class Numbers {

	@Id
	@Column(name="id")
	private int id;

	@Column(name="phone" , length=500)
	private Long phonenumber;

	public Numbers() {}

	public Numbers(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPhonenumber() {
		return phonenumber.toString();
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "Receiver [id=" + id + ", phonenumber=" + phonenumber + ", getPhonenumber()=" + getPhonenumber() + "]";
	}
}
