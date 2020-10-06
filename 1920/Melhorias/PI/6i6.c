#include<stdio.h>

#define N 1000

int ocorre(int vec[], int size, int val){
  for(int i = 0; i<size; i++){
    if(vec[i] == val){
      return 1;
    } 
  }
    return 0;
}

int main(void){
  int size,res,num,i;
  int vec[N];
  size = 0;
  do{
    scanf("%d",&num);
    //printf("leu o numero %d \n",num);
    res =  ocorre(vec,size,num);
    //printf("res = %d\n",res);   
    if(res == 0 && num!=-1){
      vec[size] = num;
      //printf("vec[%d]: %d\n",size,vec[size]);
      size++;
    }
  }while(num!=-1);
  printf("{");
  for(i = 0; i<size-1; i++) printf("%d,",vec[i]);
  printf("%d}\n",vec[i]);
  return 0;
}
