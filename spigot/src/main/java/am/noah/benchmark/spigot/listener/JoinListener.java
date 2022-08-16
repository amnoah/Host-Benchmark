package am.noah.benchmark.spigot.listener;

import am.noah.benchmark.spigot.BenchmarkPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    BenchmarkPlugin plugin;

    /**
     * Initialize the JoinListener object.
     */
    public JoinListener(BenchmarkPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * A player joining the server can compromise test results, so we should alert the Core of it happening.
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(final PlayerJoinEvent event) {
        plugin.getSpigotBridge().joinEvent();
    }
}
