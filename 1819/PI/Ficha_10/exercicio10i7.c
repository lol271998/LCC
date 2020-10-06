#include<stdio.h>
int contar_espacos(char *str){
	unsigned espacos = 0; 
	int *i;

    for(i=str; str != NULL; i++)
    {
       if(str == ' ')
         espacos ++;
    }
    return espacos;

}
unsigned contar_espacos_1(char str[])
{
    unsigned espacos = 0, i;

    for(i = 0; str[i] != '\0'; i++)
    {
       if(str[i] == ' ')
         espacos ++;
    }
    return espacos;
}

int main(){
	char str[]="Olá tudo bem ?";
	char str1[]="Olá tudo bem ?";
	contar_espacos_1(str);
	contar_espacos(&str1);
}