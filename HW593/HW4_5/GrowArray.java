import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;


public class GrowArray {
	private int[] p;
	private int size_;

	public GrowArray() {
		p = null;
		size_=0;
	}

	public void addEnd(int v) {   // O(size_)
		if(size_==0)
			addStart(v);
		else{

			int[] temp = p;
			p = new int[++size_];

			for (int i = 0; i < size_-1; i++)
				p[i] = temp[i];

			p[temp.length] = v;
		}
	}



	public void addStart(int v) {   
		int[] temp = p;
		p = new int[size_+1];
		p[0] = v;
		for (int i = 1; i < size_+1; i++)
			p[i] = temp[i-1];
		temp=null;
		size_++;
	}
	public void deleteEnd() { // O(size_)
		if (p == null)
			return;
		int[] temp = p;
		size_--;
		p = new int[size_];
		for (int i = 0; i < size_; i++)
			p[i] = temp[i];
		temp=null;
	}

	public void deleteStart() { // O(size_)
		if (p == null)
			return;
		int[] temp = p;
		size_--;
		p = new int[size_];
		for (int i = 0; i < size_; i++)
			p[i] = temp[i+1];
		temp=null;
	}


	public int get(int i) {

		return p[i];
	}

	public int size(){ return size_; }


	public static ArrayList<String> readFile(String name) throws URISyntaxException {
		ArrayList<String> li = new ArrayList<String>();
		String path = "";
		path =name;
		File f = new File(path);
		BufferedReader r = null;
		String line;
		try {
			r = new BufferedReader(new FileReader(f));
			while ((line = r.readLine()) != null) {
				if (line.startsWith("--"))
					continue;
				li.add(line);
			}
			r.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return li;
	}


	public static void main(String [] arge) throws URISyntaxException{

		GrowArray a = new GrowArray();

		String txt = null;
		String[] number=null;
		
		Scanner input;
		input = new Scanner (System.in);
		System.out.print("Enter the path: ");
		

		
		String filePath=input.next();;


		for(int j=0;j<readFile(filePath).size();j++){

			txt=readFile(filePath).get(j);

			number=txt.split(" ");



			int n=Integer.parseInt(number[0]);
			int m=Integer.parseInt(number[1]);
			int p=Integer.parseInt(number[2]);

			for(int i=0;i<n;i++)
			{
				a.addEnd(i+1);
			}
			for(int i=0;i<m;i++){
				a.deleteEnd();
			}
			for(int i=0;i<p;i++){
				a.deleteStart();
			}

			for(int i=0;i<a.size();i++){
				System.out.print(a.get(i) + " ");
			}
			System.out.println(" ");

		}
		
	}


}






