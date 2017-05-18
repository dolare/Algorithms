/**
 * Created by RuiY on 2017/5/11.
 */
public class LC51NQueen {


    private static final int n = 8;
    private static int count = 0;
    private static int[] sol;
    private static boolean[] shu,pie,na;

    public static void main (String[] args) throws java.lang.Exception
    {
        sol = new int[n];
        shu = new boolean[n];
        pie = new boolean[2 * n - 1];
        na = new boolean[2 * n - 1];
        long timeStamp1 = System.currentTimeMillis();
        DFS(0);
        System.out.println("Total solutions: " + count);
        long timeStamp2 = System.currentTimeMillis();
        System.out.print("Time use: " + (timeStamp2 - timeStamp1) + " ms");
    }

    private static void DFS(int row){
        for(int col = 0; col < n;col++){
            if(shu[col] || pie[row + col] || na[n - 1 + col - row]){
                continue;
            }
            sol[row] = col;
            if(row == n - 1){
                count++;
                //print();
            }else{
                shu[col] = true;
                pie[row + col] = true;
                na[n - 1 + col - row] = true;
                DFS(row + 1);
                shu[col] = false;
                pie[row + col] = false;
                na[n - 1 + col - row] = false;
            }
        }
    }

    private static void print(){
        System.out.print("Solution: " + count + ":");
        for(int n : sol){
            System.out.print(" " + n);
        }
        System.out.println();
    }
}
