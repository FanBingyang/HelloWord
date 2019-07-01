package domain;

import java.util.List;

/**
 * 这是一个用于封装了分页的数据
 * 里面包含了：
 * 		该页的学生数据
 * 		总的记录数
 * 		总的页数
 * 		当前页
 * 		每页显示的记录数
 * @author FBY
 * @param <T>
 *
 */
public class PageBean<T> {
	private int currentPage;//当前页
	private int totalPage;//总页数
	private int pageSize;//每页的记录数
	private int totalSize;//总的记录数
	private List<T> list;//当前页的学生集合，泛型：传进来是什么类型就是什么类型，代码拓展性强
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
	
}
