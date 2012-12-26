package refactoring.videoRental;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;

	
	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}
	
	public int getPriceCode() {
		return _price.getPriceCode();
	}
	
	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDREN:
			_price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("가격코드가 잘못됐습니다");
		}
		
		
	}
	private Price _price;
	
	public String getTitle() {
		return _title;
	}
	
	double getCharge(int daysRented) {
		double result = 0;
		//count rental fee by video type
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2)
				result += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDREN:
			result += 1.5;
			if (daysRented > 3)
				result += (daysRented -3) * 1.5;
			break;
		}
		return result;
	}
	
	int getFrequentRentalPoints(int _daysRented) {
		if((getPriceCode() == Movie.NEW_RELEASE) && _daysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}
