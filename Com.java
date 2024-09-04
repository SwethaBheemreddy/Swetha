package Week2Assignments;

import java.util.Arrays;

class Department{
	private int id;
	private String deptname;
	private String hod_name;
	public Department(int id, String deptname, String hod_name) {
		super();
		this.id = id;
		this.deptname = deptname;
		this.hod_name = hod_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getHod_name() {
		return hod_name;
	}
	public void setHod_name(String hod_name) {
		this.hod_name = hod_name;
	}
		
}

class University{
	String name;
	String address;
	Department depts[];
	public University(String name, String address, Department[] depts) {
		super();
		this.name = name;
		this.address = address;
		this.depts = depts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Department[] getDepts() {
		return depts;
	}
	public void setDepts(Department[] depts) {
		this.depts = depts;
	}
	@Override
	public String toString() {
		return "University [name=" + name + ", address=" + address + ", depts=" + Arrays.toString(depts) + "]";
	}
	
}

public class Com {
	public static void main(String[] args) {
		Department [] depts = new Department[2];
		depts[0] = new Department(123,"CSE","Ram");
		depts[1] = new Department(124,"ECE","Raju");
		
		University un1 = new University("JNU","Hyderabad",depts);
		System.out.println(un1.toString());

	}

}

