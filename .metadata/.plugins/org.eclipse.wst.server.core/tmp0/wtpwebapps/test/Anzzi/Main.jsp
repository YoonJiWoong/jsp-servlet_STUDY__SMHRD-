<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="EUC-KR">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ANZZI</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" /> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" /> <!-- https://getbootstrap.com/ -->
    <link href="fontawesome/css/all.min.css" rel="stylesheet" /> <!-- https://fontawesome.com/ -->
    <link href="css/templatemo-diagoona.css" rel="stylesheet" />
    <style>
		#logo {
			width: 250px;
			height: 250px;
			position: absolute;
			background-color: transparent;
			border: 0;
			outline: 0;
		}
</style>
</head>
<body>

	<%
		MemberVO vo = (MemberVO) session.getAttribute("member");
	%>
	<div class="tm-container">        
        <div>
            <div class="tm-row pt-4">
                <div class="tm-col-left">
                    <div class="tm-site-header media">
                        <i class="fas fa-umbrella-beach fa-3x mt-1 tm-logo"></i>
                        <div class="media-body">
                            <div class="media-body">
                               <button id="logo">
                               <a href="Main.jsp">
                           <img src="img/an3.png">
                           </a>
                        </button>  
                            </div>        
                        </div>        
                    </div>
                </div>
                <div class="tm-col-right">
                    <nav class="navbar navbar-expand-lg" id="tm-main-nav">
                        <button class="navbar-toggler toggler-example mr-0 ml-auto" type="button" 
                            data-toggle="collapse" data-target="#navbar-nav" 
                            aria-controls="navbar-nav" aria-expanded="false" aria-label="Toggle navigation">
                            <span><i class="fas fa-bars"></i></span>
                        </button>
                        <div class="collapse navbar-collapse tm-nav" id="navbar-nav">
                            <ul class="navbar-nav text-uppercase">
                                <li class="nav-item active">
                                    <a class="nav-link tm-nav-link" href="" style="color: azure;"> <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                              
                                <li class="nav-item">
                               
                                </li>
                                <li class="nav-item">
                               <%if(vo != null){ %>
                                    <a class="nav-link tm-nav-link" href="ServiceCenter.jsp">?????? </a>
                                    <%} %>
                                </li>  
                                <li class="nav-item">
                                <%if(vo != null){ %>
                                    <a class="nav-link tm-nav-link" href="MyPage.jsp">??????????</a>
                                    <%} %>
                               
                                </li>                            
                                <li class="nav-item">
                                <%if(vo == null){ %>
                                    <a class="nav-link tm-nav-link" href="Login.html">??????/????????</a>
                                    <%}else{ %>
                                    <a class="nav-link tm-nav-link" href="../Logout"><%=vo.getName()+"??\t" %>????????</a>
                                    <%} %>
                                </li>
                            </ul>                            
                        </div>                        
                    </nav>
                </div>
            </div>
               
            
            
            <div class="tm-row">
                <div class="tm-col-left"></div>
                <main class="tm-col-right">
                    <section class="tm-content">
                        <img src="img/an5.png" alt="Image" class="tm-service-img".btnsa>
                    </section>
                </main>
            </div>
        </div>        

        <div class="tm-row">
            <div class="tm-col-left text-center">            
                <ul class="tm-bg-controls-wrapper">
                    <li class="tm-bg-control active" data-id="0"></li>
                    <li class="tm-bg-control" data-id="1"></li>
                    <li class="tm-bg-control" data-id="2"></li>
                </ul>            
            </div>        
            <div class="tm-col-right tm-col-footer">
                <footer class="tm-site-footer text-right">
                    <p class="mb-0">Copyright 2021 SuperClass Co. 
                    .
                    | Design: <a rel="nofollow" target="_parent" href="https://templatemo.com" class="tm-text-link">??????????</a></p>
                </footer>
            </div>  
        </div>        

        <!-- Diagonal background design -->
        <div class="tm-bg">
            <div class="tm-bg-left"></div>
            <div class="tm-bg-right"></div>
        </div>
    </div>

    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.backstretch.min.js"></script>
    <script src="js/templatemo-script.js"></script>
    
    
</body>
</html>