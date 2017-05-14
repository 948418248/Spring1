package bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Message implements Serializable {

	private int id;
	private String name;
	private double salary;
	
	private MobilePhone phone;
	
	private List<String> cities;
	private Map<String,String> score;
	private Properties params;
	
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public Map<String, String> getScore() {
		return score;
	}
	public void setScore(Map<String, String> score) {
		this.score = score;
	}
	public Properties getParams() {
		return params;
	}
	public void setParams(Properties params) {
		this.params = params;
	}
	public MobilePhone getPhone() {
		return phone;
	}
	public void setPhone(MobilePhone phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
