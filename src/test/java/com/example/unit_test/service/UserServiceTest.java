package com.example.unit_test.service;

import com.example.unit_test.entity.User;
import com.example.unit_test.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(UserService.class)
public class UserServiceTest {
  @MockBean
  UserRepository userRepository;

  @Autowired
  UserService userService;

  private User getUser(){
    User user = new User();
    user.setId(1L);
    user.setName("Van");
    user.setAddress("Ha Noi");
    return user;
  };

  @Test
  public void testAddUser() {
    User user = getUser();
    Mockito.when(userRepository.save(user)).thenReturn(user);

    User result = userService.create(user);
    assertEquals(user.getId(), result.getId());
    assertEquals(user.getName(), result.getName());
    assertEquals(user.getAddress(), result.getAddress());
  }
}
