package com.jejupass.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultMsg {
	REG_SUCC("등록이 완료되었습니다."),
	MOD_SUCC("수정이 완료되었습니다."),
	DEL_SUCC("삭제가 완료되었습니다."),
	CANCEL_SUCC("취소 되었습니다."),
	DUP_ID_SUCC("사용가능한 아이디입니다."),
	DUP_ID_FAIL("중복된 아이디입니다."),
	DUP_NM_FAIL("중복된 이름입니다."),
	APRV_SUCC("승인 완료되었습니다."),
	RJT_SUCC("반려 처리되었습니다."),
	TEMP_PW_SUCC("임시비밀번호가 정상적으로 등록되었습니다."),
	FAIL("처리가 실패하였습니다."),
	LOGIN_FAIL("비밀번호를 잘못 입력하셨습니다.");	
	
	String msg;  
	
}