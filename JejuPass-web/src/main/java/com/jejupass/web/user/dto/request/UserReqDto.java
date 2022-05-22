package com.jejupass.web.user.dto.request;

import org.apache.ibatis.type.Alias;

import com.jejupass.web.user.userEntity.UserEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("UserReqDto")
public class UserReqDto {
	private UserEntity reqData;
}
