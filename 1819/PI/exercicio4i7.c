#include <stdio.h>
int main(void)
{
    int n;
    if (n%4 == 0 && n%100!= 0)
      return n;
    else
    {
        while ((n%4!=0)||(n%100 ==0)&&(n%400!=0))
            n++;
      return n;
    }
}