package test;

import java.util.ArrayList;

import DAO.*;
import Models.*;

public class test {

	public static void main(String[] args) {
		UtilisateurDAO udao = new UtilisateurDAO();
		MessageDAO msgdao = new MessageDAO();
        ArrayList<Utilisateur> users = udao.getUsers();
        ArrayList<Message> Messages = msgdao.getMessage(3);
       // boolean msg = msgdao.AddMessage("Bonjour", users.get(1).getId(), users.get(2).getId());
       // if(msg == false) System.out.println("Message n'est pas envoyer, y a un probleme dans quelque part");
       // else
      //  	System.out.println("Message envoyée");
        
        
        for(Message msgs : Messages)
        System.out.println(msgs.toString());
        
        boolean msg = msgdao.SupprimerMessage(4);
        if(msg == true) System.out.println("Message a eté supprimer");
        else
        	System.out.println("Message n'est pas supprimer");
        
        users = udao.getUsers();
        
        for(Message msgs : Messages)
            System.out.println(msgs.toString());
	}

}
