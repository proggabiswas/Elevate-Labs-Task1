package TASK1;
import java.util.Scanner;

class operations{
    public double add(double num1, double num2){

        return num1+num2;
    }

    public double sub(double num1,double num2){
        
        return num1-num2;
    }

    public double mul(double num1,double num2){

        return num1*num2;
    }
    
    public double div(double num1,double num2){
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return Double.NaN;
        }
        return num1/num2;
    }

}

public class JavaConsoleCalc {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
        System.out.println("FIRST NUMBER:");
        double num1 = sc.nextDouble();

        System.out.println("Second NUMBER:");
        double num2 = sc.nextDouble();

        System.out.println("1.Addition \t2.Subtraction \n3.Multiplication \t4.Division");
        System.out.println("Enter your Choice: ");
        int choice = sc.nextInt();

        operations ope= new operations();

        double result = switch (choice) {
            case 1 -> ope.add(num1,num2);
            case 2 -> ope.sub(num1,num2);
            case 3 -> ope.mul(num1,num2);
            case 4 -> ope.div(num1,num2);
            default -> 0;
        };
        System.out.println("The result is: "+ result);

        System.out.print("Do you want to perform another calculation? (yes/no): ");
            String option = sc.next();

            if (!option.equalsIgnoreCase("yes")) {
                keepRunning = false;
                System.out.println("Calculator closed.");
            }
    }
        sc.close();

    }
}

