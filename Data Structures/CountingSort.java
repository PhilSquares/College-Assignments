class CountingSort{
  public static void main(String[] args){
    int[] unsorted = {14, 23, 5, 67, 1, 54, 121, 8, 12}; //Unsorted array is considered k in step C4.

      for(int i = 0; i<unsorted.length; i++ ){
        System.out.println(unsorted[i] + "");

      }
        System.out.println("");
      int[] sorted = sort(unsorted);
      for(int i = 0; i<sorted.length; i++ ){
        System.out.println(sorted[i] + "");
      }
        System.out.println("");
  }
  public static int[] sort(int[] unsorted){
    int[] sorted = unsorted;
    int[] COUNT = new int[unsorted.length]; //N is the length of the unsorted array.
    for(int i = 0; i < COUNT.length; i++){
      COUNT[i] = 0; //Setting count to zero. This is the C1 question on assignment.
    }
    for(int i = COUNT.length - 1; i >= 1; i--){ //COUNT.length - 1 means...
      for(int j = i - 1; j>=0; j--){
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