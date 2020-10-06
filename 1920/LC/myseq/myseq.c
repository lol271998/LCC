#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>
#include<unistd.h>

  #define MAX_LENGTH 256
#define FIRST list->size[0]
#define INC list->size[1]
#define STOP list->size[2] 

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

  int p; //A maior precisão

  int size[3]; //Tamanho de cada numero
};

void option(struct opt *list, int argc, char* argv[]){

  for(int i = 1; i<argc; i++){
    if(argv[i][0] == '-'){
      switch(argv[i][1]){
        case'f':
        list->f = 1;
        strcpy(format,argv[i+1]);
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

  int temp = 0,point = 0;
  int k = 0;
  list->p = 1;

  for(int i = 1+list->nRead; i<argc; i++){
    list->size[k] = strlen(argv[i]);
    k++;
    for(int j = 0; j<strlen(argv[i]); j++){
      if(argv[i][j] == '.' && point == 0){
        list->dec = 1;
        point = 1;
      }
      else if(point == 1){
        temp++;
      }
      if(temp>list->p && point == 1){
        list->p = temp;
      }
    }
    temp = 0;
    point = 0;
  }
}

int sizenumber(int n){
  int count = 0;
  if(n == 0) return 1;
  while (n != 0) {
    n /= 10;
    ++count;
  }
  return count;
}

void print(struct opt *list, double first, double inc, double stop, char format[MAX_LENGTH], char sep[MAX_LENGTH]){
  int size,flag = 0,fl = 0;
  if(signal == -1){
    //Negativo
    for(double i = first; i>stop-0.000001; i = i + inc){
      if(list->dec == 0){
        if(list->w == 1){
          size = sizenumber(i);
          //Caso o tamanho seja inferior adicionar 0
          if(FIRST>STOP) fl = FIRST;
          else fl = STOP;
          if(size<fl){
            if(i<0){
              printf("-");
              flag = 1;
            }
            for(int k = size; k<fl; k++){
              printf("0");
            }
          }
          //Se o i for negativo, imprimir positivo
          if(flag == 1){
            printf(format,-1*i);
            flag = 0;
          }
          else printf(format,i);
        }
        //Se não for w mas for dec == 0;
        else printf(format,i);
      }
      //Caso seja decimal
      else printf(format,list->p,i);
      if(i + inc>=stop-0.000001) printf("%s",sep);
    }
  }
  else{
  //Positivo
    for(double i = first; i<stop+0.000001; i = i + inc){
      if(list->dec == 0){
        if(list->w == 1){
          size = sizenumber(i);
          if(FIRST>STOP) fl = FIRST;
          else fl = STOP;
          //Caso o tamanho seja inferior adicionar 0
          if(size<fl){
            if(i<0){
              printf("-");
              flag = 1;
            }
            for(int k = size; k<fl; k++){
              printf("0");
            }
          }
          //Se o i for negativo imprimir positivo
          if(flag == 1){
            printf(format,-1*i);
            flag = 0;
          }
          else printf(format,i);
        }
        //Se não for w mas for dec == 0
        else printf(format,i);
      }
      //Caso seja decimal 
      else printf(format,list->p,i);
      if(i + inc<=stop+0.000001) printf("%s",sep);
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

  if(argc == 2+list.nRead){ //Incrementar um de um até ao stop  
    if(list.dec == 0){
      stop = atoi(argv[list.nRead+1]);
    }
    else stop = atof(argv[list.nRead+1]);
    list.size[2] = list.size[0];
    list.size[1] = 1;
    list.size[0] = 1;   
  }

  else if(argc == list.nRead + 3){ //Incrementar 1 do first até ao stop
    if(list.dec == 0){
      first = atoi(argv[list.nRead+1]);
      stop = atoi(argv[list.nRead+2]);
    }

    else{
      first = atof(argv[list.nRead+1]);
      stop = atof(argv[list.nRead+2]);
    }
    list.size[2] = list.size[1];
    list.size[1] = 1;
  }

    else if(argc == list.nRead + 4) { //Incrementar inc do first até ao stop
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
      strcpy(format,"%.*f");
    }

    else if(list.dec == 0 && list.f != 1){
      strcpy(format, "%g");
    }
    if(first<0) list.size[0]--;
    if(inc<0) list.size[1]--;
    if(stop<0) list.size[2]--;
    print(&list,first,inc,stop,format,sep);
    return 0;
  }