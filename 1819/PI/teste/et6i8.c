/*6.8 Escreva uma função int repetidos(int vec[], int size) que testa se há (pelo
menos) dois valores iguais no vector vec com tamanho size; o resultado deve ser 1 em caso
afirmativo e 0 em caso negativo. Exemplos:
int a[5] = { 2, -1, 0, 2, -1 };
int b[5] = { 3, 4, 1, 2, -1 };
printf("%d\n", repetidos(a, 5)); // imprime 1
printf("%d\n", repetidos(b, 5)); // imprime 0
Tenha atenção que a sua função não modifique os elementos do vector 
passado como argumento.*/
int repetidos(int vec[], int size){
    int a=0,temp;
	for(int i=0;i<=size;i++){
		temp=vec[i];
		for(int j=i+1;j<=size;j++){
			if(vec[j]==temp){
				a=1;
				break;
			}
		}
	}
	return a;
}

