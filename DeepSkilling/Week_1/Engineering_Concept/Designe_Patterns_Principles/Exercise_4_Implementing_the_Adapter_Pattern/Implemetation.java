# Implementation

## Complete Java Program

```java
interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed through PayPal.");
    }
}

class StripeGateway {
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " processed through Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

public class AdapterPatternExample {

    public static void main(String[] args) {

        PaymentProcessor paypalProcessor =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripeProcessor =
                new StripeAdapter(new StripeGateway());

        paypalProcessor.processPayment(1000);
        stripeProcessor.processPayment(2500);
    }
}
```

## Output

```text
Payment of Rs.1000.0 processed through PayPal.
Payment of Rs.2500.0 processed through Stripe.
```

## Result

The Adapter Pattern was successfully implemented. Different payment gateways with incompatible interfaces were integrated through adapter classes, allowing them to be used uniformly via the PaymentProcessor interface.
