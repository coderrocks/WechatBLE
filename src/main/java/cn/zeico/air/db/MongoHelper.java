/**
 * Copyright 2014-2016, zeico inc. All right reserved.
 * Project: 	ZeicoUtility
 * Author:  	ChenZhi
 * Create date:	2016年3月23日
 */
package cn.zeico.air.db;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

/**
 * MongoHelper
 */
public class MongoHelper {
	private MongoClient mg;
	private DB db;
	
	public MongoHelper() throws UnknownHostException, MongoException {
		mg = new MongoClient();
	}
	
	public MongoHelper(String host) throws UnknownHostException, MongoException {
		mg = new MongoClient(host);
	}
	
	public MongoHelper(String host, int port) throws UnknownHostException, MongoException {
//		try {
            mg = new MongoClient(host, port);
//            mg.setWriteConcern(WriteConcern.ACKNOWLEDGED);
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
	}
	
	public MongoHelper(List<ServerAddress> hostList) throws UnknownHostException, MongoException {
		mg = new MongoClient(hostList);
	}
	
//	private void Init() {
//		
//	}
	 
	public DB GetDB(String dbName){
		db = mg.getDB(dbName);
		return db;
	}
	
	/**
	 * 
	 * @param dbName	
	 * @param userName
	 * @param passWord
	 * @return DB
	 * @throws MongoAuthException
	 */
	@SuppressWarnings({"deprecation" })
	public DB GetDB(String dbName, String userName, String password) throws MongoAuthException{
		db = mg.getDB(dbName);
		boolean auth =db.authenticate(userName, password.toCharArray());
		if (!auth) {
			throw new MongoAuthException(userName, password);
		}
		return db;
	}
	
	public MongoClient GetClient() {
		return mg;
	}
	
	public void setWriteConcern(WriteConcern concern) {
		mg.setWriteConcern(concern);
	}
	
	public void Close() {
		mg.close();
	}
	
}
