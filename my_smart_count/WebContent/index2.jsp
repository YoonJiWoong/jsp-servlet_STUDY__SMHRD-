<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Fitness - provide the easy responsive free website templates. You can easily customize and make your own website for your startup business.">
    <meta name="keywords" content="bootstrap template, Responsive Template, Website Template, free website templates, free website template download ">
    <title>Fitness-The Gym Club | Bootstrap | Free Responsive Website Templates</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- style CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- animsition css -->
    <link rel="stylesheet" type="text/css" href="css/animsition.min.css">
    <!-- Font Awesome CSS -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/fontello.css">
    <!-- font css -->
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i%7cRoboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
    <!-- owl Carousel Css -->
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    	html {scroll-behavior: smooth; /* 부드러게 */}
    </style>
    
</head>
			<%
				MemberVO vo = (MemberVO)session.getAttribute("member");
			%>

<body> <!-- class= animsition -->
	<script>
		$("#id").removeAttr("href");
	</script>
	 <div class="top-bar">
        <!-- top-bar -->
        <div class="container" style = "width : 1300px;">
            <div class="row">
                <div class="col-md-3 hidden-sm hidden-xs bdr">
                    <div class="time-info">
                        <p class="time-text">Mon - Sat : 6 am-9pm - Sun : 8am-6pm</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 hidden-xs bdr">
                    <div class="call-info">
                        <!-- call-info -->
                        <p class="call-no"> (+82) 062)655-3509</p>
                    </div>
                    <!-- /.call-info -->
                </div>
                <div class="col-md-3 col-sm-4 hidden-xs bdr">
                    <div class="mail-info">
                        <p class="mail-text">bwk1525@gmail.com</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-12">
                    <div class="top-search">
                        <div class="custom-search-input">
                            <div class="input-group  ">
                                <input type="text" class="  search-query form-control" placeholder="Search">
                                <span class="input-group-btn">
                        <button class="btn btn-default" type="button"> <i class="fa fa-search"></i> </button>
                        </span> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="hero-section">
        <div class="header">
            <!-- navigation -->
            
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6 col-xs-6">
                        <div class="logo">
                            <a href="index2.jsp"><img src="logo_120.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-md-9 col-sm-12">

                        <div class="navigation pull-right" id="navigation">
                            <ul>
                                <li class="active"><a href="index2.jsp" title="Home" class="animsition-link">Home</a></li>
                                <li><a href="#" title="Classes" class="animsition-link">목표</a>
                                    <ul>
                                        <li><a href="#target" title="Classes List">목표개수 설정</a></li>
                                    </ul>
                                </li>
                                <li><a href="#" title="Blog" class="animsition-link">자세</a>
                                    <ul>
                                        <li><a href="#link" title="Blog" class="animsition-link">참고영상</a></li>
                                    </ul>
                                </li>
                                <li><a href="#" title="Features" class="animsition-link">그래프</a>
                                    <ul>
                                        <li><a href="Graph2.jsp" title="Testimonial" class="animsition-link">일별그래프</a></li>
                                    </ul>
                                </li>
                                <li><a href="#" title="Contact Us" class="animsition-link">출석</a>
                                    <ul>
                                        <li><a href="haeuntest.jsp" title="Testimonial" class="animsition-link">출석도장</a></li>
                                    </ul>
                                </li>
                                <li><a href="#" title="Contact Us" class="animsition-link">로그인</a>
                                    <ul>
                                    <%
                                    	if (vo == null) {
                                    %>
                                        <li><a href="Join.jsp" title="Testimonial" class="animsition-link">회원가입</a></li>
                                        <li><a href="signin.html" title="Testimonial" class="animsition-link">로그인</a></li>
                                    <%
                                    	} else {
                                    %>
                                    	<li><a href="#"title="Testimonial" class="animsition-link"><%=vo.getId()%>님 환영합니다.</a></li>
                                        <li><a href="Change.jsp" title="Testimonial" class="animsition-link">회원정보수정</a></li>
                                        <li><a href="Logout" title="Testimonial" class="animsition-link">로그아웃</a></li>
                                    
                					
                                    <%
                                    	if (vo.getId().equals("admin")) {
                                    %>
                                    
                                    	<li><a href="SelectAll.jsp" title="Testimonial" class="animsition-link">전체회원관리하기</a></li>
                                    <%
                 					    }
                					%>
                  					<%
                     					}
                  					%>

                                    </ul>
                                </li>
                            </ul>
                        
                        </div>
                    </div>
                </div>
            </div>
        </div>
         <div class="container">
            <div class="row" style = "width : 2300px;">
                <div class="col-lg-6 col-md-6 col-sm-12  col-xs-12">
                    <div class="hero-caption pinside50">
                        <img src = man.png >
                    </div>
                </div>
            </div>
        </div>
    </div>
    						<!-- 자세링크 앵커태그  -->
                        	<a id="link"></a>
                        	<br><br><br><br><br><br><br>
    <div class="space-medium">
        <div class="container">
            <div class="row">  
 <!DOCTYPE html>
                <html lang="en" >
                <head>
                  <meta charset="UTF-8">
                  <title>CodePen - A Pen by 김영훈</title>
                  <link rel="stylesheet" href="./link.css">
                
                </head>
                <body>
                <div id="app">
                  <div class="search-wrapper">
                    <input type="text" v-model="search" placeholder="Search title.." />
                    <label>Search title:</label>
                  </div>
                  <div class="wrapper">
                    <div class="card" v-for="post in filteredList">
                      <a v-bind:href="post.link" target="_blank">
                        <img v-bind:src="post.img" />
                        <small>{{ post.author }}</small>
                        {{ post.title }}
                      </a>
                    </div>
                  </div>
                </div>
                <!-- partial -->
                  <script src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.9/vue.min.js'></script><script  src="./script.js"></script>
                  <script src="link.js"></script>
                </body>
                </html>
            </div>
        </div>
    </div>
    						<!-- 운동갯수 앵커태그  -->
                        	<a id="target"></a>
                        	<br><br><br><br><br><br>

    <div class="space-medium">
        <div class="container">
            <div class="row">
               <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="outline pinside80 team-block">
                        <div class="row">
                            <div class="container">
                                <!DOCTYPE html>
                                <html>
                                <head>
                                <meta charset="EUC-KR">
                                <title>Insert title here</title>
                                  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
                                    <meta charset="utf-8">
                                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                                    <meta name="viewport" content="width=device-width, initial-scale=1">
                                    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
                                    <meta name="description" content="">
                                    <meta name="author" content="">
                                    <link rel="icon" href="../../favicon.ico">
                                
                                    <title>target</title>
                                
                                    
                                    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
                                
                                   
                                    <link href="signin1.css" rel="stylesheet">
                                
                                  
                                    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
                                    
                                    <style>
                                  
                                  body{
                                      background: #848484;  /* fallback for old browsers */
                                   
                                  }
                                  </style>
                                  
                                
                                </head>
                                <body>
                                
                                    <div class="container">
                                
                                      <form class="target" action="targetUpdate">
                                        <h2 class="form-target-heading">오늘의 운동 갯수는?</h2>
                                                팔굽혀펴기<label for="push-ups" class="sr-only">팔굽혀펴기</label>
                                        <input name="push" type="text" id="push-ups" class="form-control" required>
                                                윗몸일으키기<label for="sit-up" class="sr-only">윗몸일으키기</label>
                                        <input name="sit" type="text" id="push-ups" class="form-control" required>
                                                 턱걸이<label for="chinning" class="sr-only">턱걸이</label>
                                        <input name="pull" type="text" id="chinning" class="form-control" required>
                                       
                                        <!-- bootstrap 사용법   style속성 추가해서 사용-->
                                        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="Test()" style="background-color:#cdff07; border-color: #c5f016; color: #0e0e0e;">전송</button>
                                        <button class="btn btn-lg btn-primary btn-block" type="reset" style="background-color:#cdff07; border-color: #c5f016; color: #0e0e0e;">리셋</button>
                                        
                                      </form>
                                     </div>
                                      	<script>
		
											function Test() {
												alert("오늘의 목표가 설정되었습니다."); /* 경고창 */	
				
											}
			
			
										</script>
                                
                                
                                
                                    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
                                    <!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
                                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
                                    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->
                                </body>
                                </html>
                            </div>
                       </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   
                                
    <div class="footer space-medium" style = "width : 1150px; padding-top: 20px; padding-bottom: 20px; font-color = "white">
        <div class="container" >
            <div class="row">
                <div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
                    <div class="footer-logo mb30">
                        <img src="logo_2.png" class="" alt="Fitness Website Template">
                    </div>
                </div>
                <div class="col-lg-offset-1 cols-lg-3 col-md-offset-1 col-md-3 col-sm-3 col-xs-12">
                    <div class="footer-widget mb30">
                        <h3 class="footer-title">Contact Info</h3>
                        <ul class="listnone">
                            <li>
                                <address style = "color : gray;">
								(사)스마트인재개발원
								광주광역시 남구 송암로60
                                    <br> 광주CGI센터 2층
                                </address>
                            </li>
                            <li style = "color : gray;">+82 062)655-3509</li>
                            <li style = "color : gray;">bwk1525@gmail.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-offset-1 col-lg-2 col-md-offset-1 col-md-2 col-sm-3 col-xs-12">
                    <div class="footer-widget mb30">
                        <h3 class="footer-title">Quick Links</h3>
                        <ul class="listnone">
                            <li><a href="index2.jsp">Home</a></li>
                            <li><a href="targett.html">목표</a></li>
                            <li><a href="link.html">자세</a></li>
                            <li><a href="Graph2.html">그래프</a></li>
                            <li><a href="cal.html">출석</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                    <div class="footer-widget mb30">
                        <h3 class="footer-title">Connect With us</h3>
                        <div class="footer-social"> <a href="#"><i class="fa fa-twitter"></i></a> <a href="#" class="active"><i class="fa fa-facebook"></i> </a>
                            <a href="#"> <i class="fa fa-google-plus"></i> </a>
                            <a href="#"> <i class="fa fa-pinterest"></i> </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div class="tiny-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                   Shared by <i class="fa fa-love"></i><a href="https://bootstrapthemes.co">JavaChipFrappuccino</a>
                </div>
            </div>
        </div>
    </div>
    <!-- back to top icon -->
    <a href="#0" class="cd-top" title="Go to top">Top</a>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/menumaker.js"></script>
    <!-- sticky header -->
    <script type="text/javascript" src="js/jquery.sticky.js"></script>
    <script type="text/javascript" src="js/sticky-header.js"></script>
    <!-- animsition -->
    <script type="text/javascript" src="js/animsition.js"></script>
    <script type="text/javascript" src="js/animsition-script.js"></script>
    <!-- testimonial-carousel-->
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="js/testimonial-carousel.js"></script>
    <!-- Back to top script -->
    <script src="js/back-to-top.js" type="text/javascript"></script>
    
       	<script type="text/javascript">
	
	
	$(function(){ 
		$.ajax({
			url : "GetSensor",
			type : "get",
			dataType : "json",
			success : function(data){
				$('#result').html("현재 갯수 : " + data.mysensor);
			},
			error : function(){
				
			}
		});
	});
	
		$("#push-ups").on('click',function(){
			var mysensor = $('#mysensor').val();
			$.ajax({
				url : "InputSensor",
				type : "get",
				data : {"mysensor": mysensor},
				dataType : "json",
				success : function(data){
					$('#result').html("목표갯수 : " + data.mysensor);
				},
				error : function(){
					
				}
			});
		});
	</script>
    
    
    
    
</body>
</html>