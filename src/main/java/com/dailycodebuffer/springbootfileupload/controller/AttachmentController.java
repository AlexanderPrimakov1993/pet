package com.dailycodebuffer.springbootfileupload.controller;

import com.dailycodebuffer.springbootfileupload.entity.Attachment;
import com.dailycodebuffer.springbootfileupload.model.ResponseData;
import com.dailycodebuffer.springbootfileupload.service.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentController {

    private AttachmentService attachmentService;
    private AttachmentService ascascattachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
         Attachment attachment =null;
         attachment = attachmentService.getAttachment(fileId);
         return ResponseEntity.ok()
                 .contentType(MediaType.parseMediaType(attachment.getFileType()))
                 .header(HttpHeaders.CONTENT_DISPOSITION,
                         "attachment; filename=\"" + attachment.getFileName()
                 + "\"")
                 .body(new ByteArrayResource(attachment.getData()));
    }
}
