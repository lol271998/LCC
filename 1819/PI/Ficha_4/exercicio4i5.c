#include <stdio.h>
int main(void)
{
    int n,i=1,s=0;
    printf("Introduza um valor: ");
    scanf("%d",&n);
    while (i<n)
    {
        if (n%i == 0)
        {
            s+=i;
            i++;
        }
        else
            i++;
    }
    printf("Soma dos divisores: ""%d\n",s);
}