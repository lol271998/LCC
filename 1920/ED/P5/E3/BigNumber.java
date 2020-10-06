class BigNumber{

    private char[] num;
    private int size;
    
    //Inicializa o número a partir da String n (supondo que a String só contém dígitos e não tem zeros à esquerda)
    BigNumber(String n){
	size = n.length();
	num = new char[size+1];
	for(int i = 0,j = size-1; i<size; i++,j--){
	    num[i] = n.charAt(j);
	}
    }

    //Métodos padrão:

    //Devolve true caso o número seja igual a n, ou false caso contrário
    public boolean equals(BigNumber n){
        int size1 = n.size;
	if(size!=size1) return false;
	for(int i = 0; i<size; i++){
	    if(num[i] != n.num[i]) return false;				     
	}
	return true;
	    
    }

    //devolve uma String representando o número (os dígitos em si)
    public String toString(){
	String str = "";
	for(int i = size-1; i>=0; i--){
	    str += num[i];
	}
	return str;
    }

    //Operações:
    //devolve um novo BigNumber igual à soma de n com o próprio objecto (this + n).
    public BigNumber add(BigNumber n){
	BigNumber ng,np;
	String res = "";
	int resto = 0;
	int max,min;
       	if(this.size>n.size){
	    min = n.size;
	    max = this.size;
	    ng = this;
	    np = n;
	}
	else{
	    min = this.size;
	    max = n.size;
	    ng = n;
	    np = this;
	}
	for(int i = 0; i<max; i++){
	    if(i>=min){
		int c = ng.num[i] - '0';
		//System.out.println("ng.num["+i+"] = "+c);
		//System.out.println("resto: "+resto);
		res = (c + resto)%10 + res;
		if(c+resto>=10) resto = 1;
		else resto = 0;
	    }
	    else{
		int a = ng.num[i] - '0';
		int b = np.num[i] - '0';
		//System.out.println(a+"+"+b+"+"+resto+"="+ (a+b+resto));
		if(a+b+resto>=10){
		    res = ((a+b+resto)%10)+res;
		    resto = 1;
		}
		else{
		    res = (a + b + resto)+res;
		    resto = 0;
		}
	    }
	    //System.out.println(" numero: "+res);
	}
	if(resto == 1){
	    res = "1"+res;
	}
	//System.out.println("numero: "+res);
	
	BigNumber ns = new BigNumber (res);
	return ns;
    }

    //Devolve um novo BigNumber igual à multiplicação de n com o próprio objecto (this * n).
    public BigNumber multiply(BigNumber n){
	BigNumber ng,np;
	BigNumber ns1 = new BigNumber("0");
	String res = "";
	int resto = 0,soma = 0,max,min;
       	if(this.size>n.size){
	    min = n.size;
	    max = this.size;
	    ng = this;
	    np = n;
	}
	else{
	    min = this.size;
	    max = n.size;
	    ng = n;
	    np = this;
	}
	
	for(int i = 0; i<min; i++){
	    for(int j = 0; j<max; j++){
		int a = np.num[i] - '0';
		int b = ng.num[j] - '0';
		if(j == max-1){
		    res = ((a*b)+resto) + res;
		    resto = 0;
		}
		else if( ((a*b) + resto) <10){
		    res = ((a*b)+resto)%10 + res;
		    resto = 0;
		}
		else{
		    res = ((a*b)+resto)%10 + res;
		    resto = ((a*b)+resto)/10;
		}
	    }
	    if(i>=1){
		for(int k = 0; k<i; k++){
		    res = res+"0";
		}
	    }
	    BigNumber ns2 = new BigNumber(res);
	    ns1 = ns1.add(ns2);
	    res = "";
	}
	return ns1;
    }
}
