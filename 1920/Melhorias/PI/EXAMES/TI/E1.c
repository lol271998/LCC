int isprime(int n){
  if(n<=1) return 0;
  int i = 2;
  if(n == 2) return 1;
  while(i<n){
    if(n%i==0) return 0;
    i++;
  }
  return 1;
}

int contar_primos(int a, int b){
  int count = 0;
  if(a>=b){
    a = maior;
    b = menor;
  }
  else{
    b = maior;
    a = menor;
  }
  for(int i = menor; i<=maior; i++){
    if(isprime(i) == 1) count++;
  }
  return count;
}

int main(void){
  return 0;
  contar_primos(2,1);
}
