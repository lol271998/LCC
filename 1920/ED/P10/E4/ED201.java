import java.util.Scanner;

public class ED201{

   public static int sumf = 0;
   public static int sec;

   public static int sum(int[] v){
      int sum = 0;
      for(int i = 0; i<v.length; i++){
         sum +=v[i];
      }
      return sum;
   }

   static void sets(int v[]) {
      // array de booleanos para representar o conjunto
      boolean used[] = new boolean[v.length];
      goSets(0, v, used); // chamar funcao recursiva
   }

   static void goSets(int cur, int v[], boolean used[]) {
      int sum = 0;
      if (cur == v.length) {  // Caso base: terminamos o conjunto
         int[] vnum = new int[v.length];
         for (int i=0; i<v.length; i++) if (used[i]) sum+=v[i];
         if(sum>=sumf && sum<=sec) sumf = sum;
      } else {                  // Se nao terminamos, continuar a gerar
         used[cur] = true;      // Subconjuntos que incluem o elemento actual
         goSets(cur+1, v, used);// Chamada recursiva
         used[cur] = false;     // Subconjuntos que nao incluem o el. actual
         goSets(cur+1, v, used);// Chamada recursiva
      }
   }   
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);

      sec = in.nextInt();
      int n = in.nextInt();
      int[] v = new int[n];
      
      for(int i = 0; i<n; i++){
         v[i] = in.nextInt();
      }
      sets(v);
      System.out.println(sumf);
   }
}