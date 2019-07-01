package domain;

import java.util.List;

/**
 * ����һ�����ڷ�װ�˷�ҳ������
 * ��������ˣ�
 * 		��ҳ��ѧ������
 * 		�ܵļ�¼��
 * 		�ܵ�ҳ��
 * 		��ǰҳ
 * 		ÿҳ��ʾ�ļ�¼��
 * @author FBY
 * @param <T>
 *
 */
public class PageBean<T> {
	private int currentPage;//��ǰҳ
	private int totalPage;//��ҳ��
	private int pageSize;//ÿҳ�ļ�¼��
	private int totalSize;//�ܵļ�¼��
	private List<T> list;//��ǰҳ��ѧ�����ϣ����ͣ���������ʲô���;���ʲô���ͣ�������չ��ǿ
	
	
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
