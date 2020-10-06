public class TestSet {
   public static void main(String[] args) {
      
      IntSet s = new BooleanArrayIntSet(100); // Chama o construtor padrão;

      s.clear();
      System.out.println("0: " + s.size());      // Escreve "0"
      
      System.out.println("True: " + s.add(1));      // Escreve "true"
      System.out.println("True: " + s.add(5));      // Escreve "true"
      System.out.println("True: " + s.add(7));      // Escreve "true"
      System.out.println("False: " + s.add(1));      // Escreve "false"
      System.out.println("Size: 3 == " + s.size());      // Escreve "3

      System.out.println("True: " + s.remove(5));   // Escreve "true"
      System.out.println("False: " + s.remove(5));   // Escreve "false"
      System.out.println("Size: 2 == " + s.size());      // Escreve "2"

      System.out.println("True: " + s.contains(1)); // Escreve "true"
      System.out.println("False: "+ s.contains(2)); // Escreve "false"

      s.clear();
      System.out.println("Size: 0 ==  " + s.size());      // Escreve "0"*/
   }
}
