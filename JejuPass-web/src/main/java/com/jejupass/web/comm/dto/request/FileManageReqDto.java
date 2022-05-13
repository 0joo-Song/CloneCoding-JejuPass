package com.jejupass.web.comm.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("FileManageReqDto")
public class FileManageReqDto {

    private Integer atchFileSeq;	// 파일 일련번호
    private Integer atchFileDtlSeq;	// 파일 상세 일련번호
    private String  oriFileNm;		// 원본 파일명
    private String  fileSize;		// 파일 사이즈(단위 포함)
    private String  filePath;		// 파일 경로 (서버)
    private String  chgFileNm;		// 변경 파일명
    private String  fileUrl;		// 파일 경로
    
}
