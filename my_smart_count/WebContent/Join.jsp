<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	

  <style>
    body {
    	
      background: #848484;  /* fallback for old browsers */
    

	
    }

    .input-form {
      max-width: 680px;

      margin-top: 80px;
      padding: 32px;

     
      background:lightgray;  /* fallback for old browsers */
     


      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(175, 122, 122, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(100, 58, 58, 0.15);
      box-shadow: 0 8px 20px 0 rgba(36, 3, 3, 0.15)
    }
  </style>


</head>
<body>

	<form action="#" method="post">
   <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
 
        <h4 class="mb-3">회원가입</h4>
        <form class="validation-form" novalidate>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="id">ID</label>
              <input maxlength='9' name="id" type="text" class="form-control" id="id" placeholder="ID를 입력해 주세요." value="" required="required" >
              
              <div class="invalid-feedback">
                ID를 입력해주세요. 
              </div>
             <input type="button" value="중복체크" onclick="idCheck()" required="required" style = "background-color :light-grey ">
             <span id="sp_result"></span>
             <input type="hidden" id='chk' name = "chk" value="0">
            </div>
            
            
            
            
      
            
 
            <div class="col-md-6 mb-3">
              <label for="pw">PW</label>
              <input maxlength="9" name="pw" type="password" class="form-control" id="pw" placeholder="PW를 입력해 주세요." value="" required>
              <div class="invalid-feedback">
                PW를 입력해주세요.
              </div>
            </div>
           
        
            <div class="col-md-6 mb-3">
                <label for="email">키</label>
                <input maxlength="3" name="height" type="text" class="form-control" id="email" placeholder="홍길동" required="required">
                <div class="invalid-feedback">
                 키를 입력해주세요.
                </div>
              </div>

              <div class="col-md-6 mb-3">
                <label for="id">몸무게</label>
                <input maxlength="3" name="kg" type="text" class="form-control" id="id" placeholder="몸무게를 입력해주세요." value="" required="required">
                <div class="invalid-feedback">
                몸무게를 입력해주세요.
                </div>
              </div>

              <div class="col-md-6 mb-3">
                <label for="id">나이</label>
                <input maxlength="3"  name="age" type="text" class="form-control" id="id" placeholder="나이를 입력해주세요." value="" required="required">
                <div class="invalid-feedback">
                나이를 입력해주세요.
                </div>
              </div>

              <div class="col-md-6 mb-3">
                <label for="id">BMI</label>
                <input maxlength="9" name="bmi" type="text" class="form-control" id="id" placeholder="BMI를 입력해주세요." value="" required="required">
                <div class="invalid-feedback">
                BMI를 입력해주세요.
                </div>
              </div>
              
              <div class="col-md-6 mb-3">
                <label for="id">닉네임</label>
                <input maxlength="9" name="nick" type="text" class="form-control" id="id" placeholder="닉네임을 입력해주세요." value="" required="required">
                <div class="invalid-feedback">
                닉네임을 입력해주세요.
                </div>
              </div>

          </div>

          

          

          <div class="mb-3" style="display:block">
            <label for="address2">성별<span class="text-muted" style="text-align:center; display:block; margin: 0 auto" ></span></label>
            남자<input type="radio" name="gender" value="M"  required="required"> 여자<input type="radio" name="gender" value="W" required="required">
          </div>

          
          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit" onclick="fn_submit()">가입 완료</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2021 YD</p>
    </footer>
  </div>
  <script>//유효성 검사기능.
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          
          

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  </script>
  
  <script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
  
  
  <script>
  				
  
		
  
			
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
			
  
  
 </form>
 


</body>
</html>