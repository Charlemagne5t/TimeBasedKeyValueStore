import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        String res = "";
        if(list == null || list.isEmpty()){
            return res;
        }
        int l = 0;
        int r = list.size() - 1;
        int mid;

        while(l <= r){
            mid = l + (r - l) / 2;
            if(list.get(mid).timestamp == timestamp){
                return list.get(mid).value;
            }

            if(list.get(mid).timestamp < timestamp){
                res = list.get(mid).value;
                l = mid + 1;
            }

            if(list.get(mid).timestamp > timestamp){

                r = mid -1;
            }


        }

        return res;

    }
}
class Pair{
    String value;
    int timestamp;
    Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}