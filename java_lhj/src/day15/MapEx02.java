package day15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx02 {

	public static void main(String[] args) {
		
		// Map 을 이용한 반복문 예제
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("2024160001", "고길동");
		map.put("2024160002", "홍길동");
		map.put("2024132001", "임꺽정");
		
		// 방법1. keySet 을 이용하여 set으로 만든 후, set을 반복문을 이용하여 원하는 작업을 진행한다.
		
		Set<String> set = map.keySet();
		
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		// 방법2. EntrySet 을 이용. Entry 클래스를 이용하여 set으로 만들고, 반복문을 활용.
		// 메소드 안에 메소드를 정의할 수는 없지만, 클래스 안에 클래스를 정의할 수는 있다.
		
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		
		// 내부 클래스 이용 (내부 클래스는 단독으로 사용하지 않는다. )
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> tmp = it2.next();
			String key = tmp.getKey();
			String value = tmp.getValue();
			System.out.println(key + " " + value);
		}
		
	}

}
