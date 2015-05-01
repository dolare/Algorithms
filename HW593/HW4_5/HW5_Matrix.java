import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class HW5_Matrix {
	
	String[] numbersArray0;
	
	
	public static void main(String[] args){
		 int caseNumber;
		 JFileChooser chooser = new JFileChooser();
		 String filePath = null;
		 HW5_Matrix hw5 =  new HW5_Matrix(); 
		 
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "TXT & DAT TYPE", "txt", "dat");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	filePath =  chooser.getSelectedFile().getPath();
		       System.out.println("You chose to open this file: " +
		          filePath);
		    }

		    try {
				hw5.readFile(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String[] numbersArray = hw5.numbersArray0;
		    
		    caseNumber = Integer.parseInt(numbersArray[2]); 
		    int count = 3;
		    int num = 1;
		    
		    //deal with every case
		    while(caseNumber != 0){
			    double[][] con1;
				double[][] con2;
				double[][] vector;
				int row;
				int column;
	
				row = Integer.parseInt(numbersArray[count++]);
			    column = Integer.parseInt(numbersArray[count++]);
			 	
			   
			    con1 = new double[row][column];
			    con2 = new double[row][column];
			    
			    //get matrix A
			    for(int i = 0;i < row;i++){
			    	for(int j = 0;j < column;j++){
			    		con1[i][j] = Double.parseDouble(numbersArray[count++]);
			    		//System.out.print(con1[i][j] + " ");
			    	}
			    	//System.out.println();
			    }
			    
			  //get matrix B
			    for(int i = 0;i < row;i++){
			    	for(int j = 0;j < column;j++){
			    		con2[i][j] = Double.parseDouble(numbersArray[count++]);
			    		//System.out.print(con2[i][j] + " ");
			    	}
			    	//System.out.println();
			    }
			  //get vector C
			    vector = new double[row][1];
			    for(int i = 0;i < column;i++){
			    	vector[i][0] = Double.parseDouble(numbersArray[count++]);
			    }
			    
			    
			    //print output
			    System.out.println("The case " + num + " output should be:    ");
			    Matrix A = new Matrix(con1);
			    Matrix B = new Matrix(con2);
			    Matrix C = new Matrix(vector);
			    
			    Matrix output1 = A.plus(B);
			    Matrix output2 = A.times(B);
			    Matrix output3 = A.solve(C);
			    
			    output1.show();  
			    output2.show();  
			    for (int i = 0; i < output3.M; i++) 
	               System.out.printf("%9.4f ",output3.data[i][0]);	
			    
			    System.out.println();
			    caseNumber--;
			    num++;
		    }
		    
	}
		
	//read A B,C from file
	public  void readFile(String filePath) throws IOException{
		    BufferedReader in = null;
		
			in = new BufferedReader(new FileReader(filePath));

			String textLine = "";
			String str = "";
			
			while(( textLine =in.readLine())!=null){
			    str += " "+ textLine;
			 }
			 numbersArray0=str.split("\\s{1,}");
		
		    //close the file
		    in.close();
	}
}

class Matrix {
     final int M;             // number of rows
     final int N;             // number of columns
     final double[][] data;   // M-by-N array

    // create M-by-N matrix of 0's
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }

    // create matrix based on 2d array
    public Matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                    this.data[i][j] = data[i][j];
    }

    // copy constructor
    private Matrix(Matrix A) { this(A.data); }

    // create and return a random M-by-N matrix with values between 0 and 1
    public static Matrix random(int M, int N) {
        Matrix A = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[i][j] = Math.random();
        return A;
    }

    // create and return the N-by-N identity matrix
    public static Matrix identity(int N) {
        Matrix I = new Matrix(N, N);
        for (int i = 0; i < N; i++)
            I.data[i][i] = 1;
        return I;
    }

    // swap rows i and j
    private void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // create and return the transpose of the invoking matrix
    public Matrix transpose() {
        Matrix A = new Matrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    // return C = A + B
    public Matrix plus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }


    // return C = A - B
    public Matrix minus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
    }

    // does A = B exactly?
    public boolean eq(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (A.data[i][j] != B.data[i][j]) return false;
        return true;
    }

    // return C = A * B
    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }


    // return x = A^-1 b, assuming A is square and has full rank
    public Matrix solve(Matrix rhs) {
        if (M != N || rhs.M != N || rhs.N != 1)
            throw new RuntimeException("Illegal matrix dimensions.");

        // create copies of the data
        Matrix A = new Matrix(this);
        Matrix b = new Matrix(rhs);

        // Gaussian elimination with partial pivoting
        for (int i = 0; i < N; i++) {

            // find pivot row and swap
            int max = i;
            for (int j = i + 1; j < N; j++)
                if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i]))
                    max = j;
            A.swap(i, max);
            b.swap(i, max);

            // singular
            if (A.data[i][i] == 0.0) throw new RuntimeException("Matrix is singular.");

            // pivot within b
            for (int j = i + 1; j < N; j++)
                b.data[j][0] -= b.data[i][0] * A.data[j][i] / A.data[i][i];

            // pivot within A
            for (int j = i + 1; j < N; j++) {
                double m = A.data[j][i] / A.data[i][i];
                for (int k = i+1; k < N; k++) {
                    A.data[j][k] -= A.data[i][k] * m;
                }
                A.data[j][i] = 0.0;
            }
        }

        // back substitution
        Matrix x = new Matrix(N, 1);
        for (int j = N - 1; j >= 0; j--) {
            double t = 0.0;
            for (int k = j + 1; k < N; k++)
                t += A.data[j][k] * x.data[k][0];
            x.data[j][0] = (b.data[j][0] - t) / A.data[j][j];
        }
        return x;
   
    }

    // print matrix to standard output
    public void show() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) 
                System.out.printf("%9.4f ", data[i][j]);
            System.out.println();
        }
    }
}


