<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <title>Mehupojat</title> 
        <!-- Bootstrap CSS file -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- My CSS file -->
        <link rel="stylesheet" type="text/css" href="resources/css/index.css">

        <script type="text/jsx" src="resources/js/getProducts.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://fb.me/react-0.14.1.js"></script>
        <script src="https://fb.me/react-dom-0.14.1.js"></script>
        <script src="https://fb.me/JSXTransformer-0.13.3.js"></script>
    </head>

    <body>
        <div id ="wrapper">
            <div id="headerbar">
                <a href="index.jsp" id="pagenameLink"><img src="resources/img/mehupojat.png"</a>
                <a href="" class="productsLink">Linkki #1</a>
                <a href="" class="productsLink">Linkki #2</a>
                <sec:authorize access="isAuthenticated()">  
                    <a href="login.jsp" id="login">
                    <sec:authentication property="principal.username"/></a>
                </sec:authorize>
                <sec:authorize access="isAnonymous()"> 
                    <a href="login.jsp" id="login">Kirjaudu / Luo tili</a>
                </sec:authorize>         
            </div>

            <div class="hero-image">
                <div class="hero-text">
                    <h1>FRESH AND REFRESHING JUICE</h1>
                </div>
            </div>

            <div id="products"></div>

            <div id="footer">
                <div class="container text-center">
                    <p>Mehuboys owned by ASDSADASDSADS company</p>
                </div>
            </div>
        </div>
    </body>

</html>
