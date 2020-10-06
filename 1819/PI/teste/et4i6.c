/*Um ano é bissexto se for divisível por 4, exceto se for também divisível por 100 e não
for divisível por 400. Por exemplo: 1980 foi bissexto porque 1980 é divísivel por 4 mas não
por 100; 1700 não foi bissexto porque apesar de ser divisível por 4, também é divisível por
100 e não é por 400.
Defina uma função int bissexto(int n) que verifica esta condição para um ano n; o
resultado deve ser 1 se o ano for bissexto e 0 caso contrário.*/
int bissexto (int n){
	if((n%4==0) && (n%100!=0))
		return 1;
	else
		return 0;
}
