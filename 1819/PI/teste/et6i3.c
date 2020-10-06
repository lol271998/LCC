#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(void) {
    int valor,resp=0;
    valor= 1 + rand()/(RAND_MAX/1000 + 1);
    printf("Advinhe o valor secreto entre 1 e 10000\n");
    scanf("%d",&resp);
    while(valor!=resp){
    		if (valor==resp) break;
    		if(resp>valor){
    			printf("Demasiado alto\n");
    		}
    		if(resp<valor){
    			printf("Demasiado baixo\n");
    		}
        scanf("%d",&resp);
    }
    printf("Parabéns Acertou!\n");
}