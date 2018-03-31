
public class Tiger extends Animal {
    
    String sound;
    
    public Tiger(String name, int eneryLevel) {
        super(name, eneryLevel);
    }
    
    public void sleep() {
        this.eneryLevel = eneryLevel + 5;
    }
    
    public void eatFood(String food) {
        if(food.equals("grain")) {
            System.out.println("Tiger can not eat grain!!!");
            System.out.println(this.getName() + " energy: " + this.eneryLevel);
        }
        else
            super.eatFood(food);
    }
}

