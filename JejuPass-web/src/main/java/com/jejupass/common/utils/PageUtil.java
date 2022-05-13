package com.jejupass.common.utils;

import com.jejupass.common.model.PagingModel;

public class PageUtil {

    private static int pageBlockSize = 10;  //한 화면에 보여줄 페이지의 갯수

    // TODO 새로 만들어야 함
    
    /**
     * Web 페이징 html 생성
     * @param1 currPage     클릭한 페이지 넘버
     * @param2 countPerPage 한페이지당 게시물 갯수
     * @param3 totalCount   count query 이용하여 검색한 데이터 갯수
     * @param4 fnName       페이지넘버 클릭시 호출할 javascript 함수명
     * @param5 
     * @return String       param 값을 기준으로 생성한 HTML 값 return
     * @throws Exception
     */
    public static String makeWebPaging(PagingModel pagingModel) throws Exception {
    	
        StringBuffer sb = new StringBuffer();
        pageBlockSize = pagingModel.getPageCount(); 
        int currPage = pagingModel.getCurrentPage();
        int countPerPage = pagingModel.getPageCount();
        int totalCount = pagingModel.getTotalCount();
        String fnName = "goPage";
        
        try {
            // 등록된 리스트가 없을 경우
            if(totalCount == 0) {
                return "";
            }
            
            int totalPage = totalCount / countPerPage;
            if (totalCount == 0 || totalCount%countPerPage != 0)    totalPage++;
            
            int startPage = ((currPage-1)/pageBlockSize)*pageBlockSize + 1;
            int endPage = ((startPage+pageBlockSize-1) > totalPage) ? totalPage : startPage+pageBlockSize-1;
            
            boolean hasPrevPageBlock = (startPage > pageBlockSize) ? true : false;
            boolean hasNextPageBlock = (endPage < totalPage) ? true : false;
            
            if (hasPrevPageBlock) {
            	if(startPage-10 >= 1) {
            		sb.append("<a href=\"#\" class=\"ppre\" onclick="+fnName+"("+(startPage-10)+")><img src=\"/assets/images/ico_ppre.png\" alt=\"처음\" /></a>");
            	} else {
            		sb.append("<a href=\"#\" class=\"ppre\" disabled><img src=\"/assets/images/ico_ppre.png\" alt=\"처음\" /></a>");
            	}
                sb.append("<a href=\"#\" class=\"pre\" onclick="+fnName+"("+(currPage-1)+")><img src=\"/assets/images/ico_pre.png\" alt=\"이전\" /></a>");
            } else {
            	sb.append("<a href=\"#\" class=\"ppre\" disabled><img src=\"/assets/images/ico_ppre.png\" alt=\"처음\" /></button></a>");
            	sb.append("<a href=\"#\" class=\"pre\" disabled><img src=\"/assets/images/ico_pre.png\" alt=\"이전\" /></button></a>");
            }
            
            //pages
            for (int i=startPage; i <= endPage; i++) {
                if (i == currPage) {
                    sb.append("<strong>"+i+"</strong>");
                } else {
                    sb.append("<a href=\"#\" class=\"num\" onclick=\"javascript:"+fnName+"("+i+")\">"+i+"</a>");
                }
            }
            
            //다음 page
            if (hasNextPageBlock) {
            	sb.append("<a href=\"#\" class=\"next\" onclick="+fnName+"("+(currPage+1)+")>NEXT</a>");
            	if(endPage+10 >= totalPage) {
            		sb.append("<a href=\"#\" class=\"nnext\" disabled></a>");
            	} else {
            		sb.append("<a href=\"#\" class=\"nnext\" onclick="+fnName+"("+(endPage+10)+")><img src=\"/assete/images/ico_next.png\" alt=\"다음\" /></a>");
            	}
            } else {
            	sb.append("<a href=\"#\" class=\"next\" disabled><img src=\"/assets/images/ico_next.png\" alt=\"다음\" /></a>");
            	sb.append("<a href=\"#\" class=\"nnext\" disabled><img src=\"/assets/images/ico_nnext.png\" alt=\"끝\" /></a>");
            }
        } catch( Exception ex ) {
            throw ex;
        }
        return  sb.toString();
    }
    
  
}
