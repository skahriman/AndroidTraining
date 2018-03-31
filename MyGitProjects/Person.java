
public class Person {
	
	private String name;
	private String gender;
	private int age;
	private String address;
	
	
	
	public Person(String name, String gender, int age, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	


	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + ", address=" + address + "]";
	}


	public static void main(String[] args) {
		Person p = new Person("safak", "male", 37, "Atlanta/GA");	
		System.out.println(p.toString());

	}

}
