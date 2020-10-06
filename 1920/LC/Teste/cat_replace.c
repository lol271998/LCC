#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>


int isSubstring(char *s1, char *s2) { 
	int M = strlen(s1); 
	int N = strlen(s2); 

	for (int i = 0; i <= N - M; i++) { 
		int j; 
		for (j = 0; j < M; j++) if (s2[i + j] != s1[j]) break; 
			if (j == M)	return i; 
	}   
	return -1; 
}
void print(char* fname,char* word1,char* word2) {
	int j;
	if(fname[0]!='-'){
		FILE *f = fopen(fname,"r");

		char* wordcomp = malloc(sizeof(char)*1000);
		char* line = malloc(sizeof(char)*1000);

		while(fgets(line,1000,f)!=NULL){
			if(isSubstring(word1,line) !=-1 && strlen(word1)!=0){
				for(int i = 0; i<strlen(line); i++){
					for(j = 0; j<strlen(word1); j++){
						wordcomp[j] = line[i+j];
					}
					if(strcmp(wordcomp,word1) == 0){
						printf("%s",word2);
						i+=j-1;
					}
					else printf("%c",line[i]);
				}
			}
			else printf("%s",line);
		}
	}
	else{
		char* wordcomp = malloc(sizeof(char)*1000);
		char* line = malloc(sizeof(char)*1000);

		while(fgets(line,1000,stdin)!=NULL){
			if(isSubstring(word1,line) !=-1){
				for(int i = 0; i<strlen(line); i++){
					for(j = 0; j<strlen(word1); j++){
						wordcomp[j] = line[i+j];
					}
					if(strcmp(wordcomp,word1) == 0){
						printf("%s",word2);
						i+=j-1;
					}
					else printf("%c",line[i]);
				}
			}
			else printf("%s",line);
		}
	}
}
int main(int argc, char* argv[]){
	
	//Palavra que vai substituir
	char* word1 = malloc(sizeof(char)*strlen(argv[1]));
	strcpy(word1,argv[1]);
	//int w1l = strlen(word1);

	//Palavra a ser substituida
	char* word2 = malloc(sizeof(char)*1000);
	strcpy(word2,argv[2]);
	//int w2l = strlen(word2);
	if(argc<4) print("-",word1,word2);
	for(int i = 3; i<argc; i++){
		print(argv[i],word1,word2);
	}
}