package lunchSelector;

import java.util.Random;

import org.junit.Test;

public class MenuSelector {

	@Test
	public void selector(){
		String[] menu = {
			"«��","������","��������","��ﱹ��","���õ��","������","��ġ�","����Ĵ�","Ǫ����Ʈ","��ġ����","�ܹ���","���뱹��","���"
		};
		Random randomGenerator = new Random();
		int totalCount = menu.length;
		for (int i = 0; i < 3; i++) {
			int selectedNumber = randomGenerator.nextInt(totalCount);
			System.out.println("Choice of today!!   : " + menu[selectedNumber]);
		}
	}
}
