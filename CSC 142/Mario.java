/*

In a Super Mario game, the Health is usually measured in hit points or health points, shortened to HP. 

The figure inside PDF file (Please check the PDF file for more details) shows a special level. 

In this level, Mario needs to get to the green pipe. As you can see, the path is separated into multiple grids.  

Here are the game rules:


   Assume Mario can only move rightward one grid each round. 

   If the grid contains a heart, then Mario's HP value will increase by 1 when he moves to that grid. 

   If a ``Goomba (chestnut)" is inside the grid, then Mario's HP value will decrease by 1 when he reaches to that grid. 

   If the grid contains a ``Multi-Moon" sign, then Mario's HP value will be doubled. 



Please create a Java program, asks the user input the initial HP value (int type) of Mario.

Your program should output the total life of Mario when he reaches to the green pipe. 

*/


import java.util.Scanner;
public class Mario
{
   public static void main(String[] args)
   {  
      Scanner keyboard = new Scanner(System.in);
           
      int HP = 7;
      int finalHP;
      //How to take user input
       System.out.println("Please input the initial HP for Mario: ");
       HP = keyboard.nextInt();

      //calculate final HP
      finalHP = (HP + 1 + 1 - 1)*2 + 1;
      //output the result
      System.out.println("Mario's HP is: " + HP);
      
      

   }
}