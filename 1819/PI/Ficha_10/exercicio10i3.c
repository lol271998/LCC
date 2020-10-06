#include <stdio.h>
void decompor(int total_seg, int *horas, int *mins, int *segs){
    *horas=(total_seg)/(3600);
    *mins=(total_seg)/(60);
    *segs=total_seg;
    
}
int main (){
    int h,m,s;
    decompor(3600,&h,&m,&s);
    printf("%d %d %d \n",h,m,s);
}