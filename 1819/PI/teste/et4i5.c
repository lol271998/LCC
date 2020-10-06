/*Escreva uma definição da função int soma_divisores(int n) que calcula a soma dos
divisores de n inferiores a ele próprio. Por exemplo: a soma dos divisores de 12 é 16 porque
os divisores de 12 menores que 12 são {1, 2, 3, 4, 6} e 1 + 2 + 3 + 4 + 6 = 16. Sugestão:
modifique o exemplo apresentado na aula teórica 7 para testar se um número é primo.*/
int soma_divisores(int n){
	int a,soma=0;
	for(a=1;a<n;a++){
		if(n%a==0)
			soma=soma+a;
		else continue;
	}
	return soma;
}