int magico(int a[20][20], int n){
    int valorl=0,i,j,valor1=0;

    // somar a diagonal principal
    valor1=0;
    for(i=0;i<n;i++) {//diagonal
          valor1=a[i][i]+valor1;
      }


    // diagonal secundária
    for(i=0;i<n;i++){
          valorl=a[i][n-1-i]+valorl;
        }
      
    if (valorl!=valor1){
        return 0;
    }

    // somar as linhas
    for(i=0;i<n;i++){//testar as linhas
        valorl=0;  // somar a linha i
        for(j=0;j<n;j++){ //cada coluna
            valorl=a[i][j]+valorl;
        }
        if (valor1!=valorl)
          return 0;
    }

	
	for(j=0;j<n;j++){//testar colunas
        valorl=0;
        for(i=0;i<n;i++){ //cada linha
            valorl=a[i][j]+valorl;
        }
		if (valor1!=valorl)
          return 0;
    }
    return 1;
}