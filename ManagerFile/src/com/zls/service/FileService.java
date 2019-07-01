package com.zls.service;

import java.sql.SQLException;
import java.util.List;

import com.zls.dao.FileDaoImp;
import com.zls.domain.StoreFile;

public class FileService {

	FileDaoImp fileDao = new FileDaoImp();
	public void addFile(StoreFile storefile, String fileType) {
		// TODO Auto-generated method stub
		try {
			fileDao.addFile(storefile,fileType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<StoreFile> findAllFile() {
		// TODO Auto-generated method stub
		try {
			return fileDao.findAllFile();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<StoreFile> findAllFile(String fileName) {
		// TODO Auto-generated method stub
		try {
			return fileDao.findAllFile(fileName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void deleteFile(String name, String fileType) {
		// TODO Auto-generated method stub
		try {
			fileDao.deletFile(name,fileType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<StoreFile> findFile(String filename) {
		// TODO Auto-generated method stub
		try {
			return fileDao.findFile(filename);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<StoreFile> findFileById(String fileid) {
		// TODO Auto-generated method stub
		try {
			return fileDao.findFileById(fileid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
}
