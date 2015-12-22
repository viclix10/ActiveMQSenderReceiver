package activemq.queue.reciever;

import java.util.Properties;


public class Reciever {

	public static void main(String[] args) {
		
		ActiveMQQueueListener sender = new ActiveMQQueueListener("tcp://localhost:61616", "admin", "admin");
		
		try {
			sender.startReceiving("test.queue");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
