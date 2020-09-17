
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
// part a
public class InsertionSort {
    public static void main(String[] args) throws IOException { // needs to throw IOException when reading a file
        File input = new File(args[1]);
        Scanner inputScan = new Scanner(input);
        int stringLength = Integer.parseInt(args[0]); //Length of array
        String[] data = new String[stringLength]; // TODO replace '10' with cmdline arg
        for(int i=0; i<stringLength; i++)
          data[i] = (inputScan.nextLine()); //Each string to be sorted.

        
        data = InsertionSort(data);

        //System.out.println("### DATA OUTPUT ###");
        for(int j = 0; j < data.length; j++){
          System.out.println(data[j]);
        }

    }

    public static String [] InsertionSort(String [] array){

      int i,j;
      String k;

      for( i = 1; i < array.length; i++ ){

        k = array[i];
        j = i;
        while( j > 0 && array[j-1].compareTo(k) > 0 ){
          array[j] = array[j-1];
          j--;
        }
        array[j] = k;
      }

      return array;

    }

}
