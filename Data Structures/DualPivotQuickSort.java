import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DualPivotQuickSort{
  public static void main(String[] args){
    File file = new File(args[0]); //args 1 is the contents of the file.
    int nums = 0;
     try{
       Scanner X = new Scanner(file);
       while(X.hasNextInt())
       {
         X.nextInt();
         nums++;
       }
     }
     catch (FileNotFoundException a)
     {
        a.printStackTrace();
     }

     int[] array = new int[nums];
      try{
        Scanner input = new Scanner(file);
        while(input.hasNextInt())
        {
          for(int i = 0; i < array.length; i++)
          {
            array[i] = input.nextInt();
          }
        }
        input.close();
      }
      catch (FileNotFoundException a)
      {
        a.printStackTrace();
      }
      dualPivotQuicksortYaroslavskiy(array, 0, array.length-1);
      System.out.print(array[0]);
      for (int i = 1; i < array.length; i++){
        System.out.print(" " + array[i]);
      }
  }
public static int[] dualPivotQuicksortYaroslavskiy(int[] A, int left, int right){
  int temp;
  int k;
  int g;
  int p;
  int l;
  int q;
  if(right - left >= 1){
      p = A[left];
      q = A[right];
      System.out.println("p: "+ A[left]);
      System.out.println("q : "+ A[right]);
        if(p < q){
           temp = p;
           System.out.println("Temp: "+ temp);
            p = q;
            System.out.println("p = "+ p);
            System.out.println("q = "+ q);
            q = temp;
            System.out.println("q = "+ q);
            temp = A[left];
            System.out.println("A[left] = " + A[left]);
            A[left] = A[right];
            System.out.println("A[left] = "+ A[left]);
            System.out.println("A[right] = " + A[right]);
            A[right] = temp;
            System.out.println("A[right] = " + A[right]);
          }

        l = left + 1;
        System.out.println("left = " + left);
        g = right - 1;
        System.out.println("g = "+ g);
        System.out.println("right = "+ right);
        k = l;
        System.out.println("k = "+ k);
        while(k <= g){
          System.out.println("g = "+ g);
          if(A[k] > p){
            System.out.println("A[k] = "+ A[k]);
            System.out.println("p = "+ p);
            temp = A[k];
            System.out.println("Temp = "+ temp);
            A[k] = A[l];
            System.out.println("A[l] = "+ A[l]);
            A[l] = temp;
            l = l + 1;
            System.out.println("l = "+ l);
          }
          else{
            if(A[k] < q){
              //For descending order, I changed this > or < in all but the while loop below and any with = signs in them.
              System.out.println("A[k] = "+ A[k]);
              System.out.println("q = "+ q);
              while(A[g] < q && k < g){
                g = g - 1;
              }
              temp = A[k];
              System.out.println("Temp = "+ temp);
              System.out.println("A[k] = "+ A[k]);
              A[k] = A[g];
              System.out.println("A[g] = "+ A[g]);
              A[g] = temp;
              System.out.println("Temp = "+ temp);
              g = g - 1;
              System.out.println("g = "+ g);
              if (A[k] > p){
                temp = A[k];
                System.out.println("Temp = "+ temp);
                System.out.println("A[k] = "+ A[k]);
                A[k] = A[l];
                A[l] = temp;
                System.out.println("A[l] = "+ A[l]);
                l = l + 1;
                System.out.println("l = "+ l);
              }
            }
          }
            k = k + 1;
              System.out.println("k = "+ k);
        }
            l = l - 1;
            System.out.println("l = " + l);
            g = g + 1;
            System.out.println("g = " + g);
            temp = A[left];
            System.out.println("Temp = " + temp);
            System.out.println("A[left] = " + A[left]);
            A[left] = A[l];
            System.out.println("A[l] = " + A[l]);
            A[l] = temp;
            temp = A[right];
            System.out.println("l = " + l);
            A[right] = A[g];
            System.out.println("A[right] = " + A[right]);
            A[g] = temp;
            System.out.println("A[g] = " + A[g]);
            //dualPivotQuicksortYaroslavskiy(A, left, l - 1);
            //dualPivotQuicksortYaroslavskiy(A, l + 1, g - 1);
            //dualPivotQuicksortYaroslavskiy(A, g + 1, right);

          }
            return A;
      }
}
