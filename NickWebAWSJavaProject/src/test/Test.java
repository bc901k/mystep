package test;

import DBtools.GetConnection;

public class Test {
	
	@org.junit.Test
	public void rdsInsertDummyDatas(){
		String sql = "INSERT INTO test_1 VALUES(3,'ccc','cause of you')";
		String resultMsg = GetConnection.excuteUpdateToRDS(sql);
		System.out.println("Insert result: "+resultMsg);
	}

}
