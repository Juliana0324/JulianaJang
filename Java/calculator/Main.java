package calculator;

public class Main {
	public static void main(String[] args) {
        AverageFinder finder = new AverageFinder();

        // �׽�Ʈ 1
        int[] testArray1 = {3, 7, 3};
        System.out.println(String.format("%.7f", finder.computeAverage(testArray1)));
        // �׽�Ʈ 2
        int[] testArray2 = {1, 3, 4, 7};
        System.out.println(finder.computeAverage(testArray2));

        // �׽�Ʈ 3
        int[] testArray3 = {4};
        System.out.println(finder.computeAverage(testArray3));

        // �׽�Ʈ 4
        int[] testArray4 = {1, 2, 3, 4, 5};
        System.out.println(finder.computeAverage(testArray4));
 	}

}
