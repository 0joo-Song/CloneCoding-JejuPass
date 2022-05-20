package com.jejupass.web.customerSvc.dto.response;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.jejupass.web.customerSvc.entity.FaqEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("FaqRespDto")
public class FaqRespDto {
	private List<FaqEntity> respData;
}	
