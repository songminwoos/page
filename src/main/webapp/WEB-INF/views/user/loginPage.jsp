<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<!-- left Side -->
<body>
	<div class="col-2 ms-5">
		<!-- loginBox -->
		<div class="row px-3 py-2">
			<div class="loginBox secBorder col">
				<c:choose>
					<c:when test="${empty sessionUser }">
						<!-- not logined-->
						<h3 class="secTitle"><i class="bi bi-file-lock2-fill"></i> 로그인</h3>
						<form action="../user/loginProcess" method="POST">
							<div class="loginForm">
								<input class="form-control" id="IdInput" name="user_id"
											type="text" placeholder="아이디를 입력해 주세요." aria-label="default input example" />
								<input class="form-control" id="PwInput" name="user_pw"
											type="password" placeholder="패스워드를 입력해 주세요." aria-label="default input example" />
								<div>
									<div class="chk_box">
										<input type="checkbox" id="saveIdBox" name="">
										<label>ID저장</label>
									</div>
									<div class="login_btn_box">
										<input type="submit" id="loginButton" class="btnBasic btn_submit" value="로그인">
									</div>
									<div class="login_etcBox">
										<a href="../user/userAgree">회원가입</a>
									</div>
								</div>
							</div>
						</form>
					</c:when>
					<c:otherwise>
						<h3 class="secTitle"><i class="bi bi-file-lock2-fill"></i> 로그인</h3>
						<div class="loginForm">
							${sessionUser.user_nickname }님 환영합니다.
							<div>
								<div class="chk_box"></div>
								<div class="login_etcBox">
									<a href="../user/loginoutProcess" type="button" id="logoutButton" class="btnBasic btn_submit">로그아웃</a>
								</div>
							</div>
						</div>
	
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>