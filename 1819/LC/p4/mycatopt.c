#include <getopt.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char* argv[]){
   char c;
   int opt;
   int count = 1;
   //printf("Hey1");CHECK
   /*Caso não seja atribuido nenhum argumento na shell imprimir o texto que é introduzido*/
	if(argc==1){ 
	   while((c=getchar())!= EOF) printf("%c",c);
	   return 0;
	}
	/*Caso contrário*/
	FILE* fp;
	int i = 1;
	//printf("Hey2");CHECK
	while(argv[i]!= NULL){
		if(*argv[i] != '-'){
			fp = fopen(argv[i],"r");
			while((c=fgetc(fp))!= EOF) printf("%c",c);
			fclose(fp);
			return 0;
		}
		else{
			/*Ver as opções*/
			i++;
			while ((opt = getopt (argc, argv, "nbs")) != -1){
				switch(opt){
					
					/*Numerar as linhas*/
					case'n':
						printf("%6d\t",count);
						fp = fopen(argv[i],"r");
						while((c=fgetc(fp))!=EOF){
							if(c == '\n' && c !='\0'){
								count++;
								printf("\n%6d\t",count);
							}
							else printf("%c",c);	
						}
						printf("\n");
						fclose(fp);						
					return 0;
					break;
					/*Fim Numerar as linhas*/
	   				
	   				/*Numerar linhas não vazias*/
					case'b':
						printf("%6d\t",count);
						fp = fopen(argv[i],"r");
						while((c=fgetc(fp))!=EOF){
							if(c == '\n'){
								count++;
								printf("\n%6d\t",count);
							}
							else printf("%c",c);	
						}
							printf("\n");
							fclose(fp);						
					return 0;			
					break;
	   				/*Fim Numerar linhas não vazias*/
					
					case's':
						printf("s\n");			
					break;
	   				
	    		}
	    	}
		}
		i++;
	}
	return 0;
}