#include <stdio.h>

int main(int argc, char const *argv[]) {

  if(argc != 4) {
    printf("Not enough or too many arguments \n");
    return 1;
  }

  FILE *fp = fopen(argv[1],"r");

  int m = atoi(argv[2]);
  int k = atoi(argv[3]);

  
  return 0;
}
