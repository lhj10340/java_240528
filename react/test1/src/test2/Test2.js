import {useState} from 'react';

/*
input 창과 버튼, h1 태그로 된 화면을 구성
*/

function Test2(){

	//state 변수 todo 와 setTodo를 선언

	var [todo, setTodo] = useState("");

	return(
		<div>

			<h1>Test2</h1>
			<input/>
			<button>버튼</button>

		</div>
	)
}

export default Test2;