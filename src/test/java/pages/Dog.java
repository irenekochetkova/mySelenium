package pages;

public class Dog extends Animal {
    public Dog(String name) {
        setName(name);
    }

    public void speak() {
        System.out.println(getName() + " is barking!");
    }
}
