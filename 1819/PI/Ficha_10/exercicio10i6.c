void store_zeros(int *vec, int n){
  int *p;
  for(p=vec;n>0;n--){
    *p = 0;
    p++;
  }
}
void store_zeros_1(int vec[], int n) {
int i;
  for(i = 0; i<n; i++) 
    vec[i] = 0;
}
int main(){
    int vec1[3]={1,2,3},vec2[3]={1,2,3};
    store_zeros_1(vec1, 3);
    store_zeros(&vec1,3);
}