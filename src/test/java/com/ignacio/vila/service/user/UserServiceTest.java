package com.ignacio.vila.service.user;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.ignacio.vila.model.user.User;
import com.ignacio.vila.repository.UserRepository;

public class UserServiceTest {
	private UserService userService;
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		userService = new UserService();
		
		userRepository = mock(UserRepository.class);
		
		userService.setUserRepository(userRepository);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getUserTest() {
		when(userRepository.findOne(1)).thenReturn(new User());
		
		Assert.notNull(userService.getUser(1));
	}
}
