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
  int i,r=1;
  ordenar(str1);
  ordenar(str2);
  if (strlen(str1)==strlen(str2))
  {
    for(i=0;str1[i]!='\0';i++)
    {
        if (str1[i]==str2[i]) r=1;
        else
        {
            r=0;
            break;
        }
    }
  }
  else
  r=0;
  return r;
}
int main()
{
  char str1[] = "deposit";
  char str2[] = "topside";
  int r = anagramas(str1,str2); // resultado 1
}