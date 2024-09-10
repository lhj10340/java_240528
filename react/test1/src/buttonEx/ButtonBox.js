
/*
버튼 '1(현재 페이지) / 5(최대 페이지) ' 로 화면을 구성
이전 버튼을 클릭하면 현재 패이지가 감소하고, 다음 버튼을 클릭하면 현재 페이지가 증가하도록 작성.
*/

import { useState } from "react";

// 내 풀이

/*
왼쪽 clickLeft, 오른쪽 clickRight 버튼에 각각 클릭 이벤트 부여

클릭 시, 해당 id 또는 name 를 가진 태그의 숫자를 변경시키는 조건문을 가진 함수를 작성 // id="pre" name="pre"

왼쪽 버튼을 누르면 현재 페이지가 감소하다가, 1보다 작아질 때, 5(최대 페이지)로 넘어가도록 ...

오른쪽 버튼을 누르면 현재 페이지가 증가하다가, 5(최대 페이지)보다 커질 때, 1(최소 페이지)로 돌아가도록 ...
*/

// 강사님 풀이

/*

1. state 변수 page 와 setPage 를 추가한다. (초기값 1)
2. 1 대신 page가 화면에 출력되도록 수정
3. 최대 페이지를 변수로 설정한다. (초기값5)
4. 5대신 최대 페이지가 화면에 출력되도록 수정
5. 이전 버튼 클릭 이벤트를 등록한다.
	- 클릭하면 page 가 1보다 크면 page 를 page - 1 로 업데이트하고,
		아니면 page 를 최대페이지로 업데이트
6. 다음 버튼 클릭 이벤트를 등록
	- 클릭했을 때, page 가 최대 페이지보다 작으면 page 를 page + 1 로 업데이트하고,
		아니면 page를 1페이지로 업데이트

*/


function ButtonBox(){

	let [page, setPage] = useState(1);
	let maxPage = 5;

	// 이전 페이지로
	function prevPage(){
		if(page > 1){
			//page = page - 1;
			setPage(page-1);
		} else{
			//page = maxPage;
			setPage(maxPage);
		}
	}

	// 다음 페이지로
	function nextPage(){
		if(page < maxPage){
			//page = page + 1;
			setPage(page+1);
		} else{
			//page = 1;
			setPage(1);
		}
	}
	
	// amount 에 따라 이전 또는 다음 페이지로
	function movePage(amount){
		let currentPage = page + amount;
		if(currentPage == 0){
			currentPage = maxPage;
		}
		if(currentPage == maxPage+1){
			currentPage = 1;
		}
		setPage(currentPage);
	}

	return(
		<div>
			<div>
				<h3>prevPage, nextPage 함수를 생성하여 구현 (함수 2개)</h3>
				<button onClick={prevPage}>&lt;</button>
					<span>
						<span>{page}</span>
						<span>/</span>
						<span>{maxPage}</span>
					</span>
				<button onClick={nextPage}>&gt;</button>
			</div>

			<div>
				<h3>movePage 함수를 생성하여 구현 (함수 1개)</h3>
			<button onClick={()=>{movePage(-1)}}>&lt;</button>
				<span>
					<span>{page}</span>
					<span>/</span>
					<span>{maxPage}</span>
				</span>
			<button onClick={()=>{movePage(1)}}>&gt;</button>
		</div>
		</div>
	)
}

export default ButtonBox;