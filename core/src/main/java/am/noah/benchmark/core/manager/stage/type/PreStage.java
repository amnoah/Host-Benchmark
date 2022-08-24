package am.noah.benchmark.core.manager.stage.type;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.manager.stage.StageManager;
import am.noah.benchmark.core.util.Bridge;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class PreStage extends StageManager {

    SystemInfo systemInfo;

    /**
     * Initialize the PreStage object.
     */
    public PreStage(Benchmark benchmark) {
        setBenchmark(benchmark);

        systemInfo = new SystemInfo();
        // Get a warning to pop up out of the way (if it happens at all).
        systemInfo.getOperatingSystem();

        benchmark.getBridge().log("");
        benchmark.getBridge().log("Pausing for 10 seconds to let CPU usage normalize.");
        benchmark.getBridge().log("");

        // Start a new Timer to end the stage.
        benchmark.getTimerManager().newTimer(benchmark, 10);
    }

    /**
     * When the current stage ends we need to output all of the hardware information and switch to the SingleStage.
     */
    @Override
    public void endStage() {
        Bridge bridge = getBenchmark().getBridge();
        Runtime runtime = Runtime.getRuntime();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();

        /*
         * It's also important to know what start up flags the server is using.
         * Through the use of this method we can find these flags.
         */
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        StringBuilder startupFlags = new StringBuilder();

        // Assemble all of the individual flags into one String.
        for (String flag : runtimeBean.getInputArguments()) {
            startupFlags.append(flag).append(" ");
        }

        /*
         * What plugin version is being used and what server version/type?
         * This may affect results, so we should track it.
         */
        bridge.log("");
        bridge.log("Benchmark Version: " + getBenchmark().getVersion());
        bridge.log("Server Version: " + getBenchmark().getServerVersion());
        bridge.log("Startup Flags: " + startupFlags);
        bridge.log("");

        /*
         * Log Hardware information, this may be useful for finding out what is being used when hosts don't tell you.
         */
        bridge.log("Operating System: " + systemInfo.getOperatingSystem());
        bridge.log("CPU: " + hardware.getProcessor().toString());
        bridge.log("System Installed RAM: " + FormatUtil.formatBytes(hardware.getMemory().getTotal()));
        bridge.log("System Utilized RAM: " + FormatUtil.formatBytes(hardware.getMemory().getTotal() - hardware.getMemory().getAvailable()));
        bridge.log("JVM Allocated RAM: " + FormatUtil.formatBytes(runtime.totalMemory()));
        bridge.log("JVM Utilized RAM: " + FormatUtil.formatBytes(runtime.totalMemory() - runtime.freeMemory()));

        // Oshi errors out accessing disk information on some Linux distributions...
        try {
            /*
             * Go through all of the storage devices connected to the server and log what they are.
             */
            for (HWDiskStore storage : hardware.getDiskStores()) {
                bridge.log("Storage Device: " + storage.getModel() + " - Size - " + FormatUtil.formatBytes(storage.getSize()));
            }
        } catch (Exception e) {
            bridge.log("Unable to access disk information!");
        }

        // Spacing ;)
        bridge.log("");

        getBenchmark().setStageManager(new SingleStage(getBenchmark()));
    }
}
