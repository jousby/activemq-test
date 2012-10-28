package producer;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


@Component
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    protected static final String MESSAGE_COUNT = "messageCount";

    @Autowired
    private JmsTemplate template = null;
    private int messageCount = 100;

    /**
     * Generates JMS messages
     */
    @PostConstruct
    public void generateMessages() throws JMSException {
        for (int i = 0; i < messageCount; i++) {
            final int index = i;
            final String text = "Message number is " + i + ".";

            template.send(new MessageCreator() {

                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage(text);
                    message.setIntProperty(MESSAGE_COUNT, index);
                    
                    logger.info("Sending message: " + text);
                    
                    return message;
                }
            });
        }
    }
    
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("producer-context.xml");
    }

}
