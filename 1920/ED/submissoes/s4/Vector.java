// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Implementa o TAD Vector
// Ultima alteracao: 10/03/2018
// -----------------------------------------------------------

public class Vector {
   // Atributos
   private double x, y;

   // Construtor
   Vector(double x0, double y0) {
      x = x0;
      y = y0;
   }

   //Conversao de um vector para String
   public String toString() {
      return "(" + x + "," + y + ")";
   }
   
   public Vector add(Vector v) {
      return new Vector(x + v.x, y + v.y);
   }

   public Vector sub(Vector v) {
      return new Vector(x - v.x, y - v.y);
   }

   public double magnitude() {
      return Math.sqrt(x*x + y*y);
   }

   public Vector scale(double c) {
      return new Vector(x*c,y*c);
   } 
}
