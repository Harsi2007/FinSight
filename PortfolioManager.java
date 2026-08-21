import java.util.Scanner;
class Stock {
    private String stockName;
    private int quantity;
    private double boughtPrice;
    private double currentPrice;
    public Stock(String stockName, int quantity, double boughtPrice, double currentPrice) {
        this.stockName = stockName;
        this.quantity = quantity;
        this.boughtPrice = boughtPrice;
        this.currentPrice = currentPrice;
    }

    public String getStockName() {
        return stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getBoughtPrice() {
        return boughtPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getInvestment() {
        return quantity * boughtPrice;
    }

    public double getCurrentValue() {
        return quantity * currentPrice;
    }

    public double getReturnPercentage() {
        if (getInvestment() == 0) return 0.0;
        return ((getCurrentValue() - getInvestment()) / getInvestment()) * 100;
    }

    public void printProfitOrLoss() {
        double currentValue = getCurrentValue();
        double investment = getInvestment();
        if (currentValue > investment) {
            System.out.println("Profit        : " + (currentValue - investment));
        } else if (currentValue == investment) {
            System.out.println("Neither Profit nor Loss");
        } else {
            System.out.println("Loss          : " + (investment - currentValue));
        }
    }

    public void growth() {
        if (currentPrice > boughtPrice) {
            System.out.println("Bullish       : " + (currentPrice - boughtPrice));
        } else if (currentPrice == boughtPrice) {
            System.out.println("No Growth");
        } else {
            System.out.println("Bearish       : " + (boughtPrice - currentPrice));
        }
    }
}

public class PortfolioManager {
    public static void printOverallProfitOrLoss(double total) {
        if (total > 0) {
            System.out.println("Overall Profit   : " + total);
        } else if (total == 0) {
            System.out.println("Overall Neither Profit nor Loss");
        } else {
            System.out.println("Overall Loss     : " + Math.abs(total));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Stocks:");
        int n = sc.nextInt();
        sc.nextLine();

        double totalProfitLoss = 0;
        double totalInvestment = 0;
        double totalCurrentValue = 0;

        Stock stocks[] = new Stock[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Stock Name: ");
            String stockName = sc.nextLine();

            System.out.println("Enter the quantity: ");
            int quantity = sc.nextInt();

            System.out.println("Enter the cost price: ");
            double boughtPrice = sc.nextDouble();

            System.out.println("Enter the current price: ");
            double currentPrice = sc.nextDouble();
            sc.nextLine();

            Stock stock = new Stock(stockName, quantity, boughtPrice, currentPrice);
            stocks[i] = stock;

            double investment = stock.getInvestment();
            double currentValue = stock.getCurrentValue();

            totalInvestment += investment;
            totalCurrentValue += currentValue;
            totalProfitLoss += (currentValue - investment);

            System.out.println(" ======================= ");
            System.out.println("     STOCK PORTFOLIO     ");
            System.out.println(" ======================= ");
            System.out.println("Stock         : " + stock.getStockName() + "\nQuantity      : " + stock.getQuantity() +
                               "\nBought Price  : " + stock.getBoughtPrice() +
                               "\nCurrent Price : " + stock.getCurrentPrice());
            System.out.println("Investment    : " + investment);
            System.out.println("Current value : " + currentValue);
            stock.printProfitOrLoss();
            System.out.println("Return        : " + stock.getReturnPercentage() + "%");
            stock.growth();
            System.out.println(" ======================= ");
        }

        System.out.println("\n ======================= ");
        System.out.println("      STOCK SUMMARY      ");
        System.out.println(" ======================= ");
        System.out.println("Total Investment : " + totalInvestment);
        System.out.println("Total Value      : " + totalCurrentValue);
        
        printOverallProfitOrLoss(totalProfitLoss);

        double totalReturnPercent = 0.0;
        if (totalInvestment > 0) {
            totalReturnPercent = ((totalCurrentValue - totalInvestment) / totalInvestment) * 100;
        }
        System.out.println("Overall Return   : " + totalReturnPercent + "%");
        System.out.println(" ======================= ");
        System.out.println("     PORTFOLIO STOCKS    ");
        for(int i=0;i<n;i++){
            System.out.println(stocks[i].getStockName());
        }
        sc.close();
    }
}