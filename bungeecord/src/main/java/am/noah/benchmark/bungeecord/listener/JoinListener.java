package am.noah.benchmark.bungeecord.listener;

import am.noah.benchmark.bungeecord.BenchmarkPlugin;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

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
    public void onJoinEvent(LoginEvent event){
        plugin.getBungeecordBridge().joinEvent();
    }
}
