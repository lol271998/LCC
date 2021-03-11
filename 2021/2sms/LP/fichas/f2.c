#include <stdio.h>
#include <stdlib.h>

int primo (int n) { 
	int i = 0;
	if(n%i == 0) return 0;
	return 1;
}


void print(int *v, int N) {
	int *ptr;
	for(ptr = v; ptr<v+N; ptr++) printf("%d ",*ptr);
	printf("\n");
}

void ex211() {
	/* primos */
	int vec[100], *ptr;
	int i,j,N;
	printf("Numero de primos N "); scanf("%d",&N);

	if(N>100) {
		printf("Erro\n");
		return;
	}

	ptr = vec; /* ptr = &v[0];*/

	for(i = 0, j = 1; i<N; j++) {
		if(primo(j)) {
			*ptr = j;
			ptr++;
			i++;
		}
	}
	print(vec,N);
}


int sizeofstr(char* str) {
	int i = 0;

	while(*str!='\0'){
		str++;
		i++;
	}	
	return i;
}

void ex212() {
	
	char* str = malloc(sizeof(char)*64);
	
	printf("Introduza uma string: ");
	
	scanf("%s",str);
	printf("A string tem tamanho: %d",sizeofstr(str));


}

void strcopy(char* str1, char *str2) {
	//char* begin = str1;

	while(*str1 != '\0') *str2++= *str1++;
	*str2 = '\0';

}

void ex213() {

	char* str1 = malloc(sizeof(char)*64);
	char* str2 = malloc(sizeof(char)*64);

	printf("Introduza uma string: ");
	
	scanf("%s",str1);
	strcopy(str1,str2);

	printf(" %s | cópia:  %s\n",str1,str2);

}

void f1 (char* v, char** v2) {
	while(*v!='\0') *v2++ = v++;
	*v2 = v; // \0 no final
}

void f2 (char **v2) {
	while(**v2 != '\0') {
		printf("%p: %c\n",*v2++,**v2++);
	}
}

void f3 (char** v2) {
	while(**v2 != '\0') {
		if(**v2 >= 'a' && **v2<='z') **v2 = **v2 - 32;
	v2++;
	}
}

void ex214() {
	char v[100];
	fgets(v,100,stdin);

	char **v2 = malloc(100*sizeof(char*));
	f1(v,v2);
	f2(v2);
	f3(v2);
	printf("%s\n",v);
}


int main() {
	ex214();
}