import com.mongodb.bulk.UpdateRequest;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.eq;

public class MongoPrimer {

    public static void main(String[] args) {
        //datbaase type, username:password, ip:port database
        String uri = "mongodb://course3:course3@localhost:27017/jdnd";

        //Mongo Client
        MongoClient mongoClient = MongoClients.create(uri);

        //select the database to work with, the same as db in shell
        MongoDatabase database = mongoClient.getDatabase("jdnd");

        //create collection
       // database.createCollection("members");

        //get the collection, the same as db.collectionName in shell
        MongoCollection<Document> members = database.getCollection("members");
/*
        //create a document
        Document firstMember = new Document()
                .append("first_name", "Carl")
                .append("last_name", "Jenkins")
                .append("gender", "male")
                .append("age", 23)
                .append("address", new Document("street", "123 Main Street")
                    .append("city", "Oakland")
                    .append("state", "CA"))
                .append("interests", Arrays.asList("pilates", "swim", "crossfit"))
                .append("balance", 125.20);

        //insert a document
        members.insertOne(firstMember);
        System.out.println("inserted member: " + firstMember.toString());

        //create a document
        Document secondMember = new Document()
                .append("_id", "666")
                .append("first_name", "Carl")
                .append("last_name", "Jenkins")
                .append("gender", "male")
                .append("age", 23)
                .append("address", new Document("street", "123 Main Street")
                        .append("city", "Oakland")
                        .append("state", "CA"))
                .append("interests", Arrays.asList("pilates", "swim", "crossfit"))
                .append("balance", 125.20);

        //insert a document
        members.insertOne(secondMember);
        System.out.println("inserted member: " + secondMember.toString());

        //create a document
        Document one = new Document()
                .append("first_name", "Lukas")
                .append("last_name", "Jenkins")
                .append("gender", "male")
                .append("age", 23)
                .append("address", new Document("street", "123 Main Street")
                        .append("city", "Oakland")
                        .append("state", "CA"))
                .append("interests", Arrays.asList("pilates", "swim", "crossfit"))
                .append("balance", 125.20);

        //create a document
        Document two = new Document()
                .append("first_name", "Alena")
                .append("last_name", "Jenkins")
                .append("gender", "male")
                .append("age", 23)
                .append("address", new Document("street", "123 Main Street")
                        .append("city", "Oakland")
                        .append("state", "CA"))
                .append("interests", Arrays.asList("pilates", "swim", "crossfit"))
                .append("balance", 125.20);

        //create a document
        Document three = new Document()
                .append("first_name", "Marian")
                .append("last_name", "Jenkins")
                .append("gender", "male")
                .append("age", 23)
                .append("address", new Document("street", "123 Main Street")
                        .append("city", "Oakland")
                        .append("state", "CA"))
                .append("interests", Arrays.asList("pilates", "swim", "crossfit"))
                .append("balance", 125.20);

        //create a document
        Document four = new Document()
                .append("first_name", "Linda")
                .append("last_name", "Jenkins")
                .append("gender", "male")
                .append("age", 23)
                .append("address", new Document("street", "123 Main Street")
                        .append("city", "Oakland")
                        .append("state", "CA"))
                .append("interests", Arrays.asList("pilates", "swim", "crossfit"))
                .append("balance", 125.20);

        //create a document
        Document five = new Document()
                .append("first_name", "Lena")
                .append("last_name", "Jenkins")
                .append("gender", "male")
                .append("age", 23)
                .append("address", new Document("street", "123 Main Street")
                        .append("city", "Oakland")
                        .append("state", "CA"))
                .append("interests", Arrays.asList("pilates", "swim", "crossfit"))
                .append("balance", 125.20);

        List<Document> list = Arrays.asList(one, two, three, four, five);

        //add the list of documents to the collection
        members.insertMany(list);

        //first empty filter, after new object with append option rename and new document to change key
        members.updateMany(new Document(),
                new Document().append("$rename", new Document("gender", "sex")));

        //get the doc id
        //members.findOneAndDelete(eq("first_name", "Lukas"));

        //delete one using _id
        ObjectId id = members.find(eq("first_name", "Lukas")).first().getObjectId("_id");
        members.deleteOne(new Document("_id", id));

        Document doc = members.find(eq("sex", "male")).first();
        members.deleteOne(doc);

      /*  //insert gender field to existing doc
        patients.replaceOne(new Document("_id", _id), new Document()
        .append("first_name", "Lukas")
        .append("last_name", "Lengyel")
        .append("age", 45)
        .append("gender", "male"));

        //update the document to rename a field gender => sex
        patients.updateOne(new Document("_id", _id), new Document()
        .append("$rename", new Document("gender", "sex")));

        //upsert here
        patients.replaceOne(new Document("first_name", "Lukas"), new Document("first_name", "Lukas")
        .append("last_name", "Lengyel")
        .append("age", 33)
        .append("sex", "male"),
                new ReplaceOptions().upsert(true));*/

        //DIFFERENT OPTIONS OF FIND!!!!!!!!!!

        //find with key-value
      /*  Document firstFind = members.find(new Document("first_name", "Alena")).first();

        //find with logical operator
        members.find(new Document("$or", Arrays.asList(new Document("first_name", "Alena"),
                new Document("first_name", "Marian"))))
                .iterator()
                .forEachRemaining(d -> System.err.println("Logical query " + d));

        //third find query
        firstMember = members.find(new Document("interests", "crossfit")).first();

        //fourth query
        members.find(new Document("address.state", "CA"))
                .iterator()
                .forEachRemaining(d -> System.err.println(d));

        members.find(new Document("sex", "male")).sort(new Document("first_name", 1))
                .iterator()
                .forEachRemaining(d -> System.err.println(d));

        long count = members.countDocuments(new Document("sex", "male"));
        System.err.println("count: " + count);


        */
      //find members last name Khan
        members.find(new Document("last_name", "Khan"))
                .iterator()
                .forEachRemaining(d -> System.out.println(d.toString()));

        //logical operator Doe and female
        members.find(new Document("$and", Arrays.asList(new Document("last_name", "Doe"),
                new Document("gender", "female"))))
                .iterator()
                .forEachRemaining(d -> System.out.println(d.toString()));

        //interest gold
        members.find(new Document("interests", "golf"))
                .iterator()
                .forEachRemaining(d -> System.out.println(d.toString()));

        //live in MN
        members.find(new Document("address.state", "MN"))
                .iterator()
                .forEachRemaining(d -> System.out.println(d.toString()));

        //count male
        Long count = members.countDocuments(new Document("gender", "male"));
        System.out.println("count: " + count);

        //first member female
        Document mFirst = members.find(new Document("gender", "female")).sort(new Document("first_name", 1)).first();
        System.out.println(mFirst.toString());

        System.out.println("All done");
        mongoClient.close();
    }

}
