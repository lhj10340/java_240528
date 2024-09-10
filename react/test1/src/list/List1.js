import { useState } from "react";

// < 강사님 풀이 >

// 다음과 같은 배열이 있을 때, 배열을 이용해서 checkBox와 label 태그로 된 화면을 구성하세요.

// 체크박스를 체크하는 경우, 체크한 내용이 아래에 출력되도록!
// 체크를 풀 경우, 출력되었던 내용이 사라지게 하는건 강사님이랑 같이한다.


function List1(){

	const list = ['축구', '야구', '농구', '배구', '음악감상'];
	let [hobby, setHobby] = useState([]);
	let click = (e)=>{
		let {value, checked} = e.target;
		// 이 2줄을 합친게 바로 위 1줄.
		// value = e.target.value;
		// checked = e.target.checked;
		
		// < 내 생각 >
		// e.target.checked 가 true 라면 e.target.value 를 입력?
		// e.target.checked 가 false 라면 e.target.value 를 삭제?

		let tmp = [...hobby];

		// checkbox 가 체크된 상태라면 배열에 추가하고,
		// checkbox 의 체크가 해제된 상태라면 배열에서 제거

		if(checked &&  hobby.length < 3){
			tmp.push(value);
		} else if(!checked){
			// remove 가 먹히지 않는다 .. 어떻게 ??
			// (1)
			let index = tmp.indexOf(value);
			tmp.splice(index, 1);

			// (2)
			// value와 같지 않은 요소들만 이용해서 배열을 새로 만든다.
			// tmp = tmp.filter(item=> item != value);
		} else{
			alert('최대 3개까지 선택할 수 있습니다.')
		}

		setHobby(tmp);
	}

	return(

	<div>
			<h1>당신의 취미는? (최대 3개)</h1>
			{

			list.map((v,index)=>{

			return (
				<label key={index}>
					<input type="checkbox" value={v} onClick={click}/>{v}
				</label>
			)

			})

			}
			<ul>
				{
					hobby.map((v,index)=>{
						return(
							<li key={index}>{v}</li>
						)
					})
				}
			</ul>
		</div>

	)
}

export default List1;