#include <stdio.h>
#include <ctype.h>
#include <string.h>
int forte(char str[])
{
    int i,r,r1,r2,r3,rf;
    if (strlen(str)>=6)
    {
    for(i=0;str[i]!='\0';i++)
    {
    if (isalpha(str[i])) r=1;
    if (isupper(str[i])) r1=1;
    if (islower(str[i])) r2=1;
    if (isdigit(str[i])) r3=1;
    }
    rf=r+r1+r2+r3;
    if (rf!=4)
        rf=0;
    else
        rf=1;
    }
    else
    rf=0;
    return rf;

}
int main()
{
    forte("ABCdef00");
}
