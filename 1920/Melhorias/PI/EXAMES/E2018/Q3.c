#include<stdio.h>
#include<ctype.h>
#include<string.h>

int montanhas(char str[]){
  int mont = 0,res = 0,i = 0;
  int n = strlen(str);
  if(n == 0) return 0;
  while(i<n){
    while(res>=0 && i<n){
      if(str[i] == 'S') res++;
      else if(str[i] == 'D') res--;
      if(res == 0) mont++;
      i++;
    }
    while(res<0 && i<n){
      if(str[i] == 'S') res++;
      else if(str[i] == 'D') res--;
      i++;
    }
  }
  return mont;
}

int main(void){
  char str[] = "SSDDDDSSSSDDSSDD";
  printf("são %d montanhas\n",montanhas(str));
  return 0;
}

