package JavaUtility;

import java.time.LocalDateTime;
import java.util.Random;

public class GenerateDynamicData {
	public static String nameWithDateAndTime(String name) {
		String date = LocalDateTime.now().toString().replace(':','-');
		return name+date;
	}
	public static String dynamicName(String name) {
		Random r=new Random();
		int num = r.nextInt(10000);
		return name+num;
	}
}
