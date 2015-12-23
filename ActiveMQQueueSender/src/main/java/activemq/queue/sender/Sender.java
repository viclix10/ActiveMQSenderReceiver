package activemq.queue.sender;

import java.util.Properties;

public class Sender {

	public static void main(String[] args) {
		int count=0;

		Properties systemProps = System.getProperties();
		systemProps.put(
				"javax.net.ssl.keyStore", "amq-client.ks");
		systemProps.put(
				"javax.net.ssl.keyStorePassword", "123456");
		systemProps.put(
				"javax.net.ssl.trustStore", "amq-client.ts");
		System.setProperties(systemProps);
		
		ActiveMQQueueSender sender = new ActiveMQQueueSender("ssl://localhost:61617", "admin", "admin");
			
		try {
			while (true) {
				String msg = "TimeStamp:" + System.currentTimeMillis() +" Msg Counter:"+(count++);
				sender.sendMessage("test.queue", msg);
				Thread.sleep(10);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
