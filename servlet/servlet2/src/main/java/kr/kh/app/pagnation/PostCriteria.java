package kr.kh.app.pagnation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PostCriteria extends Criteria {
	
	private String co_num;
	private String type; // 제목으로 검색할지, 작성자로 검색할지
	
	public PostCriteria(String co_num, String pageStr, String search, String type, int perPageNum) {
		
		int page;
		
		try {
			page = Integer.parseInt(pageStr);
		} catch (Exception e) {
			page = 1;
		}
		this.search = search == null ? "" : search;
		this.type = type == null? "all" : type;
		this.co_num = co_num;
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
}
