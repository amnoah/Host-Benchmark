# Host Benchmark

Host Benchmark is a benchmark system meant to benchmark a CPU through Minecraft server plugin APIs. This allows you to gain a score for the processor's ability to perform intensive string modifications at a high speed to compare to other scores. This is especially helpful for getting baseline performance information for hosts who restrict running non-Minecraft jars.

Through the use of Host Benchmark you can also get information about the system that the hosting service is running including the operating system, processor, RAM information, and storage device information.

Unfortunately, it does have its faults. Firstly, the multi-threaded test is applicable to very few scenarios in Minecraft as Minecraft is almost entirely a single-threaded application. Secondly, anybody can contribute to the score tracker and thus those scores may not be entirely accurate (think of it like Wikipedia). While it is a useful resource to have, use the results with caution.

# Where Can I Find Scores/Where Can I Submit Scores?

Check out our sister repository, [Host-Benchmark-Results](https://github.com/amnoah/Host-Benchmark-Results).

# Join our Discord

You can join the Discord server in order to discuss/help with the Host Benchmark plugin at [https://discord.gg/gkm35QgpZF](https://discord.gg/gkm35QgpZF).

# How to Use

- Download the Jar executable corresponding to your server/proxy platform of choice.
- Drag and drop the Jar into the plugins folder.
- Restart the server.
- Watch for console output - Host Benchmark is entirely automated and will begin/stop on its own.

# Download

- Official Releases: https://github.com/amnoah/Host-Benchmark/releases
- Dev Builds (Jenkins): https://ci.imjustdoom.com/job/Minecraft%20Server%20Benchmark/
