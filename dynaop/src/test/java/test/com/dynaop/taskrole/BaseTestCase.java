/**
 * 
 */
package test.com.dynaop.taskrole;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 单元测试基类
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-14
 * 
 */
public class BaseTestCase {
	
	protected static AbstractApplicationContext context;
	@BeforeClass
	public static  void setUpBeforeClass() throws Exception {
		//Logger.getRootLogger().setLevel(Level.DEBUG);
		context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/spring.xml"});
	}
	
	protected  Object getBean(String beanName) {
		return context.getBean(beanName);
	}
	
	protected  Object getBean(Class<?> beanClass) {
		return context.getBean(beanClass);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		context.close();
	}

}
