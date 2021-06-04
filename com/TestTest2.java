package com;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class TestTest2 {
    //public static void main(String [] args) {
public String cal(String filename, String pfilename, String pmarcfield){
    // The name of the file to open.
	
	
String fileName = filename;
String pfileName = pfilename;
String pmarcField = pmarcfield;
    // This will reference one line at a time
String line = null;

    //String fileName = "marc.mrk";

    // This will reference one line at a time


    try {
			
				BufferedReader in = new BufferedReader(new FileReader(fileName));
				String str;

				List<String> list = new ArrayList<String>();
				while((str = in.readLine()) != null){
					list.add(str);
				}
				
				// for (String s : list) { System.out.println(s); } //print line by line
				

				String[] stringArr = list.toArray(new String[0]);

				//String[] Marc=new ArrayList();
				List<String> Marc = new ArrayList<String>();
				for (int i=0; i<stringArr.length; i++){
					//System.out.println("********************************************************");
					//System.out.println(stringArr[i]+"\n");
					//System.out.println("Length:"+stringArr[i].length()+"\n");
					
								String field001="";
								
								if (stringArr[i].length()!=0){
									//System.out.println(stringArr[i].substring(1,4));
									
										//if(stringArr[i].substring(1,4)=="001"){
										//if(stringArr[i].substring(1,4).equals("001")){  // run without problem, replace 001 with variable 
												if(stringArr[i].substring(1,4).equals(pmarcfield)){ 
											//System.out.println("001001001001001001001001001001001001001001001001001001001001");
											
											if (pmarcfield.equals("001")||pmarcfield.equals("005")||pmarcfield.equals("006")||pmarcfield.equals("007")||pmarcfield.equals("008")){
												 field001=stringArr[i].substring(6,stringArr[i].length());
						
											}
											else
											{
												 field001=stringArr[i].substring(10,stringArr[i].length());
											}
										
										
										 
										}
									
									
									}
							
							//if (i>1){  //prevent seom filed 006 appear in some marc record, disappear from other marc record.
							/**if (stringArr[i].length()!=0){//in array there is no \r\n
								if (stringArr[i].substring(0,2).equals("/r/n")) //&& !stringArr[i-1].substring(1,2).equals("/r/n"))
								{
									if (!field001.equals("")){
										
										Marc.add(field001);
									}
									field001=""; 
									
								}
								else{
								}
							}*/
							
								if (!field001.equals("")){
										
										Marc.add(field001);
										field001="";
									}
                                    
										/*if (!field001.equals("")){
										
										Marc.add(field001);
									    }*/
									

							//}

									

					
					//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

					}
					
					//System.out.println(Arrays.toString(Marc.toArray()));
					
				
				String[] MarctoArray = Marc.toArray(new String[0]); //we have to convert list Marc to array before export them to a file.
			
			//System.out.println(Arrays.toString(stringArr));
			
						FileWriter fw = new FileWriter(pfileName); //write array to a file named file.dat
						for (int i = 0; i < MarctoArray.length; i++) {
						  //fw.write(stringArr[i] + "\r\n");
						  fw.write(MarctoArray[i] + "\r\n");//Attention, if using \n , you will have trouble of inconsistence
						}
						fw.close();
			
			       in.close();

	}
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName + "'");                
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");                  
      }
	
	return "successfull";
   }
    
}
