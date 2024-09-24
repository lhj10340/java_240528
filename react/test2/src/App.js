import { Button1, Button2 } from "./Button";
import './App.css'

function App() {

  const text1 = "버튼1";
  const text2 = "버튼2";

  const click = (text) => alert(text)

  return (
    <div>
      
        {/* 버튼을 추가
        - 버튼 컴포넌트를 생성해서 추가. ( 괄호 <> 를 적지 않았다, return 을 적지 않았다.)
        - 버튼의 문자열을 App 컴포넌트가 전달해서 버튼이 생성되도록 수정.
        - 버튼을 클릭하면 클릭한 버튼의 문자열을 알림창으로 출력하도록 작성.
        - 버튼에 배경색을 노란색, 테두리를 둥근 테두리, 크기를 30px 로 적용되도록 작성.
        - 각 버튼의 클릭 이벤트를 App 컴포넌트가 정하도록 코드를 수정.
          : button.js 에서 click 을 삭제 하고, 여기 Button 에 넣어줬다. ( props 이용 )
      */}

          <Button1 
            text={text1} 
            classNames={"btn"}
            click={() => click(text1) }/>

          <br/>
          <br/>

          <Button2 text={text2} 
            styles={
              {backgroundColor: 'yellow',
	            borderRadius: '5px',
	            height: '30px'}
            }
            click={() => click(text2)} />

      {/*
        버튼 컴포넌트와 input 창을 추가.
          - input 창에 입력된 내용을 버튼을 클릭하면 알림창에 출력되도록 작성.
        */}

    </div>
  );
}

export default App;
