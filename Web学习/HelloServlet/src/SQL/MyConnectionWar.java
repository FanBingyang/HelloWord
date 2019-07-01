package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;


public class MyConnectionWar extends MyConnectionWarper {

	private LinkedList<Connection> pool;
	private Connection oldConn;

	public MyConnectionWar(Connection oldConn,LinkedList<Connection> pool) {
		super(oldConn);
		this.oldConn = oldConn;
		this.pool = pool;
	}
	
	
	@Override
	public void close() throws SQLException{
		pool.addLast(oldConn);
	}

}
