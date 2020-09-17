import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class HelloMongo {
    public static void main(String[] args) {
        System.out.println("Hello Mongo");

        try (MongoClient mongoClient = new MongoClient( "localhost" , 27017 )) {

            MongoDatabase database = mongoClient.getDatabase("dbName");
//            System.out.println("database" + database.listCollections());
            MongoCollection<Document> collection = database.getCollection("collectionName");

            System.out.println("collection"+ collection.count());

        } catch (Exception e) {

        }
    }
}
