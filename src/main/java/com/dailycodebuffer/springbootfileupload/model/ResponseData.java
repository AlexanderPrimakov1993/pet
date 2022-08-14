package com.dailycodebuffer.springbootfileupload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    private String fileName;
    private String downLoadURL;
    private String fileType;
    private long fileSize;
    private String thing;
}
