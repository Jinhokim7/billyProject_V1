<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VillageForm</title>
<head>
    <meta charset="UTF-8">
</head>
<style>
	#header{
  		float:left;
  	}
  	h4{
  		padding-top:15px;
  	}
  	#joinTop {
		margin-left: 500px;
	}
	#join {
		font-size: 30px;
	}
</style>
  	
<body>
	<%@ include file="../bbs/bootstrap.jsp" %>
	<%@ include file="../bbs/header.jsp"%>
	<%@ include file="../bbs/nav.jsp"%>
	<div id="joinTop">
			<img src="resources/img/logo.png" alt="Logo" width="100" height="50">
			<span id="join">빌리지 등록</span>
	</div>
	
   <div id="wrap" align="center">								
      <form  method="post" action="villageAction" encType="multipart/form-data" id="send_form">
         <table>
         	<tr>
         		<th>글번호</th>
         		<td><input type="text" class="form-control" name="vNum" value="${vNum}" readonly></td>
         	</tr>
         	<tr>
         		<th>아이디</th>
         		<td><input type="text" class="form-control" name="vId" value="${login}" readonly></td>
         	</tr>
            <tr>
               <th>제목</th>
               <td><input type="text" size="70" name="vTitle" class="form-control" placeholder="제목을 입력하세요"></td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea cols="71" rows="10" name="vText" class="form-control" placeholder="내용을 입력하세요"></textarea></td>
            </tr>
            <tr>
            	<td colspan="2">
           	 		*파일은 최대2개 등록 가능합니다
           	 	</td>
            </tr>
            <tr>
            	<td colspan="2">
            		<div class="mb-3">
						<input type="file" class="form-control" name="file" accept="image/gif, image/jpeg, image/png"> 
						<input type="file"  class="form-control" name="file" accept="image/gif, image/jpeg, image/png">
					</div>
				</td>
            </tr>
         </table>
         <br>
         <br>
         <input type="submit" class="btn btn-primary"  value="등록">
         <input type="reset" class="btn btn-primary" value="다시 작성">
         <input type="button" class="btn btn-primary" value="취소" onclick="location.href='villageBoard'">
      </form>
   </div>
   <%@ include file="../bbs/footer.jsp"%>
</body>

</html>