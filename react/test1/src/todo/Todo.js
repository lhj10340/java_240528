import {useState} from 'react';

/*
input 창과 버튼, h1 태그로 된 화면을 구성
*/

/*
1. state 변수 todo 와 setTodo 선언

2. input 창의 값이 바뀌면 콘솔에 1이 출력되게 작성

3. 콘솔창에 1 대신에 input 창에 입력된 값이 출력되도록 작성

4. state 변수 tmp 와 setTmp를 선언

5. input 창에 입력된 값을 state 변수 tmp 에 업데이트
inputChage 내부에 setTmp(value); 입력.

6. 버튼을 클릭하면 콘솔에 2가 출력되도록 작성

7. 버튼을 클릭하면 state 변수 todo의 값을 tmp의 값으로 업데이트
	function btnClick(e){
		setTodo(tmp);
	}

8. h1 태그에 to의 값을 화면에 출력
*/

function Todo(){

	var [todo, setTodo] = useState("");
	var [tmp, setTmp] = useState("");

	function inputChange(e){
		var value = e.target.value;
		setTmp(value);
	}

	function btnClick(e){
		setTodo(tmp);
	}

	return(
		<div>

			<h1>{todo}</h1>
			<input onChange={inputChange} />
			<button onClick={btnClick}>버튼</button>

		</div>
	)
}

export default Todo;