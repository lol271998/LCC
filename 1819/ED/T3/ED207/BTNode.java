// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// No de uma arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class BTNode<T> {
   private T value;         // Valor guardado no no
   private BTNode<T> left;  // Filho esquerdo
   private BTNode<T> right; // Filho direito

   // Construtor
   BTNode(T v, BTNode<T> l, BTNode<T> r) {
      value = v;
      left = l;
      right = r;
   }

   // Getters e Setters
   public T getValue() {return value;}
   public BTNode<T> getLeft() {return left;}
   public BTNode<T> getRight() {return right;}
   public void setValue(T v) {value = v;}
   public void setLeft(BTNode<T> l) {left = l;}
   public void setRight(BTNode<T> r) {right = r;}   
}
