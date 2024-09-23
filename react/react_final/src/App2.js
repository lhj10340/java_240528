
import {useState} from 'react';

/*
게시글 목록 조회 + 게시글 등록
  1. 게시글 등록을 할 화면을 구성 : 제목, 내용, 작성자
    게시글 등록 버튼을 클릭하면 제목, 내용, 작성자가 알림창으로 출력되도록 작성.
  2. 게시글 등록 버튼을 클릭하면 입력된 제목, 내용, 작성자가 빈 문자열이 되도록 작성.
    : 각각의 입력창에 value 값을 지정.
    : click 함수에 빈 문자열 추가. ( state 변수를 이용 )
  3. 게시글 목록이 화면에 출력되도록 작성
  4. 게시글 등록 버튼을 클릭하면 알림창 출력 대신 list 에 추가하는 코드를 작성.
*/

function App2() {

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
  ])

  let [title, setTitle] = useState('');
  let [writer, setWriter] = useState('');
  let [content, setContent] = useState('');

  // const click = ()=>{
  //   alert(title + ", " + writer + ", " + content);
  //   setTitle(""); // title 의 값을 빈 문자열로 변경 => 렌더링이 됨 ( 화면에 보여주기위한 작업 ) => 제목이 빈 문자열이 된다. ( title = ""; 이렇게 쓰면 안된다. 렌더링이 안되서 그대로 있다.)
  //   setWriter("");
  //   setContent("");
  // }

  const click = ()=>{

    let post = {
      title,
      writer,
      content
    }

    setList([...list, post]);

  }

  // change 내부에 있는 set을 지우면 실행이 안된다.
  // 바뀐 title 을 넣어놓을 곳이 필요한데, 없기 때문이다.

  // a 를 b로 바꾸기 위해 사용하는 것에 map
  // 여기서는 객체를 태그로 바꾸기 위해 사용했다.

  return (
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
              list.map((item,index)=>{
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
        <Input text="제목" change={setTitle} value={title}/>
        
        <br/>

        <Input text="작성자" change={setWriter} value={writer}/>

        <br/>

        <textarea placeholder="내용을 입력하세요."
          onChange={(e)=>setContent(e.target.value)} value={content}/>

        <button 
          onClick={click}>등록</button>
      </div>
      
    </div>
  );

}

function Input({text, change, value}){
  return(
    <input type="text" placeholder={text + " 을 입력하세요"}
    onChange={(e)=>change(e.target.value)} value={value}/>
  )
}

export default App2;
