package cc.iteachyou.cms.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class GenPasswordTest {

	@Test
	public void genUsernameAndPassword() throws IOException {
		String username = "18811336037";
		String password = "336037";
		
		ByteSource salt = ByteSource.Util.bytes(username + password);
		SimpleHash sh = new SimpleHash("MD5", password, salt, 1024);
        
        System.out.printf("密码：%s",sh.toString());
        System.out.println();
        System.out.printf("盐：%s",salt.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	}
}
