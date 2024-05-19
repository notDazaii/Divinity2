package plugin.divinity2;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ComandoOfferte implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo i giocatori possono eseguire questo comando.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 2) {
            player.sendMessage(ChatColor.RED + "Utilizzo: /offer <nomeDivinita> <oggetto>");
            return true;
        }

        String godName = args[0];

        GodService godService = new GodService();
        int value = godService.addreputation(player.getUniqueId(), godName);
        player.sendMessage("Reputazione attuale " + godName + ": " + value);
        return true;
    }
}