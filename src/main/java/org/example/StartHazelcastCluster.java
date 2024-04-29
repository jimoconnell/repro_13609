package org.example;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class StartHazelcastCluster {

	public static void main(String[] args) {
		// Start three Hazelcast instances (nodes) on the local machine
		for (int port = 5701; port <= 5701; port++) {
			startHazelcastNode(port);
		}
	}

	private static void startHazelcastNode(int port) {
		Config config = new Config();
		// Set the instance name for easier identification
		config.setInstanceName("HazelcastInstance-" + port);
		// Configure the network settings, including the port
		config.getNetworkConfig().setPort(port);
		config.getNetworkConfig().setPortAutoIncrement(false);

		// Starting the Hazelcast instance (node)
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
		System.out.println("Started Hazelcast Node on port: " + port);
	}
}
