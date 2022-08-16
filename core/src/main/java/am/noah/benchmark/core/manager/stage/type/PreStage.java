package am.noah.benchmark.core.manager.stage.type;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.manager.stage.StageManager;
import am.noah.benchmark.core.util.Bridge;
import am.noah.benchmark.core.util.tickable.type.Countdown;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

public class PreStage extends StageManager {

    /**
     * Initialize the PreStage object.
     */
    public PreStage(Benchmark benchmark) {
        setBenchmark(benchmark);

        benchmark.getBridge().log("Pausing for 10 seconds to let CPU usage normalize.");

        // Add the Countdown to the TickManager.
        benchmark.getTickManager().addTickable(new Countdown(benchmark, 10));
    }

    /**
     * When the current stage ends we need to output all of the hardware information and switch to the SingleStage.
     */
    @Override
    public void endStage() {
        Bridge bridge = getBenchmark().getBridge();
        SystemInfo systemInfo = new SystemInfo();
        Runtime runtime = Runtime.getRuntime();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();

        // Usually get a warning when running this for the first time, so we should get it out of the way.
        systemInfo.getOperatingSystem();

        /*
         * What plugin version is being used and what server version/type?
         * This may affect results, so we should track it.
         */
        bridge.log("");
        bridge.log("Benchmark Version: " + getBenchmark().getVersion());
        bridge.log("Server Version: " + getBenchmark().getServerVersion());
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

        /*
         * Go through all of the storage devices connected to the server and log what they are.
         */
        for (HWDiskStore storage : hardware.getDiskStores()) {
            bridge.log("Storage Device: " + storage.getModel() + " - Size - " + FormatUtil.formatBytes(storage.getSize()));
        }

        // Spacing ;)
        bridge.log("");

        getBenchmark().setStageManager(new SingleStage(getBenchmark()));
    }
}
