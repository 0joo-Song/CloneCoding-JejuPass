package com.jejupass.web.comm.mapper;

import java.util.List;

import com.jejupass.web.comm.dto.request.AtchFileDto;
import com.jejupass.web.comm.dto.request.FileManageReqDto;
import com.jejupass.web.comm.dto.response.FileManageRespDto;

public interface FileManageMapper {

	List<FileManageRespDto> selectAtchFileList(FileManageReqDto fileManageReqDto);

	FileManageRespDto selectAtchFileDetailInfo(FileManageReqDto fileManageReqDto);

	int insertAtchFileSeq(AtchFileDto atchFileDto);

	int insertAtchFileDetail(FileManageReqDto fileDto);

	void deleteAtchFileDetailInfo(FileManageRespDto fileManageRespDto);

}
