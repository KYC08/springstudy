<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<c:set var="dt" value="<%=System.currentTimeMillis()%>"/>

<jsp:include page="../layout/header.jsp"/>

<h1 class="title">업로드 작성화면</h1>

<form id="frm-upload-register"
      method="POST"
      enctype="multipart/form-data"
      action="${contextPath}/upload/register.do">

  <div>
    <span>작성자</span>
    <span>${sessionScope.user.email}</span>
  </div>
  
  <div>
    <label for="title">제목</label>
    <input type="text" name="title" id="title">
  </div>
  
  <div>
    <textarea id="contents" name="contents" placeholder="내용을 입력하세요"></textarea>
  </div>
  
  <div>
    <label for="files">첨부</label>
    <input type="file" name="files" id="files" multiple>
  </div>
  
  <div id="attach-list"></div>
  
  <div>
    <input type="hidden" name="userNo" value="${sessionScope.user.userNo}">
    <button type="submit">작성완료</button>
    <a href="${contextPath}/upload/list.do"><button type="button">작성취소</button></a>
  </div>

</form>

<script>




</script>



<%@ include file="../layout/footer.jsp" %>