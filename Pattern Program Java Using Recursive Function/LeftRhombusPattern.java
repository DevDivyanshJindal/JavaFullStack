public class LeftRhombusPattern {

    public static void printPattern(int n, int currentRow) {
        if (currentRow > n) {
            return;
        }

        for (int j = 1; j <= n - currentRow; j++) {
            System.out.print(" ");
        }

        for (int j = 1; j <= n; j++) {
            System.out.print("*");
        }

        System.out.println();
        printPattern(n, currentRow + 1);
    }

    public static void main(String args[]) {
        int n = 8;
        printPattern(n, 1);
    }
}
