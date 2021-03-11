// Codigo inicial para o problema [DAA 022] Arvores Red-Black
// Pedro Ribeiro (DCC/FCUP)

// Para a função isBST usei o código do site https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

import java.util.Scanner;

// Estrutura para representar um no da arvore
class Node {
    boolean isBlack;  // No preto?
    boolean isNull;   // No nulo?
    int value;        // Valor
    Node left, right; // Filhos

    Node(int v) {
		isNull  = (v==0);
		isBlack = (v>=0);
		value   = Math.abs(v);
    }
}

public class daa022 {

    // Ler input em preorder
    static Node readPreOrder(Scanner in) {
		int v = in.nextInt();
		Node aux = new Node(v);
		if (v!=0) {
		    aux.left  = readPreOrder(in);
		    aux.right = readPreOrder(in);
		}
		return aux;
    }

    // Menor valor da arvore
    static int minimum(Node t) {
		if (t.isNull) return Integer.MAX_VALUE;
		int minLeft  = minimum(t.left);
		int minRight = minimum(t.right);
		return Math.min(t.value, Math.min(minLeft, minRight));
    }

    // Maior valor da arvore
    static int maximum(Node t) {
		if (t.isNull) return Integer.MIN_VALUE;
		int minLeft  = maximum(t.left);
		int minRight = maximum(t.right);
		return Math.max(t.value, Math.max(minLeft, minRight));
    }

    // Quantidade de nos (internos)
    static int size(Node t) {
		if (t.isNull) return 0;
		return 1 + size(t.left) + size(t.right);
    }

    // Condição ser binary search tree
    static boolean isBST(Node t){
    	return isBST(t,minimum(t),maximum(t));
    }

    static boolean isBST(Node t, int min, int max){
    	if(t.isNull) return true;
    	if(t.value < min || t.value > max) return false;
    	return isBST(t.left,min,t.value) && isBST(t.right,t.value,max);
    }

    // Condição de ter a root Black
    static boolean isRoot(Node t){
  		if(t.isBlack) return true;
  		else return false;
    }

    // Condição de que todos os filhos de nós RED são BLACKS
    static boolean isRed(Node t){
    	if(t.isNull) return true;
    	if(!(t.isBlack) && (!(t.left.isBlack))) return false;
    	if(!(t.isBlack) && (!(t.right.isBlack))) return false;
    	return isRed(t.left) && isRed(t.right);
    }

    // Condição de black property
    static boolean isBlack(Node t){
    	Node temp = t;
    	int bh = 0;
    	while(!(temp.isNull)){
    		if(temp.isBlack) bh++;
    		temp = temp.left;
    	}
    	//System.out.println(bh);
    	return isBlack(t,bh,0);
    }

    static boolean isBlack(Node t, int bh, int bs){
    	if(t.isNull && bs != bh) return false;
    	if(t.isNull && bs == bh) return true;
    	if((t.isBlack && !t.left.isNull) || (t.isBlack && !t.right.isNull) || (t.isBlack && t.left.isNull && t.right.isNull)) bs++;
    	//System.out.println("t: "+t.value+" bs: "+ bs + " bh: "+bh);
    	return isBlack(t.left,bh,bs) && isBlack(t.right,bh,bs);
    }

    // ---------------------------------------------------
    
    public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
	
		int n =  in.nextInt();
		for (int i=0; i<n; i++) {
		    Node root = readPreOrder(in);
		    
		    //System.out.printf("Tree with %d nodes (min=%d, max=%d)\n", size(root), minimum(root), maximum(root));
		    /*
		    System.out.println("isRoot: "+(root.isBlack));
		    System.out.println("isBST: "+isBST(root,root));
		    System.out.println("isRed: "+isRed(root));
		    System.out.println("isBlack: "+isBlack(root));
		    */
		    if(isBST(root) && isRed(root) && root.isBlack && isBlack(root)) System.out.println("SIM");
		    else System.out.println("NAO");
		}	
   	}
}