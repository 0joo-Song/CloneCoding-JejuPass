package com.jejupass.web.user.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("UserReqDto")
public class UserReqDto {
	private Integer userSeq;
}
