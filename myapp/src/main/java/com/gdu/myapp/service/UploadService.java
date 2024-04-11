package com.gdu.myapp.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadService {
  boolean registerUpload(MultipartHttpServletRequest multipartRequest);
  void loadUploadList(Model model);
  void loadUploadByNo(int uploadNo, Model model);
}
