<%@page import="com.model.TimeVO"%>
<%@page import="com.model.ProductVO"%>
<%@page import="com.model.TimeDAO"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>anzzi</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" /> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" /> <!-- https://getbootstrap.com/ -->
    <link href="fontawesome/css/all.min.css" rel="stylesheet" /> <!-- https://fontawesome.com/ -->
    <link href="css/templatemo-diagoona.css" rel="stylesheet" />
        <script src="js/jquery-3.4.1.min.js"></script>
        <style>
        .dayCheck{
        display: none;
        }
        .dayCheck + label{
           background-color: white;
          border: 1px solid #cacece;
          box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05);
          padding: 9px;
          border-radius: 3px;
          display: inline-block;
          position: relative;
          color : black;
          
        }
        
        .dayCheck:checked + label {
          background-color: #2F4F4F;
          border: 1px solid #adb8c0;
          color : white;
    }
       #logo{
          width:250px;
          height:250px;
          position: absolute;
          background-color:transparent;
            border : 0;
      outline : 0;
       }
        </style>
</head>
<body>
<%
	MemberVO vo = (MemberVO)session.getAttribute("member");
	ProductVO pvo = (ProductVO)session.getAttribute("PVO");
	String p_serailnum = pvo.getP_serialnum();
	TimeDAO tdao = new TimeDAO(); 
	TimeVO tvo = tdao.getTime(p_serailnum);
	
   %>

    <div class="tm-container">        
        <div>
            <div class="tm-row pt-4">
                <div class="tm-col-left">
                    <div class="tm-site-header media">
                        <i class="fas fa-umbrella-beach fa-3x mt-1 tm-logo"></i>
                        <div class="media-body">
                             <button href="Main.jsp" id="logo">
                           <img src="img/an3.png">
                        </button>  
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
                                    <a class="nav-link tm-nav-link" href="Time.jsp">�ð����� <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="Calendar.jsp">�����ټ���</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="ServiceCenter.jsp">�Խ��� </a>
                                </li>                     
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="SelectAnzzi.jsp">SELECT ANZZI</a>
                                </li>                     
                                <li class="nav-item">
                                <%if(vo == null){ %>
                                    <a class="nav-link tm-nav-link" href="Login.html">�α���/ȸ������</a>
                                    <%}else{ %>
                                    <a class="nav-link tm-nav-link" href="../Logout"><%=vo.getName()+"\t" %>�α׾ƿ�</a>
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
                 	 <form action = "../SetTime" method = "post">
                        <h3><i>wake time</i></h3>
                        <br>
                        <input type="time" min="0" max="24"  placeholder="�ð�" name="wake_time" value="<%=tvo.getWake_time() %>">
                        <!-- <button type="submit" class="btn btn-primary">����</button> -->
                        <br>
                        <br>
                        <%String day = tvo.getDayofs(); if(day.contains("mon")){ %>
                        <input id = "ckbox1" type= "checkbox" name = "selectDay" value = "mon" class="dayCheck" checked="checked">
                        <%}else{ %>
                        <input id = "ckbox1" type= "checkbox" name = "selectDay" value = "mon" class="dayCheck">
                        <%} %>
                        <label for="ckbox1">��</label>
                        <%if(day.contains("th")){ %>
                        <input id = "ckbox2"  type= "checkbox" name = "selectDay" value = "th" class="dayCheck" checked="checked">
                        <%}else{ %>
                        <input id = "ckbox2"  type= "checkbox" name = "selectDay" value = "th" class="dayCheck">
                         <%} %>
                        <label for="ckbox2">ȭ</label>
                         <%if(day.contains("wed")){ %>
                        <input id = "ckbox3"  type= "checkbox" name = "selectDay" value = "wed" class="dayCheck" checked="checked">
                        <%}else{ %>
                        <input id = "ckbox3"  type= "checkbox" name = "selectDay" value = "wed" class="dayCheck">
                         <%} %>
                        <label for="ckbox3">��</label>
                         <%if(day.contains("tu")){ %>
                        <input id = "ckbox4"  type= "checkbox" name = "selectDay" value = "tu" class="dayCheck" checked="checked">
                        <%}else{ %>
                        <input id = "ckbox4"  type= "checkbox" name = "selectDay" value = "tu" class="dayCheck">
                        <%} %>
                        <label for="ckbox4">��</label>
                        <%if(day.contains("fri")){ %>
                        <input id = "ckbox5"  type= "checkbox" name = "selectDay" value = "fri" class="dayCheck" checked="checked">
                        <%}else{ %>
                        <input id = "ckbox5"  type= "checkbox" name = "selectDay" value = "fri" class="dayCheck">
                        <%} %>
                        <label for="ckbox5">��</label>
                        <%if(day.contains("sat")){ %>
                        <input id = "ckbox6"  type= "checkbox" name = "selectDay" value = "sat" class="dayCheck" checked="checked">
                        <%}else{ %>
                        <input id = "ckbox6"  type= "checkbox" name = "selectDay" value = "sat" class="dayCheck">
                        <%} %>
                        <label for="ckbox6">��</label>
                        <%if(day.contains("sun")){ %>
                        <input id = "ckbox7"  type= "checkbox" name = "selectDay" value = "sun" class="dayCheck" checked="checked">
                        <%}else{ %>
                        <input id = "ckbox7"  type= "checkbox" name = "selectDay" value = "sun" class="dayCheck">
                        <%} %>
                        <label for="ckbox7">��</label>
                        
                        
                        <!-- <div  class="btn1 btn-primary" >��</div>
                        <div  class="btn1 btn-primary">ȭ</div>
                        <div  class="btn1 btn-primary">��</div>
                        <div  class="btn1 btn-primary">��</div>
                        <div  class="btn1 btn-primary">��</div>
                        <div  class="btn1 btn-primary">��</div>
                        <div  class="btn1 btn-primary">��</div> -->
                     
                        <br>
                        <br>
                        <h3><i>fade in</i></h3>
                        <br>
                        <%String fade = tvo.getFade_in(); %>
                        <%if(fade.contains("10")){ %>
                        <label><input type="radio" class="btn btn-primary" value="10" name="fade_in" checked="checked">&nbsp;&nbsp;10��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <%}else{ %>
                        <label><input type="radio" class="btn btn-primary" value="10" name="fade_in">&nbsp;&nbsp;10��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <%} %>
                        <%if(fade.contains("20")){ %>
                        <label><input type="radio" class="btn btn-primary" value="20" name="fade_in" checked="checked">&nbsp;&nbsp;20��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <%}else{ %>
                        <label><input type="radio" class="btn btn-primary" value="20" name="fade_in">&nbsp;&nbsp;20��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <%} %>
                        <%if(fade.contains("30")){ %>
                        <label><input type="radio" class="btn btn-primary" value="30" name="fade_in" checked="checked">&nbsp;&nbsp;30��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <%}else{ %>
                        <label><input type="radio" class="btn btn-primary" value="30" name="fade_in">&nbsp;&nbsp;30��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <%} %>
                        
                        <hr class="mb-5">
                                            
                      <table style="border-collapse: separate;border-spacing: 0 20px;">
                      <%String sound = tvo.getSound(); %>
                      <%if(sound.contains("on")){ %>
                      <tr><td><label><input type="checkbox" name="sound" value="on" checked="checked">&nbsp;�Ҹ��˸����� ��ħ�� �˷��帱���?</label></td></tr>
                      <%}else{ %>
                      <tr><td><label><input type="checkbox" name="sound" value="on">&nbsp;�Ҹ��˸����� ��ħ�� �˷��帱���?</label></td></tr>
                      <%} %>
                      <%String weather_sound = tvo.getWeather_sound(); %>
                      <%if(weather_sound.contains("on")){ %>
                      <tr><td><label><input type="checkbox" name="weather_sound" value="on" checked="checked"> &nbsp;�����Ҹ��� ��ħ�� �˷��帱���?</label></td></tr>
                      <%}else{ %>
                      <tr><td><label><input type="checkbox" name="weather_sound" value="on"> &nbsp;�����Ҹ��� ��ħ�� �˷��帱���?</label></td></tr>
                      <%} %>
                      <%String schedule = tvo.getSchedule(); %>
                      <%if(schedule.contains("on")){ %>
                      <tr><td><label><input type="checkbox" name="schedule" value="on" checked="checked"> &nbsp;�����پ˸����� ��ħ�� �˷��帱���?</label></td></tr>
                      <%}else{ %>
                      <tr><td><label><input type="checkbox" name="schedule" value="on"> &nbsp;�����پ˸����� ��ħ�� �˷��帱���?</label></td></tr>
                      <%} %>
                      <%String pattern = tvo.getPattern(); %>
                      <%if(pattern.contains("on")){ %>
                      <tr><td><label><input type="checkbox" name="pattern" value="on" checked="checked">&nbsp;�������ϱ���� �̿��Ͻðڽ��ϱ�? </label></td></tr>
                      <%}else{ %>
                      <tr><td><label><input type="checkbox" name="pattern" value="on">&nbsp;�������ϱ���� �̿��Ͻðڽ��ϱ�? </label></td></tr>
                      <%} %>
                         </table>
                    <input type="submit" id="send" class="btn btn-primary" value='��!'>
                    </form>
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
                    
                        | Design: <a rel="nofollow" target="_parent" href="https://templatemo.com" class="tm-text-link">�Ϳ���۹�</a></p>
                </footer>
            </div>  
        </div>

        <!-- Diagonal background design -->
        <div class="tm-bg">
            <div class="tm-bg-left"></div>
            <div class="tm-bg-right"></div>
        </div>
    </div>
    


    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.backstretch.min.js"></script>
    <script src="js/templatemo-script.js"></script>
   
</body>
</html>