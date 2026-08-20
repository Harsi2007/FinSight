import java.util.*;
public class PortfolioManager {
	public static double invest(int quantity, double boughtPrice) {
		return quantity*boughtPrice;
	}
	public static double cvalue(int quantity, double currentPrice) {
		return quantity*currentPrice;
	}
	public static double returnPercentage(double Value, double investment) {
		return ((Value-investment)/investment)*100;
	}
	public static void profitOrLoss(double investment, double currentValue, double total) {
		if(currentValue>investment) {
			System.out.println("Profit: "+(currentValue-investment));
			total += (currentValue-investment);
		}
		else if(currentValue==investment) {
			System.out.println("Neither Profit or Loss");
		}
		else {
			System.out.println("Loss: "+(investment - currentValue));
			total -= (investment - currentValue);
		}
	}
	public static void OverallProfitOrLoss(double total) {
		if(total>0) {
			System.out.println("Overall Profit: "+total);
		}
		else if(total==0) {
			System.out.println("Overall Neither Profit or Loss");
		}
		else {
			System.out.println("Overall Loss: "+Math.abs(total));
		}
	}
	public static void Growth(double boughtPrice, double currentPrice) {
		if(currentPrice>boughtPrice) {
			System.out.println("Bullish: "+(currentPrice-boughtPrice));
		}
		else if(currentPrice==boughtPrice) {
			System.out.println("No Growth");
		}
		else {
			System.out.println("Bearish: "+(boughtPrice-currentPrice));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Stocks");
		int n = sc.nextInt();
		sc.nextLine();
		double total = 0;
		double totalInvestment =0;
		double totalCurrentValue =0;
		for(int i=0; i<n; i++) {
			System.out.println("Enter the Stock Name: ");
			String stockName = sc.nextLine();
			System.out.println("Enter the quantity: ");
			int quantity = sc.nextInt();
			System.out.println("Enter the cost price: ");
			double boughtPrice = sc.nextDouble();
			System.out.println("Enter the current price: ");
			double currentPrice = sc.nextDouble();
			sc.nextLine();
			double investment = invest(quantity,boughtPrice);
			totalInvestment += investment;
			double currentValue = cvalue(quantity,currentPrice);
			totalCurrentValue += currentValue;
			System.out.println(" ======================= ");
			System.out.println("     STOCK PORTFOLIO     ");
			System.out.println(" ======================= ");
			System.out.println("Stock: "+stockName+"\nQuantity: "+quantity+"\n\nBought Price: "+boughtPrice+
			                   "\nCurrent Price: " + currentPrice+"\n");
			System.out.println("Investment: "+investment);
			System.out.println("Current value: "+currentValue);
			profitOrLoss(investment,currentValue,total);
			double returnPercent = returnPercentage(currentValue,investment);
			System.out.println("Return: "+returnPercent);
			Growth(boughtPrice,currentPrice);
			System.out.println(" ======================= ");
		}
		System.out.println("\n ======================= ");
		System.out.println("      STOCK SUMMARY      ");
		System.out.println(" ======================= ");
		System.out.println("Total Investment: "+totalInvestment);
		System.out.println("Total Value: "+totalCurrentValue);
		OverallProfitOrLoss(total);
		double totalReturnPercent = returnPercentage(totalCurrentValue, totalInvestment);
		System.out.println("Overall Return: "+totalReturnPercent);
		System.out.println(" ======================= ");
	}
}