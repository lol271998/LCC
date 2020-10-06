/*5.8 Pretende-se calcular o logaritmo natural (isto é, de base e) 
usando a série de Taylor:
Escreva uma função double serie_log(double x, int n) que calcula aproximamente a
série acima somando os termos até à potência n de x. Por exemplo: serie_log(x, 3) deve
calcular x − x^2/2 + x^3/3. Pode assumir que n ≥ 1. Tenha o cuidado de evitar o cálculo
desnessário de potências sucessivas de x.*/
double serie_log(double x, int n){
	int i=1;
	double res=0,resp=1;
	while(i<=n){
		resp=resp*(-1)*x;
		res=res+((-1)*(resp/i));
		i++;
	}
	return res;
}