import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class SelectionSort{

    public static void main(String[] args) throws IOException {

        /* 1 arg -> Text file
         *      unknown # lines of integers
         *      integers on a line are separated by single space
         * read integers from file into array
         * sort intgers in ascending order using selection sort
         * print integers one per line
         */

        Scanner reader;
        int n;
        String raw;
        String[] splitted;
        int[] data;

        // Read file into string 'raw'
        raw = "";
        n = 0; // number of integer elements
        reader = new Scanner(new File(args[0])); // open file
        while( reader.hasNextInt() ){
            raw += reader.nextInt() + " "; //Read an interger, leave a space
            n++; // incremnt count
        }
        reader.close(); // close file

        data = new int[n]; // initialize array of length 'n'

        splitted = raw.split(" "); // "45 94 22 500" => {"45","94","22","500"}

        for( n -= 1 ; n >= 0; --n ) // {"45","94","22","500"} => {45, 94, 22, 500}
            data[n] = Integer.parseInt(splitted[n]);

        data = selectionSort(data); // Sort values in Ascending order

        for( n = 0; n < data.length; n++ ) // Print sorted array
            System.out.printf("%d\n",data[n]); // one element per line



    }

     public static int[] selectionSort(int[] arr){
        // Java implementation of SelectionSort

        int i, j, idx, tmp; // variables

        for (i = 0; i < arr.length - 1; i++)  //arr.length - 1 is used to find the last element in an array:
                                              // For Example: int[] oldArray = {1,2,3,4,5};
                                              //int lastElement = oldArray.length - 1; // 4
                                              //oldArray[lastElement] // returns last element, 5
        {
            idx = i;
            for ( j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[idx])
                    idx = j;//searching for lowest index
            // swap
            tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }


}
