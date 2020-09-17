import java.util.Scanner; 

public class Packages
{

   public static void main(String[] args)
   {
      String instruction = "Please enter the number of pakcages purchased: "; //Instruct the user.
      System.out.print(instruction);
      
      Scanner sc = new Scanner(System.in);//Create a scanner object so the user can type in a quantity.
      double quantity = sc.nextDouble();//This will stop the program so the user can enter the desired quantity.
      //double "quantity" will now store the number of packages entered.
      
      //Logic:
      double price = 99.0;
      double total = quantity*price;//99$ per package.
      double discount = 0.0; //Default discount, updated based on what user enters.
      
      if(quantity <= 0.0) //Cannot enter 0 or less packages
      {
         System.out.println("Invalid input.");
      }
      else if(quantity >= 1.0 && quantity < 10.0)//Case where no discount is applied.
           {
               System.out.println("Discount: " + discount + "% ");//Print our discount.
               System.out.println("Your total is "+ "$"+ total);//Print out total after applied discount.
           }
           else if(quantity >= 10.0 && quantity < 20.0)//Case where 20% discount is applied.
           {
               discount = 0.2;
               total = (total*discount);//20% discount applied
               System.out.println("\nDiscount: " + discount + "% ");
               System.out.println("Your total is " + "$" + total);
           }
           else if(quantity >= 20.0 && quantity < 50.0)//Case where 30% discount is applied.
           {
               discount = 0.3;
               total = (total*discount);//30% discount applied.
               System.out.println("\nDiscount: "+discount+"$");
               System.out.println("Your total is "+total+"$");
           }
           else if(quantity >= 50.0 && quantity < 100.0)//Case where 40% discount is applied.
           {
               discount = 0.4;
               total = (total*discount);//40% discount applied.
               System.out.println("\nDiscount: "+discount+"$");
               System.out.println("Your total is "+total+"$");
           }
           else if(quantity >= 100.0)//Case where 50% discount is applied.
           {
               discount = 0.5;
               total = (total*discount);//50% discount applied.
               System.out.println("\nDiscount: "+discount+"$");
               System.out.println("Your total is "+total+"$");
           }
           
           //End program.
   }
}