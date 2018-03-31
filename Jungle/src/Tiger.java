
public class Tiger extends Animal {

	String sound;
	
	public Tiger(String name, int eneryLevel) {
		super(name, eneryLevel);
	}

	public void sleep() {
		this.eneryLevel = eneryLevel + 5;
	}
}
