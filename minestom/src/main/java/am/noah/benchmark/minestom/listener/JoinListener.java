package am.noah.benchmark.minestom.listener;

import am.noah.benchmark.minestom.BenchmarkPlugin;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerLoginEvent;

public class JoinListener implements EventListener<PlayerLoginEvent> {

    BenchmarkPlugin plugin;

    /**
     * Upon initialization of the JoinListener object create a PlayerLoginEvent listener.
     */
    public JoinListener(BenchmarkPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Class<PlayerLoginEvent> eventType() {
        return PlayerLoginEvent.class;
    }

    @Override
    public Result run(PlayerLoginEvent event) {
        plugin.getMinestomBridge().joinEvent();
        return Result.SUCCESS;
    }
}
