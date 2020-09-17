/* 
    * Refer to previous program (malloc_1.c). 
    * This program shows us how to condense on one line. 
*/
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
  int *ip = (int *)malloc(sizeof(int)); //sizeof determines the size of a type from the OS.
  *ip = 98765;
  printf("%d\n", *ip);
  return 0;
}

