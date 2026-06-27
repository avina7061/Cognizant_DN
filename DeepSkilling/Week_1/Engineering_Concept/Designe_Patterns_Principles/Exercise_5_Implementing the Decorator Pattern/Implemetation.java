# Implementation

## Complete Java Program

```java
interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {

    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {

    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("SMS Notification: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Slack Notification: " + message);
    }
}

public class DecoratorPatternExample {

    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Your order has been shipped.");
    }
}
```

## Output

```text
Email Notification: Your order has been shipped.
SMS Notification: Your order has been shipped.
Slack Notification: Your order has been shipped.
```

## Result

The Decorator Pattern was successfully implemented. Additional notification channels such as SMS and Slack were added dynamically to the Email notifier without modifying the original EmailNotifier class.
