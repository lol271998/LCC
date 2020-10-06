#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<assert.h>

char rodar_letra(char ch){
  if(ch>='A' && ch<'Z') return ch+1;
  else if(ch == 'Z') return 'A';
  else if(ch >= 'a' && ch<'z') return ch+1;
  else if( ch == 'z') return 'a';
  else return ch;
}

int main(void){
  char ch1 = 'A';
  char ch2 = 'a';
  char ch3 = '!';
  int i = 0;
  while(i<25){
    assert(rodar_letra(ch1) == ch1+1);
    printf("{%c->%c}\n",ch1,rodar_letra(ch1));
    ch1++;
    i++;
  }
  if(i == 25){
      assert(rodar_letra(ch1) == 'A');
      printf("{%c->%c}\n",ch1,rodar_letra(ch1));
  }
  i = 0;
  while(i<25){
    assert(rodar_letra(ch2) == ch2+1);
    printf("{%c->%c}\n",ch2,rodar_letra(ch2));
    i++;
    ch2++;
  }
  if(i == 25){
    assert(rodar_letra(ch2) == 'a');
    printf("{%c->%c}\n",ch2,rodar_letra(ch2));
  }
  for(int i = 0; i<31; i++){
    assert(rodar_letra(ch3) == ch3);
    printf("{%c->%c}\n",ch3,rodar_letra(ch3));
    ch3++;
  }
  return 0;
}
