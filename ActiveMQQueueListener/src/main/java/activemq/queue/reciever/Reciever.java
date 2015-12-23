package activemq.queue.reciever;

import java.util.Properties;


public class Reciever {

	public static void main(String[] args) {
		
		Properties systemProps = System.getProperties();
		systemProps.put(
				"javax.net.ssl.keyStore", "amq-client.ks");
		systemProps.put(
				"javax.net.ssl.keyStorePassword", "123456");
		systemProps.put(
				"javax.net.ssl.trustStore", "amq-client.ts");
		System.setProperties(systemProps);
		
		ActiveMQQueueListener sender = new ActiveMQQueueListener("ssl://localhost:61617", "admin", "admin");
		
		try {
			sender.startReceiving("test.queue");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
