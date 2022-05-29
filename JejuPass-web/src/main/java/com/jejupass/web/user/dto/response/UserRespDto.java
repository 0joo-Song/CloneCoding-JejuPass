package com.jejupass.web.user.dto.response;

import org.apache.ibatis.type.Alias;

import com.jejupass.web.user.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("UserRespDto")
public class UserRespDto {
	private UserEntity respData;
	
	private String result;
	
}
