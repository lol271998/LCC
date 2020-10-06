/* 3.8 Baseando-se na solução do exercício 3.7 complete a denição da seguinte função para
calcular a mediana de 3 inteiros a, b e c.
int mediana(int a, int b, int c) {
/* calcular e retornar a mediana de a,b,c */
int mediana(int a, int b, int c) {
	int maior, menor,res;
		if(a>=b) maior=a;
		else maior = b;
		if (c>=maior) maior=c;
		if(a<b) menor=a;
		else menor=b;
		if(c<menor) menor=c;
		res=(a+b+c)-(menor+maior);
		return res;
}