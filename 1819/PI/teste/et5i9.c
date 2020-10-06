#include <stdio.h>
double aprox_pi(int n){
    int i=0,resp=-1;
    double a,res=0.0;
    while(i<=n){
        resp=resp*(-1);
        a=2*i+1;
        res=res+(resp/a);
        i++;
    }
    return 4*res;
}
int main(void){
    double pi;
    pi=aprox_pi(10000000);
    printf("%f\n",pi);
}