#include<stdio.h> 

int main(int argc, char *argv[]) {    
  int i;
  char str[] = "Hello, world!"; //str is considered an array of characters in C NOT a single string. 
  printf("%s\n",str);     
  for (i = 0; i <= 12; i++) {
    printf("%c ", str[i]);
  } 
  printf("\n");
  return 0; 
} 