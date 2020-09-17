public class Zombie
{
   private double HP;
   private double speed;
   
   public Zombie(String t);
   {
   if(t.equals("Regular"))
   {
      type = 0;
      HP = 300;
      speed = 2;
   }
   
   
   public double getHP();
   {
      return HP;
   }
   
   public void setHP(double h)
   {
      HP = h;
   }
   
   public double getSpeed();
   {
      return speed;
   }
   
   public String attack(int type);
   {
   String attack = "";
   switch(type)
   case "Bite":
   System.out.println("Bite");
   break;
   
   case "Scratch"
   System.out.println("Scratch");
   
   //Ran out of time...
   
    
    
   }