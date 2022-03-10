package homework0308;

public class CarVO {
	private String country, maker,model, carOption;
	private int carYear,price;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCarOption() {
		return carOption;
	}
	public void setCarOption(String carOption) {
		this.carOption = carOption;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CarVO [country=" + country + ", maker=" + maker + ", model=" + model + ", carOption=" + carOption
				+ ", carYear=" + carYear + ", price=" + price + "]";
	}
	
	
}
