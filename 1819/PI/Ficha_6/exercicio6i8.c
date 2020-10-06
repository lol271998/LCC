#include <stdio.h>

int repetidos(int vec[], int size)
{
    int i,c,d,vvec;
    i=0;
    d=0;
    for(i=0;(i<=size && d!=1);i++)
    {
      vvec=vec[i];
     for(c=i+1;c<size;c++)
     {
         if(vvec==vec[c])
         {
             d=1;
             break;
             
         }
         else
             d=0;
     }
    }    
    return d;
}
int main() //teste
{
 	int a[3] = {-1, -1, 0 };
	//int b[5] = { 3, 4, 1, 2, -1 };
	printf("%d\n", repetidos(a, 3)); // imprime 1
	//printf("%d\n", repetidos(b, 5)); // imprime 0
}