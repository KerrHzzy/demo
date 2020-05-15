package xdclass_springboot.demo;

import junit.framework.TestCase;
import net.xdclass.demo.XdClassApplication;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={XdClassApplication.class})//启动整个springboot工程
public class SpringBootTestDemo {

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("before class");
	}

	@Before
	public void testBefore(){
		System.out.println("before");
	}

	@Test
	public void testOne(){
		System.out.println("test hello 1");
		TestCase.assertEquals(1, 1);
	}

	@Test
	public void testTwo(){
		System.out.println("test hello 2");
		TestCase.assertEquals(1, 1);
	}

	@After
	public void testAfter(){
		System.out.println("after");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("after class");
	}
}
