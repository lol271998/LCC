int ordenada(int vec[], int size)
{
    int i;
    for(i=0;i<size-1;i++){
        if(vec[i]>vec[i+1])
          return 0;
    }
    return 1;
}
int main(void){
  int vec[6]={-1,-2,1,4,2,3};
  ordenada(vec,6);
}