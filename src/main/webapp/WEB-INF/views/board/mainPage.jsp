<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <!-- my css -->
    <link rel="stylesheet" type="text/css" href="../resources/css/frameCss.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/commonCss.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/commonFormCss.css">

    <!-- font css -->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">

    <!-- script -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>

    <script type="text/javascript" src="../resources/js/frame/dropdown.js"></script>
    <script type="text/javascript" src="../resources/js/frame/jquery-3.6.0.min.js"></script>

</head>

<body>

    <!-- header part end-->

    <!-- body part start -->

    <section class="container-fluid">

        <div class="row mt-4">

            <jsp:include page="../user/loginPage.jsp"></jsp:include>

            <div class="col">
                <!-- page Title --> 
                <div class="row mt-1 conTitleArea">
                	<form action="./mainPage" method="post">
                		<div class="row mt-3">
                			<div class="col">
                				<select name ="category" class="form-select">
                					<option value="title">타이틀</option>
                					<option value="content">내용</option>
                					<option value="nick">닉네임</option>
                				</select>
                			</div>
                			<div class="col-8">
                				<input type="text" name="keyword" class="form-control" placeholder="검색할 단어를 입력하세요">
                			</div>
                			<div class="col d-grid">
                				<input type="submit" value="검색" class="btn btn-primary">
                			</div>
                		</div>
                	</form>
				</div>
				
				
                <!-- 페이지별 내용 시작-->
				<div class="row formTable">
					<table>
						<thead>
							<tr>
								<th scope="col">글 번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">비밀글</th>
								<th scope="col">작성일</th>
								<th scope="col">조회수</th>
							</tr>						
						</thead>

						<tbody>
							<c:forEach items="${dataList }" var="data">
								<tr>
									<td class="text-center">${data.boardVo.board_no }</td>
									
									<c:if test="${data.boardVo.board_secret == 'N' }">
										<c:if test="${!empty data.newKeyword }">
											<td class="text-center"><a href="./readContentPage?board_no=${data.boardVo.board_no }">${data.boardVo.board_title }<span class="badge bg-danger">new</span></a></td>
										</c:if>
										<c:if test="${empty data.newKeyword }">
											<td class="text-center"><a href="./readContentPage?board_no=${data.boardVo.board_no }">${data.boardVo.board_title }</a></td>
										</c:if>
									</c:if>
									
									<c:if test="${sessionUser.user_no == data.userVo.user_no && data.boardVo.board_secret == 'Y' }">
										<c:if test="${!empty data.newKeyword }">
											<td class="text-center"><a href="./readContentPage?board_no=${data.boardVo.board_no }">${data.boardVo.board_title }<span class="badge bg-danger">new</span></a></td>
										</c:if>
										<c:if test="${empty data.newKeyword }">
											<td class="text-center"><a href="./readContentPage?board_no=${data.boardVo.board_no }">${data.boardVo.board_title }</a></td>
										</c:if>
									</c:if>
									
									<c:if test="${sessionUser.user_no != data.userVo.user_no && data.boardVo.board_secret == 'Y' }">
										<c:if test="${!empty data.newKeyword }">
											<td class="text-center">비밀글입니다<span class="badge bg-danger">new</span></td>
										</c:if>
										<c:if test="${empty data.newKeyword }">
											<td class="text-center">비밀글입니다</td>
										</c:if>
									</c:if>
									<td class="text-center">${data.userVo.user_nickname }</td>	
									<td class="text-center">${data.boardVo.board_secret }</td>
									<td class="text-center"><fmt:formatDate value="${data.boardVo.board_writedate }" pattern="yyyy:MM:dd: HH:mm:ss" /></td>
									<td class="text-center">${data.boardVo.board_readcount }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>				
				</div>
				
				<div class="row-3">
						<div align="right">
							<div class="col-2 d-grid">
								<c:if test="${!empty sessionUser }">
									<a href="./writeContentPage" class="btn btnBasic">글쓰기</a>
								</c:if>
							</div>
						</div>
				</div>
                <!-- 페이지별 내용 끝 -->
            </div>
        </div>
    </section>
</body>

</html>