package com.challenge;

import com.challenge.Service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

	@Autowired
	private UsersService usersService;

	@Test
	public void contextLoads() {
		usersService.generateVcode("15975065431");
	}

}
