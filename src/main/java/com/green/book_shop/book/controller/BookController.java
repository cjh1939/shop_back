package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;
  private final UploadUtil uploadUtil;
  //도서 등록 api
  //post ~/books
  @PostMapping("")
  public void regBook(@RequestBody BookDTO bookDTO){
    //첨부파일 (도서 이미지) 업로드

    //book 테이블에 데이어 insert
    bookService.insertBook(bookDTO);
  }

  @PostMapping("/upload")
  public void upload(@RequestParam(name = "file",required = false)MultipartFile file){
    uploadUtil.fileUpload(file);
  }


}















