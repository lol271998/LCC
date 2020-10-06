/*Generalizando o exemplo apresentado na aula teórica 6, escreva um programa que lê
um inteiro não-negativo e imprime os seus dígitos binários. Podemos obter a representação
de um inteiro positivo n numa base b fazendo divisões sucessivas por b até obter quociente
0; os restos das divisões são os "dígitos" (de 0 a b − 1).
Exemplo: obtemos a representação em binário de 25 fazendo 4 divisões sucessivas por 2:
Assim, 25 decimal é representado em binário por 11001. Note que os dígitos são obtidos
pela ordem do menos signifcativo para o mais signifcativo.*/
#include <stdio.h>
int cdb(int n){
    int bin = 0;
    int i=1, resto;
    while (n != 0){
        resto = n % 2;
        printf("O resto de n por dois é %d\n", resto);
        n /= 2;
        bin += resto*i;
        i *= 10;
    }
    return bin;
}
int main(void){
	int num,res;
	printf("Introduza o numero que pretende traduzir para binário: \n");
	scanf("%d",&num);
	res=cdb(num);
	printf("%d\n",res);
}
