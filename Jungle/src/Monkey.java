
public class Monkey extends Animal{
    
    String sound;
    
    public Monkey(String kind, int eneryLevel) {
        super(kind, eneryLevel);
        this.sound = "Monkeys are screaming";
    }
    
    public void eatFood(String string) {
        this.eneryLevel = eneryLevel + 2;
    }
    
    public void makeSound() {
        if(this.eneryLevel - 4 < 0)
            System.out.println("can not perform action: No enaugh energy...");
        else {
            this.eneryLevel = eneryLevel - 4;
            System.out.println(this.getName() + " is speaking...");
            System.out.println(this.getName() + " energy: " + this.eneryLevel);
        }
    }
    
    public void play() {
        if(this.eneryLevel >= 8) {
            this.eneryLevel = this.eneryLevel - 8;
            System.out.println(this.getName() + " is playing");
            System.out.println("Oooo Oooo Oooo");
            System.out.println(this.getName() + " energy: " + this.eneryLevel);
        }
        else
            System.out.println(this.getName() +  " doesn't have enaugh energy");
    }
    
}

