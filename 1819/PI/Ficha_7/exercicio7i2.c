#define FALSE 0
#define TRUE  1 
#include <stdio.h>
unsigned comprimento(char str[])  
{
  unsigned i = 0;
  while(str[i] != '\0') 
    i++;
  return i;
}
/*char inverter(char str[])
{
   int i = 0, j;
   j = comprimento(str) - 1; 
   while (i < j) 
   {
      char ch = str[i];
      str[i] = str[j];
      str[j] = ch;
      i ++;
      j --;
   }
   return str[j];
   
}
//Ver se o primeiro caracter é igual ao ultimo que segundo igual ao penultimo e ect */
int palindromo(char str[])
{
  int i,j,stri;
  j=comprimento(str)-1;
  for (i=0;str[i]==str[j] && j!='\0';i++)
  {
    j--;
  }
  if (j==0)
   printf("É um palidromo");
  else
    printf("Não é um palidromo");
}

int main ()
{
  char text[8]="anna";
  palindromo(text);
}