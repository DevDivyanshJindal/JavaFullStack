import java.util.Scanner;

public class Palindrome {
    public static void main(String args[]) {  
        int r, sum = 0, temp;    
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = scanner.nextInt();
            
            temp = n;
            while (n > 0) {
                r = n % 10;
                sum = (sum * 10) + r;
                n = n / 10;
            }
            
            if (temp == sum)
                System.out.println("Palindrome number");
            else
                System.out.println("Not palindrome");
        }  
    }  
}
