package SeaManifesto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soham
 */
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static org.junit.Assert.assertEquals;

public class upload {

	public static void main(String[] args) {
		//assert(true);
                
                System.out.println("preparing to send mail");
		final String username = "seamanifestoofficial@gmail.com";
		final String password = "$eaManifesto4";
		String fromEmail = "seamanifestoofficial@gmail.com";
		String toEmail = "sohughosh41@gmail.com";
                String toEmail1 = "jivop74480@tigasu.com";
		
                //assertEquals("seamanifestoofficial@gmail.com",username);
                //assertEquals("$eaManifesto4",password);
		
                Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
                        msg.addRecipient(Message.RecipientType.CC, new InternetAddress(toEmail1));
			msg.setSubject("Manifests");
			
			Multipart emailContent = new MimeMultipart();
			
			
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Hello!! sending json files");
			
			
			MimeBodyPart jsonAttachment = new MimeBodyPart();
			jsonAttachment.attachFile("C:\\Users\\Soham\\Desktop/demo.json");
			
			
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(jsonAttachment);
			
			
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("Message sent Successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
