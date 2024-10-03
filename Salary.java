import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
          System.out.println("Enter your NAME:");
          String name = sc.nextLine();
          
          System.out.println("Enter your EMPID:");
          int id = sc.nextInt();
          
          sc.nextLine();

          System.out.println("Enter your DEPT:");
          String dept = sc.nextLine();
          
          System.out.println("Enter your Salary (Basic Pay):");
          float basicSalary = sc.nextFloat();
          
          double HRA = basicSalary * 0.25;
          double DA = basicSalary * 0.30;
          double TA = basicSalary * 0.20;
          double PF = basicSalary * 0.12;
          
          double grossPay = basicSalary + HRA + DA + TA;
          
          double tax = 0;
          if (basicSalary > 700000) {
              tax = basicSalary * 0.20;
          } else if (basicSalary > 450000) {
              tax = basicSalary * 0.15;
          } else if (basicSalary > 320000) {
              tax = basicSalary * 0.12;
          }
          
          double netPay = grossPay - PF - tax;
          
          System.out.println("\n--- Salary Slip ---");
          System.out.println("ABC Co.");
          System.out.println("NAME: " + name);
          System.out.println("EMPID: " + id);
          System.out.println("DEPT: " + dept);
          System.out.println("Basic Pay (BP): " + basicSalary);
          System.out.println("HRA: " + HRA);
          System.out.println("DA: " + DA);
          System.out.println("TA: " + TA);
          System.out.println("PF: " + PF);
          System.out.println("Gross Pay: " + grossPay);
          System.out.println("Tax: " + tax);
          System.out.println("Net Pay: " + netPay);
        }
    }
}
