import demos.Airport;

public class binarySearchAirports {

	
	
	public static String findAirportCode (String toFind,
			Airport[] airports) {
		int low = 0;
		int high = airports.length - 1;
		int mid;
		while (low <= high) {
			mid = low + ((high - low) / 2);
			int compare = toFind.compareTo(airports[mid].getCity());
			if (compare < 0) { high = mid -1; } 
			else if (compare > 0)  { low = mid +1; }
			else	{ return airports[mid].getCode3(); }
		}
				
		return null;
	}
}
