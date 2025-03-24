package com.green.book_shop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

//첨부파일 모음 클래스
@Component
public class UploadUtil {
  //application.properties 파일에 정의한
  //file.upload.dir 값을 가져와서 uploadPath 변수에 저장
  @Value("${file.upload.dir}")
  private String uploadPath;


  //단일 파일 업로드 메서드
  public void fileUpload(MultipartFile File){

    //파일을첨부하지 않앗으면
    if(File == null){
      return;
    }


    //화면에서 선택한 원본 파일명
    String originFileName = File.getOriginalFilename();

    //첨부할 파일명
    String attachFileName = getAttachedFileName(originFileName);

    //업로드 경로, 파일명 연결
    //c:/My_folder/abc.jpg;
    File f = new File(uploadPath + attachFileName);

    //파일첨부
    //첨부한 파일을(file)실제 업로드 할 경로(f) 로 옮기다
    try {
      File.transferTo(f);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }




  //다중 파일 업로드 메서드
  public void multiFileUpload(MultipartFile[] Files){
    for(MultipartFile eachFile : Files){
      fileUpload(eachFile);
    }
  }

  //원본 파일명에서 첨부할 파일명을 생성하는 메서드
  public  String getAttachedFileName(String originFilename){

    //첨부할 파일명 (랜덤한 문자열 생성)
    String uuid = UUID.randomUUID().toString();


    //화면에서 선택한 파일의 확장자 추출
    //abc.jpg (jpg)확장자만추출함
    String[] result = originFilename.split("\\.");
    System.out.println(Arrays.toString(result));
    String extnesion = result[result.length -1 ];

    //완성된 첨부할 파일명
    String attachFileName = uuid + "." + extnesion;

    return attachFileName;
  }



}
