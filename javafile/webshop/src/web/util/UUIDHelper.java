package web.util;

import java.util.UUID;

public class UUIDHelper {
	//UUID 32 
	public static String generateShortString(){
		String uuidString = UUID.randomUUID().toString(); 
        //去掉�?-”符�? 
        return uuidString.substring(0,8)+uuidString.substring(9,13)+uuidString.substring(14,18)+uuidString.substring(19,23)+uuidString.substring(24);
	}
}
