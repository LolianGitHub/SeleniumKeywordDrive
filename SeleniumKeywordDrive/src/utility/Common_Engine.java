package utility;

import java.lang.reflect.Method;

import config.LoginKeyWords;

public class Common_Engine {
	
//	ִ�йؼ����еķ���
	public static void Action(String Keywords,Object actionKeyWords,String r,int sRowNum,boolean bResult){
//		new LoginKeyWords();
//		java�����õ���Ӧ�����з���
		/*actionKeyWords= new LoginKeyWords();*/
		Method[] method=actionKeyWords.getClass().getMethods();
		for(int i=0;i<method.length;i++){
			if(method[i].getName().trim().equals(Keywords)){
							

					System.out.println(method[i].getName()+"#######"+actionKeyWords+Keywords+"#######"+r);

					try {
						method[i].invoke(actionKeyWords,r);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					if(bResult == true){
						ExcelUtils.setCellData(Contants.pass, sRowNum, Contants.caseResult,Contants.excelFile+Contants.excelName, Contants.caseSheet);
					}else{
						ExcelUtils.setCellData(Contants.fail, sRowNum, Contants.caseResult,Contants.excelFile+Contants.excelName, Contants.caseSheet);
						/*actionKeyWords.CloseBrowser(r);*/
					}
					break;
					
				
			}
		}
	}
}
