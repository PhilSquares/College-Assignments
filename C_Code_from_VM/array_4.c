
#include <stdio.h>
#include <stdlib.h>
//In C, the command line arguments include the program’s name. The actual arguments start at index position 1 (not 0 like Java).
int main(int argc, char *argv[]) { 
  int i, size;
  int *p; 
  size = atoi(argv[1]); //atoi converts to an integer. Similiar to parseInt or parseDouble in java. 
  printf("Before malloc, p is pointing to address (%p)\n", p);
  p = malloc(sizeof(int) * size);
  for (i = 0; i < size; i++){
    p[i] = i * 2;
    printf("After malloc and assignment, index %d has value %d at addr (%p)\n", i, p[i], p + i);
  }
  return 0;
}