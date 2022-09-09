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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="../resources/js/user/joinUserPage.js"></script>

	<script type="text/javascript" src="../resources/js/frame/dropdown.js"></script>
	<script type="text/javascript" src="../resources/js/frame/jquery-3.6.0.min.js"></script>

	<style>
		#error_message {
			color : red;
			font-size : 15px;
		}
	</style>

</head>

<body>
	<!-- header part end-->

	<!-- body part start -->

	<section class="container-fluid">

		<div class="row mt-4">

			<jsp:include page="./loginPage.jsp"></jsp:include>

			<div class="col">
				<!-- page Title -->
				<div class="row mt-1 conTitleArea">
					<h3 class="conTItle"><i class="bi bi-list"></i> 사용자 등록</h3>
				</div>

				<!-- 페이지별 내용 시작-->

				<div class="col">
					<form:form action="./insertUserProcess" modelAttribute="userVo" id="insertForm">
						<div class="row mt-2" id="submitOptionBox">
							<!-- 옵션박스 -->
							<div class="col">
								<div class="row mt-3">
									<div class="inputTitle">아이디</div>
									<div class="col-3 fs-5"><form:input class="form-control" id="joinIdInput" path="user_id"
											type="text" placeholder="아이디를 입력해 주세요." aria-label="default input example" />
									</div>
									<div class="col-2 d-grid"><button type="button" id="checkIdButton" class="btnBasic"
											style="height:36px;">중복확인</button></div>
									<div class="col my-auto" id="alertId"><form:errors path="user_id" id="error_message" /></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">비밀번호</div>
									<div class="col-3 fs-5"><form:input class="form-control" id="changePassword" path="user_pw"
											type="password" placeholder="패스워드를 입력해 주세요." aria-label="default input example" /></div>																				
									<div class="col-6 my-auto" id="alterPassword"><form:errors path="user_pw" id="error_message" /></div>
								</div>

								<div class="row mt-3">
									<div class="inputTitle">닉네임</div>
									<div class="col fs-5"><form:input class="form-control" id="userNickName" path="user_nickname"
											type="text" placeholder="이름을 입력해 주세요." aria-label="default input example" />
									</div>
									<div class="col-2 d-grid"><button type="button" id="checkNickNameButton" class="btnBasic"
											style="height:36px;">닉네임중복확인</button></div>
									<div class="col my-auto" id="alertNickName"><form:errors path="user_nickname" id="error_message" /></div>									
								</div>

								<div class="row mt-3">
									<div class="inputTitle">생년월일</div>
									<div class="col fs-5"><form:input class="form-control" id="userBirth" path="user_birth"
											type="date" placeholder="생년웡릴을 입력 해주세요" aria-label="default input example" /></div>
								</div>

								<div class="row mt-3">
									<div class="inputTitle">전화번호</div>
									<div class="col fs-5"><form:input class="form-control" id="userPhone" path="user_phone"
											type="text" placeholder="전화번호를 입력해주세요." aria-label="default input example" />
									</div>
									<div class="col-2 d-grid"><button type="button" id="checkPhoneNumberButton" class="btnBasic"
											style="height:36px;">중복확인</button></div>
									<div class="col my-auto" id="alertPhoneNumber"><form:errors path="user_phone" id="error_message" /></div>									
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">이메일</div>
									<div class="col-4 fs-5"><form:input class="form-control" id="userEmail" path="user_email"
											type="text" placeholder="이메일을 입력해 주세요." aria-label="default input example" />
									</div>
									<div class="col-2 d-grid"><button type="button" id="checkEmailButton" class="btnBasic"
											style="height:36px;">중복확인</button></div>
									<div class="col my-auto" id="alertEmail"><form:errors path="user_email" id="error_message" /></div>									
								</div>

								<div class="row mt-1">
									<div class="col"></div>
									<div class="col-2 d-grid mb-3 "><button type="button" id="joinButton"
											class="btnBasic inputSubmit bi bi-check2-square">&nbsp;가입하기</button></div>
									<div class="col-3"></div>
								</div>
							</div>
						</div>
					</form:form>
				</div>

				<!-- 페이지별 내용 끝 -->
			</div>
		</div>
	</section>
</body>

</html>