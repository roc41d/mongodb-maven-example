import com.mongodb.MongoClient;
import com.mongodb.client.*;
import config.MongoConnectionManager;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class HelloMongo {
    public static void main(String[] args) {
        System.out.println("Hola Mongo");

        MongoClient mongoClient = MongoConnectionManager.initConnection();
        MongoDatabase DB = mongoClient.getDatabase("dataBasename");
    }
}
