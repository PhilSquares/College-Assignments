/* Instructions: 
File head display - Write a program that (1) asks the user for the name of a file. 
The program should display ONLY the FIRST FIVE LINES of the file's contents. If the file
contains FEWER THAN FIVE LINES, it should display the file's ENTIRE CONTENTS. 
*/

import java.util.Scanner; 
import java.io.*;

public class homework5
{
   public static void main(String[] args)throws IOException
   {
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Enter the filename: ");
      String filename = keyboard.nextLine();
      
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
      
      int i = 0; 
      
      while (inputFile.hasNext() && i < 5)
      {
         String friendName = inputFile.nextLine();
      
         System.out.println(friendName);
         
          i++;
      }
      
      inputFile.close();
      
      
   }
}