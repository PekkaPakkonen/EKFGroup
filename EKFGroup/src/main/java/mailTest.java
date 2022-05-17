import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class mailTest {

    public static void main(String[] args) {
        String host = "post.ekf.su";

        Properties props = new Properties();

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "false");
        //props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props, null);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("AutomaticTestReport@ekf.su"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("k.stecenko@ekf.su"));   // like inzi769@gmail.com
            message.setSubject("Test");

            MimeBodyPart part1 = new MimeBodyPart();
            part1.setText("Test message from java");
            MimeBodyPart part2 = null;

            try {
                part2 = new MimeBodyPart();
                part2.attachFile("links.csv");
            } catch (IOException e) {
                System.out.println("File not found");
            }

            Multipart part = new MimeMultipart();
            part.addBodyPart(part1);
            part.addBodyPart(part2);

            message.setContent(part);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }



}

