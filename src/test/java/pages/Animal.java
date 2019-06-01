package pages;

public class Animal {
    private String name;

    public Animal() {
        name = "nameless one";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println(getClass() + " is walking");
    }

    public void sleep() {
        System.out.println(getClass() + " is sleeping");
    }

    public void eat(String what) {
        System.out.println(getClass() + " is eating " + what);
    }

    public void speak() {
        System.out.println(getClass() + " is making noise!");
    }


}
