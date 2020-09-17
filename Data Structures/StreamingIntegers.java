import java.util.Scanner;
import java.util.*;
import java.util.PriorityQueue;

public class StreamingIntegers{
  public static void main(String[] args){

//Create Priority Queue
PriorityQueue<Integer> q = new PriorityQueue<Integer>();
//Scanner object
Scanner in = new Scanner(System.in);
//Read in integers from user until "END"
while (true) {

      String s = in.nextLine();
      if (s.compareTo("END") == 0) break;

      else {
        String[] splitedMethod = s.split(" ");
        for (String part : splitedMethod) {
        q.add(Integer.parseInt(part));
      }
    }
}

    while (!q.isEmpty()) {
     
        Integer i = q.poll();

        if(q.size()==0)
          System.out.print(i + "");
        else
          System.out.print(i + " ");
    }
  }
}
