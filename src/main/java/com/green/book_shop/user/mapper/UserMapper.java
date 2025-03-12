package com.green.book_shop.user.mapper;

import com.green.book_shop.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

  public void insertUserList(UserDTO userDTO);

  //id 중복확인
  public  String checkUserId(String userId);

  public UserDTO selectUserId(UserDTO userDTO);


}
