# Implementation

## Complete Java Program

```java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockName, double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName) {
        this.stockName = stockName;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

class MobileApp implements Observer {

    public void update(String stockName, double price) {
        System.out.println("Mobile App: " + stockName + " price updated to " + price);
    }
}

class WebApp implements Observer {

    public void update(String stockName, double price) {
        System.out.println("Web App: " + stockName + " price updated to " + price);
    }
}

public class ObserverPatternExample {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket("TCS");

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice(3500.50);
        stockMarket.setPrice(3650.75);
    }
}
```

## Output

```text
Mobile App: TCS price updated to 3500.5
Web App: TCS price updated to 3500.5
Mobile App: TCS price updated to 3650.75
Web App: TCS price updated to 3650.75
```

## Result

The Observer Pattern was successfully implemented. The MobileApp and WebApp observers were registered with the StockMarket and received notifications whenever the stock price changed.
