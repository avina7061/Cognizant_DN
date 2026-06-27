

### Logger.java

```java
public class Logger {

    private static Logger instance;

    private Logger() {
        System.out.println("Logger Instance Created");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
```

### TestSingleton.java

```java
public class TestSingleton {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("User Logged In");

        if (logger1 == logger2) {
            System.out.println("Both objects refer to the same Logger instance.");
        } else {
            System.out.println("Different Logger instances created.");
        }
    }
}
```

## Combined Code (Single File)

```java
class Logger {

    private static Logger instance;

    private Logger() {
        System.out.println("Logger Instance Created");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class TestSingleton {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("User Logged In");

        if (logger1 == logger2) {
            System.out.println("Both objects refer to the same Logger instance.");
        } else {
            System.out.println("Different Logger instances created.");
        }
    }
}
```

## Sample Output

```text
Logger Instance Created
LOG: Application Started
LOG: User Logged In
Both objects refer to the same Logger instance.
```

## Result

The Singleton Design Pattern was successfully implemented. Only one instance of the Logger class was created and shared throughout the application.
