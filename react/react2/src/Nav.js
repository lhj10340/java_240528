import {BrowserRouter, Link, Route, Routes} from 'react-router-dom';
import PostList from './PostList';
import Main from './Main';

function Nav(){
	return (
		<nav>
			<ul>
				<li>
					<Link to={"/"}>홈으로</Link>
				</li>
				<li>
					<Link to={"/post/list/0"}>커뮤니티</Link>
				</li>
			</ul>
			
		</nav>
	);
}
export default Nav;

// Link 컴포넌트와 a 태그의 차이점 ..
// a 태그는 url 이 바뀌고 새로고침이 발생한다.
// Link 컴포넌트는 url 이 바뀌고 새로고침이 발생하지 않는다.

// 그래서 Link 컴포넌트는 한 페이지에서 작동하는 어플을 만들 때 사용한다.