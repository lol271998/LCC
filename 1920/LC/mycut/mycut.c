#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>

#define MAX_LENGTH 256

char delim = '\t';
int num_b[MAX_LENGTH];
int lista[MAX_LENGTH];
int kb = 0,kf = 0,kd = 0;


struct opt{
	
	int b;

	int d;
	
	int f;

	int nRead;

};

void option(struct opt *list, int argc, char* argv[]){
	//printf("argv[3][1]: %c\n",argv[3][1]);
	//printf("argc = %d\n",argc);
	for(int i = 1; i<argc-1; i++){
		if(argv[i][0] == '-'){
			//printf("argv[%d][1]: %c\n",i,argv[i][1]);
			switch(argv[i][1]){
				case 'b':

				list->b = 1;
				if(strlen(argv[i+1]) == 1){
					num_b[0] = atoi(argv[i+1]);
					kb = 1;
				}
				else{
					char* token;
					token = strtok(argv[i+1], ",");
					while( token != NULL ) {
						num_b[kb] = atoi(token);
						kb++;
						token = strtok(NULL, ",");
					}
				}
				list->nRead+=2;
				break;

				case 'd':
				//printf("d\n");
				list->d = 1;
				if(argv[i][2] != '\0'){
					//printf("%c\n",argv[i][2]);
					delim = argv[i][2];
					kd = 1;
					//printf("%c\n",delim[0]);
					list->nRead++;
				}
				else{
					delim = argv[i+1][0];
					//printf("delim: %s\n",delim);
					list->nRead+=2;
				}
				break;

				case 'f':
				list->f = 1;
				int n = strlen(argv[i]);

				if(argv[i][2] != '\0'){
					for(int j = 1; j<n; j++){
						if(argv[i][j]!=','){
							lista[kf] = argv[i][j] - '0';
							kf++;
						}
					}
					//printf("só um lista[0]: %d\n",lista[0]);
					list->nRead++;
				}

				else{
					if(strlen(argv[i+1]) == 1){
						lista[0] = atoi(argv[i+1]);
						kf = 1;
					}
					else{
						char* token;
						token = strtok(argv[i+1], ",");
						while( token != NULL ) {
							lista[kf] = atoi(token);
							kf++;
							token = strtok(NULL, ",");
						}
					}
					list->nRead+=2;
				}
				break;
			}
		}
	}
}

void print(struct opt *list,char *fname, int argc){

	char *line = malloc(sizeof(char)*1000);
	int w = 1;
	if(fname[0] != '-'){
		FILE *f = fopen(fname,"r");
		if(f==NULL){
			perror("error\n");
		}	
		else{
			while(fgets(line,1000,f)!=NULL){
				//printf("%s",line);
				if(list->b == 1){
					for(int i = 1; i<strlen(line);i++){
						for(int j = 0; j<kb; j++){
							if(i == num_b[j]){
								printf("%c",line[i-1]);
							}
						}
					}
				}

				else if(list->d == 1 && list->f == 1){
					w = 0;
					int k = 0,l = 0;
					char **word = malloc(sizeof(char*)*1000);
					*word = malloc(sizeof(char)*10000);
					while (line[l] != '\n'){
						printf("w: %d, l: %d\n",w,l);
						if(line[l] != ':' && w>0){
							word[w][k] = line[l];
							k++;
						}
						else{							
							w++;
							k = 0;
						}
						l++;
					}
					w = 0;
					for(int i = 0; i<kf; i++){
						if(w+1 == lista[i]){
							printf("%s",word[w]);
						}
					}
				}
			}
			printf("\n");
		}
	}

	else{
		while(fgets(line,1000,stdin)!=NULL){
			for(int i = 1; i<strlen(line);i++){
				for(int j = 0; j<kb; j++){
					if(i == num_b[j]){
						printf("%c",line[i-1]);
					}
				}
			}
			printf("\n");
		}
	}	
}

int main(int argc, char* argv[]){	
	
	struct opt list = {0};

	option(&list,argc,argv);
	
	if(list.nRead+1 == argc){
		print(&list,"-",argc);
	}
	else{
		for(int i = list.nRead+1; i<argc; i++){
			if(argv[i][0] == '-'){
				print(&list,"-",argc);
			}
			else{
				print(&list,argv[i],argc);
			}
		}	
	}
	return 0;
}