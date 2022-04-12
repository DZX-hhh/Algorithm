package Leetcode.Study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * O(1)增删元素
 */
public class RandomizedSet {
    //O(1)插入(确认是否已经存在),删除,查找必然是要用到哈希表
    HashMap<Integer, Integer> valToKey;
    //O(1)删除,使用ArrayList<>
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        valToKey = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * 先判断是否存在val
     * 如果不存在再插入尾部
     *
     * @param val
     * @return
     */
    public boolean insert(int val) {
        if (valToKey.containsKey(val)) {
            return false;
        }
//        直接插入到list尾部
        valToKey.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * 先找到要删除的元素的位置
     * 将list尾部的元素赋值到这个位置
     * 然后删除list最后一个元素
     *
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!valToKey.containsKey(val)) {
            return false;
        }
        int index = valToKey.get(val);
        int lastElement = list.get(list.size() - 1);

        list.set(index, lastElement);//完成最后元素对删除元素的覆盖
        valToKey.put(lastElement, index);

        list.remove(list.size() - 1);
        valToKey.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/*
 * Your Study.RandomizedSet object will be instantiated and called as such:
 * Study.RandomizedSet obj = new Study.RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
