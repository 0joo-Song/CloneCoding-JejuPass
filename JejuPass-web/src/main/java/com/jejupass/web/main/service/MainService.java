package com.jejupass.web.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jejupass.web.comm.dto.request.CommCdReqDto;
import com.jejupass.web.main.mapper.MainMapper;

@Service
public class MainService {

	@Autowired
	private MainMapper mainMapper;

	public int test(CommCdReqDto testCd) {
		return mainMapper.test(testCd);
	}
	
}
