/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.FileHandler;
import java.util.ArrayList;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class SearchCandidateManagement {

    private static final InterfaceView view = new InterfaceView();

    public static void SearchBySkillController() {
        ArrayList<String> listSkills = FileHandler.getAllDataInFile("skill.txt");
        String skillName = null;
        boolean isContinue = true;
        while (isContinue) {
            skillName = view.SearchBySkill(listSkills);
            for (int i = 0; i < listSkills.size(); i++) {
                if (skillName.equalsIgnoreCase(listSkills.get(i).split("\\|")[1])) {
                    isContinue = false;
                }
            }
            if (isContinue) {
                System.out.println("Do not have this skill! Please enter again!");
            }
        }
        ArrayList<String> listCandidates = FileHandler.getCandidateBySkillName(skillName);
        System.out.println("List candidates by skill: " + skillName);
        if (listCandidates.isEmpty()) {
            System.out.println("No candidate has this skill!");
        } else {
            for (String candidate : listCandidates) {
                System.out.println(candidate);
            }
        }
    }
}
