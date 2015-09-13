package bean;

public class City {
	private String cityName;
	private String cityValue;
	public City() {
		super();
	}
	public City(String cityName, String cityValue) {
		super();
		this.cityName = cityName;
		this.cityValue = cityValue;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityValue() {
		return cityValue;
	}
	public void setCityValue(String cityValue) {
		this.cityValue = cityValue;
	}
	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", cityValue=" + cityValue + "]";
	}
	
}
