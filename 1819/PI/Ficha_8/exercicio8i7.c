#include <string.h>
void inserir(char str[], char ch){
    int l,i,j=0;
    l=strlen(str);
        for(i=0;i<l;i++){
            if(str[i]>=ch){
              j=i;
              break;
            }
        }
        if(str[i]>=ch){
          for(i=l;i>j;i--){
            str[i]=str[i-1];
          }
          str[j]=ch;
        }
        else str[l]=ch;
}