import java.util.*;
public class PortfolioManager {
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
			double investment = quantity*boughtPrice;
			totalInvestment += investment;
			double currentValue = quantity*currentPrice;
			totalCurrentValue += currentValue;
			System.out.println(" ======================= ");
			System.out.println("     STOCK PORTFOLIO     ");
			System.out.println(" ======================= ");
			System.out.println("Stock: "+stockName+"\nQuantity: "+quantity+"\n\nBought Price: "+boughtPrice+
			                   "\nCurrent Price: " + currentPrice+"\n");
			System.out.println("Investment: "+investment);
			System.out.println("Current value: "+currentValue);
			if(currentValue>investment) {
				System.out.println("\nStatus: PROFIT");
				System.out.println("Profit: "+(currentValue-investment));
				total += currentValue-investment;
			}
			else if(currentValue==investment) {
				System.out.println("Neither Profit or Loss");
			}
			else {
				System.out.println("\nStatus: LOSS");
				System.out.println("Loss: "+(investment - currentValue));
				total -= investment - currentValue;
			}
			double returnPercent = ((currentValue-investment)/investment)*100;
			System.out.println("Return: "+returnPercent);
			if(currentPrice>boughtPrice) System.out.println("Bullish");
			else if(currentPrice<boughtPrice) System.out.println("Bearish");
			System.out.println(" ======================= ");
		}
		System.out.println("\n ======================= ");
		System.out.println("      STOCK SUMMARY      ");
		System.out.println(" ======================= ");
		System.out.println("Total Investment: "+totalInvestment);
		System.out.println("Total Value: "+totalCurrentValue);
		if(total>0){
		    System.out.println("Overall Profit: "+total);
		}
		else if(total<0){
		    System.out.println("Overall Loss: "+Math.abs(total));
		}
		else System.out.println("Overall Neither Profit or Loss");
		double totalReturnPercent = ((totalCurrentValue - totalInvestment)/totalInvestment)*100;
		System.out.println("Overall Return: "+totalReturnPercent);
		System.out.println(" ======================= ");
	}
}