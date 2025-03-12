package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;

import java.util.List;

public interface UserService {

  public boolean  insertUserList(UserDTO userDTO);

  public UserDTO selectUserId(UserDTO userDTO);


}
