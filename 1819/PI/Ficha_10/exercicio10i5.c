#include<stdio.h>
int mdc(int a, int b){
    int r;
    while(b != 0) {
        r = a%b;
        a = b;
        b = r;
    }
    return a;
}
void reduzir(int *pnum, int *pdenom){
    int r;
    r=mdc(*pnum,*pdenom);
    *pnum=*pnum/r;
    *pdenom=*pdenom/r;
}
int main(){
    int num,den;
    num=26;
    den=12;
    reduzir(&num,&den);
    printf("%d/%d \n",num,den);
}