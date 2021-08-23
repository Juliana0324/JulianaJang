package Market;

public class MarketGood {
	String name;
	int retailPrice;
	int discountRate;
	
	
	public MarketGood(String name, int retailPrice, int discountRate) {
		this.name = name;
		this.retailPrice = retailPrice;
		
		if(discountRate<0 || discountRate>100) {
			this.discountRate = 0;
		}else {
			this.discountRate = discountRate;
		}
	}
	
	public MarketGood(String name, int retailPrice) {
		this.name = name;
		this.retailPrice = retailPrice;
		discountRate = 0;
	}
	
	public String getName() {
		return name;
	}

	public int getRetailPrice() {
		return retailPrice;
	}
	
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public int getDiscountedPrice() {
		int dp = retailPrice * (100-discountRate)/100;
		
		return dp;
	}
	
	
	
}
