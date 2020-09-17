import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.*;

public class StreamingWords{

   //main method
   public static void main (String[] args){
    Comparator<String> s = new Comparator<String>(){
       @Override //Overrides a built in method such as the one above.
        public int compare(String s1, String s2){
          String[] splitedMethod = s1.split(" "), splitedMethod2 = s2.split(" ");
          return splitedMethod.length - splitedMethod2.length;
        }
     };
     Scanner in = new Scanner(System.in);
     //Create a Comparator Que

    PriorityQueue<String> wordsQueue = new PriorityQueue<>(s);
     //Read in integers from user until "END"
     while (in.hasNextLine()) {

           String test = in.nextLine();
           if (test.compareTo("END") == 0) break;
              else {
                wordsQueue.add(test);
              }
            }

            while(!wordsQueue.isEmpty()){
              System.out.println(wordsQueue.remove());
            }
}
}
