<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <tiles:insertAttribute name="header" />
 </head>
<body>
  <div id="wrap">
    <tiles:insertAttribute name="contents" />
    <tiles:insertAttribute name="footer" />
  </div>
</body>
</html>