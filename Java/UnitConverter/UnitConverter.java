package UnitConverter;

public class UnitConverter {
    // �ʿ��� ��� ����
    private static final double POUNDTOKG= 0.45359237;
    private static final double KGTOPOUND = 2.204623;
    private static final double INCHESTOCM = 2.54;
    private static final double CMTOINCH = 0.393701;
    private static double fahrenheit= 0.0;
    private static double celsius = 0;
   
   
    public static double toPounds(double kilograms) {
        // �޼ҵ� ���θ� ä���ּ���
        double pounds = kilograms*KGTOPOUND;
        return pounds;
    }
    public static double toKilograms(double pounds) {
        // �޼ҵ� ���θ� ä���ּ���
        double kilograms = pounds*POUNDTOKG;
        return kilograms;
    }
    public static double toCentimeters(double inches) {
        // �޼ҵ� ���θ� ä���ּ���
        double centimeters = inches*INCHESTOCM;
        return centimeters;
    }
    public static double toInches(double centimeters) {
        // �޼ҵ� ���θ� ä���ּ���
        double inches = centimeters*CMTOINCH;
        return inches;
    }

    public static double toFahrenheit(int celsius) {
        // �޼ҵ� ���θ� ä���ּ���
        double fahrenheit = celsius*1.8+32;
        return fahrenheit;
    }
    public static double toCelsius(double fahrenheit) {
        double celsius = (fahrenheit-32)/1.8;
    	return celsius;
    }
    
    
}