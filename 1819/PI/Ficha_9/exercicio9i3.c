#include <string.h>
#include <stdlib.h>
void normalizar (char str[]){
    int i,l;
    l=strlen(str);
    for(i=0;i<l;i++){
        if(isalpha(str[i])!=1){
            eliminar(str,str[i]);
        }
    }
}


void eliminar(char str[],char ch){
    int i,l;
    l=strlen(str);
    for(i=0;str[i]!='\0';i++){
        if(str[i]==ch){
          while(i<l){
            str[l]=str[i];
            str[i]=str[i+1];
            str[l]='\0';
            i++;
          }
          str[l-1]='\0';
            return 0;
        }
    }
}


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
  normalizar(str1);
  normalizar(str2);
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

int main(){
  char str1[]="Quid est veritas?";
  char str2[]="Est vir qui adest";
  int r = anagramas(str1,str2);  
}