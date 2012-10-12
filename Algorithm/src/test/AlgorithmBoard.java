package test;

import java.util.Scanner;

import org.junit.Test;

public class AlgorithmBoard {
	@Test
	public void paymentUnits(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean chk = true;
		while(chk){			
			System.out.println("-----------------------------");
			System.out.println("Insert total payment");
			System.out.println("-----------------------------");
			int totalAmount = 0;
			int countedAmount = 0;
			int reducedAmount = 0;
			totalAmount = scan.nextInt();
			countedAmount = totalAmount;
			if(totalAmount<=0){
				System.out.println("-----------------------------");
				System.out.println("Not allowed inserting under '0'");
				System.out.println("-----------------------------");
				totalAmount = scan.nextInt();
			}
			int[] unit = {50000,10000,5000,1000,500,100,50,10,5,1};
			int[] unitCount = new int[10];
			for (int i = 0; i < unit.length; i++) {
				if(countedAmount>=0) {
					reducedAmount = countedAmount/unit[i];
					countedAmount = countedAmount - (reducedAmount*unit[i]);
					unitCount[i] = reducedAmount;
				}
			}
			System.out.println("total amout: "+totalAmount);
			for (int i = 0; i < unitCount.length; i++) {
				for (int j = 0; j < (10-((11-i)/2)*2); j++) {
					System.out.print(" ");
				}
				System.out.println(unit[i]+" won            "+unitCount[i]);
			}
			
			System.out.println("-----------------------------");
			System.out.println("make payment again?(y/n)");
			System.out.println("-----------------------------");
			if(scan.next().equalsIgnoreCase("n")) chk = false;
		}
	}
}
