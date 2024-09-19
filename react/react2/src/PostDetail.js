
function PostDetail(){
	let [post, setPost] = useState({});
	let {po_num} = useParams();

	useEffect(()=>{
		fetch("/spring/react/post/detail/"+po_num)
		.then(res=>res.json())
		.then(data=>{
			// 
			var date = (new Date(data.po_date )).toLocaleDateString();
						data = {...data, date};
						setPost(data)
		})
		.catch(e=>console.error(e));
	}, [])
	
	return(
		<div>
			{
				<div>
					<div>제목 : {post.po_title}</div>
					<div>작성자 : {post.po_me_id}</div>
					<div>작성일 : {post.date}</div>
					<div>조회수 : {post.po_view}</div>
					<div>내용 : </div>
					<div>{post.po_title}</div>
				</div>
			}
		</div>
	)
}

export default PostDetail;