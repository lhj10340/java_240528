import { useState } from "react";

function PostInsert({list, setList}){

	let [ title, setTitle ] = useState("");
	let [ writer, setWriter ] = useState("");
	let [ content, setContent ] = useState("");

	function btnClick(){
	
		// 입력한 제목, 작성자, 내용을 이용해서 객체로 만들고 만들어진 객체를 콘솔에 출력한다.
		// 속성의 이름과 변수의 값이 동일할 경우, 이름만 적어줘도 실행이 된다.

		var view = 0;

		let post = {
			title, content, writer, view
		}

		setList([post, ...list])

		// let post = {
		// 	// title, content, writer <= 요렇게!
		// 	title : title,
		// 	writer : writer,
		// 	content : content
		// }

		/*
			< 강사님 풀이 >
			제목, 작성자, 내용 입력창에 입력된 값들을 지운다.
			1. 삭제할 부분에 각각 value를 추가한다.
			2. 각각의 부분을 빈 문자열로 초기화.
		*/

		setTitle('');
		setWriter('');
		setContent('');

	}

	return (
		<div>
			<input type="text" id="title" name="title" placeholder="제목을 입력하세요." 
				onChange={(e)=>setTitle(e.target.value)}
				value={title}/>
			<input type="text" id="writer" name="writer" placeholder="작성자 입력하세요." 
				onChange={(e)=>setWriter(e.target.value)}
				value={writer}/>
			<textarea id="content" name="content" placeholder="내용을 입력하세요."
				onChange={(e)=>setContent(e.target.value)} value={content}></textarea>
			<button className="btn" onClick={btnClick}>게시글 등록</button>
		</div>
	)
}

export default PostInsert;