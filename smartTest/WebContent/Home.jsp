<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    <!DOCTYPE HTML>
<!--
	Dimension by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Dimension by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
		
		<%
				MemberVO vo = (MemberVO) session.getAttribute("member");
		
			%>
		
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="logo">
							<span class="icon fa-gem"></span>
						</div>
						<div class="content">
							<div class="inner">
								<h1>Smart Health Counter</h1>
								<p>Slow and steady win the game</p>
								<%if(vo!=null){%>
									
									<p><%=vo.getId()%>님 환영합니다.</p>
									
								<%} %>
								
							</div>
						</div>
						<nav>
							<ul>
							
							
							<%
							if (vo == null) {
						%>
						<li><a href="#Login">로그인</a></li>
						<li><a href="#join">회원가입</a></li>												
						<%
							} else {
						%>

						<li><a href="Logout">로그아웃</a></li>
						<li><a href="#updata">Mypage</a></li>
						<li><a href="#work">카운팅 그래프</a></li>
						<li><a href="#about">운동추천 및 자세</a></li>
						<li><a href="#contact">출석체크</a></li>
						
					<%
                     if (vo.getId().equals("admin")) {
                  %><li><a href="#updata">전체회원관리하기</a></li>
                  
             
                  <%
                     }
                  %>
                  <%
                     }
                  %>
							
							
							
							
							
							
							
							
							
						
							
								<!--<li><a href="#elements">Elements</a></li>-->
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Intro -->
							<article id="join">
								<h2 class="major">Join</h2>
								
								 <form class="form-signin" action="#">
        							<div>
    							    <label for="id">ID</label>
        							<input maxlength="9" name="id" type="text" id="id" placeholder="ID" required="required"><br>
        							 <input type="button" value="중복체크" onclick="idCheck()" required="required">
             						 <span id="sp_result"></span>
            						 <input type="hidden" id='chk' name = "chk" value="0">
									<br><br>
        							<label for="inputPassword">password</label>
        							<input maxlength="9" name="pw" type="password" id="inputPassword" placeholder="PW" required="required"><br>
        							<label for="inputHeihgt">Heihgt</label>
        							<input maxlength="3" name="heihgt" type="text" id="inputHeihgt" placeholder="heihgt" required="required"><br>
        							<label for="inputKg">KG</label>
        							<input maxlength="3" name="kg" type="text" id="inputKg" placeholder="kg" required="required"><br>    			
        							<label for="inputnick">nick</label>
        							<input maxlength="9" name="nick" type="text" id="inputnick" placeholder="nick" required="required"><br>
   									<label for="inputage]">age</label>
        							<input maxlength="3" name="age" type="text" id="inputage" placeholder="age" required="required"><br>   									
        							<label for="inputbmi">bmi</label>
        							<input maxlength="9" name="bmi" type="text" id="inputbmi" placeholder="bmi" required="required"><br>
   									<label for="inputgender">성별</label>
									<input type="radio" id="inputgender1" name="gender" value="M">
									<label for="inputgender1">남자</label>
									<input type="radio" id="inputgender2" name="gender" value="W">
									<label for="inputgender2">여자</label>   									   
        							<button type="submit" onclick="fn_submit()">가입 완료</button>
   									
   									
   									</div>
        							
      							</form>
								
							</article>
							
							
							<article id="updata">
								<h2 class="major">회원정보수정</h2>
								
								 <form class="form-updata" action="Update">
        							<div>
        							
        							<label for="inputPassword">password</label>
        							<input maxlength="9" name="pw" type="password" id="inputPassword" placeholder="PW" required="required"><br>
        							<label for="inputHeihgt">Heihgt</label>
        							<input maxlength="3" name="heihgt" type="text" id="inputHeihgt" placeholder="heihgt" required="required"><br>
        							<label for="inputKg">KG</label>
        							<input maxlength="3" name="kg" type="text" id="inputKg" placeholder="kg" required="required"><br>    			
   									<label for="inputage]">age</label>
        							<input maxlength="3" name="age" type="text" id="inputage" placeholder="age" required="required"><br>   									
        							<label for="inputbmi">bmi</label>
        							<input maxlength="9" name="bmi" type="text" id="inputbmi" placeholder="bmi" required="required"><br>
   									<label for="inputgender">성별</label>
									<input type="radio" id="inputgender3" name="gender" value="M">
									<label for="inputgender3">남자</label>
									<input type="radio" id="inputgender4" name="gender" value="W">
									<label for="inputgender4">여자</label>  									   
        							<button type="submit">수정 완료</button>
   									
   									
   									</div>
        							
      							</form>
								
							</article>
							
							
							
							
							
							<article id="Login">
								<h2 class="major">Login</h2>
								
								 <form class="form-signin" action="Login">
        							<div>
    							    <label for="inputEmail">ID</label>
        							<input name="id" type="text" id="inputEmail" placeholder="ID" required="required"><br>
        							<label for="inputPassword">password</label>
        							<input name="pw" type="password" id="inputPassword" placeholder="PW" required="required"><br>
   									</div>
        							<button type="submit">Login</button>
      							</form>
								
								
								
								
								
								
								</article>
							
							

						<!-- Work -->
							<article id="work">
								<h2 class="major">그래프</h2>
							
								<p>윗몸 일으키기</p>
								<div back><canvas id="myChart"></div><br><br><br><br>
								<p>팔굽혀펴기</p>
								<div><canvas id="myChart2"></div><br><br><br><br>
								<p>턱걸이</p>
								<div><canvas id="myChart3"></div>
								
									</article>

						<!-- About -->
							<article id="about">
								<h2 class="major">운동추천</h2>								
								<p>스마트 헬스 카운터는 다음과 같은 다양한 운동들을 추천합니다.</p>
								
								
								<!DOCTYPE html>
                <html lang="en" >
                <head>
                  <meta charset="UTF-8">
                  <title>CodePen - A Pen by 김영훈</title>
                  <link rel="stylesheet" href="link.css">
                
                </head>
                <body>
                <div id="app">
                  <div class="search-wrapper">
                  
                  </div>
                  <div class="wrapper">
                    <div class="card" v-for="post in filteredList">
                      <a v-bind:href="link.css" target="_blank">
                        <img v-bind:src="post.img" />
						<small>{{  post.author  }}</small>
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
                
                
                
                
                
                
                
								
							
								</article>

						<!-- Contact -->
							<article id="contact">
								<h2 class="major">Contact</h2>
								<form method="post" action="#">
									<div class="fields">
										<div class="field half">
											<label for="name">Name</label>
											<input type="text" name="name" id="name" />
										</div>
										<div class="field half">
											<label for="email">Email</label>
											<input type="text" name="email" id="email" />
										</div>
										<div class="field">
											<label for="message">Message</label>
											<textarea name="message" id="message" rows="4"></textarea>
										</div>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" class="primary" /></li>
										<li><input type="reset" value="Reset" /></li>
									</ul>
								</form>
								<ul class="icons">
									<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
									<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
									<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
									<li><a href="#" class="icon brands fa-github"><span class="label">GitHub</span></a></li>
								</ul>
							</article>

						<!-- Elements -->
							<article id="elements">
								<h2 class="major">Elements</h2>

								<section>
									<h3 class="major">Text</h3>
									<p>This is <b>bold</b> and this is <strong>strong</strong>. This is <i>italic</i> and this is <em>emphasized</em>.
									This is <sup>superscript</sup> text and this is <sub>subscript</sub> text.
									This is <u>underlined</u> and this is code: <code>for (;;) { ... }</code>. Finally, <a href="#">this is a link</a>.</p>
									<hr />
									<h2>Heading Level 2</h2>
									<h3>Heading Level 3</h3>
									<h4>Heading Level 4</h4>
									<h5>Heading Level 5</h5>
									<h6>Heading Level 6</h6>
									<hr />
									<h4>Blockquote</h4>
									<blockquote>Fringilla nisl. Donec accumsan interdum nisi, quis tincidunt felis sagittis eget tempus euismod. Vestibulum ante ipsum primis in faucibus vestibulum. Blandit adipiscing eu felis iaculis volutpat ac adipiscing accumsan faucibus. Vestibulum ante ipsum primis in faucibus lorem ipsum dolor sit amet nullam adipiscing eu felis.</blockquote>
									<h4>Preformatted</h4>
									<pre><code>i = 0;

