
public class moreSorting {
	
	public static void mysterySort( int[] vals) {
		int currInd;
		
		for ( int pos=1; pos < vals.length ; pos++) {
			currInd = pos;
			while ( currInd > 0 && vals[currInd] < vals[currInd-1])
			{
				swap(vals, currInd, currInd - 1);
				currInd--;
			}
		}
		
	}
	
	public static void swap(int[] ints, int currentIndex, int k) {
		int value = ints[k];
		ints[k] = ints[currentIndex];
		ints[currentIndex] = value;
	}

}
