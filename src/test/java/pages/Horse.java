package pages;

public class Horse extends Animal{
    public Horse(String name) {
        setName(name);
    }

    public void speak() {
        System.out.println(getName() + " is clopping!");
    }
}
