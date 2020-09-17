import java.util.Arrays;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Merge {
    public static void main(String[] args) {
      File file = new File(args[0]);
      File file1 = new File(args[1]);
      int i = 0;
      int k = 0;
      int length = 0;
      int length2 = 0;
      try {
        Scanner input2 = new Scanner(file);
          while (input2.hasNextInt()) {
            input2.nextInt();
            length++;
          }
          input2.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      try {
        Scanner input3 = new Scanner(file1);
          while (input3.hasNextInt()) {
            input3.nextInt();
            length2++;
          }
          input3.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      int arr[] = new int[length];
      int arr2[] = new int[length2];
    try {
          Scanner input = new Scanner(file);
            while(input.hasNextInt()) {
              arr[i] = input.nextInt();
              i++;
            }
          input.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
          try {
          Scanner input1 = new Scanner(file1);
            while(input1.hasNextInt()) {
              arr2[k] = input1.nextInt();
              k++;
          }
          input1.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }

      int[] ascendingArray = new int[length];
      Merge isort = new Merge();
      ascendingArray = isort.insertionSort(arr);
      for (int r = 0; r < ascendingArray.length - 1; r++) {
        System.out.print(ascendingArray[r] + " ");
      }
      System.out.println(ascendingArray[length - 1]);
      int[] descendingArray = new int[length2];
      Merge isort2 = new Merge();
      descendingArray = isort2.insertionSort(arr2);
      for(int a = descendingArray.length - 1; a > 0; a--) {
        System.out.print(descendingArray[a] + " ");
      }
      System.out.println(descendingArray[0]);
      int[] array3 = new int[length + length2];

      int d = descendingArray.length - 1;
      int a = ascendingArray.length - 1;
      for(int q = 0; q < array3.length; q++) {
        if (d > -1 && a > -1 ) {
          if (descendingArray[d] > ascendingArray[a]) {
            array3[q] = descendingArray[d];
            d--;
          }
          else {
            array3[q] = ascendingArray[a];
            a--;
          }
        }
        else if (d <= -1) {
          while (a > -1) {
            array3[q] = ascendingArray[a];
            a--;
            q++;
          }
        }
        else {
          while (d > -1) {
            array3[q] = descendingArray[d];
            d--;
            q++;
          }
        }
      }
      for (int v = 0; v < array3.length - 1; v++) {
        System.out.print(array3[v] + " ");
      }
      System.out.println(array3[array3.length - 1]);
    }
  public int[] insertionSort(int[] array) {
    for (int j = 1; j < array.length; j++) {
        int key = array[j];
        int i = j - 1;
        while (i >= 0 && array[i] > key) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = (key);

    }
    return array;

  }
}
