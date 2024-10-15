public class SquarePattern {

  public static void main(String[] args) {
      int n = 4;
      printPattern(n, 1, n);
  }
  
  public static void printPattern(int n, int X, int Y) {
      if (X > n) {
          return;
      }
      
      if (Y > 0) {
          System.out.print("* ");
          printPattern(n, X, Y - 1);
      } else {
          System.out.println();
          printPattern(n, X + 1, n);
      }
  }
}
