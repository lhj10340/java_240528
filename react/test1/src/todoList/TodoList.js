// state 변수 활용을 위하여 필수적으로 적어줘야 한다.
import {useState} from 'react';

/*
input 창과 버튼, 리스트를 구성해서 버튼을 클릭하면 input창에 들어간 값이 오늘의 할일에 추가되도록 작성
1. state 변수를 추가한다.
	- todo , setTodo => 문자열
	- todoList, setTodoList => 배열
2. input 창에 값을 입력하면 state 변수 todo에 입력한 값으로 업데이트
3. 버튼을 클릭하면 todo의 값을 todoList에 추가
4. todoList를 이용해서 ul 태그 안에 li 태그들로 구성
	- 배열의 map을 이용해서 구성(첫번째 예제 참고)
*/

function TodoList(){

	// var 대신 let
	let [todo, setTodo] = useState("");
	let [todoList, setTodoList] = useState([]);

	function change(e){
		// todo 말고 setTodo 입력해야한다.
		setTodo(e.target.value)
	}

	function add(){
		// 3번 문제 풀이 ...
		setTodoList([...todoList, todo])
	}

	return(
		<div>
			
			<input onChange={change}/>

			<button onClick={add}>등록</button>
			
			<h1>오늘의 할일</h1>

			<ul>
				{
					// 4번 문제 풀이 ...
					todoList.map((value)=>{
						return <li>{value}</li>;
					})
				}
			</ul>

		</div>
	)
}

export default TodoList;