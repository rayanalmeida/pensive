package com.shc.learning.mq;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class MQTest {
	private Log LOGGER = LogFactory.getLog(this.getClass());
	String hostName;
	int port;
	String channel;
	boolean inited;
	
	public static void main(String args[]) {
		MQTest obj = new MQTest();
		try {
			obj.sendAndReceiveImmediately("SQLT0285", "OMS1.IMS.DOWNLOAD.SIMULATOR.QL01", 4, "test", "OMS1.IMS.CUSTORD.REPLY.QL01", 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MQTest(String hostName, int port, String channel) {
		super();
		this.hostName = hostName;
		this.port = port;
		this.channel = channel;
	}

	public MQTest() {
		super();
	}


	public void sendMessage(String queueManagerName, String requestQueueName,
			int priority, String messageString) throws Exception {
		this.init();
		LOGGER.info("Entering sendMessage method of MqSender, Params -> queueManagerName: "+queueManagerName+", requestQueueName: "+requestQueueName+", priority: "+priority+", messageString: "+messageString);
		//System.out.println("sending message to " + this.hostName + " " + this.port + " " + this.channel + " " + queueManagerName + " " + requestQueueName);
		LOGGER.info("sending message to " + this.hostName + " " + this.port + " " + this.channel + " " + queueManagerName + " " + requestQueueName);
		//Connection To the Queue Manager
		MQQueueManager qMgr = null;
		MQQueue requestQueue = null;
		byte[] requestMessageId = null;
		try{
			qMgr= new MQQueueManager(queueManagerName);
			/* Set up the open options to open the queue for out put and
				additionally we have set the option to fail if the queue manager is
				quiescing.
			 */
			int openOptions = MQC.MQOO_OUTPUT | MQC.MQOO_FAIL_IF_QUIESCING ;
			//Open the queue
			requestQueue = qMgr.accessQueue(requestQueueName,
					openOptions,
					null,
					null,
					null);

			// Set the put message options , we will use the default setting.
			MQPutMessageOptions pmo = new MQPutMessageOptions();
			//pmo.options = pmo.options + MQC.MQPMO_NEW_MSG_ID ;
			//pmo.options = pmo.options + MQC.MQPMO_SYNCPOINT ;
			MQMessage outMsg = new MQMessage(); //Create the message buffer
			outMsg.format = MQC.MQFMT_STRING ; // Set the MQMD format field.
			outMsg.messageFlags = MQC.MQMT_REQUEST ;

			//Prepare message with user data

			outMsg.writeString(messageString);
			// Now we put The message on the Queue
			requestQueue.put(outMsg, pmo);
			requestMessageId = outMsg.messageId;
			qMgr.commit();
			if(LOGGER.isInfoEnabled()) {
				//LOGGER.info(" The message has been Sussesfully put, message id " + StringUtil.bytesToHexString(requestMessageId));
			}

		}catch(MQException me){
			LOGGER.error("MQ", me);
			throw new RuntimeException("Failed to send message ", me);
		}finally{
			// Close the the Request Queue
			if(requestQueue!=null && requestQueue.isOpen()){
				requestQueue.close();
			}
			requestQueue=null;
			if(qMgr!=null){
				qMgr.disconnect();
				qMgr.close();
			}
			qMgr = null;
		}
		//LOGGER.info("Exiting sendMessage method of MqSender");
	}

	private void init(){
		if(!inited){
			//Set up the MQEnvironment properties for Client Connections
			MQEnvironment.hostname = "omsapp301p.stress.ch3.s.com";
			MQEnvironment.port=1414;
			MQEnvironment.channel = "SQLT0285.OMS01";
			MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY,
					MQC.TRANSPORT_MQSERIES);

			inited=true;
		}
	}
	public String sendAndReceiveImmediately(String queueManagerName,
			String requestQueueName, int priority, String messageString,
			String replyQueueName, long timeoutInMilliSeconds) throws Exception {
		/*LOGGER.info(String
				.format("Entering sendAndReceiveImmediately method of MqSender, Params -> queueManagerName: %s, requestQueueName: %s, priority %d, messageString: %s, replyQueueName: %s, timeoutInMilliSeconds: %s", 
						queueManagerName, requestQueueName, priority,
						messageString,replyQueueName,timeoutInMilliSeconds));*/
		this.init();
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("request-reply to host:" + this.hostName + " port:" + this.port + " channel:" + this.channel + " manager:" + queueManagerName + " queue:" + requestQueueName + " reply:" + replyQueueName);
		}
		//Connection To the Queue Manager
		MQQueueManager qMgr = null;
		MQQueue requestQueue = null;
		byte[] requestMessageId = null;
		try{
			qMgr= new MQQueueManager(queueManagerName);


			try{
				/* Set up the open options to open the queue for out put and
				additionally we have set the option to fail if the queue manager is
				quiescing.
				 */
				int openOptions = MQC.MQOO_OUTPUT | MQC.MQOO_FAIL_IF_QUIESCING ;
				//Open the queue
				requestQueue = qMgr.accessQueue(requestQueueName,
						openOptions,
						null,
						null,
						null);

				// Set the put message options , we will use the default setting.
				MQPutMessageOptions pmo = new MQPutMessageOptions();
				pmo.options = pmo.options + MQC.MQPMO_NEW_MSG_ID ;
				pmo.options = pmo.options + MQC.MQPMO_SYNCPOINT ;
				MQMessage outMsg = new MQMessage(); //Create the message buffer
				outMsg.format = MQC.MQFMT_STRING ; // Set the MQMD format field.
				outMsg.messageFlags = MQC.MQMT_REQUEST ;
				outMsg.replyToQueueName = replyQueueName;
				outMsg.replyToQueueManagerName = queueManagerName ;
				outMsg.priority=4;
				outMsg.characterSet=1208;
				//Prepare message with user data

				outMsg.writeString(messageString);
				// Now we put The message on the Queue
				requestQueue.put(outMsg, pmo);
				requestMessageId = outMsg.messageId;
				//Commit the transaction.
				qMgr.commit();
				if(LOGGER.isDebugEnabled()) {
					//LOGGER.debug(" The message has been Sussesfully put, message id " + StringUtil.bytesToHexString(requestMessageId));
				}


			}catch(MQException me){
				LOGGER.error("MQ", me);
				throw new RuntimeException("Failed to send message ", me);
			}finally{
				// Close the the Request Queue
				if(requestQueue!=null && requestQueue.isOpen()){
					requestQueue.close();
				}
				requestQueue=null;
			}
			MQQueue respQueue = null;
			try{
				// Set openOption for response queue
				int openOptions = MQC.MQOO_INPUT_AS_Q_DEF + MQC.MQOO_FAIL_IF_QUIESCING + MQC.MQOO_INQUIRE;//MQC.MQOO_INPUT_SHARED | MQC.MQOO_FAIL_IF_QUIESCING ;
				respQueue = qMgr.accessQueue(replyQueueName,
						openOptions,
						null,
						null,
						null);
				MQMessage respMessage = new MQMessage();
				MQGetMessageOptions gmo = new MQGetMessageOptions();
				gmo.options = gmo.options + MQC.MQGMO_SYNCPOINT ; //Get messages under sync point control
				gmo.options = gmo.options + MQC.MQGMO_WAIT ; // Wait for Response Message
				gmo.matchOptions = MQC.MQMO_MATCH_CORREL_ID;
				gmo.waitInterval = (int)timeoutInMilliSeconds ;
				respMessage.correlationId = requestMessageId ;
				// Get the response message.
				LOGGER.info("depth: "+respQueue.getCurrentDepth());
				respQueue.get(respMessage, gmo);
				int dataLength = respMessage.getDataLength();
				String replyTextMessage = respMessage.readStringOfCharLength(dataLength);
				if(LOGGER.isDebugEnabled()) {
					//LOGGER.debug("received message, coorelation id " + StringUtil.bytesToHexString(respMessage.correlationId) + " reply:" + replyTextMessage);
				}
				qMgr.commit();
				//LOGGER.info(String.format("Exiting sendAndReceiveImmediately method of MqSender, Returns: %s",replyTextMessage));
				return replyTextMessage;
			}catch(MQException me){
				LOGGER.error("MQ", me);
				throw new RuntimeException("Failed to receive message ", me);
			}finally{
				// Close the the Reply Queue
				if(respQueue!=null && respQueue.isOpen()){
					respQueue.close();
				}
				respQueue=null;
			}
		}finally{
			if(qMgr!=null && qMgr.isConnected()){
				qMgr.disconnect();
			}
			qMgr=null;
		}

	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String sendMessageGetReply(String queueConnFactoryName,
			String requestqueueName, int priority, String messageString,long timeoutInMilliSeconds)
					throws Exception {
		return null;
	}
}
