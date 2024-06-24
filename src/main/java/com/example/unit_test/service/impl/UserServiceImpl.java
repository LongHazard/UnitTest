package com.example.unit_test.service.impl;

import com.example.unit_test.entity.User;
import com.example.unit_test.repository.UserRepository;
import com.example.unit_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public User create(User user) {
    User newUser = new User();
    newUser.setId(user.getId());
    newUser.setName(user.getName());
    newUser.setAddress(user.getAddress());
    return userRepository.save(newUser);
  }
}
