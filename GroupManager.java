import java.util.*;

public class GroupManager {
    private static GroupManager groupManager;
    private List<Group> groupList;
    private GroupManager() {
        groupList = new ArrayList<>();
    }
    public static GroupManager getInstance() {
        if (groupManager == null) {
            synchronized (GroupManager.class) {
                if (groupManager == null) {
                    groupManager = new GroupManager();
                }
            }
        }
        return groupManager;
    }
    public void addGroup(Group group) {
        groupList.add(group);
    }
    public void removeGroup(Group group) {
        groupList.remove(group);
    }
    public List<Group> getGroupList() {
        return groupList;
    }
}
