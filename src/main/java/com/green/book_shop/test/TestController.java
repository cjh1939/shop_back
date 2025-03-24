package com.green.book_shop.test;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.UUID;
@RequiredArgsConstructor
@RestController
@RequestMapping("/test")

public class TestController {
  private final UploadUtil uploadUtil;

  @GetMapping("/1")
  public int test1(){
    return 5;
  }

  //첨부파일 연습1
  //첨부파일 을 자바에서 받기위해서 formData 객체를 사용했다 .
  //전달되는 데이터의 형태도 multipart/form-data 형식으로 변환해서 전달.
  //이렇게 전달 되는 데이터를 받기위한 코드를 변경했기 때문에
  //평소랑 다르게 데이터를 전달 받아야함
  //DTO객체로 전달된 데이터를 받되, @requsetBody 어노테이션은 사용하지않는다 .
  //그렇다고해서  DTO 객체에 첨부파일 정보도 받는것은 아니다.
  //첨부파일 데이터를 받을때는 multipartFile 객체를 사용한다.(@RequestParam)사용
  @PostMapping("{upload1}") //단일 첨부
  public void upload1(BookDTO bookDTO ,@RequestParam(name = "firstFile", required = false) MultipartFile File ){

    //단일 첨부파일 업로드
    uploadUtil.fileUpload(File);

  }

  //첨부할 파일이 여러개들어오면  MultipartFile[]배열 형태로 데이터 받음
  @PostMapping("/upload2") //다중파일 첨부
  public void  upload2(@RequestParam(name = "files",required = false) MultipartFile[] files){
    // 다중파일 업로드
    uploadUtil.multiFileUpload(files);


    }


  }













