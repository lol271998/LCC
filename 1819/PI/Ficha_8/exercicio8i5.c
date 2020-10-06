void select_sort(int vec[], int n) {
  int i, j;
  for(i = 0; i < n; i++) {
    int imax = i; // índice inicial do mínimo
    for(j = i+1; j < n; j++) {
      if(vec[j] > vec[imax]) imax = j;
    }
    // trocar o mínimo com vec[i]
    if(imax != i) {
      int temp = vec[i];
      vec[i] = vec[imax];
      vec[imax] = temp;
    }
  }
}

int main(){
  int vec[6]={1,2,3,4,5,6};
  select_sort(vec,6);
}