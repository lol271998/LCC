void select_sort(int vec[], int n) {
  int i, j;
  for(i = 0; i < n; i++) {
    int imin = i; // índice inicial do mínimo
    for(j = i+1; j < n; j++) {
      if(vec[j] < vec[imin]) imin = j;
    }
    // trocar o mínimo com vec[i]
    if(imin != i) {
      int temp = vec[i];
      vec[i] = vec[imin];
      vec[imin] = temp;
    }
  }
}
int main(){
	int vec[7]={1,2,3,4,5,-1,-2};
	select_sort(vec,7);
}