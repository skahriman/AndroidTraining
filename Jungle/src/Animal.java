
public class Animal {
	
	String name;
	int eneryLevel;
	String sound;
	private static int totalNumberOfAnimal = 0;

	public Animal(String name, int eneryLevel) {
		this.eneryLevel = eneryLevel;
		this.name = name;
		Animal.totalNumberOfAnimal++;
	}

	public void makeSound() {
		if(this.eneryLevel - 3 < 0)
			System.out.println("can not perform action: No enaugh energy...");
		else {
			this.eneryLevel = eneryLevel - 3;
			System.out.println(this.getName() + " is speaking...");
			System.out.println(this.getName() + " energy: " + this.eneryLevel);
		}
	}
	
	public void eatFood() {
		System.out.println(this.getName() +  " is eating.");
		this.eneryLevel = eneryLevel + 5;
		System.out.println(this.getName() + " energy: " + this.eneryLevel);
	}
	
	public void sleep() {
		System.out.println(this.getName() +  " is sleaping.");
		this.eneryLevel = eneryLevel + 10;
		System.out.println(this.getName() + " energy: " + this.eneryLevel);
	}
	
	public String getSound() {
		return sound;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int totalNumberOfAnimal() {
		return Animal.totalNumberOfAnimal;
	}
	
}
