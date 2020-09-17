/*
The Internet can be a confusing place, 
even for someone who is using it every day. Because Internet language evolves every day. 
In fact, Internet slang words can transform language itself, so you need to know them to get by in real life.

Write a program to help the user look up words in online slang dictionaries. Using *switch* statement.

The dictionary should support the following words:

AMA: Ask Me Anything
IMO: In My Opinion
NSFW: Not Safe For Work
TL;DR: Too Long; Didn’t Read
YMMV: Your Mileage May Vary
LOL: laugh out loud

E.g.

Input: LOL
Output: laugh out loud

*/


import java.util.Scanner;
public class InternetSlang
{
   public static void main(String[] args)
   {  
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter abbreviated slang:");
      // store user input into variable
      String input = keyboard.nextLine();
      // Use switch statement Chapter 3
      switch(input)
      {
         case "LOL":
            System.out.println("laugh out loud");
            break;
            
         case "AMA":
            System.out.println("Ask Me Anything");
            break;
            
         case "IMO":
            System.out.println("In My Opinion");
            break;
            
         case "NSFW":
         System.out.println("Not Safe For Work");
            break;
            
         case "TL;DR":
         System.out.println("Too Long; Didn't Read");
         break;
         
         case "YMMV":
         System.out.println("Your Mileage May Vary");
         break;
         
      

      }
   }
}