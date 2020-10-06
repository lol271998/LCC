#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct FRAC{
	int Sinal;
	int Num;
	int Den;
	int Erro;
} Frac;
Frac Numero, Numero1,Soma,Mult,Div;
int gcd;

Frac simp(Frac f){
    int i;

    for(i=1; i <= Numero.Num && i <= Numero.Den; ++i)
    {
        if(Numero.Num%i==0 && Numero.Den%i==0)
            gcd = i;
    }
    Numero.Num = Numero.Num/gcd;
    Numero.Den = Numero.Den/gcd;

    return Numero;
}

Frac soma(Frac f,Frac f1){
	
	if(Numero.Den != Numero1.Den){
		Numero.Num = Numero.Num*Numero1.Den;
		Numero1.Num = Numero1.Num*Numero.Den;
		Numero.Den = Numero.Den*Numero1.Den;
		Numero1.Den = Numero.Den*Numero1.Den; 
	}

	if(Numero.Sinal == -1) Soma.Num = Numero1.Num - Numero.Num;
	if(Numero1.Sinal == -1) Soma.Num = Numero.Num - Numero.Den;
	else Soma.Num = Numero1.Num + Numero.Num;
	Soma.Den = Numero.Den;
	Soma.Num = Numero.Num + Numero1.Den;
	return Soma;

}

void sinal(int n1,int n2){

	if(((n1 >= 0) && (n2 >= 0)) || ((n1<=0)&&(n2<=0))) Numero.Sinal = 1;
	else Numero.Sinal = -1;
}

int main(){
	
	printf("Introduza o numerador: \n");
	scanf("%d", &Numero.Num);
	
	printf("Introduza o denominador: \n");
	scanf("%d",&Numero.Den);
	if(Numero.Den == 0) Numero.Erro = 0;
	printf("\n");

	sinal(Numero.Num,Numero.Den);	
	
	printf("Sinal: %d\n",Numero.Sinal);
	printf("Numerador: %d\n",Numero.Den);
	printf("Denominador: %d\n",Numero.Num);
	printf("\n");

	simp(Numero);
	
	printf("Simplificado:\n");
	printf("\n");
	printf("Sinal: %d\n",Numero.Sinal);
	printf("Numerador: %d\n",Numero.Den);
	printf("Denominador: %d\n",Numero.Num);
	printf("\n");

	printf("Soma:");
	printf("\n");
	printf("Introduza os numeros que quer somar\n");
	scanf("%d %d %d %d",&Numero.Num,&Numero.Den,&Numero1.Num, &Numero1.Den);
	
	sinal(Numero1.Num,Numero1.Den);
	sinal(Numero.Num,Numero.Den);

	soma(Numero,Numero1);
	
	printf("Soma: \n");
	printf("\n");
	printf("Sinal: %d\n",Soma.Sinal);
	printf("Numerador: %d\n",Soma.Den);
	printf("Denominador: %d\n",Soma.Num);
	printf("\n");



}
/*FRAC soma(FRAC,FRAC){

}
FRAC sub(FRAC,FRAC){

}
FRAC mult(FRAC,FRAC){

}
FRAC div(FRAC,FRAC){

}*/