while (!deck.isInOrder()) {
    print 'Iteration ' + i;
    deck.shuffle();
    i++;
}

print 'It took ' + i + ' iterations to sort the deck.';</code></pre>
								</section>

								<section>
									<h3 class="major">Lists</h3>

									<h4>Unordered</h4>
									<ul>
										<li>Dolor pulvinar etiam.</li>
										<li>Sagittis adipiscing.</li>
										<li>Felis enim feugiat.</li>
									</ul>

									<h4>Alternate</h4>
									<ul class="alt">
										<li>Dolor pulvinar etiam.</li>
										<li>Sagittis adipiscing.</li>
										<li>Felis enim feugiat.</li>
									</ul>

									<h4>Ordered</h4>
									<ol>
										<li>Dolor pulvinar etiam.</li>
										<li>Etiam vel felis viverra.</li>
										<li>Felis enim feugiat.</li>
										<li>Dolor pulvinar etiam.</li>
										<li>Etiam vel felis lorem.</li>
										<li>Felis enim et feugiat.</li>
									</ol>
									<h4>Icons</h4>
									<ul class="icons">
										<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
										<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
										<li><a href="#" class="icon brands fa-github"><span class="label">Github</span></a></li>
									</ul>

									<h4>Actions</h4>
									<ul class="actions">
										<li><a href="#" class="button primary">Default</a></li>
										<li><a href="#" class="button">Default</a></li>
									</ul>
									<ul class="actions stacked">
										<li><a href="#" class="button primary">Default</a></li>
										<li><a href="#" class="button">Default</a></li>
									</ul>
								</section>

								<section>
									<h3 class="major">Table</h3>
									<h4>Default</h4>
									<div class="table-wrapper">
										<table>
											<thead>
												<tr>
													<th>Name</th>
													<th>Description</th>
													<th>Price</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Item One</td>
													<td>Ante turpis integer aliquet porttitor.</td>
													<td>29.99</td>
												</tr>
												<tr>
													<td>Item Two</td>
													<td>Vis ac commodo adipiscing arcu aliquet.</td>
													<td>19.99</td>
												</tr>
												<tr>
													<td>Item Three</td>
													<td> Morbi faucibus arcu accumsan lorem.</td>
													<td>29.99</td>
												</tr>
												<tr>
													<td>Item Four</td>
													<td>Vitae integer tempus condimentum.</td>
													<td>19.99</td>
												</tr>
												<tr>
													<td>Item Five</td>
													<td>Ante turpis integer aliquet porttitor.</td>
													<td>29.99</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="2"></td>
													<td>100.00</td>
												</tr>
											</tfoot>
										</table>
									</div>

									<h4>Alternate</h4>
									<div class="table-wrapper">
										<table class="alt">
											<thead>
												<tr>
													<th>Name</th>
													<th>Description</th>
													<th>Price</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Item One</td>
													<td>Ante turpis integer aliquet porttitor.</td>
													<td>29.99</td>
												</tr>
												<tr>
													<td>Item Two</td>
													<td>Vis ac commodo adipiscing arcu aliquet.</td>
													<td>19.99</td>
												</tr>
												<tr>
													<td>Item Three</td>
													<td> Morbi faucibus arcu accumsan lorem.</td>
													<td>29.99</td>
												</tr>
												<tr>
													<td>Item Four</td>
													<td>Vitae integer tempus condimentum.</td>
													<td>19.99</td>
												</tr>
												<tr>
													<td>Item Five</td>
													<td>Ante turpis integer aliquet porttitor.</td>
													<td>29.99</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="2"></td>
													<td>100.00</td>
												</tr>
											</tfoot>
										</table>
									</div>
								</section>

								<section>
									<h3 class="major">Buttons</h3>
									<ul class="actions">
										<li><a href="#" class="button primary">Primary</a></li>
										<li><a href="#" class="button">Default</a></li>
									</ul>
									<ul class="actions">
										<li><a href="#" class="button">Default</a></li>
										<li><a href="#" class="button small">Small</a></li>
									</ul>
									<ul class="actions">
										<li><a href="#" class="button primary icon solid fa-download">Icon</a></li>
										<li><a href="#" class="button icon solid fa-download">Icon</a></li>
									</ul>
									<ul class="actions">
										<li><span class="button primary disabled">Disabled</span></li>
										<li><span class="button disabled">Disabled</span></li>
									</ul>
								</section>

								<section>
									<h3 class="major">Form</h3>
									<form method="post" action="#">
										<div class="fields">
											<div class="field half">
												<label for="demo-name">Name</label>
												<input type="text" name="demo-name" id="demo-name" value="" placeholder="Jane Doe" />
											</div>
											<div class="field half">
												<label for="demo-email">Email</label>
												<input type="email" name="demo-email" id="demo-email" value="" placeholder="jane@untitled.tld" />
											</div>
											<div class="field">
												<label for="demo-category">Category</label>
												<select name="demo-category" id="demo-category">
													<option value="">-</option>
													<option value="1">Manufacturing</option>
													<option value="1">Shipping</option>
													<option value="1">Administration</option>
													<option value="1">Human Resources</option>
												</select>
											</div>
											<div class="field half">
												<input type="radio" id="demo-priority-low" name="demo-priority" checked>
												<label for="demo-priority-low">Low</label>
											</div>
											<div class="field half">
												<input type="radio" id="demo-priority-high" name="demo-priority">
												<label for="demo-priority-high">High</label>
											</div>
											<div class="field half">
												<input type="checkbox" id="demo-copy" name="demo-copy">
												<label for="demo-copy">Email me a copy</label>
											</div>
											<div class="field half">
												<input type="checkbox" id="demo-human" name="demo-human" checked>
												<label for="demo-human">Not a robot</label>
											</div>
											<div class="field">
												<label for="demo-message">Message</label>
												<textarea name="demo-message" id="demo-message" placeholder="Enter your message" rows="6"></textarea>
											</div>
										</div>
										<ul class="actions">
											<li><input type="submit" value="Send Message" class="primary" /></li>
											<li><input type="reset" value="Reset" /></li>
										</ul>
									</form>
								</section>

							</article>

					</div>

				<!-- Footer -->
					<footer id="footer">
						<p class="copyright">&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
					</footer>

			</div>

		<!-- BG -->
			<div id="bg"></div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			
			<script>

  // === include 'setup' then 'config' above ===


  var data1 = {
      label: '목표갯수',
      backgroundColor: 'rgb(0, 0, 0)',
      borderColor: 'rgb(0, 0, 0)',

      type: 'line',

      data: [20, 20, 20, 20, 20, 20, 20]
  };

  var data2 = {
      label: '실제갯수',
      backgroundColor: 'rgb(255, 0, 0)',
      borderColor: 'rgb(255, 0, 0)',
      data: [10, 25, 15, 30, 5, 30, 45],


  };

  const labels = [
      '10월1일',
      '10월2일',
      '10월3일',
      '10월4일',
      '10월5일',
      '10월6일',
  ];

  const Adata = {
      labels: labels,
      datasets: [
          data1, data2],
  };

  const config = {
      type: 'bar',
      data: Adata,
      options: {

          maintainAspectRatio: false,
          plugins: {
            title: {
                display: true,
                text: '윗몸일으키기'
            }
        }
      }
  };

  const myChart = new Chart(
      document.getElementById('myChart'),
      config

  );
