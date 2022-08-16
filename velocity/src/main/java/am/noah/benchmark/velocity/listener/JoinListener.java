package am.noah.benchmark.velocity.listener;

import am.noah.benchmark.velocity.BenchmarkPlugin;
import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;

public class JoinListener {

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
    @Subscribe(order = PostOrder.FIRST)
    public void onPostLogin(PostLoginEvent event) {
        plugin.getVelocityBridge().joinEvent();
    }
}
