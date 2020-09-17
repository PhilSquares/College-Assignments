/* 
Side notes:
N = The length of the unsoted array.
K = The unsorted array that we pass to the sort() function.
*/
public class Notes{
  public static void main(String[] args){
    int[] unsorted = {14, 23, 5, 67, 1, 54, 121, 8, 12};
      // Print out the array!
      for(int i = 0; i < unsorted.length; i++){
        System.out.println(unsorted[i] + "");
      }
      System.out.println("");

      int[] sorted = sort(unsorted); // After sort() method below is created, this is how we call it in main.
      for(int i = 0; i < sorted.length; i++){
        System.out.println(sorted[i] + " ");

      }
        System.out.println("");
  }

  public static int[] sort(int[] unsorted){  // We have a function called sort() that takes an array and returns the sorted.
    int[] sorted = unsorted;
      // Step C1 in problem "C1. [Clear COUNTs.] Set COUNT[1] through COUNT[N] to zero."
      // This means to create an empty array COUNT with the same size as the unsorted array and initialize all values of count to 0.
    int[] COUNT = new int[unsorted.length];
    for(int i = 0; i < COUNT.length; i++){
        COUNT[i] = 0;
    }
    // C2. [Loop on i.] Perform step C3, for i = N, N-1,....,2; then terminate the algorithm.
      // This means to create a loop on i going from N back to 2
      // Side note: This algorithm uses 1 as its starting index for arrays. We must scale the range to N-1 back to 1.
    for(int i = COUNT.length - 1; i >= 1; i--){
      // C3. [Loop on j.] Perform step C4, for j = i-1, i-2, ...,1.
      // Due to indexing differences, 1 should be set to 0.
      // Inside the nested for loop below is step C4 which states the following: "[Compare Ki : kj.] If Ki < Kj, increase COUNT[j] by 1, otherwise increase
      // COUNT[i] by 1."
      for(int j = i - 1; j >= 0; j--){
        if(unsorted[i] < unsorted[j]){
          COUNT[j]++;
        } else{
          COUNT[i]++;
        }
      }
    }
    return COUNT;
  }
}
