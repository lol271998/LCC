
// Pedro Ribeiro (DCC/FCUP)
// [ED213] Caminho de maior soma
 
class ED213 {
    static String best_path;
    static int best_sum;
   
    public static String maxSum(BTree<Integer> t) {
        
        best_sum = -1; best_path = "";
        maxSum(t.getRoot(), "", 0);
        
        return best_path;
    }
 
    private static void maxSum(BTNode<Integer> n, String path, int sum) {
        if (n==null) return;
        sum += n.getValue();
        if (n.getLeft()==null && n.getRight()==null) {
            if (sum > best_sum) {
                best_sum  = sum;
                best_path = path;
            }
        } else {
            maxSum(n.getLeft(), path + "E", sum);
            maxSum(n.getRight(), path + "D", sum);
        }
    }
}