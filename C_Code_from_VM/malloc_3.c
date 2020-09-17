#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
  int *ip = (int *)malloc(sizeof(int));
  *ip = 98765;
  printf("%d\n", *ip);
  free(ip); //Don't use * when you free up a pointer. 
  //When we free up a pointer, it wipes the memory (security purposes).
  ip = NULL; //Forgets the address/memory we asked for before. 
  return 0;
}