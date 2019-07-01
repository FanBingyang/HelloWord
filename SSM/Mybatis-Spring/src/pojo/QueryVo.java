package pojo;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	List<Integer> idList;
	
	Integer[] ids;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the idList
	 */
	public List<Integer> getIdList() {
		return idList;
	}

	/**
	 * @param idList the idList to set
	 */
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	/**
	 * @return the ids
	 */
	public Integer[] getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
	

}
