#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>

int main(int argc, char* argv[]){
	int n = atoi(argv[1]);
	int m = atoi(argv[2]);

	if(n>m){
		printf("Argumentos trocados?");
	}
	if(n == m){
		return 0;
	}
	char* line = malloc(sizeof(char)*1000);

	if(argc == 4){
		FILE *f = fopen(argv[3],"r");
		int l = 1;
		while(fgets(line,1000,f)!=NULL){
			if(l>=n && l<m) printf("%s",line);
			l++;
		}
	}
	else{
		int l = 1;
		while(fgets(line,1000,stdin)!=NULL){
			if(l>=n && l<m) printf("%s",line);
			l++;
		}
	}
}