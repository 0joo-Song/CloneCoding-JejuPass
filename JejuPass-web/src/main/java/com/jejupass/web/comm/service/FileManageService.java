package com.jejupass.web.comm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jejupass.common.utils.FileUtil;
import com.jejupass.web.comm.dto.request.AtchFileDto;
import com.jejupass.web.comm.dto.request.FileManageReqDto;
import com.jejupass.web.comm.dto.response.FileManageRespDto;
import com.jejupass.web.comm.mapper.FileManageMapper;

@Service
public class FileManageService {

    Logger log = LoggerFactory.getLogger(FileManageService.class);

    // 실제 파일 경로
    @Value("${file.upload.path}")
    private String uploadPath;

    // URL 경로
    @Value("${file.upload.url}")
    private String uploadUrl;

    @Autowired
    private FileManageMapper fileManageMapper;

    /**
     * 첨부 파일 리스트 조회
     *
     * @param fileManageReqDto
     * @return
     */
    public List<FileManageRespDto> selectAtchFileList(FileManageReqDto fileManageReqDto) {
        return fileManageMapper.selectAtchFileList(fileManageReqDto);
    }

    /**
     * 첨부 파일 상세 조회
     *
     * @param fileManageReqDto
     * @return
     */
    public FileManageRespDto selectAtchFileDetailInfo(FileManageReqDto fileManageReqDto) {
        return fileManageMapper.selectAtchFileDetailInfo(fileManageReqDto);
    }

    /**
     * 업로드 파일 등록
     *
     * @param upfile
     * @return atchFileSeq
     */
    public int insertAtchFile(MultipartFile upfile) {
		List<MultipartFile> mfile = new ArrayList<MultipartFile>();
		mfile.add(upfile);
		return insertAtchFile(mfile);
    }
    
    /**
     * 업로드 파일 리스트 등록
     *
     * @param upfile
     * @return atchFileSeq
     */
    public int insertAtchFile(List<MultipartFile> upfile) {

        AtchFileDto atchFileDto = new AtchFileDto();    
        // atchFileSeq 생성 및 조회
        fileManageMapper.insertAtchFileSeq(atchFileDto);
        
        log.info("atchFileSeq :: " + atchFileDto.getAtchFileSeq());

        if (upfile != null && !upfile.isEmpty()) {

        	int index = 1;
            for (MultipartFile uploadFile : upfile) {

                if (!uploadFile.isEmpty()) {

                    FileUtil fileUtil = new FileUtil();

                    FileManageReqDto fileDto = new FileManageReqDto();
                    fileDto.setAtchFileSeq(atchFileDto.getAtchFileSeq());
                    fileDto.setOriFileNm(uploadFile.getOriginalFilename());
                    fileDto.setFileSize(fileUtil.getFileSize(uploadFile.getSize()));
                    fileDto.setChgFileNm(fileUtil.uploadFile(uploadPath, uploadFile));
                    fileDto.setFileUrl(uploadUrl + "/" + fileDto.getChgFileNm());
                    
                    log.info(fileDto.toString());
                    fileManageMapper.insertAtchFileDetail(fileDto);

                }
            }

        } else {
            // 파일이 존재하지 않을 경우 0 리턴
            atchFileDto.setAtchFileSeq(0);
        }

        return atchFileDto.getAtchFileSeq();

    }

    
    /**
     * 업로드 파일 수정
     *
     * @param atchFileSeq
     * @param upfile
     * @return
     */
    public int updateUploadFile(String atchFileSeq, MultipartFile upfile) {
        int rtnNum = 0;
        if (atchFileSeq != null && !"".equals(atchFileSeq)) {
			List<MultipartFile> mfile = new ArrayList<MultipartFile>();
			mfile.add(upfile);        	
            rtnNum = updateUploadFile(Integer.parseInt(atchFileSeq), mfile);
        }
        return rtnNum;
    }
    
    /**
     * 업로드 파일 수정
     *
     * @param atchFileSeq
     * @param upfile
     * @return
     */
    public int updateUploadFile(Integer atchFileSeq, MultipartFile upfile) {
    	
		List<MultipartFile> mfile = new ArrayList<MultipartFile>();
		mfile.add(upfile);        	        	
        return updateUploadFile(atchFileSeq, mfile);
    }
    
    /**
     * 업로드 파일 수정
     *
     * @param atchFileSeq
     * @param upfile
     * @return
     */
    public int updateUploadFile(String atchFileSeq, List<MultipartFile> upfile) {
        int rtnNum = 0;
        if (atchFileSeq != null && !"".equals(atchFileSeq)) {
            rtnNum = updateUploadFile(Integer.parseInt(atchFileSeq), upfile);
        }
        return rtnNum;
    }

    /**
     * 업로드 파일 수정
     *
     * @param atchFileSeq = 수정할 첨부파일 SEQ
     * @param upfile      = 업로드 파일
     * @return 0 이 아니면 성공
     */
    public int updateUploadFile(Integer atchFileSeq, List<MultipartFile> upfile) {

        // 수정일 경우에는 atchFileSeq 받아서 처리
        AtchFileDto atchFileDto = new AtchFileDto();
        atchFileDto.setAtchFileSeq(atchFileSeq);

        if (upfile != null && !upfile.isEmpty()) {
        	int index = 1;
            for (MultipartFile uploadFile : upfile) {

                if (!uploadFile.isEmpty()) {

                    FileUtil fileUtil = new FileUtil();

                    FileManageReqDto fileDto = new FileManageReqDto();
                    fileDto.setAtchFileSeq(atchFileDto.getAtchFileSeq());
                    fileDto.setOriFileNm(uploadFile.getOriginalFilename());
                    fileDto.setFileSize(fileUtil.getFileSize(uploadFile.getSize()));
                    fileDto.setChgFileNm(fileUtil.uploadFile(uploadPath, uploadFile));
                    fileDto.setFileUrl(uploadUrl + "/" + fileDto.getChgFileNm());

                }
            }

        } else {
            // 파일이 존재하지 않을 경우 0 리턴
            atchFileDto.setAtchFileSeq(0);
        }

        return atchFileDto.getAtchFileSeq();

    }

    /**
     * 업로드 파일 삭제 (개별 파일 삭제, 단건)
     *
     * @param atchFileDetailSeq
     */
    public void deleteAtchDetailFile(Integer atchFileSeq) {
        List<Integer> delSeqList = new ArrayList<Integer>();
        delSeqList.add(atchFileSeq);
        deleteAtchDetailFile(delSeqList);
    }

    /**
     * 업로드 파일 삭제 (개별 파일 삭제 - 리스트)
     *
     * @param atchFileDetailSeqList
     */
    public void deleteAtchDetailFile(List<Integer> atchFileSeqList) {

        if (atchFileSeqList != null && atchFileSeqList.size() > 0) {
            for (int detailSeq : atchFileSeqList) {
                FileManageReqDto fileManageReqDto = new FileManageReqDto();
                fileManageReqDto.setAtchFileSeq(detailSeq);
                System.out.println("삭제확인");
                FileManageRespDto fileManageRespDto = fileManageMapper.selectAtchFileDetailInfo(fileManageReqDto);

                fileManageMapper.deleteAtchFileDetailInfo(fileManageRespDto);
            }
        }
    }

}
