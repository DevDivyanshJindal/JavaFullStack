public class HollowSquarePattern {

    public static void main(String[] args) {
        int n = 5; 
        printPattern(n, 1, 1);
    }
    
    public static void printPattern(int n, int X, int Y) {
        if (X > n) {
            return;
        }
        
        if (Y > n) {
            System.out.println();
            printPattern(n, X + 1, 1);
        } else {
            if (X == 1 || X == n || Y == 1 || Y == n) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
            printPattern(n, X, Y + 1);
        }
    }
}
