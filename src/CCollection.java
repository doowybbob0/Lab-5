import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * This Class is designed to sort and store collections that are used in this program
 */
public class CCollection {
    public static ArrayDeque<SpaceMarine> collectionBuffer = new ArrayDeque<>();
    public static HashMap<Long, SpaceMarine> collection;
    private static ZonedDateTime time;
    public static HashMap<Long, SpaceMarine> enscribing() throws FileNotFoundException {
        collection = new HashMap<Long, SpaceMarine>();
        long keys;
        while (collectionBuffer.size() != 0) {
            keys = Keys.keys();
            collection.put(keys, collectionBuffer.getFirst());
            collectionBuffer.removeFirst();             
        }
        
            long i = 1;
            int n = collection.size();
            if (collection.size() != 0){
            
            	while (i <= n) {
            		System.out.print("Element ID " + "["+collection.get(i) + "]:" + collection.get(i).getId()+" | ");
            		i++;
            	}
            	System.out.println();
            }
         time = ZonedDateTime.now();
         return collection;

    }
    public static HashMap<Long, SpaceMarine> getCollection() {
        return collection;
    }
    public static ZonedDateTime getTime() {
        return time;
    }

    public static void setCollection(HashMap<Long, SpaceMarine> collection) {
        CCollection.collection = collection;
    }
}
