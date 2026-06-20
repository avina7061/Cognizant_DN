public class TypeCastingExample {
    public static void main(String[] args) {

        double price = 99.99;
        int intPrice = (int) price;

        int age = 21;
        double doubleAge = age;

        System.out.println("Original double value: " + price);
        System.out.println("After casting to int: " + intPrice);

        System.out.println();

        System.out.println("Original int value: " + age);
        System.out.println("After casting to double: " + doubleAge);
    }
}