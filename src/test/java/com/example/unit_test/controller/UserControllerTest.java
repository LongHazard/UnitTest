package com.example.unit_test.controller;

import com.example.unit_test.entity.User;
import com.example.unit_test.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(UserController.class)
public class UserControllerTest {
  private static final String END_POINT_PATH = "/api/v1/users";

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  private UserService userService;

  private User getUser(){
    User user = new User();
    user.setId(1L);
    user.setName("Van");
    user.setAddress("Ha Noi");
    return user;
  };

  @Test
  void createUser() throws Exception {
    User user = getUser();
    Mockito.when(userService.create(user)).thenReturn(user);

    mockMvc.perform(post(END_POINT_PATH)
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsBytes(user)))
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
          .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Van"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("Ha Noi"));

  }
}
