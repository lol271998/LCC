// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Conversao entre varios tipos de variaveis
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

class TestConversion {
   public static void main(String[] args) {
      double d1 = 3.2;
      double d2 = 3.999999;
      
      // Casting explicito      
      int    i1 = (int)d1;    // i1 fica com o valor de 3
      int    i2 = (int)d2;    // i2 fica com o valor de 3
      double d3 = (double)i2; // d3 fica com o valor de 3.0
      
      // Casting implicito
      int    i3 = 42;
      double d4 = i3;         // d4 fica com o valor de 42.0
      //     int    i4 = d4;         // erro de compilacao: "possible loss of precision

      char  ch1 = 'A';
      int    i5 = ch1;        // i5 fica com o valor de 65 (codigo ascii de 'A')
      char  ch2 = 66;         // ch2 fica com o valor de 'B' (codigo ASCII 66)

      //      boolean b1 = i1;        // erro de compilacao: "incompatible types"           
   }
}
