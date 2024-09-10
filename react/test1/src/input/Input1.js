
/*
input 태그 2개를 생성
- 왼쪽 input 태그 : 쓰기가 가능
- 오른쪽 input 태그 : 읽기만 가능
- 왼쪽에 있는 input 태그에 값을 입력하면 오른쪽에 있는 input 태그의 값이 변경되도록 작업

추가 기능
input 태그 사이에 버튼을 추가
버튼을 클릭하면 읽기 전용이 반대로 되도록 작성
*/

import { useState } from "react";

/*
내 생각 (강사님 풀이를 보고 ...)
state 변수 추가.
왼쪽 input 에 onChange 를 입력, 오른쪽 input 에 value 와 readonly 를 입력.
value 의 값과 onChange 에 들어갈 함수를 동일하게 설정

추가 기능에 대한 생각
바로 이전에 복습했던 props 적용을 해보려했으나 잘 되지 않았다.
*/

/*
강사님 풀이
1. state 변수 input, setInput 추가
2. 왼쪽 input 태그의 내용이 변경되면 input 태그의 값을 가져와서 input 변수에 업데이트
3. 오른쪽 input 태그의 value를 input 변수의 값으로 업데이트

추가 기능 풀이
1. state변수 flag를 추가 (초기값 true)
2. 두 input 태그에 readonly 속성을 추가
	- 오른쪽 flag가, 왼쪽에는 !flag가 적용되도록 작성 // 여기까지는 정답 ...
3. 버튼에 클릭 이벤트를 등록
	- flag의 값을 반대로 수정
*/

function Input1(){

	let [input, setInput] = useState("");

	let change = e=>setInput(e.target.value);

	let [flag, setFlag] = useState(true);

	// 위 1줄의 코드와 동일하다.
	// function change(e){
	// 	setInput(e.target.value);
	// }

	// 일부 풀이에서 다르게 입력되어 구현이 되지 않았었다.
	// value={input} 입력.

	let btnClick = ()=>setFlag(!flag)

	return (
		<div>
				<input type="text" disabled={!flag} value={input} onChange={change}/>
				<button onClick={btnClick}>변환</button>
				<input type="text" disabled={flag} value={input} onChange={change}/>
		</div>
	)
}

export default Input1;