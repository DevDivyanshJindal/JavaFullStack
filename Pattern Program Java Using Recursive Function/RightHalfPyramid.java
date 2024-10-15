public class RightHalfPyramid {

    public static void main(String[] args) {
        int n = 5; 
        printPyramid(n, 1);
    }
    
    public static void printPyramid(int n, int X) {
        if (X > n) {
            return;
        }

        printStars(X);
        System.out.println();
        printPyramid(n, X + 1);
    }

    public static void printStars(int X) {
        if (X <= 0) {
            return;
        }
        System.out.print("* ");
        printStars(X - 1);
    }
}
