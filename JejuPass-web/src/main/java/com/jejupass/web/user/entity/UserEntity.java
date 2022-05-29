package com.jejupass.web.user.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias("UserEntity")
public class UserEntity {
	/* 회원 */
	
	private Integer userSeq;
	private String userId;
	private String userPw;
	private String encPw;
	private String userNm;
	private String userTel;
	private String userEmail;
	private String tempPwYn;
}
