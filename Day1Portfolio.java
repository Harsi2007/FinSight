import java.util.*;
public class Day1Portfolio{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Stock Name: ");
	    String StockName = sc.nextLine();
	    System.out.println("Enter the quantity: ");
	    int quantity = sc.nextInt();	    
	    System.out.println("Enter the cost price: ");
	    double broughtPrice = sc.nextDouble();
	    System.out.println("Enter the current price: ");
	    double currentPrice = sc.nextDouble();
	    double Investment = quantity*broughtPrice;
	    double currentValue = quantity*currentPrice;
	    System.out.println(" ======================= ");
	    System.out.println("     STOCK PORTFOLIO     ");
	    System.out.println(" ======================= ");
	    System.out.println("Stock: "+StockName+"\nQuantity: "+quantity+"\n\nBrought Price: "+broughtPrice+
	    "\nCurrent Price: " + currentPrice+"\n");
	    System.out.println("Investment: "+Investment);
	    System.out.println("Current value: "+currentValue);
	    if(currentValue>Investment){
	        System.out.println("\nStatus: PROFIT");
	        System.out.println("Profit: "+(currentValue-Investment));
	    }
	    else if(currentValue==Investment){
	        System.out.println("Neither Profit or loss");
	    }
	    else{
	        System.out.println("\nStatus: LOSS");
	        System.out.println("Loss: "+(Investment - currentValue));
	    }
	    System.out.println(" ======================= ");
	}
}