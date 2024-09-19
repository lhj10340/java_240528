
import { useEffect, useState } from "react";

function FetchEx1(){

	let [str, setStr] = useState('');
	let [obj, setObj] = useState({});
	let [person, setPerson ] = useState({
		name : '',
		age : ''
	})
	useEffect(()=>{
		fetch('/spring/react/get/str')
		// 서버에서 보낸 결과를 문자열로 변환한다.
		.then((res)=>{
			return res.text();
		})
		// 아래 공백처리한 1줄과 위 2줄은 같은 의미이다.
		//.then(res=>res.text())
		.then(data=>setStr(data))
		.catch(error=>console.error(error));

		fetch('/spring/react/get/obj')
		// 객체로 보내는 경우 json 을 사용해야한다.
		// 서버에서 보낸 결과를 객체로 변환
			.then(res=>res.json())
			.then(data=>setObj(data))
			.catch(e=>console.error(e));

	},[])

	function submit(e){
		e.preventDefault();

		// form 태그 안에 있는 input 태그들 값을 읽어온다.
		// 한번에 읽어와서 객체로 넘겨준다.
		const data = new FormData(e.target);
		fetch("/spring/react/send/person", {
			method : "post",
			body : data
			//contentType 이 multipart/form-data 또는 application/x-www-form-urlencoded 로 되어있어서
			// @RequestBody 로 바로 받을 수 없다/
		})
		.then(res => res.text())
		.then(data => console.log(data))
		.catch(e=>console.error(e));

		fetch("/spring/react/send/person2", {
			method : "post",
			body : JSON.stringify(person),
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(res => res.text())
		.then(data => console.log(data))
		.catch(e=>console.error(e));
	}

	function change(e){
		serPerson({
			...person,
			[e.target.name] : e.target.value
		})
	}

	return(
		<div>
			<h1>{str}</h1>
			{
				obj && (
					<div>
						<div> 이름 : {obj.name} </div>
						<div> 나이 : {obj.age} </div>
					</div>
				)
			}

			<form onSubmit={submit}>
				<input name="name" placeholder="이름을 입력하세요." onChange={change}/>
				<br/>
				<input name="age" type="number" placeholder="나이를 입력하세요" onChange={change}/>
				<button type="submit">전송</button>
			</form>

		</div>
	)

}

export default FetchEx1;