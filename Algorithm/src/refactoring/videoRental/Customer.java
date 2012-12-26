package refactoring.videoRental;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	
	public Customer(String name) {
		_name = name;
	}
	
	public void addRental (Rental arg) {
		_rentals.addElement(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = getName() + "Your rental history \n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();	
			// a point increasing
			frequentRenterPoints += each.getFrequentRentalPoints();					
			//print rental video info  and fee in this time
			result += "\t" + each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
		}
		
		//add footer raw
		result += "accumulated rental fee: "+String.valueOf(getTotalCharge()) + "\n";
		result += "accumulated point: "+String.valueOf(getTotalFrequentRenterPoints());
		return result;
	}
	
	private double getTotalCharge() {
		double result = 0;
		Enumeration retals = _rentals.elements(); 
		while (retals.hasMoreElements()) {
			Rental each = (Rental) retals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRentalPoints();
		}
		return result;
	}
	
	public String htmlStatment() {
		Enumeration rentals = _rentals.elements();
		String result = "<H1><EM>" + getName() + "'s retal history</EM></H1><P>\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//print every rental video detail and fee
			result += each.getMovie().getTitle()+ ": " 
					+ String.valueOf(each.getCharge())+ "<BR>\n";
		}
		//add footer
		result += "<P>Accumulated rental fee: <EM>" + String.valueOf(getTotalCharge()) + "</EM></P>\n";
		result += "Accumulated point: <EM>" 
				+ String.valueOf(getTotalFrequentRenterPoints()) + "</EM><P>";
		return result;
	}
}
