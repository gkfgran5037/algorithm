package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Printer_2 {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		LinkedList<Document_2> que = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			if (i == location) {
				que.add(new Document_2(priorities[i], true));
			}else {
				que.add(new Document_2(priorities[i], false));
			}
		}
		int cursur = 0;
		while (cursur < priorities.length) {
			boolean isChange = false;
			for (int i = cursur + 1; i < priorities.length; i++) {
				if (que.get(cursur).priority < que.get(i).priority) {
					isChange = true;
					que.add(que.get(cursur));
					que.remove(cursur);
				}
			}
			if (isChange == false) {
				cursur++;
			}
		}
		
		for (int i = 0; i < priorities.length; i++) {
			if (que.get(i).target == true) {
				answer = i + 1;
			}
		}
		return answer;
	}
}
