package activemq.queue.sender;

import java.util.Properties;

public class Sender {

	public static void main(String[] args) {
		int count=0;
		ActiveMQQueueSender sender = new ActiveMQQueueSender("tcp://localhost:61616", "admin", "admin");
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
