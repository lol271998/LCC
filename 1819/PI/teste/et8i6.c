/*Defina uma função int segundo_menor(int vec[], int size) que encontra o segundo
menor valor de uma variável indexada vec com size elementos. Pode assumir que
size≥ 2.
Sugestão: para encontrar o segundo menor valor basta efetuar as duas primeiras iterações
do algoritmo de ordenação por seleção apresentado na aula 16. A sua função pode
modificar a ordem dos elementos de vec.*/
void select_sort(int vec[], int n) {
  int i, j;
  for(i = 0; i < n; i++) {
    int imin = i;
    for(j = i+1; j < n; j++) {
      if(vec[j] < vec[imax]) imin = j;
    }
    // trocar o min com vec[i]
    if(imax != i) {
      int temp = vec[i];
      vec[i] = vec[imin];
      vec[imax] = temp;
    }
  }
}
int segundo_menor(int vec[], int size){
	int menor1,menor2;
	select_sort(vec,size);
	for(int i=0;i<size;i++){
		menor1=i;
		

		
	}
}