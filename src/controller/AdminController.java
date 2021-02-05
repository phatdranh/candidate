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
public class AdminController {

    private final InterfaceView view = new InterfaceView();

    public void manage(User user) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\nWelcome: " + user.getUserName());
            System.out.println("********** CANDIDATE MANAGEMENT - ADMIN **********");           
            int choice = view.AdminMenu();
            switch (choice) {
                case 1: {
                    CandidateManagement.CandidateManagementController();
                }
                break;
                case 2: {
                    SkillInfoManagement.SkillInformationManagementController();
                }
                break;
                case 3: {
                    CandidateSkillInfoManagement.CandidateSkillInformationController();
                }
                break;
                case 4: {
                    AccountManagement.UserManagementController();
                }
                break;
                case 5: {
                    SearchCandidateManagement.SearchBySkillController();
                }
                break;
                case 6: {
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
