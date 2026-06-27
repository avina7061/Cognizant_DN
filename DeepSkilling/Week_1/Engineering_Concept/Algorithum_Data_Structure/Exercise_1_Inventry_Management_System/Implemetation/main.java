public class Main {
    public static void main(String[] args) {
        InventoryManager im = new InventoryManager();

        Product p1 = new Product("P001", "Laptop", 10, 899.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);

        im.addProduct(p1);
        im.addProduct(p2);

        System.out.println("\n--- Current Inventory ---");
        im.displayInventory();

        System.out.println("\n--- Updating Laptop ---");
        im.updateProduct("P001", 8, 849.99);

        System.out.println("\n--- Deleting Smartphone ---");
        im.deleteProduct("P002");

        System.out.println("\n--- Final Inventory ---");
        im.displayInventory();
    }
}