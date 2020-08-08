package cn.bikan8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author 小浩
 * @Date 2020/8/8 9:26
 * @Version 1.0
 **/
public class SuperLotto {
    private Random random = new Random();
    private List<Integer> list =  new ArrayList<>();

    public String getRandomResult() {
        StringBuilder result = new StringBuilder();
        list.clear();
        for (; ; ) {
            int r = random.nextInt(35)+1;
            if (!list.contains(r)){
                list.add(r);
            }
            if (list.size()>=5){
                break;
            }

        }
        Collections.sort(list);
        for (; ; ) {
            int r = random.nextInt(12)+1;
            if (!list.contains(r)){
                list.add(r);
            }
            if (list.size()>=7){
                break;
            }
        }
        if (list.get(5)>list.get(6)){
           int temp =list.get(5);
            list.set(5,list.get(6));
            list.set(6,temp);
        }
        for (int i = 0;i<list.size();i++){
            if (i==list.size()-2){
                result.append(","+list.get(i)+" ");
            }else {
                result.append(list.get(i)+" ");
            }

        }
        return  result.toString();

    }
}
