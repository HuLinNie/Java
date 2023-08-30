package eb;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserCreator {
	public static User generateUser() {
		User user = new User();
		// UUID含义是通用唯一识别码 (Universally Unique Identifier)，使用UUID 防止主键重复
		String str = UUID.randomUUID().toString();
		// 去掉"-"符号
		String uuidstr =  str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
		+ str.substring(24);
		user.setEmail(uuidstr + "@neuq.edu.cn");
		user.setName("testUser");
		user.setPassword("123456");
		user.setMemo("testUser@test.info");
		user.setRegDate(LocalDateTime.now());
		return user;
	}
}
