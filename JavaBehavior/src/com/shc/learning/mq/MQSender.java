package com.shc.learning.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MQSender {

	/**
	 * To Send:
	 * Get ConnectionFactory from the InitialContext
	 * Create Connection from the factory
	 * Create Session from the connection
	 * Get Destination from the InitialContext
	 * Create Producer from session using Destination
	 * Create Message from the session
	 * Send message using Producer
	 * 
	 * To Receive
	 * Set CorrelationId to the Message
	 * Set the ReplyQueue to the Message
	 * Create a Consumer from session using ReplyQueue and the CorrelationId.
	 * Receive message using the consumer.
	 * 
	 * @return
	 */
	public static boolean send() {

		QueueConnectionFactory qcf = null;
		Queue queue = null;
		Destination dest = null;
		Object obj1, obj2, obj3 = null;
		try {
			obj1 = new InitialContext().lookup("MyQueueFactory");
			if(obj1 instanceof QueueConnectionFactory) {
				qcf = (QueueConnectionFactory) obj1;

				QueueConnection conn = qcf.createQueueConnection();
				QueueSession session = conn.createQueueSession(true, 0);

				obj2 = new InitialContext().lookup("MyRemoteQueue");
				if(obj2 instanceof Queue) {
					queue = (Queue) obj2;
				}
				QueueSender sender = session.createSender(queue);
				Message msg = session.createTextMessage("MyQueueMessage");
				
				Queue replyQueue = (Queue) new InitialContext().lookup("ReplyQueue");
				msg.setJMSCorrelationID("12345");
				msg.setJMSReplyTo(replyQueue);
				
				sender.send(msg);
				
				QueueReceiver receiver = session.createReceiver(replyQueue, "12345");
				Message reply = receiver.receive();
				
			} else {
				ConnectionFactory cf = (ConnectionFactory) obj1;
				Connection conn = cf.createConnection();
				Session session = conn.createSession(true, 0);

				obj3 = new InitialContext().lookup("MyRemoteDestination");
				if(obj3 instanceof Destination) {
					dest = (Destination) obj3;
				}

				MessageProducer producer = session.createProducer(dest);

				Message msg = session.createTextMessage("MyTestMessage");
				Destination replyDest = (Destination) new InitialContext().lookup("ReplyDest");
				msg.setJMSCorrelationID("0986");
				msg.setJMSReplyTo(replyDest);
				
				MessageConsumer consumer = session.createConsumer(replyDest, "0986");
				
				producer.send(msg);
				
				Message reply = consumer.receive();
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
