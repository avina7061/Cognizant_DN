

public class BookService {

    public void addBook() {

        System.out.println("Book added successfully.");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}