<%@page import="controller.GraphDAO"%>
<%@page import="model.MemberVO"%>
<%@page import="model.GraphVo"%>
<%@page import="model.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTDHTML4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html id="id_html">
<head>
<title>Full Secondary Column, 1/3 x 1/3 x 1/3 Main Column.</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Graph2styles.css">
</head>
<body>
	<div id="doc3" class="yui-t7">
		<div id="hd">
			<div id="header">
				<br>
				<h1 align="center" style="color: white">스마트 운동 카운터</h1>
				<p align="center" style="color: white">스마트 운동 카운터를 이용한 카운팅 결과를
					그래프로 볼 수 있습니다.</p>
			</div>
		</div>
		<div id="bd">
			<div id="yui-main">
				<div class="yui-b">
					<div class="yui-gb" style="height :75px">
						<div class="yui-u first">
							<div class="content">
								<canvas id="myChart">
							</div>
						</div>
						<div class="yui-u">
							<div class="content">
								<canvas id="myChart2"></canvas>
							</div>
						</div>
						<div class="yui-u">
							<div class="content">
								<canvas id="myChart3"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--
                        <div class="yui-b">
                          <div id="secondary">Secondary Column</div>
                        </div>
                      </div>
                      <div id="ft">
                        <div id="footer">Footer</div>
                      </div>
                    </div>
                    -->




			<%
				//JDBC(Select)
			GraphDAO gdao = new GraphDAO();

			// 목표갯수
			String[] event = gdao.get();
			String push_tgt = event[0];
			String sit_tgt = event[1];
			String pull_tgt = event[2];

			MemberVO vo = (MemberVO) session.getAttribute("member");
			String id = vo.getId();
			ArrayList<GraphVo> a0 = gdao.R_COUNT(id, "a0");
			
			ArrayList<GraphVo> b0 = gdao.R_COUNT(id, "b0");
			
			ArrayList<GraphVo> c0 = gdao.R_COUNT(id, "c0");
			%>


			<%
				/* 	   GraphVo gvo;
				   
				   MemberDAO dao = new MemberDAO();
				   ArrayList<GraphVo> al = dao.R_COUNT("A"); */
			%>

			<script>
                    
                    
                        // === include 'setup' then 'config' above ===
                        var push_tgt ="<%=push_tgt%>"; 
                        var sit_tgt ="<%=sit_tgt%>"; 
                        var pull_tgt ="<%=pull_tgt%>"; 
                        
                        
                        var data1 = {
                            label: '목표갯수',
                            backgroundColor: 'rgb(0, 0, 0)',
                            borderColor: 'rgb(0, 0, 0)',
                            type: 'line',
                            data: []
                        };
                            	<%for (int i = 0; i < a0.size(); i++) {%>
                            		
                            		data1.data.push('<%=push_tgt%>');
                            		<%}%>
                        var data2 = {
                            label: '실제갯수',
                            backgroundColor: 'rgb(255, 0, 0)',
                            borderColor: 'rgb(255, 0, 0)',
                            data: [
                            	
                  
                            ]
                        };
                            	<%for (int i = 0; i < a0.size(); i++) {%>
                            		
                            	data2.data.push('<%=a0.get(i).getR_COUNT()%>');
                            		
                            	<%}%>
                            	// 다른것들도 라벨 추가해야함
                        const labels = [];
                        const labels2 = [];
                        const labels3 = [];
                        
                        <%for (int i = 0; i < a0.size(); i++) {%>
                        
                    	labels.push("<%=a0.get(i).getDate().substring(0,10)%>")
                    	
                    	console.log('<%=a0.get(i).getDate()%>');
                    	<%}%>
                    	console.log('<%=a0.size()%>');
                        const Adata = {
                            labels: labels,
                            datasets: [data1, data2]
                        };
                        const config = {
                            type: 'bar',
                            data: Adata,
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
                        
                        
                        
                        // ////////////////////////////
                        var data3 = {
                            label: '목표갯수',
                            backgroundColor: 'rgb(0, 0, 0)',
                            borderColor: 'rgb(0, 0, 0)',
                            type: 'line',
                            data: [
                            	
                            ]
                        };
                            	<%for (int i = 0; i < b0.size(); i++) {%>
                            		
                            		data3.data.push('<%=sit_tgt%>')
                            		
                            		<%}%>
                        var data4 = {
                            label: '실제갯수',
                            backgroundColor: 'rgb(255, 0, 0)',
                            borderColor: 'rgb(255, 0, 0)',
                            data: [
                            ]
                        };
                            	<%for (int i = 0; i < b0.size(); i++) {%>
                            	data4.data.push('<%=b0.get(i).getR_COUNT()%>')
                            	<%}%>
                        		
                                 // label
                                 
                                 /* const labels = []; */
                                 
                                <%for (int i = 0; i < b0.size(); i++) {%>
                                 
                             	labels2.push("<%=b0.get(i).getDate()%>")
                             	
                             	console.log('<%=b0.get(i).getDate()%>');
                             	<%}%>    	
                             	console.log('<%=b0.size()%>');
                            	
                        const Adata2 = {
                            labels: labels2,
                            datasets: [data3, data4]
                        };
                        const config2 = {
                            type: 'bar',
                            data: Adata2,
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
                        
                        
                        
                        
                        // ///////////////////////////////
                        var data5 = {
                            label: '목표갯수',
                            backgroundColor: 'rgb(0, 0, 0)',
                            borderColor: 'rgb(0, 0, 0)',
                            type: 'line',
                            data: [
                            ]
                        };
                            	<%for (int i = 0; i < c0.size(); i++) {%>
                            		
                            		data5.data.push(<%=pull_tgt%>);
                            		
                            		<%}%>
                        var data6 = {
                            label: '실제개수',
                            backgroundColor: 'rgb(255, 0, 0)',
                            borderColor: 'rgb(255, 0, 0)',
                            data: [
                            ]
                        };
                            	<%for (int i = 0; i < c0.size(); i++) {%>
                            		
                            		data6.data.push(<%=c0.get(i).getR_COUNT()%>);
                            	<%}%>
                            	// 라벨
                            	/* const labels = []; */
                                
                                 <%for (int i = 0; i < c0.size(); i++) {%>
                                
                            	labels3.push("<%=c0.get(i).getDate()%>")
                            	
                            	console.log('<%=c0.get(i).getDate()%>');
                            	<%}%>    	
                            	console.log('<%=c0.size()%>');
                            	
                        const Adata3 = {
                            labels: labels3,
                            datasets: [data5, data6]
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
                        const myChart1 = new Chart(document.getElementById('myChart').getContext('2d'), config);
                     	const myChart2 = new Chart(document.getElementById('myChart2'), config2);
                        const myChart3 = new Chart(document.getElementById('myChart3'), config3); 
                    </script>
</body>
<div class="logo" align="center">
	<a href="index2.jsp"><img src="logo_120.png" alt=""></a>
</div>
<!--   <button type="button"  onclick="location.href='index2.jsp'" id = "home" style="background-color: #fffadf;" >홈으로</button> -->
</html>