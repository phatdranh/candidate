/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class MemberController {

    private final InterfaceView view = new InterfaceView();

    public void manage(User user) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\nWelcome: " + user.getUserName());
            System.out.println("********** CANDIDATE MANAGEMENT - MEMBER **********");            
            int choice = view.MemberMenu();
            switch (choice) {
                case 1: {
                    CandidateSkillInfoManagement.CandidateSkillInformationController();
                }
                break;
                case 2: {
                    SearchCandidateManagement.SearchBySkillController();
                }
                break;
                case 3: {
                    int accountManagementChoice = view.AccountManagement();
                    switch (accountManagementChoice) {
                        case 1: {
                            ChangePasswordController.ChangePassword(user);
                        }
                        break;
                        case 2: {
                            isContinue = LogOutController.LogOut();
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
}
