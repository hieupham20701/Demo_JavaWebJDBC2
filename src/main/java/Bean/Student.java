package Bean;

public class Student {
	private int idstudent;
	private String name;
	private Province province;
	
	
	public Student(int idstudent, String name, Province province) {
		super();
		this.idstudent = idstudent;
		this.name = name;
		this.province = province;
	}
	


	public Student(String name, Province province) {
		super();
		this.name = name;
		this.province = province;
	}



	public int getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
}
