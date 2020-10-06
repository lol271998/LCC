#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>

#define MAX_LENGTH 256

int main(){

	char delim = '\t';
	int lista[1] = {2};
	int kf = 1,k = 0;
	char *fname = "BaladaDaNeve_short.txt";
	char *line = malloc(sizeof(char)*1000);

	FILE *f = fopen(fname,"r");
	if(f==NULL){
		perror("error\n");
	}
	while(fgets(line,1000,f)!=NULL){
		char *token = malloc(sizeof(char)*1000);
		char *list_line[MAX_LENGTH];
		*list_line = malloc(sizeof(char)*1000);
		token = strtok(line,delim);
		while(line[k] != delim){
			printf("token: %s\n",token);
			strcpy(list_line[k],token);
			printf("list_line[%d]: %s\n",k,list_line[k]);
			k++;
			strtok(NULL,delim);
		}

		for(int i = 0; i<kf; i++){
			for(int j = 0; j<k; k++){
				if(j == lista[i]){
					printf("%s",list_line[k]);
				}
			}
		}
		k = 0;
	}
}