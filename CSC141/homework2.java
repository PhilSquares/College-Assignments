/*Instructions: 
Restaurant Bill
Write a program that computes the tax and tip on a restaurant bill. The program should ask the user to enter the charge for the meal. The tax should be 6% of 
the meal charge. The tip should be 20% of the total after adding the tax.

The following need to be displayed on the screen: 
   Meal charge
   Tax amount
   Tip amount­­­­­
   Total bill

Bonus (1 point): Find a way to take the input and display the answer in a dialog window? 
*/

import javax.swing.JOptionPane;

public class homework2
{
   public static void main(String[] args)
   {
      final double tax_tip = 0.26; //.06+.20=.26
      double r, total; 

      //The parseDouble() method in Java Double class is a built in method in Java that returns a new double initialized to the value represented by the specified String.
      r = Double.parseDouble(JOptionPane.showInputDialog("The price of the meal was?"));
      total = r * tax_tip + r;
      
      JOptionPane.showMessageDialog(null,"The total amount is: " + total);
      
   }
}



     