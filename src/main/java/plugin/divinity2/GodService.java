package plugin.divinity2;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GodService {

    public static GodService instance;

    public Map<String, Integer> gods = new HashMap<>();
    public Map<UUID, RepPlayer> playersoffer;


    public GodService() {
        if (instance != null)
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        this.gods = new HashMap<>();
        this.gods.put("Zeus", 0);
        this.gods.put("Hades", 0);
        this.gods.put("Poseidon", 0);
        this.playersoffer = new HashMap<>();
    }

    public static GodService getInstance() {
        if (instance == null)
            instance = new GodService();
        return instance;
    }

    public int addreputation(UUID uuid, String godname){
        Player player = Bukkit.getPlayer(uuid);
        if (player == null)
            return 0;
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        Material material = itemStack.getType();
        player.getInventory().removeItem(new ItemStack(material,1));
        this.gods.put(godname, this.gods.get(godname)+1);

        if (!this.playersoffer.containsKey(uuid)){
            RepPlayer repPlayer = new RepPlayer();
            repPlayer.addoffer(godname);
            this.playersoffer.put(uuid, repPlayer);
            return 1;
        }
        RepPlayer repPlayer = this.playersoffer.get(uuid);
        repPlayer.addoffer(godname);
        return repPlayer.getreputation(godname);
    }
}

