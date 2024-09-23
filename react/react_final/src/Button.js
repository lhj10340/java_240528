
function Button1(props){

	return(
		<button
			onClick={props.click}
			className={props.classNames}>
			{props.text}</button>
	)
}

const Button2 = ({text, styles, click})=>{

	return(
		<button
			onClick={click}
			style={styles}>
			{text}</button>
	)
}

function Button3(){
	return(
		<div>
			<input type='text'/>
			<button>입력</button>
		</div>
	)
}

export {Button1, Button2, Button3};