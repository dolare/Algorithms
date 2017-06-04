package UnionFind;

/**
 * Created by Dolare on 2017/5/22.
 */
public class LC547FriendCircles {
    public static void  main(String[] args){
        int[][] matrix1 = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] matrix2 = {{1,1,0},{1,1,1},{0,1,1}};

        long start = System.currentTimeMillis();
        System.out.println(findCirCleNum(matrix1));
        System.out.println(findCirCleNum(matrix2));
        long end = System.currentTimeMillis();
        System.out.print((end - start) + " ms");
    }
    public static int findCirCleNum(int[][] M){
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        //the matrix must be symmetrical by diagonal
        for(int i = 0;i < n - 1;i++){
            for(int j = i + 1;j < n;j++){
                if(M[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }
}


class UnionFind{
    private int count = 0;
    //rank is not nessceray to define
    private int[] parent,rank;

    public UnionFind(int n){
        count = n;
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i < n;i++){
            parent[i] = i;
        }
    }

    public int findRoot(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p,int q){
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        //if they are in a same union
        if(rootP == rootQ){
            return;
        }
        if(rank[rootQ] > rank[rootP]){
            parent[rootP] = rootQ;
        }else{
            parent[rootQ] = rootP;
            if(rank[rootP] == rank[rootQ]){
                rank[rootP]++;
            }
        }
        count--;
    }

    public int count(){
        return count;
    }
}
