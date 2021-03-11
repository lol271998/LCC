/*
*
* recebe uma string na linha de comando e a transforma numa string equivalente mas
* com todos os caracteres em minusculas;
* 
* recebe duas strings na linha de comando e indica se a primeira ocorre na segunda;
* 
* recebe duas strings na linha de comando e indica quantas vezes a primeira ocorre na
* segunda.
*
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#define MAX_STR_SIZE 64

char* lower(char* p1) {
	char* str = (char*)malloc(MAX_STR_SIZE * sizeof(char));
	int n = strlen(p1);
	for(int i = 0; i<n; i++) {
		str[i] = tolower(p1[i]);
	}
	return str;
}

int isSubstring(char* p1,char* p2) {

	int m,n,j = 0,k = 0;
	m = strlen(p1); n = strlen(p2);

	if(m>n) return 0;
	for(int i = 0; i<n; i++) {
		if(p1[0] == p2[i] && i+m<=n) {
			for(j = 0,k = i; j<m; j++,k++) {
				if(p1[j] != p2[k]) break;
			}
			if(j == m) return 1;
		}
	}
	return 0;
}

int occ(char* p1,char* p2) {

	int m,n,j = 0,k = 0,occ = 0;
	m = strlen(p1); n = strlen(p2);

	if(m>n) return 0;
	for(int i = 0; i<n; i++) {
		if(p1[0] == p2[i] && i+m<=n) {
			for(j = 0,k = i; j<m; j++,k++) {
				if(p1[j] != p2[k]) break;
			}
			if(j == m) occ++;
		}
	}
	return occ;
}

int main(int argc, char* argv[]) {
	char* p1 = (char*)malloc(MAX_STR_SIZE * sizeof(char));
	char* p2 = (char*)malloc(MAX_STR_SIZE * sizeof(char));
	
	//toLower();
	if(argc == 2) {
		strcpy(p1,argv[1]);
		printf("toLower: %s\n",lower(p1));
	}

	//First in second ?
	if(argc == 3) {
		strcpy(p1,argv[1]);
		strcpy(p2,argv[2]);
		int n = occ(p1,p2);
		if(n >= 1) printf("É substring\n");
		else printf("Não é substring\n");
		printf("occorências de %s em %s = %d\n",p1,p2,n);
	}
}