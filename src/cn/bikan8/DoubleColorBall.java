package cn.bikan8;
import java.util.*;

/**
 * @Author 小浩
 * @Date 2020/8/8 9:07
 * @Version 1.0
 **/
public class DoubleColorBall {

    private Random random = new Random();
    private List<Integer>  list =  new ArrayList<>();

    public String getRandomResult() {
        StringBuilder result = new StringBuilder();
        list.clear();
        for (; ; ) {
            int r = random.nextInt(33)+1;
            if (!list.contains(r)){
                list.add(r);
            }
            if (list.size()>=6){
                break;
            }

        }
        Collections.sort(list);
        list.add(random.nextInt(16)+1);
        for (int i = 0;i<list.size();i++){
            if (i==list.size()-1){
                result.append(","+list.get(i));
            }else {
                result.append(list.get(i)+" ");
            }

        }
        return  result.toString();

    }
}
