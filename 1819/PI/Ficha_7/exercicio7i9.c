int contar_maiores(int vec[], int size, int val)
{
    int i,c=0,num;
    for(i=0;i<=size;i++)
    {
        num=vec[i];
        if(num<val)
            c++;
        else
            continue;
    }
    printf("%d\n",c);
}
int main()
{
    int vec[]={1,2,3,4,5,6,7};
    contar_maiores(vec,6,8);
}