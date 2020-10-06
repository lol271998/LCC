#include<stdio.h>


int filtrar_positivos(int vec[],int size){
  int i = 0;
  //Encontrar os valores positivos
  while(i<size){
    // printf("vec[%d] = %d\n",i,vec[i]);
    if(vec[i]<=0){ //Econtrou, passar todos os valores para trás
      for(int j = i; j<size; j++){
	vec[j] = vec[j+1];
      }
      size--; //Size fica menos 1
      i=0;
    }
    else i++;
  }
  return size;
}

int main(void){
  int vec[]={0,0,1};
  int size = filtrar_positivos(vec,3);
  for(int i = 0; i<size; i++){
    printf("%d",vec[i]);
  }
  printf("\n");
  return 0;
}
