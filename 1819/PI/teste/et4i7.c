/*Escreva uma função int prox_bissexto(int n) que calcula o próximo ano bissexto
a partir do ano dado; se n for um ano bissexto, então o resultado deve ser n. Exemplos:
prox_bissexto(1980) retorna 1980; prox_bissexto(2017) retorna 2020.
Sugestão: utilize um ciclo while começando no ano dado e a função do exercício 4.6 para
determinar se um ano é bissexto.*/
int prox_bissexto (int n){
	if((n%4==0) && (n%100!=0))
		return n;
	else
		while((n%4!=0)||((n%100==0)&&(n%400!=0))){
		    n++;
		}
	return n;
}