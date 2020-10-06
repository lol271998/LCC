#include<stdio.h>
#include<assert.h>
int isprime(int n){
  for(int i = 2; i<n; i++){
    if(n%i == 0){
      printf("%d %% %d = %d\n",n,i,n%i);
      return 0;
    }
  }
  return 1;
}

int proximo_primo(int n){
  //printf("proximo_primo\n");
  if(n <= 1) return 2;
  else{
    n++;
    while(isprime(n)!=1){
      n++;
      printf("n = %d\n",n);
    }
    return n;
  }
}

int main(void){
  //printf("%d\n",proximo_primo(2));
  assert(proximo_primo(0) == 2);
  assert(proximo_primo(1) == 2);
  assert(proximo_primo(2) == 3);
  assert(proximo_primo(3) == 5);
  assert(proximo_primo(5) == 7);
  assert(proximo_primo(7) == 11);
  assert(proximo_primo(11)== 13);
  assert(proximo_primo(13) == 17);
  assert(proximo_primo(37) == 41);
  
  return 0;
}
