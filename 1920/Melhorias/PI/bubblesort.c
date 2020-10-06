void bubblesort(int vec[], int n){
  for(int i = 1; i<n; i++){
    if(vec[i-1] > vec[i]){
      int temp = vec[i];
      vec[i] = vec[i-1];
      vec[i-1] = temp;
      i=0;
    }
  }
}

int main(void){return 0;}
