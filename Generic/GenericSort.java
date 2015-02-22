package test1;

public class GenericSort {
	public static void main(String[] args){
		//Creat an Integer array
		Integer[] intArray = {new Integer(2),new Integer(5),new Integer(4)};
		
		
		Double[] doubleArray = {new Double(2.0),new Double(5.0),new Double(4.0)};
		
		Character[] charArray = {new Character('a'),new Character('c'),new Character('b')};
		
		String[] stringArray = {"Tom" ,"Jeery", "kitty"};
		
		sort(intArray);printList(intArray);
		
		sort(doubleArray);printList(doubleArray);
		
		sort(stringArray);printList(stringArray);
		
		sort(charArray);printList(charArray);
	}
	
	
	//sort an array of comparable objects
	public static <E extends Comparable<E>> void sort(E[] list){
		E currentMin;
		int currentMinIndex;
		
		for(int i = 0; i < list.length-1; i++){
			currentMin = list[i];
			currentMinIndex = i;
			
			for(int j = i + 1;j < list.length;j++){
				if(currentMin.compareTo(list[j]) > 0){
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			if(currentMinIndex != i){
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
	
	public static void printList(Object[] list){
		for(int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
		
	}
		
		
		
		
}
	