//////////////////////////////

var data3 = {
      label: '목표갯수',
      backgroundColor: 'rgb(0, 0, 0)',
      borderColor: 'rgb(0, 0, 0)',

      type: 'line',

      data: [30, 30, 30, 30, 30, 30, 30]
  };

  var data4 = {
      label: '실제갯수',
      backgroundColor: 'rgb(255, 0, 0)',
      borderColor: 'rgb(255, 0, 0)',
      data: [50, 25, 45, 30, 15, 35, 45],


  };

  const Adata2 = {
      labels: labels,
      datasets: [
          data3, data4],
  };



  const config2 = {
      type: 'bar',
      data: Adata2,
      options: {

          maintainAspectRatio: false,
          plugins: {
            title: {
                display: true,
                text: '팔굽혀펴기'
            }
        }
      }
  };

  const myChart2 = new Chart(
      document.getElementById('myChart2'),
      config2

  );

  /////////////////////////////////

  var data5 = {
      label: '목표갯수',
      backgroundColor: 'rgb(0, 0, 0)',
      borderColor: 'rgb(0, 0, 0)',

      type: 'line',

      data: [10, 10, 10, 10, 10, 10, 10]
  };

  var data6 = {
      label: '실제개수',
      backgroundColor: 'rgb(255, 0, 0)',
      borderColor: 'rgb(255, 0, 0)',
      data: [20, 5, 35, 14, 7, 15, 5],


  };

  const Adata3 = {
      labels: labels,
      datasets: [
          data5, data6],
  };




  const config3 = {
      type: 'bar',
      data: Adata3,
      options: {
    	  
          maintainAspectRatio: false,
          plugins: {
            title: {
                display: true,
                text: '턱걸이갯수'
            }
        }
      }
  };

  const myChart3 = new Chart(
      document.getElementById('myChart3'),
      config3

  );


  function idCheck() {
		
		var input = document.getElementById("id");
		
		$.ajax({
			type : "post", // 데이터 전송(요청) 방식
			data : {"id": input.value}, // 전송하는 데이터
			url : "idCheck", // 데이터를 전송하는 (요청하는) 서퍼페이지 url
			dataType : "text", // 응답 데이터의 형식
			success : function(data) { //통신 성공
				
				var sp_result = document.getElementById("sp_result");
				
				if(data=="true"){
					
					sp_result.innerText = "사용불가능한 아이디";
					input.value="";
					$('#chk').attr('value', '0');
					
				}else{
					
					$("#sp_result").text("사용가능한 아이디");
					$('#chk').attr('value', '1');
					$('form').attr('action', 'Join');
	
				}
				
				
			}, 
			error : function () { // 통신 실패
				alert("통신실패")
			}
								
		});

		}
	
		
		
		
	      function fn_submit() {
				if($('#chk').val() =='0'){ // value값 가져올때는 .val()
					alert("ID 중복체크를 해주세요!!");
					
					return false;
					// 이 false값을 받아서 if 문 이용해서 action도 조정해주고 alert로 해줄수도 있겠네요 
					//그 조금 더 공부 해보고 질문드려도 될까요! ㅇ ㅣ해할 시간이 필요합니다 ㅠㅠ 네 이따 카톡으로 말씀해 주세요 월요일에도 괜찮구요
					//넵 감사합니다!!
				}
				else{
					alert("회원가입 성공");
				}
          }
		
  
  
  



</script>
			
			
			
			
  <script src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.9/vue.min.js'></script><script  src="./script.js"></script>
  <script src="link.js"></script>
			
			
			
			

	</body>
</html>
    