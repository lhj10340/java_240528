import {BrowserRouter, Link, Route, Routes} from 'react-router-dom';
import PostList from './PostList';
import Main from './Main';

function Nav(){
	return (
		<BrowserRouter>
			<ul>
				<li>
					<Link to={"/"}>홈으로</Link>
				</li>
				<li>
					<Link to={"/post/list/0"}>커뮤니티</Link>
				</li>
			</ul>
			<Routes>
				<Route path={"/"} exact element={<Main/>}/>
				<Route path={"/post/list/:co_num"} element={<PostList/>}/>
			</Routes>
		</BrowserRouter>
	);
}
export default Nav;