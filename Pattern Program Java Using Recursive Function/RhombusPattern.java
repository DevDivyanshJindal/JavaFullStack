public class RhombusPattern {

    public static void main(String[] args) {
        int n = 5; 
        printRhombus(n, 1);
    }
    
    public static void printRhombus(int n, int X) {
        if (X > n) {
            return;
        }

        printSpaces(n, X);
        printStars(n);
        System.out.println();
        printRhombus(n, X + 1);
    }

    public static void printSpaces(int n, int X) {
        if (X <= 1) {
            return;
        }
        System.out.print(" ");
        printSpaces(n, X - 1);
    }

    public static void printStars(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
    }
}
