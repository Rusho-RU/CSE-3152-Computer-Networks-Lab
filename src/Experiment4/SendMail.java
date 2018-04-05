package Experiment4;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class SendMail{
    private String sender;
    private String recipient;
    private String host;

    SendMail(){
        sender = "admin@localhost";
        recipient = "dragontwister@localhost";
        host = "localhost";
    }

    public void send(String message){
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(sender));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            msg.setSubject("Test Subject");
            msg.setText(message);

            Transport.send(msg);
            System.out.println("Success!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}