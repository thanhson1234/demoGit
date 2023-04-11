import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
 
	private static int nextid = 1;
	private int id;
	private String name;
	private Date Birday;
	private String address;
	private int height;
	private double weight;
	public Person() {
		super();
	}
	public Person(String name, Date birday, String address, int height, double weight) {
		super();
		this.id = nextid;
		nextid++;
		this.name = name;
		this.Birday = birday;
		this.address = address;
		this.height = height;
		this.weight = weight;
	}
	

	public static int getNextid() {
		return nextid;
	}
	public static void setNextid(int nextid) {
		Person.nextid = nextid;
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
	public Date getBirday() {
		return Birday;
	}
	public void setBirday(Date birday) {
		Birday = birday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", Birday=" + Birday + ", address=" + address + ", height="
				+ height + ", kg=" + weight + "]";
	}
	

}
