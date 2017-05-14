package bean;

import java.io.Serializable;

public class Student implements Serializable {

	private Computer computer;
	private MobilePhone phone;
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public MobilePhone getPhone() {
		return phone;
	}
	public void setPhone(MobilePhone phone) {
		this.phone = phone;
	}
	
	
}
