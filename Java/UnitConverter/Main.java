package UnitConverter;

public class Main {
    public static void main(String[] args) {
        System.out.format("35 lb -> %.2f kg\n", UnitConverter.toKilograms(35));
        System.out.format("62 kg -> %.2f lb\n", UnitConverter.toPounds(62));
        System.out.format("12.2 in -> %.2f cm\n", UnitConverter.toCentimeters(12.2));
        System.out.format("3.82 cm -> %.2f in\n", UnitConverter.toInches(3.82));
        System.out.format("48 ¡ÆF -> %.2f ¡ÆC\n", UnitConverter.toCelsius(48));
        System.out.format("-9 ¡ÆC -> %.2f ¡ÆF\n", UnitConverter.toFahrenheit(-9));
    }
}