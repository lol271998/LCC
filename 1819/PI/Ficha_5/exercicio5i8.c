double serie_log(double x, int n) 
{
   int i;
   double num,par,soma;
   num=-1;
   par=0;
   soma=0;
   for(i=1;i<=n;i++)
   {
   num=(num*-x);
   par= num/i;
   soma+=par;
    }
    return soma;
}
