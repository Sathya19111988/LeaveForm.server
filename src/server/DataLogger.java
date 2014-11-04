package server;

import java.net.UnknownHostException;

import model.Customer;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class DataLogger {
	
	DBCollection table;
	public static void main(String[] args) {
		DataLogger dataLogger = new DataLogger();
		Customer cust = new Customer();
		cust.setId(1);
		cust.setName("Sathish");
		cust.setEmpId("646");
		cust.setProjectName("CNN");
		cust.setEmailId("sathishkumar.dharmaraj@object-frontier.com");
		cust.setPassword("Password@ofs");
		dataLogger.logInDB("mydb", cust);
	}
	
	public void logInDB(String dbName, Customer cust) {
		createConnection(dbName);
		insert(cust);
	}
	
	public void createConnection(String dbName) {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("testdb");
			table = db.getCollection("mydbCollection");
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Customer cust) {
		BasicDBObject document = new BasicDBObject();
		document.put("cust", cust);
		table.insert(document);
		System.out.println("Success");
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("cust", "sathish");
	 
		DBCursor cursor = table.find(searchQuery);
	 
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
}
