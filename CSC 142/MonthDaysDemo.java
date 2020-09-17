import java.util.Scanner;

public class MonthDaysDemo
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      int inputMonth;
      int inputYear;
      
      System.out.println("Enter a month (1-12): ");
      inputMonth = keyboard.nextInt();
      
      
      System.out.println("Enter a year: ");
      inputYear = keyboard.nextInt();
      
      MonthDays period1 = new MonthDays( inputMonth, inputYear);
      
      System.out.println(period1.getNumberOfDays() + "days" );
      
      
      
      
       
   }
}