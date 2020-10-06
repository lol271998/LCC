// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class BTree<T> {   
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
   	root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
   	return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
   	return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
   	if (n == null) return 0;
   	return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
   	return depth(root);
   }

   private int depth(BTNode<T> n) {
   	if (n == null) return -1;
   	return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------

   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
   	return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
   	if (n==null) return false;
   	if (n.getValue().equals(value)) return true;
   	return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   //ED204 - Contar o numero de folhas.
   public int numberLeafs(){
   	return numberLeafs(root);
   }

   private int numberLeafs(BTNode<T> n){
		if(n == null) return 0; //Caso Base
		if(n.getRight() == null && n.getLeft() == null) return 1;
		else{
			return numberLeafs(n.getRight()) + numberLeafs(n.getLeft());
		}
	}

   //ED205 - Verificar se a arvore é estritamente binária.
	public boolean strict(){
		return strict(root);
	}	

	private boolean strict(BTNode<T> n){
		if(n == null) return true; //Caso base
		if((n.getRight() != null && n.getLeft() != null )|| (n.getRight() == null && n.getLeft() == null)){
			return strict(n.getRight()) && strict(n.getLeft());
		}
		else return false;
	}

   /*ED206 - Devolve o valor guardado no caminho indicado pela string s.
	public T path(String s){
		return path(root,s);
	}

	private T path(BTNode n, String s){
		if(s.length() == 1){
			if(s.charAt(0) == 'D'){
				return n.getRight().getValue();
			}
			else{
				return n.getLeft().getValue();
			}
		}
		if(s.charAt(0) == 'D'){
			s = s.substring(1);
			return path(n.getRight(),s);
		}
		else{
			s = s.substring(1);
			return path(n.getLeft(),s);
		}
	}*/
 	// --------------------------------------------------------

    //Devolve a quantidade de nós internos da árvore.
	public int internal(){
		return internal(root);
	}

	public int internal(BTNode<T> n){
		if(n == null || (n.getRight() == null && n.getLeft() == null)) return 0;
		else if(n.getRight() != null && n.getLeft() == null) return 1 + internal(n.getRight());
		else if(n.getLeft() != null && n.getRight() == null) return 1 + internal(n.getLeft());
		return 1 + internal(n.getLeft()) + internal(n.getRight());
	}

    // --------------------------------------------------------

    //Remover da árvore todos os nós com profundidade ≥d
	public void cut(int d){
		cut(root,d,1);
	}

	public void cut(BTNode<T> n, int d, int cur){
		if(d<=0) root = null;
		if(n == null || d<cur) return;
		if(d == cur){
			n.setLeft(null);
			n.setRight(null);

		}
		cut(n.getRight(),d,cur+1);
		cut(n.getLeft(),d,cur+1);

	}

    //---------------------------------------------------------

    /*Devolver um array [a,b] onde a é a quantidade máxima de nós num 
      único nível de profundidade, e b é a quantidade
      de níveis com essa quantidade a de nós.*/

    //int level = -1;
      public int[] maxLevel(){
      	int[] a = new int[]{0,0};
      	int[] k = new int[this.depth()+1]; 
      	maxLevel(root,-1,0,k,a);
      	return a;
      }

      private int maxLevel(BTNode<T> n,int level,int cur, int[] k,int[] a){
      	if(n == null || cur == level) return 0;
      	k[level+1]++;
      	if(k[level+1]>a[0]){ 
      		a[0] = k[level+1];
      		a[1] = 1;
      	}
      	else if(k[level+1] == a[0]) a[1]++;
      	level++;
    	//System.out.println("Nodes at level ("+(level+1)+")");
      	return maxLevel(n.getLeft(),level,cur+1,k,a) + maxLevel(n.getRight(),level,cur+1,k,a);
      }

      public int count(){
      	return count(root);
      }

      private int count(BTNode<T> n){
      	if(n == null) return 0;
      	if((n.getLeft()!=null && n.getRight()==null)||(n.getLeft() == null && n.getRight() != null)){
      		return 1 + count(n.getLeft()) + count(n.getRight());
      	}
      	else return count(n.getLeft()) + count(n.getRight());
      }

      int levelmin;
      public int level(T v){
      	if(!contains(v)) return -1;
      	else{
      		levelmin = this.depth();
      		level(root,v,0);
      		return levelmin;
      	}
      }

      private void level(BTNode<T> n, T v, int cur){
      	if(n == null)return;
      	if(n.getValue().equals(v)){
      		//System.out.println(n.getValue()+" "+v+" "+cur+" "+levelmin);
      		if(cur<=levelmin){
      			levelmin = cur;
      		}
      	}
      	level(n.getRight(),v,cur+1);
      	level(n.getLeft(),v,cur+1);
      }



    // --------------------------------------------------------

    // Imprimir arvore em PreOrder
      public void printPreOrder() {
      	System.out.print("PreOrder:");
      	printPreOrder(root);
      	System.out.println();
      }

      private void printPreOrder(BTNode<T> n) {
      	if (n==null) return;
      	System.out.print(" " + n.getValue() );
      	printPreOrder(n.getLeft());
      	printPreOrder(n.getRight());
      }

    // --------------------------------------------------------

    // Imprimir arvore em InOrder
      public void printInOrder() {
      	System.out.print("InOrder:");
      	printInOrder(root);
      	System.out.println();
      }

      private void printInOrder(BTNode<T> n) {
      	if (n==null) return;
      	printInOrder(n.getLeft());
      	System.out.print(" " + n.getValue());
      	printInOrder(n.getRight());
      }

    // --------------------------------------------------------

    // Imprimir arvore em PostOrder
      public void printPostOrder() {
      	System.out.print("PostOrder:");
      	printPostOrder(root);
      	System.out.println();
      }

      private void printPostOrder(BTNode<T> n) {
      	if (n==null) return;
      	printPostOrder(n.getLeft());
      	printPostOrder(n.getRight());
      	System.out.print(" " + n.getValue());
      }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Fila)
      public void printBFS() {
      	System.out.print("BFS:");

      	MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      	q.enqueue(root);
      	while (!q.isEmpty()) {
      		BTNode<T> cur = q.dequeue();
      		if (cur != null) {
      			System.out.print(" " + cur.getValue());
      			q.enqueue(cur.getLeft());
      			q.enqueue(cur.getRight());
      		}
      	}
      	System.out.println();
      }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
      public void printDFS() {
      	System.out.print("DFS:");

      	MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      	q.push(root);
      	while (!q.isEmpty()) {
      		BTNode<T> cur = q.pop();
      		if (cur != null) {
      			System.out.print(" " + cur.getValue());
      			q.push(cur.getLeft());
      			q.push(cur.getRight());
      		}
      	}
      	System.out.println();
      }

   }
