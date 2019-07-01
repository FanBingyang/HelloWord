package commoncrud;

import java.sql.ResultSet;

public interface ResultSetHandle {
	
	/**
	 * 定义了数据封装的规则，规范
	 * @param rs
	 */
	void handle(ResultSet rs);
}
