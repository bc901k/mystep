package making;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class MinMaxAlgorithm {
	
	/**
	 * Method: generating random 10000 numbers and write it to file 
	 * params:
	 */
	@Before
	public void makingNumberFile(){
		Random randomGenerator = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(randomGenerator.nextInt(10000)).append(" ");
		}
		try {
			File file = new File("numberSample.txt");
			FileUtils.deleteQuietly(file);
			FileUtils.writeStringToFile(file, sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> numberRead(String filename){
		List<String> originList = new ArrayList<String>();
		try {
			File file = new File("numberSample.txt");
			String str = FileUtils.readFileToString(file);
			String[] splitStr = str.trim().split("[\" \"]");
			for (int i = 0; i < splitStr.length; i++) {
				originList.add(splitStr[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return originList;
	}
	
	@Test
	public void ListMinMaxAlgorithm(){
		List<String> organizedList = new ArrayList<String>();
		organizedList = numberRead("numberSample.txt");
		for (int i = 0; i < organizedList.size(); i++) {
			System.out.println(organizedList.get(i));
		}
	}
	
	public void binarySearching(){
		double target = 21367.0;
		double listSize = 100000.0;
		double half 	= 0.0;
		double max 	= listSize;
		boolean chk = true;
		int count		= 1;
		while(chk){
			half = (double) Math.ceil(max/2);
			System.out.println("target: "+target+"       Half: "+half+"      realNumber: "+(max/2));
			if (half == target) {
				chk = false;
			} else {
				if(half < target) {
					max = max + (double) Math.ceil(listSize/(Math.pow(2,count)));
				} else {
					max = max - (double) Math.ceil(listSize/(Math.pow(2,count)));
				}
				count++;
			}
			if (count>=listSize) chk = false;
			if (max/2>listSize) max = (double) Math.ceil(listSize*2);
			System.out.println("max: "+max);
		}
		System.out.println(count);
	}
}
