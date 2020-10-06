#include<stdio.h>

int mediana(int a, int b, int c){
    int maior, menor, mediana;

    if(a>=b){
        maior = a;
        menor = b;
    }
    else{
        maior = b;
        menor = a;
    }
    if(c>=maior){
        maior = c;
    }
    else if(c<=menor) menor = c;
    
    mediana = a+b+c-menor-maior;
    return mediana;
}

int main(){
    printf("Mediana: %d\n",mediana(1,2,3));
}