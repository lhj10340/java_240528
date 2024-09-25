package kr.kh.boot.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

//현재 페이지 정보를 나타내는 클래스
@Data
@NoArgsConstructor
public class Criteria {
	
	protected int page = 1;
	protected int perPageNum = 5; //현재 페이지의 최대 컨텐츠 수
	
	protected String search = ""; //검색어 : 기본값 - 빈문자열=> 전체 검색
	protected String type; //검색 타입 
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
}
