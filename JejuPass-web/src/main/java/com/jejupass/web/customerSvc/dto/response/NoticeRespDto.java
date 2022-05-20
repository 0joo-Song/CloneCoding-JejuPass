package com.jejupass.web.customerSvc.dto.response;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.jejupass.web.customerSvc.entity.NoticeEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("NoticeRespDto")
public class NoticeRespDto {
	private List<NoticeEntity> respData;
}
