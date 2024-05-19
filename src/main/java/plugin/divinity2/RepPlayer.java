package plugin.divinity2;

import java.util.HashMap;
import java.util.Map;

public class RepPlayer {

    private Map<String, Integer> playeroffers;

    public RepPlayer(){
        this.playeroffers = new HashMap<>();
    }

    public void addoffer(String godname){
        if (this.playeroffers.get(godname) == null){
            this.playeroffers.put(godname, 1);
            return;
        }
        int value = this.playeroffers.get(godname);
        this.playeroffers.put(godname, value +1);
    }

    public int getreputation(String godname){
        return this.playeroffers.getOrDefault(godname, 0);
    }
}
