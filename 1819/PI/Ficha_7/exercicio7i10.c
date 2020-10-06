int filtrar_positivos(int vec[], int size)
{
    int i,c,in=0;
    for(i=0;i<=size;i++)
    {
        if(vec[i]<0)
        {
            vec[i]=vec[size+1];
            vec[in]=vec[i];
            vec[size+1]=vec[i+1];
            c++;
            in++;
        }
    in++;
    }
return c;
}
int main()
{
    int vec[]={1,2,3,-6,-8,-10,1,2,3,4};
    filtrar_positivos(vec,9);
}