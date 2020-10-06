/*Escreva uma função int filtrar_positivos(int vec[], int size) que remove
os valores não positivos (isto é, negativos ou zero) de um vector vec com tamanho size.
A função deve modificar a variável indexada dada de forma a que os valores positivos
fiquem num segmento inicial do vetor. O resultado deve ser o número de valores positivos
(i.e. o comprimento do segmento final).
Sugestão: pode utilizar uma técnica análoga à usada na função para eliminar repetidos
apresentada na aula teórica 15*/
int filtrar_positivos(int vec[], int size)
{
 int j, k = 0;
   for(j = 0; j < size; j++) {
      int val = vec[j];
      if (val > 0){
         vec[k++] = val;
            }
   }  
   return k;
}