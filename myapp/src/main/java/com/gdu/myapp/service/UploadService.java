package com.gdu.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadService {
  boolean registerUpload(MultipartHttpServletRequest multipartRequest);
  void loadUploadList(Model model);
  void loadUploadByNo(int uploadNo, Model model);
  ResponseEntity<Resource> download(HttpServletRequest request);
  ResponseEntity<Resource> downloadAll(HttpServletRequest request);
}
