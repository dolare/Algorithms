import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;


public class Double_LinkedList {
	private static class Node{
		int val;
		Node next;
		Node prev;
		public Node(int v,Node n, Node p){
			val=v;
			next=n;
			prev=p;
		}
	}
	private Node head;

	public Double_LinkedList(){
		head=null;
	}

	public void addFirst(int v){
		head=new Node(v,head,null);
	}

	public void addLast(int v){
		Node ptr=head;
		if(ptr==null)
			addFirst(v);
		while(ptr.next!=null){
			ptr=ptr.next;
		}
		ptr.next=new Node(v,null,ptr);
	}

	public int get(int n){
		Node p;
		int j=0;
		for(p=head;j<n;p=p.next){
			j++;
		}
		return p.val;
	}

	public void deleteFirst(){
		if (head==null)
			return;
		Node temp=head;
		head=head.next;
		temp=null;

	}

	public void deleteLast(){
		Node p;
		Node q = null;
		if(head==null)
			return;
		if(head.next==null){
			head=null;
			return;
		}
		for(p=head;p.next!=null;q=p,p=p.next)
			;
		q.next=null;
		p=null;

	}


	public void insertMiddle(int tar,int v){
		Node temp;
		for(Node p=head;p!=null;p=p.next){
			if(p.val==tar){
				temp=p.prev;
				p.prev=new Node(v,p,p.prev);
				if(temp!=null)
					temp.next=p.prev;
			}
		}
	}



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
		Double_LinkedList l1=new Double_LinkedList();
		String txt = null;
		String[] number=null;

		//	int [] read_in=new int [10];
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
				l1.addFirst(n-i);
			}
			for(int i=0;i<m;i++){
				l1.deleteLast();
			}
			for(int i=0;i<p;i++){
				l1.deleteFirst();
			}

			for(int i=0;i<n-m-p;i++){
				System.out.println(l1.get(i));
			}
			System.out.println("");
		}
	}

}








