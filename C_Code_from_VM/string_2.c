#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]){ 
  int i, word_count;
  int str_len[2] = {6, 4};
  char **s_array; //** means pointer of pointer... Pointer to a memory address that contains another pointer of characters.
  word_count = 2;
  s_array = (char**)calloc(word_count, sizeof(char *)); //calloc locates memory blocks.
  for (i = 0; i < word_count; i++){
    s_array[i] = (char *)calloc(str_len[i], sizeof(char)); 
  }
  strcpy(s_array[0], "Golden");
  strcpy(s_array[1], "Rams");
  printf("%s %s\n", s_array[0], s_array[1]);
  return 0;
} 