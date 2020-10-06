#include<stdio.h>
#include<stdlib.h>
#define N 25

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
int random_1 (void)
{
	int a;
      a = 1 + (int)((double)rand() /((double)RAND_MAX+1)*365);
      return a;
}

int main()
{
	int i,c=0,vec[N];
	for(i=0;i<=N;i++)
	{
		vec[i]= random_1();
		repetidos(vec,N);
	 if (repetidos(vec,N)==1)
	 	c++;
	 else
	 	break;
	}
	printf("%d\n",c);
}
