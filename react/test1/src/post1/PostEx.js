import { useState } from 'react';
import Modal from './Modal'
import './PostEx.css';
import PostInsert from './PostInsert';
import PostList from './PostList';

/*
게시글 제목, 내용, 작성자를 입력해서 버튼을 클릭하면
입력한 게시글 정보가 콘솔창에 출력되도록 작성.

< 강사님 풀이 >
1. state 변수 3개 추가 ( title, writer, content )
2. 내용이 바뀔 때마다 변경된 내용을 각 항목에 업데이트
3. 버튼을 클릭하면 title, writer, content 를 콘솔에 출력

+
< 내가 하려했던 풀이의 문제점 >
	- onChange 이벤트를 생성하지 않았다. 그 이외에는 얼추 비슷했다.

*/

function PostEx(){
	
	let [list, setList] = useState([{
		title : '공지',
		writer : 'admin',
		content : '공지사항',
		view : 0
	}]);
	
	return(
		<div>
			<PostInsert list={list} setList={setList} />
			<hr/>
			<PostList list={list} setList={setList}/>
		</div>
	)
}


export default PostEx;