
public class linearSearchAirports {

	public class Airport {
		private String city;
		private String country;
		private String code3;
		
		public String getCity() { return this.city; }
		public String getCountry() { return this.country; }
		public String getCode() { return this.code3; }
	}
	
	public static String findAirportCode(String toFind,
			Airport[] airports) {
		int size = airports.length;
		int index = 0;
		
		while (index < size) {
			if (toFind.equals(airports[index].getCity())) return airports[index].getCode();
			index++;
		}
		
		// my idea of a failed search
		return null;
	}
	
	
	
}
