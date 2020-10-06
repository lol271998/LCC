#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>
#include<unistd.h>

#define MAX_LENGTH 256
char format[MAX_LENGTH] = "%g";
char sep[MAX_LENGTH] = "\n";
int signal = 1;

struct opt{

	int f;
  /*-f FORMAT utilizar o estilo de formato da função printf() para imprimir cada número. Os
    caracteres de conversão válidos são E, e, f, G, g, e o %, bem como qualquer flag opcional ou campos
    para definição do tamanho e da precisão.*/

	int s;
  /*-s string utilizar string para separar os números. O separador por omissão é o \n .*/

	int w;
  /*-w equalizar o tamanho de todos números utilizando zeros à esquerda, conforme necessário. Esta
    opção não é aplicável caso a opção -f seja utilizada.*/

	int dec;

	int nRead;

};

void option(struct opt *list, int argc, char* argv[]){

	for(int i = 1; i<argc; i++){
		if(argv[i][0] == '-'){
			switch(argv[i][1]){
				case'f':
				list->f = 1;
				strcpy(format,argv[i+1]);
		//printf("%s",format);
				list->nRead+=2;
				break;

				case's':
				list->s = 1;
				strcpy(sep,argv[i+1]);
				list->nRead+=2;
				break;

				case'w':
		//printf("w\n");
				list->w = 1;
				list->nRead++;
				break;
			}
		}
	}	
	for(int i = 1+list->nRead; i<argc; i++){
		if(strchr(argv[i],'.') != NULL){
			list->dec = 1;
		}
	}
}

	void print_dec(struct opt *list, double first, double inc, double stop, char format[MAX_LENGTH], char sep[MAX_LENGTH]){
		if(signal == -1){
		//Positivo
			for(double i = first; i>stop-0.000001; i = i + inc){
				printf(format,i);
				if(i + inc>=stop) printf("%s",sep);
			}
		}
		else{
		//Negativo
			for(double i = first; i<stop+0.000001; i = i + inc){
				printf(format,i);
				if(i + inc<=stop) printf("%s",sep);
			}
		}
	}

	void print_int(struct opt *list, double first, double inc, double stop, char format[MAX_LENGTH], char sep[MAX_LENGTH]){
  	//printf("first: %d, inc: %d, stop: %d\n",first,inc,stop);
		char sfirst[100];
		char sstop[100];
		char snum[100];

		sprintf(sfirst, "%g", first);
		sprintf(sstop, "%g", stop);
		int f = 0;
		if(signal == -1){
  		//Negativo
			for(double i = first; i>=stop; i = i + inc){
				sprintf(snum, "%g", i);
			//printf("size: %ld\n",strlen(snum));
				if(strlen(snum)>strlen(sstop) && list->w == 1 && first){
					if(i<0){
						i*=-1;
						printf("-");
						f = 1;
					}
					for(int j = strlen(sstop); j>strlen(snum); j--)	printf("0");
						printf(format,i);
					if(f == 1){
						i *=-1;
						f = 0;
					}
				}
				else printf(format,i);

				if(i + inc>=stop) printf("%s",sep);
			}
		}
		else{
		//Positivo
			for(double i = first; i<=stop; i = i + inc){
				sprintf(snum, "%g", i);
			//printf("size: %ld\n",strlen(snum));
				if(strlen(snum)<strlen(sstop) && list->w == 1){
					for(int j = strlen(snum); j<strlen(sstop); j++) printf("0");
				}
			printf(format,i);
			if(i + inc<=stop) printf("%s",sep);
		}
	}
}

int main(int argc,char* argv[]){

	struct opt list = {0};

	//Default numbers
	double first = 1;
	double inc = 1;
	double stop = 1;
	option(&list,argc,argv);

	if(argc == list.nRead + 2){ //Incrementar um de um até ao stop	
		if(list.dec == 0) stop = atoi(argv[list.nRead+1]);
		else stop = atof(argv[list.nRead+1]);			
	}

  	else if(argc == list.nRead + 3){ //Incrementar do first até ao stop
  		if(list.dec == 0){
  			first = atoi(argv[list.nRead+1]);
  			stop = atoi(argv[list.nRead+2]);
  		}

  		else{
  			first = atof(argv[list.nRead+1]);
  			stop = atof(argv[list.nRead+2]);
  		}
  	}

  	else if(argc == list.nRead + 4) {
  		if(list.dec == 0){
  			first = atoi(argv[list.nRead+1]);
  			inc = atoi(argv[list.nRead+2]);
  			if(argv[list.nRead+2][0] == '-') signal = -1;
  			stop = atoi(argv[list.nRead+3]);
  		}
  		else{
  			first = atof(argv[list.nRead+1]);
  			inc = atof(argv[list.nRead+2]);
  			if(argv[list.nRead+2][0] == '-') signal = -1;
  			stop = atof(argv[list.nRead+3]);
  		}
  	}

  	if(list.nRead == 0 && list.dec == 1 && list.f != 1){
  		int prec = 1;
  		for(int i = 1+nRead;i<argc;i++){
  			
  		}
  		strcpy(format,"%.*f",prec);
  	}
  	else if(list.dec == 0 && list.f != 1){
  		strcpy(format,"%g");
  	}

  	if(list.dec == 1) print_dec(&list,first,inc,stop,format,sep);
  	else print_int(&list,first,inc,stop,format,sep);
  	return 0;
  }
