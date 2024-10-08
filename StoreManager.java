import java.util.*;

public class StoreManager {
    private List<Store> storeList;
    private static StoreManager storeManager;
    private StoreManager() {
        storeList = new ArrayList<>();
    }
    public static StoreManager getInstance() {
        if(storeManager == null) {
            storeManager = new StoreManager();
        }
        return storeManager;
    }

    public void addStore(Store store) {
        storeList.add(store);
    }

    public void removeStore(Store store) {
        storeList.remove(store);
    }

    public Store getStorebyLocation(Location location) {
        for(Store store : storeList) {
            if(store.getLocation().equals(location)) {
                return store;
            }
        }
        return null;
    }
}
