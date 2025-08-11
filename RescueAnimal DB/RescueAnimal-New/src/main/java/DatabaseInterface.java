import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class DatabaseInterface {
    // Setup connection to database
    private MongoClient client = MongoClients.create("mongodb://localhost:27017");
    private MongoDatabase db = client.getDatabase("RescueAnimal");
    private MongoCollection<Document> dogCollection = db.getCollection("Dogs");
    private MongoCollection<Document> monkeyCollection = db.getCollection("Monkeys");

    // Creates a document for the new dog and adds it to the database
    public void createDog(String name, String breed, String gender, String age,
                          String weight, String acquisitionDate, String acquisitionCountry,
                          String trainingStatus, boolean reserved, String inServiceCountry) {

        Document newDog = new Document("Name", name).append("Breed", breed).append("Gender", gender)
                .append("Age", age).append("Weight", weight).append("Acquisition Date", acquisitionDate)
                .append("Acquisition Country", acquisitionCountry).append("Training Status", trainingStatus)
                .append("Reserved", reserved).append("Service Country", inServiceCountry);
        dogCollection.insertOne(newDog);
    }

    // Creates a document for the new monkey and adds it to the database
    public void createMonkey(String name, String species, String gender, String age,
                             String weight, String tailLength, String height, String bodyLength,
                             String acquisitionDate, String acquisitionCountry,
                             String trainingStatus, boolean reserved, String inServiceCountry) {

        Document newMonkey = new Document("Name", name).append("Species", species).append("Gender", gender)
                .append("Age", age).append("Weight", weight).append("Tail Length", tailLength)
                .append("Height", height).append("Body Length", bodyLength).append("Acquisition Date", acquisitionDate)
                .append("Acquisition Country", acquisitionCountry).append("Training Status", trainingStatus)
                .append("Reserved", reserved).append("Service Country", inServiceCountry);
        monkeyCollection.insertOne(newMonkey);
    }

    // Gets the names of all dogs, monkeys, or available animals
    public ArrayList<String> readNames(String animalType) {
        ArrayList<String> result = new ArrayList<String>();
        if ("Dog".equalsIgnoreCase(animalType)) {
            for (Document doc:dogCollection.find()) {
                result.add(doc.getString("Name"));
            }
        }
        else if ("Monkey".equalsIgnoreCase(animalType)) {
            for (Document doc:monkeyCollection.find()) {
                result.add(doc.getString("Name"));
            }
        }
        else if ("Available".equalsIgnoreCase(animalType)) {
            Bson filter = Filters.and(Filters.eq("Reserved", false),
                    Filters.eq("Training Status", "In service"));

            for (Document doc:dogCollection.find(filter)) {
                result.add(doc.getString("Name"));
            }
            for (Document doc:monkeyCollection.find(filter)) {
                result.add(doc.getString("Name"));
            }
        }
        return result;
    }

    // Finds the requested animal type in the reserve country, in service, and not reserved
    public String reserveAnimal(String animalType, String reserveCountry) {
        Document result;
        Bson filter = Filters.and(Filters.eq("Service Country", reserveCountry),
                Filters.eq("Reserved", false),
                Filters.eq("Training Status", "In service"));
        Bson update = Updates.set("Reserved", true);

        if ("Dog".equalsIgnoreCase(animalType)) {
            result = dogCollection.findOneAndUpdate(filter, update);
        }
        else {
            result = monkeyCollection.findOneAndUpdate(filter, update);
        }

        if (result != null) {
            return "Reserved " + result.getString("Name" + ".");
        }
        return "Could not find animal.";
    }
}
