package Bean;

public class Province {
	private int idProvince;
	private String name;
	
	
	public Province(int idProvince, String name) {
		super();
		this.idProvince = idProvince;
		this.name = name;
	}
	
	public Province() {
		super();
	}

	public int getIdProvince() {
		return idProvince;
	}
	public void setIdProvince(int idProvince) {
		this.idProvince = idProvince;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
