package UnitConverter;

public class UnitConverter {
    // 필요한 상수 정의
    private static final double POUNDTOKG= 0.45359237;
    private static final double KGTOPOUND = 2.204623;
    private static final double INCHESTOCM = 2.54;
    private static final double CMTOINCH = 0.393701;
    private static double fahrenheit= 0.0;
    private static double celsius = 0;
   
   
    public static double toPounds(double kilograms) {
        // 메소드 내부를 채워주세요
        double pounds = kilograms*KGTOPOUND;
        return pounds;
    }
    public static double toKilograms(double pounds) {
        // 메소드 내부를 채워주세요
        double kilograms = pounds*POUNDTOKG;
        return kilograms;
    }
    public static double toCentimeters(double inches) {
        // 메소드 내부를 채워주세요
        double centimeters = inches*INCHESTOCM;
        return centimeters;
    }
    public static double toInches(double centimeters) {
        // 메소드 내부를 채워주세요
        double inches = centimeters*CMTOINCH;
        return inches;
    }

    public static double toFahrenheit(int celsius) {
        // 메소드 내부를 채워주세요
        double fahrenheit = celsius*1.8+32;
        return fahrenheit;
    }
    public static double toCelsius(double fahrenheit) {
        double celsius = (fahrenheit-32)/1.8;
    	return celsius;
    }
    
    
}