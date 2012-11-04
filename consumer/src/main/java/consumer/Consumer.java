package consumer;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Consumer implements MessageListener {

    protected static final String MESSAGE_COUNT = "messageCount";
    
    private static final Logger logger = LoggerFactory
            .getLogger(Consumer.class);

    @Autowired
    private AtomicInteger counter = null;

    /**
     * Implementation of <code>MessageListener</code>.
     */
    public void onMessage(Message message) {
        try {
            int messageCount = message.getIntProperty(MESSAGE_COUNT);

            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage) message;
                String msg = tm.getText();

                logger.info("Processed message '{}'.  value={}", msg,
                        messageCount);

                counter.incrementAndGet();
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }
    
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("consumer-context.xml");
    }
}
