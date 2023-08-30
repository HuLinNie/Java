package richanglianxi;

public enum Week{
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
	Saturday,
	Sunday;
	public static void main(String... args) {
		Week day= Monday;
		Week day1 = Tuesday;
		System.out.println(day);
		Week day3 = Week.Friday;
		Week day4 = Week.valueOf("Monday");
		System.out.println(day4);
		for( Week d:Week.values()) {
			System.out.println(d);
			
		}
		int x= day.compareTo(day4);
		System.out.print(x);
		
	}	
//	{monday,
//		Tuesday,
//			 Wednesday,
//			 Thursday,
//			 Firday,
//			 Saturday,
//			 Sunday;
//
//		public static void main(String[] args) {		
//			Week day=Week.monday;
//			System.out.println(day);
//			Week d1 = Week.valueOf("Wednesday");
//			System.out.println(d1);
//			for(Week d :Week.values())
//			{
//				System.out.println(d);
//			}
//			boolean b = day.compareTo(d1)==0;
//			System.out.println(b);
//			
//			
//			
//			
//		}
	}
