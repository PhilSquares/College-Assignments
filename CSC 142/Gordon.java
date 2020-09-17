/* 
********************************************
   
   *Gordon Ramsay* shouts. He shouts and swears. There may be something wrong with him.
   
   Please define and complete a method -- convertToGordon, 
   this method should accept one String type argument 
   and should return back a String value when finish. 
   
   The convertToGordon method is designed based on the following rules:

   Rules:
   
   * Obviously the words **should be all Caps**;
   * The sentence should end with **'!!!!'**
   
   Example:
   
   ```java
       Input: 
                       How are u
       Output: 
                       HOW ARE U!!!
   ```

********************************************
*/
import java.util.Scanner;

public class Gordon
{
   public static void main(String[] args)
   {
      // Please DO NOT add or change any code inside main method
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Say something: "); 
      // Take user input
      String sentence = keyboard.nextLine();
      
      // Calling convertToGordon method 
      String gordonShout = convertToGordon(sentence);
      
      // Output the result
      System.out.println(gordonShout);
   }
   
   // Please define and complete the **convertToGordon** Method 
   public static String convertToGordon(String sentence) // focus on return type being STRING for test(Understand the header)
   {
      sentence = sentence.toUpperCase() + "!!!";
      return sentence;
   }

   
   
}