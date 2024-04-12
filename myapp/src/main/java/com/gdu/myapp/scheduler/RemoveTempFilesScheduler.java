package com.gdu.myapp.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.myapp.service.UploadService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RemoveTempFilesScheduler {
  
  private final UploadService uploadService;
  
  @Scheduled(cron="0 28 12 * * ?")
  public void execute() {
    uploadService.removeTempFiles();
  }
  
}
