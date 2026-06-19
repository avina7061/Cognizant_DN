# Implementation

## Complete Java Program

```java
interface Image {
    void display();
}

class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading " + fileName + " from remote server...");
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

public class ProxyPatternExample {

    public static void main(String[] args) {

        Image image = new ProxyImage("sample.jpg");

        System.out.println("First Display:");
        image.display();

        System.out.println();

        System.out.println("Second Display:");
        image.display();
    }
}
```

## Output

```text
First Display:
Loading sample.jpg from remote server...
Displaying sample.jpg

Second Display:
Displaying sample.jpg
```

## Result

The Proxy Pattern was successfully implemented. The ProxyImage class provided lazy initialization by loading the image only when needed and cached the RealImage object so that subsequent display requests did not reload the image from the remote server.
