#include<stdio.h>
int calc(char str[])
{
  int a,b,i,res;
  char op;
  a=str[0] - '0';
  b=str[2] - '0';
  op=str[1];
  if (op == '*')
   res=a*b;
  if (op == '+')
   res=a+b;
  if (op == '-')
   res=a-b;
  printf("%d\n",res);
}

int main()
{
    calc("2+3");
}