
import Li from "./Li";

function Ul(){
	let listTitle = ['등원', '수업', '점심', '수업', '하원'];

	function list(value){
		return <Li text={value}/>
	}

	return(
		<ul>
			{
				// map 은 a를 b로 변환해주는 함수
				listTitle.map((value, index, arr)=>{
					return <Li text={value} />
				})
			}
			{
				// 여기에는 ; 를 입력하면 에러가 난다.
				// listTitle.map(list)
			}
			{/* <Li text={listTitle[0]}/>
			<Li text={listTitle[1]}/>
			<Li text={listTitle[2]}/>
			<Li text={listTitle[3]}/>
			<Li text={listTitle[4]}/> */}
		</ul>
	)
}

export default Ul;