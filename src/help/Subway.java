package help;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;




public class Subway {
	
	private List<Station> outList = new ArrayList<Station>();
	

	public void calculate(Station s1,Station s2){
		if(outList.size() == DataBuilder.totalStaion){
			System.out.println("找到目标站点："+s2.getName()+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
			for(Station station : s1.getAllPassedStations(s2)){
				System.out.println(station.getName()+" (" +station.getLinename()+")");
			}
			return;
		}
		if(!outList.contains(s1)){
			outList.add(s1);
		}
		
		if(s1.getOrderSetMap().isEmpty()){
			List<Station> Linkedstations = getAllLinkedStations(s1);
			for(Station s : Linkedstations){
				s1.getAllPassedStations(s).add(s);
			}
		}
		
		Station parent = getShortestPath(s1);
		if(parent == s2){
			System.out.println("找到目标站点："+s2+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
			for(Station station : s1.getAllPassedStations(s2)){
				System.out.print(station.getName()+" (" +station.getLinename()+")");
			}
			return;
		}
		for(Station child : getAllLinkedStations(parent)){
			if(outList.contains(child)){
				continue;
			}
			int shortestPath = (s1.getAllPassedStations(parent).size()-1) + 1;
			if(s1.getAllPassedStations(child).contains(child)){
				
				if((s1.getAllPassedStations(child).size()-1) > shortestPath){
					
					s1.getAllPassedStations(child).clear();
					s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
					s1.getAllPassedStations(child).add(child);
				}
			} else {
				
				s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
				s1.getAllPassedStations(child).add(child);
			}
		}
		outList.add(parent);
		calculate(s1,s2);
	}

	private Station getShortestPath(Station station){
		int minPatn = Integer.MAX_VALUE;
		Station rets = null;
		for(Station s :station.getOrderSetMap().keySet()){
			if(outList.contains(s)){
				continue;
			}
			LinkedHashSet<Station> set  = station.getAllPassedStations(s);
			if(set.size() < minPatn){
				minPatn = set.size();
				rets = s;
			}
		}
		return rets;
	}
	
	
	private List<Station> getAllLinkedStations(Station station){
		List<Station> linkedStaions = new ArrayList<Station>();
		for(List<Station> line : DataBuilder.lineSet){
			if(line.contains(station)){
				Station s = line.get(line.indexOf(station));
				if(s.prev != null){
					linkedStaions.add(s.prev);
				}
				if(s.next != null){
					linkedStaions.add(s.next);
				}
			}
		}
		return linkedStaions;
	}
 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String a = sc.next();

		if(a.length()==2||a.length()==6||a.length()==7) {
			 switch(a) {
			 case "-map":
				 System.out.print("成功");
				break;
//			 case "-a":
//				 System.out.print(sc.next());
//				 Subway we = new Subway();
//				we.searchlist(sc.next());
//				
//				break;
				 case "-b":
			 Subway sw = new Subway();
				sw.calculate(new Station(sc.next()), new Station(sc.next()));
			 }
			}
			else
				System.out.println("格式错误！");
		}

	}

