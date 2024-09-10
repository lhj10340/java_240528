
import { useState } from "react";



/*

< 내가 한 것, 일단 주어진 문제와 동일하게 출력이 되기는 한다 ... >

function Input2(){

	let [time, setTime] = useState(0);

	function MakeTime(e){
		setTime((e.target.value)*60);
	}

	// 마지막 부분에도 setTime 가 아니라 time으로 해주는 이유는
	// 함수 내부의 setTime 을 통해 time의 값이 바뀌고 렌더링까지 완료되었기 때문이다.
	// 이전에 내용에서도 동일하게 작업해서 진행했다.
	// set 자체가 바꾼다는 의미.

	return (
		<div>
			<input type="text" onChange={MakeTime}/>
			<button>변환</button>
			<br/>
			<input type="text" readOnly value={time}/>
		</div>
	)
}

< 강사님 풀이 - 1 >

function Input2(){

	// 입력을 하고 계산 버튼을 누르는 방식으로 진행하고 싶다면 state 변수가 2종류 필요하다.

	let [tmp, setTmp] = useState(0);
	let [time, setTime] = useState(0);

	return (
		<div>
			<input type="text" disabled={false} onChange={e=>setTime(e.target.value)}/>
			<label>분</label>
			<button>계산</button>
			<br/>
			<input type="text" disabled={true} value={time*60}/>
			<label>초</label>
		</div>
	)
}

*/

/*

< 강사님 풀이 - 2 >

function Input2(){

	// 입력을 하고 계산 버튼을 누르는 방식으로 진행하고 싶다면 state 변수가 2종류 필요하다.

	let [tmp, setTmp] = useState(0);
	let [time, setTime] = useState(0);

	return (
		<div>
			<input type="text" disabled={false} onChange={e=>setTmp(e.target.value)}/>
			<label>분</label>
			<br/>
			<input type="text" disabled={true} value={time*60}/>
			<label>초</label>
		</div>
	)
}

*/

/*
input 태그1 버튼
input 태그2

구성으로 화면을 생성
input 태그1에 분을 입력하면 input 태그 2는 초로 변환해서 출력

추가 ..
반대로 초를 입력하면 분으로 환산이 되도록 .. ( 어려울 수 있다. )
생각도 잘 안됐다 ..

*/

function Input2(){

let [time, setTime] = useState(0);
let [flag, setFlag] = useState(true);

return (
	<div>
		<input type="text" disabled={!flag} onChange={e=>setTime(e.target.value)} value={flag?time:Math.floor(time/60)}/>
		<label>분</label>
		<button onClick={()=>{setFlag(!flag); setTime(0)}}>변환</button>
		<br/>
		<input type="text" disabled={flag} onChange={e=>setTime(e.target.value)} value={flag?time*60:time}/>
		<label>초</label>
	</div>
)

}

export default Input2;