package StartEngine;


import utility.Common_Engine;
import utility.Contants;
import utility.ExcelUtils;

//�����Ĵ����߼��Ǻ�Excel����Ӧ�ģ����Ҫ����Excelֻ��Ҫ������࣬����������һ����Excel��Ӧ����
public class StartEngine_Excel {
	
	public static String Keywords=null;
	public static String r;
	public static boolean bResult;
	
	
	public static void StartEngine(Object actionKeyWords){
		
		
		/*LOGINKEYWORDS ACTIONKEYWORDS=NEW LOGINKEYWORDS();*/
		ExcelUtils.setExcelFile(Contants.excelFile+Contants.excelName );
		bResult = true;
//		ѭ����ȡsuitSheet�����ֵ���ҳ����еĳ���
		for(int j=1;j<=ExcelUtils.getLastRowNums(Contants.suitSheet);j++){
			
			String Runmode=ExcelUtils.getCellDate(j, Contants.suitRunmode,Contants.suitSheet);
			String suitTestSuiteId=ExcelUtils.getCellDate(j, Contants.suitTestSuiteId,Contants.suitSheet);
			int sRowNum;
			
			if(Runmode.equals("YES")){
//				����stepTestSuiteId��caseSheet��ѭ���������Ӧ��ִ�в���
				for(sRowNum=1;sRowNum<=ExcelUtils.getLastRowNums(Contants.caseSheet);sRowNum++){
					String stepTestSuiteId=ExcelUtils.getCellDate(sRowNum, Contants.stepTestSuiteId,Contants.caseSheet);
					System.out.println(ExcelUtils.getCellDate(sRowNum, Contants.excelKWCloNum,Contants.caseSheet));
					if(stepTestSuiteId.trim().equals(suitTestSuiteId)){				
						Keywords=ExcelUtils.getCellDate(sRowNum, Contants.excelKWCloNum,Contants.caseSheet);
						r=ExcelUtils.getCellDate(sRowNum, Contants.excelPOCloNum,Contants.caseSheet);
						Common_Engine.Action(Keywords,actionKeyWords, r, sRowNum, bResult);
						if(bResult == false){
							ExcelUtils.setCellData(Contants.fail, j, Contants.suitResult,Contants.excelFile+Contants.excelName, Contants.suitSheet);
							
						}
					}	
				}
				if(bResult == true){
					ExcelUtils.setCellData(Contants.pass, j, Contants.suitResult,Contants.excelFile+Contants.excelName, Contants.suitSheet);
				}
																						
			}else{
				
				System.out.println("No execute Test Case");
				break;
			}
			
		}
		
						
	}
}
