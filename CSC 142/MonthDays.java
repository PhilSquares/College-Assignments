
public class MonthDays 
{
   private int month;
   private int year;

   public int getNumberOfDays()
   {
      int numberOfDays = 0;
      switch( month )
      {
      //Jan
         case 1: 
            numberOfDays = 31;
            break;
      //Feb
         case 2:
            if( year % 100 == 0 ){
               if(year % 400 == 0){
                  numberOfDays = 29;
            
            }
         }
         else if(year % 4 == 0){
            numberOfDays = 29;
         }
         else{
            numberOfDays = 28;
         }
             break;
      //March
         case 3: 
            numberOfDays = 31;
            break;
      //April
         case 4: 
            numberOfDays = 30;
            break;
      //May
         case 5: 
            numberOfDays = 30;
            break;
      //June
         case 6: 
            numberOfDays = 31;
            break;
      //July
         case 7: 
            numberOfDays = 31;
            break;
      //August
         case 8: 
            numberOfDays = 31;
            break;
      //Sept
         case 9: 
            numberOfDays = 30;
            break;
      //Oct
         case 10: 
            numberOfDays = 31;
            break;
      //Nov
         case 11: 
            numberOfDays = 30;
            break;
      //Dec
         case 12: 
            numberOfDays = 31;
            break;
    }
      return numberOfDays;
 } 
   
   
   public MonthDays(int m, int y)// Constructor 
   {
      month = m;
      year = y;
   }
   
    
  
         
   }  
