package containers.water;

import java.util.*;

public class User {
    private String name;
    private Set<User> directFriends = new HashSet<>();

    public User(String name){
        this.name = name;
    }

    /*做朋友*/
    public void befriend(User other){
        directFriends.add(other);
        other.directFriends.add(this);
    }

    /*判断是否直接连接*/
    public boolean isDirectFriendOf(User other){
        return directFriends.contains(other);
    }

    /*判断是否间接连接*/
    public boolean isInDirectFriendOf(User other){
        Set<User>  visited = new HashSet<>();
        Deque<User> frontier = new LinkedList<>();

        frontier.add(this);
        while(!frontier.isEmpty()){
            User user = frontier.removeFirst();
            if(user.equals(other)){
                return true;
            }
            if(visited.add(user)){
                frontier.addAll(user.directFriends);
            }
        }
        return false;
    }
}
