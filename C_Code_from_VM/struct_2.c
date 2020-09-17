#include <stdio.h>

struct point {
  int x;
  int y;
};

struct line {
  struct point start;
  struct point end;
};

int main(int argc, char *argv[]){ 
  struct line l;
  l.start.x = 0;
  l.start.y = 0;
  l.end.x = 1;
  l.end.y = 2;

  printf("The coordinates of the lines are: %d %d %d %d\n", 
          l.start.x, l.start.y, l.end.x, l.end.y);
  printf("The address of coordinates of the origin are: %p %p %p %p\n", 
          &l.start.x, &l.start.y, &l.end.x, &l.end.y);
  return 0;
}