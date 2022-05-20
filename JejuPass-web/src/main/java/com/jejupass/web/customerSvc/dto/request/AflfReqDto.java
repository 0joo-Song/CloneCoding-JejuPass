package com.jejupass.web.customerSvc.dto.request;

import org.apache.ibatis.type.Alias;

import com.jejupass.web.customerSvc.entity.AflfEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("AflfReqDto")
public class AflfReqDto {
	
	AflfEntity data;
}
