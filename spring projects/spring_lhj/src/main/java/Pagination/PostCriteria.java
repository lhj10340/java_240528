package Pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {
	
	private int co_num;

	@Override
	public String toString() {
		return "[co_num=" + co_num + "]" + super.toString();
	}
	
}
