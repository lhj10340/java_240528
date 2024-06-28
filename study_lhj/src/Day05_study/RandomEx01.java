package Day05_study;

public class RandomEx01 {

	public static void main(String[] args) {
		
		/* 랜덤한 수를 출력하는 예제
		 * 
		 *  0 <= r < 1
		 * 위 식에서 각 항에 0보다 큰 (max - min + 1)로 곱해준다.
		 * 
		 * 0 * (max - min + 1) <= r * (max - min + 1) < 1 * (max - min + 1)
		 * 
		 * 0 <= r * (max - min + 1) < (max - min + 1)
		 * 위 식에서 각 항에 min을 더해준다.
		 * 
		 * 0 + min <= r * (max - min + 1) + min < (max - min + 1) + min
		 * 위 식은 min 이상 max + 1 이하의 실수가 랜덤으로 생성. 위 식에서 가운데에 int로 자료형 변환을 하면
		 * 
		 * min <= (int)(r * (max - min + 1) + min) < max + 1
		 * 위 식은 min 이상 max+1 미만의 정수 => min 이상 max 이하의 정수
		 * 
		 * */ 
		
		int min = 1, max = 10;
		
		int random = (int)(Math.random()*(max - min + 1) + min);
		
		System.out.println(random);
		
	}

}
