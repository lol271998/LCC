#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>

void ordenarChar(char* file, int r){
	char* line;
	char* temp;
	char** total = malloc(sizeof(char**)*1000);
	int i = 0,j = 0,count = 0;

	//Standart Input
	if(strcmp(file,"-") == 0){
		while(1){
			line = malloc(sizeof(char*)*1000);
			if(fgets(line,100,stdin)==NULL) break;
			else{
				total[count] = line;
				count++;
			}
		}
		free(line);
	}

	//Opening a file
	else{
		FILE *fp;
		fp = fopen(file, "r");
		while(1){
			line = malloc(sizeof(char*)*1000);
			if(fgets(line,1000,fp)==NULL) break;
			else{
				total[count] = line;
				count++;
			}
		}
		fclose(fp);
	}

	temp = malloc(sizeof(char*)*1000);
	
	//Ordenar
	for(i=0;i<count;i++){
		for(j=i+1;j<count;j++){
			if(strcmp(total[i],total[j])>=0){
				strcpy(temp,total[i]);
				strcpy(total[i],total[j]);
				strcpy(total[j],temp);
			}
		}
	}
	if(r != 1){		
		for(int i = 0; i<count; i++){
			if(strcmp(total[i],"\n")!= 0) printf("%s",total[i]);
		}
	}
	else{
		for(int i = count-1; i>0; i--){
			printf("%s",total[i]);
		}
	}
	free(total);
	free(temp);
}

int check(char* line){
	int point = 0;
	for(int i = 0; i<strlen(line); i++){
		if(line[i] == '.'){
			point = 1;
		}
		else if(point>=1){
			point++;
		}
	}
	return point;
}

void ordenarInt(char* file, int r){
	char* line;
	int temp;
	int* total = malloc(sizeof(int)*1000);
	float* totalf = malloc(sizeof(float)*1000);
	float tempf;
	int count = 0,countf = 0;

	//Standart Input
	if(strcmp(file,"-") == 0){
		while(1){
			line = malloc(sizeof(char*)*1000);
			if(fgets(line,1000,stdin)==NULL) break;
			else{
				if(check(line) == 0){
					int a = atoi(line);
					total[count] = a;
					count++;
				}
				else{
					float b = atof(line);
					totalf[countf] = b;
					countf++;
				}
			}
		}
	}

	//Opening a file
	else{
		FILE *fp;
		fp = fopen(file, "r");
		while(1){
			line = malloc(sizeof(char*)*1000);
			if(fgets(line,1000,fp)==NULL) break;
			else{
				if(check(line) == 0){
					int a = atoi(line);
					total[count] = a;
					count++;
				}
				else{
					float b = atof(line);
					totalf[countf] = b;
					countf++;
				}
			}
		}
		fclose(fp);
	}

	for(int i = 0; i<count; i++){
		for(int j = i+1; j<count; j++){
			if(total[i]>=total[j]){
				temp = total[i];
				total[i] = total[j];
				total[j] = temp;
			}
		}
	}
	for(int i = 0; i<countf; i++){
		for(int j = i+1; j<countf; j++){
			if(totalf[i]>=totalf[j]){
				tempf = totalf[i];
				totalf[i] = totalf[j];
				totalf[j] = tempf;
			}
		}
	}

	if(r == 1){

	}
	free(total);
	free(totalf);
	free(line);
}

int main(int argc, char* argv[]){
	int opt,n = 0,r = 0, m = 0;

	while((opt = getopt(argc,argv,"nr"))!=-1){
		switch(opt){
			case 'n':
			n = 1;
			break;
			case 'r':
			r = 1;
			break;
		}
	}

	if((n == 1 && r == 1) || n == 1 || r == 1) m = 1;

	if(argc == 1+m){
		if(n == 1)ordenarInt("-",r);
		else ordenarChar("-",r);
	}

	for(int i = 1+m; i<argc; i++){
		if(n == 1) ordenarInt(argv[i],r);
		else ordenarChar(argv[i],r);
	}
}