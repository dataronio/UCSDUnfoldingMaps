

public class selectionSort {
	public static void sortInts (int[] ints) {
	
	    for (int i = 0;i< ints.length - 1; i++) {
		   int minIndex = i;
		   for (int j = i+1;j < ints.length;j++) {
			   if (ints[j]< ints[minIndex]) {minIndex = j;}
		   }
	       int value = ints[i];
		   ints[i] = ints[minIndex];
	       ints[minIndex] = value;	
	    }
		
	}
		
}
