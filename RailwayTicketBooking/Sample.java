package RailwayTicketBooking;

import java.util.HashMap;

public class Sample {
	public static void main(String[] args) {
		HashMap<Integer, a> map = new HashMap<>();
		a obj1 = new a();
		a obj2 = new a();
		map.put(1, obj1);
		map.put(2, obj2);
		
		System.out.println(map);
		map.remove(2,obj2);
		System.out.println(map);
		map.remove(2);
		System.out.println(map);
	}
}

class a {

}
