package com.zls.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zls.domain.StoreFile;
import com.zls.util.C3P0Util;

public class FileDaoImp {

	
	/*
	 * 上传文件操作
	 * 根据文件名来对文件进行存储
	 */
	public void addFile(StoreFile storefile, String fileName) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into storefile values(?,?,?,?,?,?)",0,storefile.getFilename(),storefile.getFilestyle(),storefile.getFilesize(),storefile.getUptime(),storefile.getFilepath() );
		QueryRunner qr1 = new QueryRunner(C3P0Util.getDataSource());
		qr1.update("insert into"+" "+ fileName+" values(?,?,?,?,?,?)",0,storefile.getFilename(),storefile.getFilestyle(),storefile.getFilesize(),storefile.getUptime(),storefile.getFilepath() );
	}

	public List<StoreFile> findAllFile(String fileName) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from"+" "+ fileName,new BeanListHandler<StoreFile>(StoreFile.class) );//new BeanListHandler<Book>(Book.class)
	}
	public List<StoreFile> findAllFile() throws SQLException {
		// TODO Auto-generated method stub
		
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from storefile",new BeanListHandler<StoreFile>(StoreFile.class) );//new BeanListHandler<Book>(Book.class)
	}

	public void deletFile(String name, String fileType) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("对数据库操作...fileType="+fileType+"...nmae="+name);
		QueryRunner qr1 = new QueryRunner(C3P0Util.getDataSource());
		qr1.update("delete from"+" "+ fileType +" where filename=?", name);
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from storefile where filename=?", name);
		
	}

	public List<StoreFile> findFile(String filename) throws SQLException {
		// TODO Auto-generated method stub
	     QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	     return qr.query("select * from storefile where filename=?",new BeanListHandler<StoreFile>(StoreFile.class), filename);
	}

	public List<StoreFile> findFileById(String fileid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from storefile where fileid=?",new BeanListHandler<StoreFile>(StoreFile.class),fileid);
	}


	

}
