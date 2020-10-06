#include <string.h>
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
int main()
{
    char str[]="ABBA";
    eliminar(str,'B');
}