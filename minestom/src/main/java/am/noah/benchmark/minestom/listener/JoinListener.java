package am.noah.benchmark.minestom.listener;

import am.noah.benchmark.minestom.BenchmarkPlugin;
import net.minestom.server.event.EventFilter;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.event.trait.PlayerEvent;

public class JoinListener {

    BenchmarkPlugin plugin;

    /**
     * Upon initialization of the JoinListener object create a PlayerLoginEvent listener.
     */
    public JoinListener(BenchmarkPlugin plugin) {
        this.plugin = plugin;

        EventNode<PlayerEvent> node = EventNode.type("player-listener", EventFilter.PLAYER);
        node.addListener(PlayerLoginEvent.class, playerLoginEvent -> {
            plugin.getMinestomBridge().joinEvent();
        });
    }
}
