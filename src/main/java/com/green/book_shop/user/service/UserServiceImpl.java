package com.green.book_shop.user.service;

import com.green.book_shop.user.mapper.UserMapper;
import com.green.book_shop.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
  private final UserMapper userMapper;

  @Override
  public boolean insertUserList(UserDTO userDTO) {

    //회원가입 여부 변수
    boolean isJoin = false;
    //아이디가 중복이다 -> 조회된  데이터 null이 아니다
    //아이디가 중복이 아니다 -> 조회된 데이터가 null이다
    String selectedUserId = userMapper.checkUserId(userDTO.getUserId());
    if (selectedUserId == null){
       userMapper.insertUserList(userDTO);
       isJoin = true;
    }
    return isJoin;
  }

  @Override
  public UserDTO selectUserId(UserDTO userDTO) {

    return userMapper.selectUserId(userDTO);
  }


}
