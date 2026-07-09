class Animal {

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    void makeSound() {
        System.out.println("Dog Bark");
    }
}

public class ImplementInheritance {
    public static void main(String[] args) {

        Animal animal = new Animal();
        Dog d = new Dog();

        animal.makeSound();
        d.makeSound();
    }
}