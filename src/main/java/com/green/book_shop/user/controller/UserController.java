package com.green.book_shop.user.controller;


import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;


  @PostMapping("")
  public boolean insertUserList(@RequestBody UserDTO userDTO){
    return userService.insertUserList(userDTO);
  }
  //로그인
  //@PathVariable,@RequestParam 으로 전달되는 데이토는
  //url이 노출됨 => 아이디,비번 유출 우려

  @GetMapping("/login")
  public UserDTO selectUserId(UserDTO userDTO ){
    //조회된 데이터가 있으면 로그인 된다 -> 로그인 유저가  null이 아니다
    //조회된 데이터가 없으면 로그인 불가능 -> 로그인 유저가 null이다
    UserDTO LoginUser = userService.selectUserId(userDTO);

    return LoginUser ;

  }




}
