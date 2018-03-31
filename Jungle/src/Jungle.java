import java.util.ArrayList;

public class Jungle <T> {

	ArrayList<T> snakeList;
	ArrayList<T> tigerList;
	ArrayList<T> monkeyList;

	
	public Jungle() {
		snakeList = new ArrayList<T>();
		tigerList = new ArrayList<T>();
		monkeyList = new ArrayList<T>();
	
	}
	
	@SuppressWarnings("unchecked")
	public <T> void addAnimals(ArrayList<T> list, Animal animal) {
		list.add((T) animal);
	}
	
	public <T> void showAnimalList(ArrayList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
//	
//	public <T> void printAnimalList(ArrayList<T> list) {
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(this.snakeList.get(i).getName());
//		}
//	}
	
	public static void main(String[] args) {

		Snake s1 = new Snake("Snake_1", 10);
		Snake s2 = new Snake("Snake_2", 10);
		Snake s3 = new Snake("Snake_3", 10);
		Tiger t1 = new Tiger("Tiger_1", 10);
		Tiger t2 = new Tiger("Tiger_2", 10);
		Tiger t3 = new Tiger("Tiger_3", 10);
		Monkey m1 = new Monkey("Monkey_1", 10);
		Monkey m2 = new Monkey("Monkey_2", 10);
		Monkey m3 = new Monkey("Monkey_3", 10);
		
		Jungle<?> jungle = new Jungle<Object>();
		
		jungle.addAnimals(jungle.snakeList, s1);
		jungle.addAnimals(jungle.snakeList, s2);
		jungle.addAnimals(jungle.snakeList, s3);
		
		jungle.addAnimals(jungle.tigerList, t1);
		jungle.addAnimals(jungle.tigerList, t2);
		jungle.addAnimals(jungle.tigerList, t3);
		
		jungle.addAnimals(jungle.monkeyList, m1);
		jungle.addAnimals(jungle.monkeyList, m2);
		jungle.addAnimals(jungle.monkeyList, m3);
		
		((Snake) jungle.snakeList.get(0)).makeSound();
		((Snake) jungle.snakeList.get(0)).makeSound();
		((Snake) jungle.snakeList.get(0)).makeSound();
		((Snake) jungle.snakeList.get(0)).makeSound();
		((Snake) jungle.snakeList.get(0)).eatFood();
		System.out.println();
		
		((Tiger) jungle.tigerList.get(0)).makeSound();
		System.out.println();
		
		((Monkey) jungle.monkeyList.get(0)).makeSound();
		((Monkey) jungle.monkeyList.get(0)).makeSound();
		((Monkey) jungle.monkeyList.get(0)).makeSound();
		((Monkey) jungle.monkeyList.get(0)).sleep();
		((Monkey) jungle.monkeyList.get(0)).play();
		
	}
}









