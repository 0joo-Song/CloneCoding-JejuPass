package com.jejupass.web.comm.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("AtchFileDto")
public class AtchFileDto {

    private Integer atchFileSeq;		// 파일 일련번호

}
