import java.util.Scanner;

public class FibonacciRecursion {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
          System.out.print("Enter the number of terms: ");
          int n = sc.nextInt();

          System.out.println("Fibonacci series up to " + n + " terms:");
          for (int i = 0; i < n; i++) {
              System.out.println(fibonacci(i) + " ");
          }
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
