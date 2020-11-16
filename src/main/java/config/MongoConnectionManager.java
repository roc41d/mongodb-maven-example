package config;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class MongoConnectionManager {

    private static final String MONGO_HOST = "localhost";
    private static final int MONGO_PORT = 27017;
    public static MongoClient initConnection() {
        List<ServerAddress> mongoHostList = new ArrayList<>();
        mongoHostList.add(new ServerAddress(MONGO_HOST, MONGO_PORT));

        try {
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .applyToClusterSettings(clusterSettingsBuilder -> clusterSettingsBuilder.hosts(mongoHostList))
                    .writeConcern(WriteConcern.W1)
                    .readConcern(ReadConcern.MAJORITY)
                    .readPreference(ReadPreference.nearest())
                    .retryWrites(true)
                    .build();

            MongoClient client = MongoClients.create(mongoClientSettings);

            return client;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
