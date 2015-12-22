package activemq.queue.reciever;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQQueueListener {

	private String brokerUrl;
	private String username;
	private String password;

	public ActiveMQQueueListener(final String brokerUrl, String username, String password) {
		this.brokerUrl = brokerUrl;
		this.username = username;
		this.password = password;
	}

	public void startReceiving(final String queueName) throws Exception {
		Connection connection = null;
		Session session = null;
		try {
			// get the connection factory
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(this.username, this.password, this.brokerUrl);
			// create connection
			connection = connectionFactory.createConnection();

			// start
			connection.start();

			// create session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// create queue (it will create if queue doesn't exist)
			Destination queue = session.createQueue(queueName);

			MessageConsumer consumer = session.createConsumer(queue);

			// create listener
			MessageListener messageListener = new MessageListener() {

				@Override
				public void onMessage(Message message) {
					// only text type message
					if (message instanceof TextMessage) {
						TextMessage txt = (TextMessage) message;
						try {
							System.out.println("Message received =" + txt.getText());
						} catch (JMSException e) {
							System.out.println("error retrieving message");
							System.exit(1);
						}
					}

				}
			};

			consumer.setMessageListener(messageListener);
			System.in.read();
			consumer.close();
			session.close();
			connection.close();

		} catch (Exception e) {
			System.out.println("Exception while sending message to the queue" + e);
			throw e;
		}

	}

}
