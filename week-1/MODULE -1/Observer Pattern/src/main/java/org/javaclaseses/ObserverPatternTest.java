package org.javaclaseses;

public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStockPrice("TCS", 4200.50);

        stockMarket.removeObserver(web);

        stockMarket.setStockPrice("Infosys", 1850.75);
    }
}
