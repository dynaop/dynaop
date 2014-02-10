/**
 * 
 */
package test.com.dynaop.taskrole.user.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dynaop.taskrole.user.service.UserInfoService;

import test.com.dynaop.taskrole.BaseTestCase;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-14
 */
public class TestUserInfoServiceImpl extends BaseTestCase{
	private UserInfoService userInfoService;
	
	@Before
	public void setUp(){
		userInfoService =  (UserInfoService)this.getBean("userInfoService");
	}
	
	@Test
	public void testCheckLoginTrue(){
		Map<String,String> param = new HashMap<String,String>();
		param.put("username", "ivan");
		param.put("pwd", "ivan");
		boolean loginStatus = userInfoService.checkLogin(param);
		Assert.assertTrue(loginStatus);
	}
	
	@Test
	public void testCheckLoginFalse(){
		Map<String,String> param = new HashMap<String,String>();
		param.put("username", "");
		param.put("pwd", "");
		boolean loginStatus = userInfoService.checkLogin(param);
		Assert.assertFalse(loginStatus);
	}

}
