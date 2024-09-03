<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title ></title>
</head>
<body>

<h1 class="mt-3">커뮤니티 관리</h1>

	<ul class="list-group mt-3 mb-3">

		<c:forEach items="${list }" var="community">
		
			  <li class="list-group-item d-flex justify-content-between align-items-center">
			   <span> ${community.co_name } </span>
			   
			   <span>
				    <span class="badge badge-primary badge-pill">${community.co_count }</span>
				    <button class="btn btn-outline-danger btn-co-update" data-num ="${community.co_num}">수정</button>
				    <a href="<c:url value="/admin/community/delete?co_num=${community.co_num }"/>" class="btn btn-outline-dark">삭제</a>
			   </span>
			   
			  </li>
		</c:forEach>
	  
	</ul>
	
	<form action="<c:url value="/admin/community/insert"/>" method="post" id="form1">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="등록할 커뮤니티명을 입력하세요." name="name" required>
			<div class="input-group-append">
				<button type="submit" class="btn btn-outline-info col-12">등록</button>
			</div>
		</div>
	</form>
	
	<script type="text/javascript">
		
$('.btn-co-update').click(function(){
	$('#form2').remove();
	var co_num = $(this).data('num')
	var co_name = $(this).parent().prev().text();
	var str = `
		<form action="<c:url value="/admin/community/update"/>" method="post" id="form2">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="등록할 커뮤니티명을 입력하세요." 
				name="co_name" required 
				value="\${co_name}">
			<input type="hidden" name="co_num" value="\${co_num}"/>
			<div class="input-group-append">
				<button type="submit" class="btn btn-outline-info col-12">수정</button>
			</div>
		</div>
	</form>
	`;
	$('#form1').hide().after(str);
});
	
	</script>
	
</body>
</html>

<!-- 

< 커뮤니티 삭제기능 구현순서 - 내가 적어본 것 >

1. community.jsp 에 있는 삭제버튼에 url 을 등록하여 링크를 만든다.
2. controller 에 위에서 작성한 url 과 맞는 메소드를 작성한다.
3. dao 와 mapper 를 작성한다. ( 삭제 버튼을 위한 jsp 는 만들 필요가 없다. )

//

< 강사님 풀이 >

community.jsp

1. 삭제 버튼을 a태그로 수정
	- href에 삭제할 커뮤니티 번호를 추가. // community 뒤에 delete 까지 넣어야했다. ( 살짝 틀렸다, 아쉽다. )

controller
1. 메소드를 추가
	- GetMapping 추가 ( a태그는 get 이다. )
	- 매개변수로 커뮤니티 번호를 받아온다. // 여기 틀렸다, 매개 변수를 int co_num 으로 넣어야 했다.
	- 서비스에게 커뮤니티 번호를 주면서 삭제하라고 요청.
	- 삭제 여부를 알림으로 출력.
 -->
 
 <!-- 
 
 < 커뮤니티 수정기능 구현순서 - 내가 적어본 것 >
 
 1. community.jsp 에 있는 삭제버튼에 url을 등록하여 링크를 만든다.
 2. controller 에 위에서 작성한 url 과 맞는 메소드를 작성한다.
 	- 커뮤니티 번호를 불러온다.
 	- 수정 시, 커뮤니티를 등록하는 입력하는 창은 숨기고, 수정하는 창을 그 위에 출력한다.
 3. dao 와 mapper 를 작성한다. ( 삭제 버튼을 위한 jsp 는 만들 필요가 없다. )
 
 < 강사님 풀이 >
 
 community.jsp ( 1번 말고는 잘 모르겠다, 1번은 맞았네 ... )
 
 1. 수정 버튼에 커뮤니티 번호를 추가한다.
 	- data-xxx
 	
 2. 수정 버튼 클릭 이벤트를 등록한다. ( class 이름 변경하는건 했다 ... )
 	- 앞서 만들어진 커뮤니티 수정창을 제거. ( 수정창이 1번만 나오게 하려면 ... )
 	- 커뮤니티 등록창과 형태가 같은 커뮤니티 수정창을 만든다.
 		- 커뮤니티 번호를 수정창 안에 input:hidden 으로 추가한다.
 	- 커뮤니티 등록창 뒤에 추가한다.
 	- 커뮤니티 등록창은 감춘다.
 		
 controller
 
 1. method를 추가. ( service 부터는 다른 수정 기능을 참고하여 작성해봤다, 일단 다 작성했긴 함 ... )
 	- PostMapping 추가
 	- 커뮤니티 번호와 커뮤니티 명을 가져온다. ( 각각 가져오는게 아닌 CommunityVO 로 가져와야 했다 .. 여기 틀렸다. )
 		- 서비스에서 중복을 고려한 try - catch를 작성하지 않았다.
 	- 서비스에게 커뮤니티 번호와 커뮤니티 명을 주면서 수정하라고 요청한다.
 	- 결과에 따라 알림을 출력한다.
  -->