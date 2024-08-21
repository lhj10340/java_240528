package kr.kh.app.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

// VO 는 @Data, @NoArgsConstructor 를 항상 입력하고 시작할 것. ( 나 혼자할 때, 빼먹고 했다. )

public class MemberVO {

	private String me_id; 
	private String me_pw; // 나는 int 로 했었는데, 강사님은 String 으로 하셨다.
	private String me_email;
	
	// 밑에는 넣지 않았었다. ( 나 혼자 했을 때 )
	
	private int me_fail;
	private String me_cookie;
	private Date me_limit;
	private int me_report;
	private String me_ms_name; 
	private Date me_stop;
	
	public MemberVO(String me_id, String me_pw, String me_email) {
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_email = me_email;
	}

	public MemberVO(String me_id, String me_pw) {
		this.me_id = me_id;
		this.me_pw = me_pw;
	}
	
}
