package iducs.springboot.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("iducs.springbooot.board")
public class BootThymeleafApplicationTests {
	@Test
	public void contextLoads() throws Exception {

		ApplicationContext applicationContext = 
				SpringApplication.run(BootThymeleafApplication.class);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	}

}
