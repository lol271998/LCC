// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao do TAD Ponto
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

public class TestPoint {
   public static void main(String[] args) {
      // E possivel chamar metodo estatico mesmo sem objectos criados
      Point.showNumPoints();   // Escreve npoints = 0

      Point p1 = new Point();      // p1 fica com (0,0)
      p1.show();
      Point p2 = new Point(42,13); // p2 fica com (42,13)
      p2.show();
      
      Point.showNumPoints();   // Escreve npoints = 2

      Point p3 = new Point(1,1);  // p3 fica com (1,1)
      Point p4 = new Point(1,1);  // p4 fica com (1,1)
      System.out.println(p3==p4); // escreve false, porque sao referências 
                                  // para objectos diferentes, embora tenham
                                  // o mesmo conteudo

      Point.showNumPoints();   // Escreve npoints = 4
   }
}
