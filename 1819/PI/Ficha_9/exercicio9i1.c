#include <stdio.h>
#include <string.h>
void ordenar(char str[])
{
    int i,l,j,letra;
    l=strlen(str);
    for (i=1;i<l;i++)
    {
      letra=str[i];
      j = i-1;
    
      while(j>=0 && str[j]>letra)
        {
          str[j+1] = str[j];
          j--;
        }
      str[j+1]= letra;
    }
}

int anagramas(char str1[], char str2[])
{
  int i;
  char a[100]=str1;
  char b[100]=str2;
  str1=ordenar(a);
  str2=ordenar(b);
  for(i=0;a[i]!='\0';i++)
  {
    if (str1[i]==str2[i])
        return 1;
    else
        return 0;
  }
}
int main()
{
  char str1[] = "deposit";
  char str2[] = "topside";
  int r = anagramas(str1,str2); // resultado 1
}