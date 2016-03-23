package cn.zeico.air.db;

public class MongoAuthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4663025241638319087L;

	public MongoAuthException(String userName, String password){
		super("Authentication failed with user:" + userName + " and password " + password + "!");
	}
}
