package lunchSelector;

import java.util.Random;

import org.junit.Test;

public class MenuSelector {

	@Test
	public void selector(){
		String[] menu = {
			"Â«»Í","±¼±¹¹ä","µÅÁö±¹¹ä","»ï»ï±¹¹ä","±è¹äÃµ±¹","¼³··ÅÁ","±èÄ¡Âî°³","±¸·æ½Ä´ç","ÇªµåÄÚÆ®","°¥Ä¡Á¶¸²","ÇÜ¹ö°Å","¼ø´ë±¹¹ä","µ·±î½º"
		};
		Random randomGenerator = new Random();
		int totalCount = menu.length;
		for (int i = 0; i < 3; i++) {
			int selectedNumber = randomGenerator.nextInt(totalCount);
			System.out.println("Choice of today!!   : " + menu[selectedNumber]);
		}
	}
}
