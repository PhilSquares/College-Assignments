/*
Instructions: 
   Convert Fahrenheit to Celsius
The Fahrenheit temperature scale is named for German physicist Daniel Gabriel Fahrenheit and is used primarily in the United States.
The Celsius temperature scale—originally centigrade and later renamed for Swedish astronomer Anders Celsius—is used almost everywhere else in the world.
Write a method named F2C to convert Fahrenheit to Celsius
Hint: The formula is C = (F-32) * 5 / 9
*/
public class homework6
{
   public static void main(String[] args)
   {
      double temperatureF = 60;
      double temperatureC;
      temperatureC = F2C(60);
      System.out.printf("The temperature for today is %f F and %f C", temperatureF, temperatureC);
   }
   
   public static double F2C(double temperatureF)
   {
   double c = 5.0 / 9.0 * (temperatureF-32);
   return c;
   }
}