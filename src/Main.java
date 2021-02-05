
import controller.AdminController;
import controller.LoginController;
import controller.MemberController;
import java.util.ArrayList;
import model.Candidate;
import model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dang Phat
 */
public class Main {

    public static void main(String[] args) {       
        LoginController loginController = new LoginController();
        AdminController adminController = new AdminController();
        MemberController memberController = new MemberController();
        ArrayList<Candidate> candidates = new ArrayList<>();        
        while(true) {
            System.out.println("********** CANDIDATE MANAGEMENT **********");
            User user = loginController.login();            
            int getTypeLogin = user.getType();
            switch (getTypeLogin) {
                case 1: {                    
                    adminController.manage(user);
                }
                break;
                case 2: {                    
                    memberController.manage(user);
                }
                break;
            } 
            System.out.println("\n");
        }        
    }
}
