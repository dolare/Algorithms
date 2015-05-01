import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



public class HW2bQ_GaussQuadrature {
	final static double cons2=1/Math.sqrt(3);
	final static double cons3=Math.sqrt(3.0/5.0);
	final static double weight2=1;
	final static double weight3_0=8.0/9.0;
	final static double weight3_1=5.0/9.0;
	static String[] fx ;
	static double[] start;
	static double[] end;
	static double[] prec;

	public static void main(String[] args){
		JFileChooser chooser = new JFileChooser();
		String filePath = null;
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
			new HW2bQ_GaussQuadrature().readFile(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<fx.length;i++){
			System.out.println(fx[i]);
			gauss2(fx[i],start[i],end[i],prec[i],0,1);
			gauss3(fx[i],start[i],end[i],prec[i],0,1);	
		}

		
	}

	public static void gauss2(String fx,double start,double end,double prec,double pre_res,double slice){

		double res=0;
		double h=(end-start)/(2*slice);
		for(double i=0;i<slice;i++){
			double mid=start+h+i*2*h;
			double mid_l=mid-cons2*h;
			double mid_r=mid+cons2*h;

			if(fx.equals("fa")){
				res+=(mid_l*mid_l+mid_r*mid_r)*h;
			}
			else if(fx.equals("fb")){
				res+=(mid_l*mid_l*mid_l+mid_r*mid_r*mid_r)*h;
			}
			else if(fx.equals("fc")){
				res+=(mid_l*Math.pow(Math.E,-1*mid_l)+mid_r*Math.pow(Math.E,-1*mid_r))*h;
			}
		}

		if(Math.abs(res-pre_res)>prec){
			slice*=2;
			gauss2(fx,start,end,prec,res,slice);
		}
		else
			{
			System.out.print(res+" "+slice+" ");
			}

	}



	public static void gauss3(String fx,double start,double end,double prec,double pre_res,double slice){

		double res=0;
		double h=(end-start)/(2*slice);
		for(double i=0;i<slice;i++){
			double mid=start+h+2*i*h;
			double mid_l=mid-cons3*h;
			double mid_r=mid+cons3*h;

			if(fx=="fa"){
				res+=mid*weight3_0*h+weight3_1*(mid_l*mid_l+mid_r*mid_r)*h;
			}
			else if(fx=="fb"){
				res+=mid*weight3_0*h+weight3_1*(mid_l*mid_l*mid_l+mid_r*mid_r*mid_r)*h;
			}
			else if(fx=="fc"){
				res+=mid*weight3_0*h+weight3_1*(mid_l*Math.pow(Math.E,-1*mid_l)+mid_r*Math.pow(Math.E,-1*mid_r))*h;
			}
		}

		if(Math.abs(res-pre_res)>prec){
			slice*=2;
			gauss3(fx,start,end,prec,res,slice);
		}
		else
			{
			System.out.print(res+" "+slice+" ");
			}

	}



	public  void readFile(String filePath) throws IOException{
		int caseNumber;
		BufferedReader in = null;

		in = new BufferedReader(new FileReader(filePath));

		String textLine = "";
		String str = "";

		while(( textLine =in.readLine())!=null){
			str += " "+ textLine;
		}
		String[] numbersArray=str.split("\\s{1,}");
		for(int i = 0;i < numbersArray.length;i++)
			System.out.println(numbersArray[i] + " ");System.out.println();

			caseNumber = Integer.parseInt(numbersArray[2]);
			System.out.print(caseNumber); 
			fx = new String[caseNumber];
			start = new double[caseNumber];
			end = new double[caseNumber];
			prec = new double[caseNumber];

			for(int i = 3,j = 0;j < caseNumber;j++){
				fx[j] = numbersArray[i++];
				start[j] =Double.parseDouble(numbersArray[i++]);
				end[j] =Double.parseDouble(numbersArray[i++]);
				prec[j] =Double.parseDouble(numbersArray[i++]);
			}

			in.close();
	}
}
