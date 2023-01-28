package containers.water;

import java.util.HashSet;
import java.util.Set;

public class Container {
    //容器组
    private Set<Container> group;
    //当前容器的水量
    private double amount;

    /*创建容器（构造函数）*/
    public Container(){
        //此容器在当前组内
        group = new HashSet<Container>();
        group.add(this);
    }

    public double getAmount(){
        return amount;
    }

    public void addWater(double amount){
        double amountPerContainer = amount / group.size();
        for(Container c : group){
            c.amount += amountPerContainer;
        }
    }

    public boolean connectTo(Container other){
        if(group == other.group){
            //若已相连，不操作
            return true;
        }
        //计算容器中的新水量
        int sizeThis = group.size(),
                sizeOther = other.group.size();
        double amountThis = amount * sizeThis,
                amountOther = other.amount * sizeOther,
                totalAmount = (amountThis + amountOther) / (sizeThis + sizeOther);
        //合并两个组容器
        group.addAll(other.group);
        //更新相连容器的组
        for (Container c : other.group) {
            c.group = group;
        }
        //更新所有新相连的容器的水量
        for (Container c : group){
            c.amount = totalAmount;
        }
        return true;
    }
}
