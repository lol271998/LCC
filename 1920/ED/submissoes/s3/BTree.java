/*
Nome: Filipe Colla David
Número mecanográfico: 201810097

Sobre ajudas: Utilizei alguns sites para perceber melhor o funcionamento de recursão, e o funcionamento de árvores,
revi, inclusivé, as aulas sobre recursão e árvores do professor. No entanto cheguei à minha solução com tentativa erro.

Explicação da solução:
- public int internal() -> Para este método utilizei um método recursivo. O caso base devolve 0 quando n é ou null
ou quando ambos os seus filhos são null. No caso recursivo, com o uso de duas condiões, caso o filho de um dos lados
fosse diferente de null, somava um, e continuava a pesquivar a arvore pelo filho não nulo. Caso fossem os dois filhos
fossem diferentes de null, somo 1, e continuo continuo a pesquisa pelos dois lados da arvóre.

- public void cut(int d) -> Para este método utilizei também um método recursivo onde com o uso de uma variavel, comparo
a profundidade dada e o nivel a que estamos.
Caso a profundidade for inferior ou igual a 0, a arvore fica vazia, logo a root fica igual a null. 
Para o caso base deste método, a função termina se a profundidade for inferior ao nó em que nos encontramos ou o nó for 
null.
Se nos encontrarmos no nivel d, mudamos o valor de cada filho para null, caso contrário fazemos cut e aumentamos o nivel
em que nos encontramos.

public int[] maxLevel() -> Para este método, criei um vetor a, que é o resultado do método, e outro vetor k com o 
tamanho da árvore. O vetor k serve para armazenar quantos nós tem cada nivel. 
O algoritmo vai percorrendo as arvores da esquerda, e caso não seja null incrementa o respectivo nivel, e depois 
percorre as arvores da direita analogamente. Sempre que chega a um novo nivel, compara esse nivel com o a[0],
e caso seja superior, substitui-se o a[0] pelo nivel, e a[1] fica = 1 caso o valor do nivel for igual ao valor 
armazenado em a[0], incrementa-se o a[1] pois significa que existe outro nivel com um máximo numero de nós.  
*/
	

public class BTree<T> {   
    private BTNode<T> root; // raiz da arvore

    // Construtor
    BTree() {root = null;}

    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}

    // Verificar se arvore esta vazia
    public boolean isEmpty() {return root == null;}

    // --------------------------------------------------------

    // Numero de nos da arvore   
    public int numberNodes() {return numberNodes(root);}

    private int numberNodes(BTNode<T> n) {
    	if (n == null) return 0;
    	return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------

    // Altura da arvore
    public int depth() {return depth(root);}

    private int depth(BTNode<T> n) {
    	if (n == null) return -1;
    	return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------

    // O elemento value esta contido na arvore?
    public boolean contains(T value){
    	return contains(root, value);
    }

    private boolean contains(BTNode<T> n, T value) {
    	if (n==null) return false;
    	if (n.getValue().equals(value)) return true;
    	return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

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
    /*
    public int[] maxLevel(){
    	int[] a = new int[]{0,0};
    	int n = this.depth();
    	for(int i = 0; i<level; i++){
    		int m = this.max(i);
    		if(m>a[0]){
    			a[0] = m;
    			a[1] = 1;
    		}
    		else if(m == a[0]) a[1]++;
    	}
    	return a;
    }*/

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

    //---------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
    	System.out.print("PreOrder:");
    	printPreOrder(root);
    	System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
    	if (n==null){
    		//System.out.print(" N");
    		return;
    	}
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
