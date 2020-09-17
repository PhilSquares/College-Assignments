import java.util.Scanner;

public class homework3
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner (System.in);

    double seconds; // The number of seconds
    boolean output = false;

    // Prompt the user to enter a number of seconds.
    System.out.println("Enter the number of seconds");
    seconds = sc.nextDouble();

    System.out.println("That equals:");

    // Display the number of days given the user input. 
    if (seconds >= 86400)
    {
      // cast seconds to an int so we get integer division: whole number of days
      System.out.print(((int)seconds / 86400) + " days ");
      seconds %= 86400;
      output = true;
    }

    // Display the number of hours given user input. 
    if (seconds >= 3600)
    {
      int numHours = (int)seconds / 3600;
      System.out.print(numHours + " hours ");
      seconds = seconds - (3600 * numHours);  // seconds %= 3600;
      output = true;
    }

    // Display the number of minutes given user input. 
    if (seconds >= 60)
    {
      System.out.print(((int)seconds / 60) + " minutes ");
      seconds %= 60; 
      output = true;
    }

    if (seconds > 0 || !output)
    {
      System.out.printf("", seconds);
      output = true;
    }
          
    System.out.println();
  }
}