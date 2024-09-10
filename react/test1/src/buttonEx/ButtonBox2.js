

import { useState } from "react";

/*
PagenationBox 컴포넌트를 생성해서 2개를 만들어 활용

1/4 버튼 과 1/13 버튼 ...

	- 재사용을 위해 props를 활용할 수 있는지 확인하는 예제

*/

function ButtonBox2(){

	return(
		<div>
			<PagenationBox maxPage={4}/>
			<PagenationBox maxPage={13}/>
		</div>
	)
}

function PagenationBox({maxPage}){

	let [page, setPage] = useState(1);

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

	return(
			<div>
				<button onClick={prevPage}>&lt;</button>
					<span>
						<span>{page}</span>
						<span>/</span>
						<span>{maxPage}</span>
					</span>
				<button onClick={nextPage}>&gt;</button>
			</div>
	)

}

export default ButtonBox2;