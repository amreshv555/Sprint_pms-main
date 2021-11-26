package com.pms.in.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.pms.in.entities.AbstractUser;



@SpringBootTest
public class TestAbstractUserController {
	
	@MockBean
	private com.pms.in.repository.AbstractUserRepository repository;
	
	@Autowired
	private AbstractUserController controller;
	
	@Autowired
	private com.pms.in.service.AbstractUserService service;
	

	@Test
	public void testRegister() {
		AbstractUser user = new AbstractUser((int)3,"admin","admin");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.register(user));
	}
	
}
