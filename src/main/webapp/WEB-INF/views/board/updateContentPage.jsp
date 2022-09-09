<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h3 class="conTItle"><i class="bi bi-list"></i> 수정 페이지</h3>
                </div>

                <!-- 페이지별 내용 시작-->
                <div class="row mt-3">
                    <div class="col">
                        <form action="./updateContentProcess" method="post">
                            작성자 : ${data.userVo.user_nickname }<br>
                            제목 : <input type="text" class="form-control" value="${data.boardVo.board_title }"
                                name="board_title"><br>
                            내용 : <br>
                            <textarea class="form-control" rows="10" cols="40"
                                name="board_content">${data.boardVo.board_content }</textarea>
                            <br>
                            <input type="hidden" name="board_no" value="${data.boardVo.board_no }">

                            <input type="submit" class="btn btn-dark" value="수정완료">
                        </form>
                    </div>
                </div>

                <!-- 페이지별 내용 끝 -->
            </div>
        </div>
    </section>

</body>

</html>