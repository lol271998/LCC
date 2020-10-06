/*A linguagem C não tem um operador para potências, mas podemos calcular x
n efetuando
multiplicações sucessivas (assumindo n ≥ 0 inteiro): x
n = x × x × · · · × x
| {z }
n fatores
.
Complete a denição da seguinte função para calcular potências.
int potencia(int x, int n) {
/* calcular e retornar x*x*...*x (n fatores)
Sugestão: utilize um ciclo for ou uma denição recursiva. Tenha atenção que x
0 = 1 (o
produto de zero fatores dá 1)*/
int potencia(int x, int n) {
	int i,res=1;
	for(i=0;i<=n;i++)
		res=res*x;
	return res;
}