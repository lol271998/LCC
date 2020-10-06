#include<stdio.h>
#include<string.h>

typedef struct Fraction{

  int sinal;
  int num;
  int den;
  int erro;
  
}FRAC;

//Retorna o argumento simplificado
FRAC simp(FRAC f){
  int a,b,r;
  a = f.num;
  b = f.den;
  while (b != 0){
    r = a % b;
    a = b;
    b = r;
  }
  
  f.den = f.den/a;
  f.num = f.num/a;
  return f;
}

//Retorna a soma dos dois argumentos
FRAC soma(FRAC f1, FRAC f2){
  FRAC fs = {0,0,0,0};
  fs.den = f1.den*f2.den;
  fs.num = (f1.sinal*(f1.num*f2.den)) + (f2.sinal*(f2.num*f1.den));
  return simp(fs);
}

//Retorna a subtração dos dois argumentos
FRAC sub(FRAC f1, FRAC f2){ 
  return f1;
}

//Retorna a multiplicação dos dois argumentos
FRAC mult(FRAC f1, FRAC f2){
  return f1;
}

//Retorna a divisão dos dois argumentos
FRAC div(FRAC f1, FRAC f2){
  return f1;
}

void msinal(FRAC f){
  if(f.den > 0 && f.num > 0) f.sinal = 1;
  else{
    f.sinal = -1;
    if(f.den<0) f.den*=-1;
    else if(f.num<0) f.num*=-1;
  }
}

void print(FRAC f){
  if(f.erro != 0) printf("ERRO");
  if(f.sinal == -1) printf("-");
  printf("%d/",f.num);
  printf("%d\n",f.den);
}

int main(void){

  FRAC f1 = {0,0,0,0};
  FRAC f2 = {0,0,0,0};

  printf("Numerador1: ");
  scanf("%d", &f1.num);
  printf("Denominador1: ");
  scanf("%d", &f1.den);
  msinal(f1);

  printf("Numerador2: ");
  scanf("%d", &f2.num);
  printf("Denominador2: ");
  scanf("%d", &f2.den);
  msinal(f2);

  print(simp(f1));
  print(simp(f2));
  print(soma(f1,f2));
  
  return 0;
}

