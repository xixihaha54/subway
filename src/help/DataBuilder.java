package help;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author :
 * @date : 2018/8/30
 * @description:
 */
public class DataBuilder {
 
    /**
    * @author:
    * @date:2018/8/30
    * @description:从txt文件读取List<String>
    */

    public static List<String> getFileContent(String path) {
        List<String> strList = new ArrayList<String>();
        File file = new File(path);
        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(new FileInputStream(file));
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                strList.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
 
        }
        return strList;
        
        
    }
    public static List<Station> lineS1 = new ArrayList<Station>();//s1号线
	public static List<Station> line1 = new ArrayList<Station>();//1号线
	public static List<Station> line2 = new ArrayList<Station>();//2号线
	public static List<Station> line4 = new ArrayList<Station>();//4号线
	public static List<Station> line5 = new ArrayList<Station>();//5号线
	public static List<Station> line6 = new ArrayList<Station>();//6号线
	public static List<Station> line7 = new ArrayList<Station>();//7号线
	public static List<Station> line8 = new ArrayList<Station>();//8号北线
	public static List<Station> line81 = new ArrayList<Station>();//8号南线
	public static List<Station> line9 = new ArrayList<Station>();//9号线
	public static List<Station> line10 = new ArrayList<Station>();//10号线
	public static List<Station> line13 = new ArrayList<Station>();//13号线
	public static List<Station> line14 = new ArrayList<Station>();//14号东线
	public static List<Station> line141 = new ArrayList<Station>();//14号西线
	public static List<Station> line15 = new ArrayList<Station>();//15号线
	public static List<Station> line16 = new ArrayList<Station>();//16号线
	public static List<Station> lineba = new ArrayList<Station>();//八通线
	public static List<Station> linech = new ArrayList<Station>();//昌平线
	public static List<Station> linefa = new ArrayList<Station>();//房山线
	public static List<Station> linesh = new ArrayList<Station>();//首都机场线
	public static List<Station> linexi = new ArrayList<Station>();//西郊线
	public static List<Station> lineya = new ArrayList<Station>();//燕房线
	public static List<Station> lineyi = new ArrayList<Station>();//亦庄线
	public static Set<List<Station>> lineSet = new HashSet<List<Station>>();//所有线集合
	public static List<Station> linez = new ArrayList<Station>();//线路名
	public static int totalStaion = 0;//总的站点数量
	static {		
		List<String> fileContent = 
				DataBuilder.getFileContent("E:\\subway.txt");
//		        for (String s : fileContent) {
//		           System.out.println(s);
//		        }
//		        System.out.println(fileContent.get(1));

				//s1号线        
		        
				String lineS1Str = fileContent.get(1);
				String[] lineS1Arr = lineS1Str.split(" ");
				for(String s : lineS1Arr){
					lineS1.add(new Station(s));
				}
				for(int i =0;i<lineS1.size();i++){
					if(i<lineS1.size()-1){
						lineS1.get(i).next = lineS1.get(i+1);
						lineS1.get(i+1).prev = lineS1.get(i);
						
					}
				}
				for(int a =0;a<lineS1.size();a++){
				lineS1.get(a).linename = fileContent.get(0);
				}
		//1号线        
		String line1Str = fileContent.get(3);
		String[] line1Arr = line1Str.split(" ");
		for(String s : line1Arr){
			line1.add(new Station(s));
		}
		for(int i =0;i<line1.size();i++){
			if(i<line1.size()-1){
				line1.get(i).next = line1.get(i+1);
				line1.get(i+1).prev = line1.get(i);
			}
		}
		for(int a =0;a<line1.size();a++){
		line1.get(a).linename = fileContent.get(2);
		}
		/*******************************************************************************/
		//2号线
		String line2Str = fileContent.get(5);
		String[] line2Arr = line2Str.split(" ");
		for(String s : line2Arr){
			line2.add(new Station(s));
		}
		for(int i =0;i<line2.size();i++){
			if(i<line2.size()-1){
				line2.get(i).next = line2.get(i+1);
				line2.get(i+1).prev = line2.get(i);
			}
		}
		for(int a =0;a<line2.size();a++){
		line2.get(a).linename = fileContent.get(4);
		}
		
		/*******************************************************************************/
		//4号线
		String line4Str = fileContent.get(7);
		String[] line4Arr = line4Str.split(" ");
		for(String s : line4Arr){
			line4.add(new Station(s));
		}
		for(int i =0;i<line4.size();i++){
			if(i<line4.size()-1){
				line4.get(i).next = line4.get(i+1);
				line4.get(i+1).prev = line4.get(i);
			}
		}
		for(int a =0;a<line4.size();a++){
		line4.get(a).linename = fileContent.get(6);
		}
        /*******************************************************************************/		
		//5号线
		String line5Str = fileContent.get(9);
		String[] line5Arr = line5Str.split(" ");
		for(String s : line5Arr){
			line5.add(new Station(s));
		}
		for(int i =0;i<line5.size();i++){
			if(i<line5.size()-1){
				line5.get(i).next = line5.get(i+1);
				line5.get(i+1).prev = line5.get(i);
			}
		}				
		for(int a =0;a<line5.size();a++){
			line5.get(a).linename = fileContent.get(8);
			}
		/*******************************************************************************/
		//6号线
		String line6Str = fileContent.get(11);
		String[] line6Arr = line6Str.split(" ");
		for(String s : line6Arr){
			line6.add(new Station(s));
		}
		for(int i =0;i<line6.size();i++){
			if(i<line6.size()-1){
				line6.get(i).next = line6.get(i+1);
				line6.get(i+1).prev = line6.get(i);
			}
		}
		for(int a =0;a<line6.size();a++){
		line6.get(a).linename = fileContent.get(10);
		}
		/*******************************************************************************/
		//7号线
		String line7Str = fileContent.get(13);
		String[] line7Arr = line7Str.split(" ");
		for(String s : line7Arr){
			line7.add(new Station(s));
		}
		for(int i =0;i<line7.size();i++){
			if(i<line7.size()-1){
				line7.get(i).next = line7.get(i+1);
				line7.get(i+1).prev = line7.get(i);
			}
		}		
		for(int a =0;a<line7.size();a++){
			line7.get(a).linename = fileContent.get(12);
			}
		/*******************************************************************************/
		//8号西线
		String line8Str = fileContent.get(15);
		String[] line8Arr = line8Str.split(" ");
		for(String s : line8Arr){
			line8.add(new Station(s));
		}
		for(int i =0;i<line8.size();i++){
			if(i<line8.size()-1){
				line8.get(i).next = line8.get(i+1);
				line8.get(i+1).prev = line8.get(i);
			}
		}
		for(int a =0;a<line8.size();a++){
		line8.get(a).linename = fileContent.get(14);
		}
		/*******************************************************************************/
		//8号东线
		String line81Str = fileContent.get(17);
		String[] line81Arr = line81Str.split(" ");
		for(String s : line81Arr){
			line81.add(new Station(s));
		}
		for(int i =0;i<line81.size();i++){
			if(i<line81.size()-1){
				line81.get(i).next = line81.get(i+1);
				line81.get(i+1).prev = line81.get(i);
			}
		}
		for(int a =0;a<line81.size();a++){
		line81.get(a).linename = fileContent.get(16);
		}
		/*******************************************************************************/
		//9号线
		String line9Str = fileContent.get(19);
		String[] line9Arr = line9Str.split(" ");
		for(String s : line9Arr){
			line9.add(new Station(s));
		}
		for(int i =0;i<line9.size();i++){
			if(i<line9.size()-1){
				line9.get(i).next = line9.get(i+1);
				line9.get(i+1).prev = line9.get(i);
			}
		}
		for(int a =0;a<line9.size();a++){
		line9.get(a).linename = fileContent.get(18);
		}
		//10号线
		String line10Str = fileContent.get(21);
		String[] line10Arr = line10Str.split(" ");
		for(String s : line10Arr){
			line10.add(new Station(s));
		}
		for(int i =0;i<line10.size();i++){
			if(i<line10.size()-1){
				line10.get(i).next = line10.get(i+1);
				line10.get(i+1).prev = line10.get(i);
			}
		}
		for(int a =0;a<line10.size();a++){
		line10.get(a).linename = fileContent.get(20);
		}
		/*******************************************************************************/
		//13号线
		String line13Str = fileContent.get(23);
		String[] line13Arr = line13Str.split(" ");
		for(String s : line13Arr){
			line13.add(new Station(s));
		}
		for(int i =0;i<line13.size();i++){
			if(i<line13.size()-1){
				line13.get(i).next = line13.get(i+1);
				line13.get(i+1).prev = line13.get(i);
			}
		}
		for(int a =0;a<line13.size();a++){
		line13.get(a).linename = fileContent.get(22);
		}
		/*******************************************************************************/
		//14号东线
		String line14Str = fileContent.get(25);
		String[] line14Arr = line14Str.split(" ");
		for(String s : line14Arr){
			line14.add(new Station(s));
		}
		for(int i =0;i<line14.size();i++){
			if(i<line14.size()-1){
				line14.get(i).next = line14.get(i+1);
				line14.get(i+1).prev = line14.get(i);
			}
		}
		for(int a =0;a<line14.size();a++){
		line14.get(a).linename = fileContent.get(24);
		}
		/*******************************************************************************/
		//14号西线
		String line141Str = fileContent.get(27);
		String[] line141Arr = line141Str.split(" ");
		for(String s : line141Arr){
			line141.add(new Station(s));
		}
		for(int i =0;i<line141.size();i++){
			if(i<line141.size()-1){
				line141.get(i).next = line141.get(i+1);
				line141.get(i+1).prev = line141.get(i);
			}
		}
		for(int a =0;a<line141.size();a++){
		line141.get(a).linename = fileContent.get(26);
		}
		/*******************************************************************************/
		//15号线
		String line15Str = fileContent.get(29);
		String[] line15Arr = line15Str.split(" ");
		for(String s : line15Arr){
			line15.add(new Station(s));
		}
		for(int i =0;i<line15.size();i++){
			if(i<line15.size()-1){
				line15.get(i).next = line15.get(i+1);
				line15.get(i+1).prev = line15.get(i);
			}
		}
		for(int a =0;a<line15.size();a++){
		line15.get(a).linename = fileContent.get(28);
		}
		/*******************************************************************************/
		//16号线
		String line16Str = fileContent.get(31);
		String[] line16Arr = line16Str.split(" ");
		for(String s : line16Arr){
			line16.add(new Station(s));
		}
		for(int i =0;i<line16.size();i++){
			if(i<line16.size()-1){
				line16.get(i).next = line16.get(i+1);
				line16.get(i+1).prev = line16.get(i);
			}
		}
		for(int a =0;a<line16.size();a++){
		line16.get(a).linename = fileContent.get(30);
		}
		/*******************************************************************************/
		//八通线
		String linebaStr = fileContent.get(33);
		String[] linebaArr = linebaStr.split(" ");
		for(String s : linebaArr){
			lineba.add(new Station(s));
		}
		for(int i =0;i<lineba.size();i++){
			if(i<lineba.size()-1){
				lineba.get(i).next = lineba.get(i+1);
				lineba.get(i+1).prev = lineba.get(i);
			}
		}
		for(int a =0;a<lineba.size();a++){
		lineba.get(a).linename = fileContent.get(32);
		}
		/*******************************************************************************/
		//昌平线
		String linechStr = fileContent.get(35);
		String[] linechArr = linechStr.split(" ");
		for(String s : linechArr){
			linech.add(new Station(s));
		}
		for(int i =0;i<linech.size();i++){
			if(i<linech.size()-1){
				linech.get(i).next = linech.get(i+1);
				linech.get(i+1).prev = linech.get(i);
			}
		}
		for(int a =0;a<linech.size();a++){
		linech.get(a).linename = fileContent.get(34);
		}
		/*******************************************************************************/
		//房山线
		String linefaStr = fileContent.get(37);
		String[] linefaArr = linefaStr.split(" ");
		for(String s : linefaArr){
			linefa.add(new Station(s));
		}
		for(int i =0;i<linefa.size();i++){
			if(i<linefa.size()-1){
				linefa.get(i).next = linefa.get(i+1);
				linefa.get(i+1).prev = linefa.get(i);
			}
		}
		for(int a =0;a<linefa.size();a++){
		linefa.get(a).linename = fileContent.get(36);
		}
		/*******************************************************************************/
		//首都机场线
		String lineshStr = fileContent.get(39);
		String[] lineshArr = lineshStr.split(" ");
		for(String s : lineshArr){
			linesh.add(new Station(s));
		}
		for(int i =0;i<linesh.size();i++){
			if(i<linesh.size()-1){
				linesh.get(i).next = linesh.get(i+1);
				linesh.get(i+1).prev = linesh.get(i);
			}
		}
		for(int a =0;a<linesh.size();a++){
		linesh.get(a).linename = fileContent.get(38);
		}
		/*******************************************************************************/
		//西郊线
		String linexiStr = fileContent.get(41);
		String[] linexiArr = linexiStr.split(" ");
		for(String s : linexiArr){
			linexi.add(new Station(s));
		}
		for(int i =0;i<linexi.size();i++){
			if(i<linexi.size()-1){
				linexi.get(i).next = linexi.get(i+1);
				linexi.get(i+1).prev = linexi.get(i);
			}
		}
		for(int a =0;a<linexi.size();a++){
		linexi.get(a).linename = fileContent.get(40);
		}
		/*******************************************************************************/
		//燕房线
		String lineyaStr = fileContent.get(43);
		String[] lineyaArr = lineyaStr.split(" ");
		for(String s : lineyaArr){
			lineya.add(new Station(s));
		}
		for(int i =0;i<lineya.size();i++){
			if(i<lineya.size()-1){
				lineya.get(i).next = lineya.get(i+1);
				lineya.get(i+1).prev = lineya.get(i);
			}
		}
		for(int a =0;a<lineya.size();a++){
		lineya.get(a).linename = fileContent.get(42);
		}
		/*******************************************************************************/
		//亦庄线
		String lineyiStr = fileContent.get(45);
		String[] lineyiArr = lineyiStr.split(" ");
		for(String s : lineyiArr){
			lineyi.add(new Station(s));
		}
		for(int i =0;i<lineyi.size();i++){
			if(i<lineyi.size()-1){
				lineyi.get(i).next = lineyi.get(i+1);
				lineyi.get(i+1).prev = lineyi.get(i);
			}
		}
		for(int a =0;a<lineyi.size();a++){
		lineyi.get(a).linename = fileContent.get(44);
		}
		
		String linezStr = fileContent.get(45);
		String[] linezArr = linezStr.split(" ");
		for(String s : linezArr){
			linez.add(new Station(s));
		}
		for(int i =0;i<linez.size();i++){
			if(i<linez.size()-1){
				linez.get(i).next = linez.get(i+1);
				linez.get(i+1).prev = linez.get(i);
			}
		}
		System.out.print(linez);
	
		lineSet.add(lineS1);
		lineSet.add(line1);
		lineSet.add(line2);
		lineSet.add(line4);
		lineSet.add(line5);
		lineSet.add(line6);
		lineSet.add(line7);
		lineSet.add(line8);
		lineSet.add(line81);
		lineSet.add(line9);
		lineSet.add(line10);
		lineSet.add(line13);
		lineSet.add(line14);
		lineSet.add(line141);
		lineSet.add(line15);
		lineSet.add(line16);
		lineSet.add(lineba);
		lineSet.add(linech);
		lineSet.add(linefa);
		lineSet.add(linesh);
		lineSet.add(linexi);
		lineSet.add(lineya);
		lineSet.add(lineyi);
		
		
		
		totalStaion  = line1.size() + line2.size() + line4.size() +line5.size() + line6.size() + line7.size() + 
				line8.size() + line81.size() + line9.size() +line10.size() +
				line13.size() + line14.size() + line141.size() +
				line15.size() + line16.size() + lineba.size() +
				linech.size() + linefa.size() + linesh.size() +
				linexi.size() + lineya.size() + lineyi.size() +lineS1.size() ;
//		System.out.println("总的站点数量："+totalStaion);
//		System.out.println(lineSet);
	}

}

