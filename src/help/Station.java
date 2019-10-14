
package help;
 
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
 
/**
 * desc������վ����
 * @author chaisson
 * @since 2015-5-31 ����10:22:44
 *
 */
public class Station {
	
	private String name; //����վ���ƣ�����߱�Ψһ��
	
	public Station prev; //��վ��lineNo�������ǰһ��վ
	
	public Station next; //��վ��lineNo������ĺ�һ��վ
	
	public String linename;//������·��
	
	//��վ��ĳһ��Ŀ��վ(key)������������վ����(value)������ǰ��˳��
	private Map<Station,LinkedHashSet<Station>> orderSetMap = new HashMap<Station,LinkedHashSet<Station>>();
	
	public Station (String name){
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLinename() {
		return linename;
	}
 
	public void setLinename(String linename) {
		this.linename = linename;
	}
	
	public LinkedHashSet<Station> getAllPassedStations(Station station) {
		if(orderSetMap.get(station) == null){
			LinkedHashSet<Station> set = new LinkedHashSet<Station>(); 
			set.add(this);
			orderSetMap.put(station, set);
		}
		return orderSetMap.get(station);
	}
 
	public Map<Station, LinkedHashSet<Station>> getOrderSetMap() {
		return orderSetMap;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		} else if(obj instanceof Station){
			Station s = (Station) obj;
			if(s.getName().equals(this.getName())){
//				System.out.print(s.getLinename());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
}