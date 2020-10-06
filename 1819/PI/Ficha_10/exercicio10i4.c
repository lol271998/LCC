void max_min(int vec[], int size, int *pmax, int *pmin)
{
  int i;
    *pmax=vec[0];
    *pmin=vec[0];
    for(i=0;i<size;i++){
      if(vec[i]>*pmax){
        *pmax=vec[i];
      }
      if(vec[i]<*pmin){
        *pmin=vec[i];
      } 
    }
}