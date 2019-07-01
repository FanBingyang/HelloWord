package test_injection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CollectionBean {
	private Object[] arr;//��������ע��
	private List list; //list/set ����ע��
	private Map map;//map����ע��
	private Properties prop;//Properties����ע��
	/**
	 * @return the arr
	 */
	public Object[] getArr() {
		return arr;
	}
	/**
	 * @param arr the arr to set
	 */
	public void setArr(Object[] arr) {
		this.arr = arr;
	}
	/**
	 * @return the list
	 */
	public List getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List list) {
		this.list = list;
	}
	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}
	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	/**
	 * @return the prop
	 */
	public Properties getProp() {
		return prop;
	}
	/**
	 * @param prop the prop to set
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CollectionBean [arr=" + Arrays.toString(arr) + ", list=" + list + ", map=" + map + ", prop=" + prop
				+ "]";
	}
	
	
}
