# Implementation

## Complete Java Program

```java
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal.");
    }
}

class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternExample {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment(5000);

        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment(2500);
    }
}
```

## Output

```text
Paid Rs.5000.0 using Credit Card.
Paid Rs.2500.0 using PayPal.
```

## Result

The Strategy Pattern was successfully implemented. Different payment methods were selected and executed at runtime through the PaymentContext class without changing the client code.
