
/*
	select 태그를 이용해서 과일을 선택할 수 있는 창을 만들고, 과일을 선택하면 h1 태그에 선택한 과일이 출력되도록 작성.
	- 선택 안 함, 사과, 바나나, 오렌지
*/

/*

< 내가 생각하고 구현해본 것 - 실행은 되지 않았다. >

import { useState } from "react";

function Select(){

	let [sel, setSel] = useState("");

	function selection(){
		setSel(value);
	}

	return(
		<div>
			<select>
				<option onClick={selection} value="">선택 안 함</option>
				<option onClick={selection} value="사과">사과</option>
				<option onClick={selection} value="바나나">바나나</option>
				<option onClick={selection} value="오렌지">오렌지</option>
			</select>
			<br/>
			<h1>{sel}</h1>
		</div>
	)
}

export default Select;

*/

import { useState } from "react";

function Select(){

	let [fruit, setFruit] = useState("");

	function display(){
		return fruit == '' ? '' : fruit;		
	}

	return(
		<div>
			<select onChange={(e)=>setFruit(e.target.value)}>
				<option value={""}>선택 안 함</option>
				<option>사과</option>
				<option>바나나</option>
				<option>오렌지</option>
			</select>
			<br/>
			<h1>{fruit == '' ? '' : fruit}</h1>
			<h1>{display()}</h1>
		</div>
	)
}

export default Select;