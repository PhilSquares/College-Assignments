/*  
    -The values of pointers are memory addresses.
    -98765 is the value saved in memory.
    -Line 12: Declares a pointer *p that allocates 4 contiguous bytes. P = void pointer bc there is no type. 
    -Line 13: Declares an integer pointer *ip. The address value pointed to by p is assigned to pointer variable ip. 
  The bytes pointed to be p are now casted to type int.
*/
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
  void *p = malloc(4); 
  int *ip = (int *)p; 
  *ip = 98765;
  printf("%d\n", *ip);
 return 0;
} 