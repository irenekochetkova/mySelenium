package pages;

public class Cat extends Animal{
   public Cat(String name) {
       setName(name);
   }

   public void speak() {
       System.out.println(getName() + " is meowing");
   }
}
