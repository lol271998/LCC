#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Protótipo do programa
void ex11();
void ex12();
void ex13();
void ex14();
void ex15();
void ex16();

void ex11() {
	int num,d1,d2,d3,d4;
	printf("Introduza numero: ");
	scanf("%d",&num);

	d1 = num/1000%10;
	d2 = num/100/10;
	d3 = num/10%10;
	d4 = num%10;

	printf(" %d, %d, %d, %d\n",d1,d2,d3,d4);

	if((d1+d2+d3+d4)%2 == 0) printf(" %d%d%d%d0\n",d1,d2,d3,d4);
	else printf(" %d%d%d%d1\n",d1,d2,d3,d4);
}

void ex12() {
	int inicio, fim, i;
	printf("Inicio e fim: ");
	scanf(" %d %d", &inicio,&fim);

	printf("Bissextos entre %d e %d: ",inicio,fim);
	for(i = inicio; i<=fim; i++)
		if(i%400 == 0 || (i%4 == 0 && i%100 !=0))
			printf(" %d, ",i);
	printf("\n");
}

int bx(int ano){
	if(ano%400 == 0 || (ano%4 == 0 && ano%100 != 0))
		return 1;
	else return 0;
}

void ex13() {
	int dia,mes,ano;
	printf("Introduza dia mês ano: ");
	scanf(" %d %d %d",&dia,&mes,&ano);
	switch(mes) {
	case 2:
		if((bx(ano) == 1 && dia == 29)|| (bx(ano) == 0 && dia == 28)){
			dia = 1;
			mes++;
		}
		if(bx(ano) == 0 && dia == 29){
			printf("error");
			return;
		}	
		else dia++;
		break;
	case 4: case 6: case 11:
		if(dia == 30) {
			dia = 1;
			mes++;
		}
		else dia++;
		break;
	default:
		if(dia == 31 && mes == 12) {
			dia = 1;
			mes = 1;
			ano++;
		}
		else dia++;
		break;
	}
	printf("dia seguinte: %d/%d/%d",dia,mes,ano);
}

int gcd(int a, int b) {  
	if (a == 0) return b;  
	return gcd(b % a, a);  
}

int lcm(int a, int b) {return (a / gcd(a, b)) * b;}

void ex14() {
	
	int n1, n2;
	printf("Introduza dois numeros: ");
	scanf("%d %d",&n1,&n2);
	printf("Minímo Múltiplo Comun: %d\n",lcm(n1,n2));

}

void ex15() {
	int ndias,start,d = 0;
	int days[35];
	char barra = '|';
	printf("Introduza o numero de dias: ");
	scanf("%d",&ndias);
	printf("Semana começa a: \n");
	printf("Domingo -> 0\n");
	printf("Segunda -> 1\n");
	printf("Terça   -> 2\n");
	printf("Quarta  -> 3\n");
	printf("Quinta  -> 4\n");
	printf("Sexta   -> 5\n");
	printf("Sábado  -> 6\n");

	scanf("%d",&start);

	for(int i = 0; i<=35; i++){
		if(i<start) days[i] = 0;
		else if(d>ndias) days[i] = 0;
		else{
			days[i] = d;
			d++;
		}
	}

	d = 0;

	printf("-------------------------------------------\n");
	printf("|  D  |  S  |  T  |  Q  |  Q  |  S  |  S  |\n");
	printf("-------------------------------------------\n");

	for(int i = 0; i<5; i++) {
		for(int j = 0; j<7; j++) {
			d++;
			printf("%-3c",barra);
			if(days[d] != 0){
				if(days[d] >= 10) printf("%d ",days[d]);
				else printf("%d  ",days[d]);
			}
			else printf("%c  ",' ');
		}
		printf("|\n");
		printf("-------------------------------------------\n");
	}
}

void ex16() {
	int num,tent = 0,i,s;
	printf("Introduza o intervalo de procura\n");
	scanf("%d %d",&i,&s);
	int r = rand() % (s + 1 - i) + i;
	do{
		printf("Introduza o seu palpite\n");
		scanf("%d",&num);
		if(num>r) printf("O numero que introduziu é superior\n");
		else if(num<r) printf("O numero que introduziu é inferior\n");
		tent++;	
	}while(r != num);
	printf("Parabéns acertou ao fim de %d tentativas\n",tent);
}

void ex17() {
	int d;
	printf("Introduza um número impar: ");
	scanf("%d",&d);
	for(int i = 0; i<=d/2; i++){
		for(int j = 0; j<d; j++){
			int n = (d/2);
			//printf("n: %d\n",n);
			if(j>= n - i && j<= n + i){
				if(j%2 == 0) printf("o");
				else printf("+");
			}
			else printf(" ");
		}
		printf("\n");
	}

	for(int i = (d/2)+1; i<d; i++){
		for(int j = 0; j<d; j++){
			int n = (d/2);

			if(j>=i-n && j<=d-i+1){
				if(j%2 == 0) printf("o");
				else printf("+");
			}
			else printf(" ");
		}
		printf("\n");
	}
}

int friends (int a, int b){
	int sum = 0;

	for(int i = 1; i<a; i++){
		if(a%i == 0) sum+=i;
	}
	if(sum == b) return 1;
	else return 0;
}

void ex18() {
	int a,b;
	
	printf("Introduza 2 números: ");
	scanf("%d %d",&a,&b);
	if(friends(a,b) != 1){
		printf("%d e %d não são números amigos",a,b);
		return;
	}
	else{
		printf("%d e %d são números amigos\n",a,b);
		for(int k = 0; k<=1; k++){
			printf("Divisores de %d: ",a);
			for(int i = 1; i<a; i++){
				if(a%i == 0) printf("%d ",i);
			}
			printf("\n");
			a = b;
		}
	}		
}



int main() {
	ex18();
	return 0;
}