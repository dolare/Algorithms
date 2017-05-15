
public class LC51NQueen {
	private static final int n = 14;
	private static int[] solution;
	private static int count = 0;
	
	public static void main(String[] args) {
		solution = new int[n];
		long start = System.currentTimeMillis();
		DFS(0);
		long end = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Time: " + ( end - start) + " ms");
	}
	
	
	public static void DFS(int row){
		for(int col = 0;col < n;col++){
			boolean ok = true;
			for(int i = 0;i < row;i++){
				if(col == solution[i] || row - i == solution[i] - col || row - i == col - solution[i]){
					ok = false;break;
				}
			}
			
			if(!ok){
				continue;
			}
			solution[row] = col;
			if(row == n - 1){
				count++;
				//print();
			}else{
				DFS(row + 1);
			}			
		}
	}
}
