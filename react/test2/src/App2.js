
/*
게시글 목록 조회 + 게시글 등록
- 게시글 등록을 할 화면을 구성 : 제목, 내용, 작성자
- 게시글 등록 버튼을 클릭하면 제목, 내용, 작성자가 알림창으로 출력되도록 작성
- 게시글 등록 버튼을 클릭하면 입력된 제목, 내용, 작성자가 빈 문자열이 되도록 작성
- 게시글 목록을 화면에 출력되도록 작성
*/

import { useState } from "react";

function App2(){

	let [list, setList] = useState([
		{
			title : '제목1',
			content : '내용1',
			writer : 'admin'
		},
		{
			title : '제목2',
			content : '내용2',
			writer : 'abc123'
		}
	]);

	let [title, setTitle] = useState('');
	let [content, setContent] = useState('');
	let [writer, setWriter] = useState('');
	
	// 여기는 렌더링만 했다. return 이 붙지 않았다.
	// 붙는 경우는 화면에 보여주는 부분을 작성하는 경우다.

	const click = ()=>{

			let post = {
				title,
				writer,
				content
			};

			setList([...list, post]);

			setTitle("");
			setWriter("");
			setContent("");

	}

	return(
		<div>
			<div>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
						</tr>
					</thead>
					<tbody>
					{
						list.map((item, index)=>{
							return(
								<tr key={"tr" + index}>
									<td>{index+1}</td>
									<td>{item.title}</td>
									<td>{item.writer}</td>
								</tr>
							)
						})
					}
					</tbody>
				</table>
			</div>
			<div>
				<input type="text" placeholder="제목을 입력하세요." 
					onChange={(e)=> setTitle(e.target.value)} value={title}/>
				<br/>
				<input type="text" placeholder="작성자를 입력하세요." 
					onChange={(e)=> setWriter(e.target.value)} value={writer}/>
				<br/>
				<br/>
				<textarea type="text" placeholder="내용을 입력하세요."
					onChange={(e)=> setContent(e.target.value)} value={content}/>
				<br/>
				<br/>
				<button onClick={click}>등록</button>
			</div>
		</div>
	)
}

export default App2;