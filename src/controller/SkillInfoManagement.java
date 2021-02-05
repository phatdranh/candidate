/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.DataInput;
import common.FileHandler;
import java.util.ArrayList;
import model.Skill;
import view.InterfaceView;
import view.SKillView;

/**
 *
 * @author Dang Phat
 */
public class SkillInfoManagement {

    private static final InterfaceView view = new InterfaceView();

    public static void SkillInformationManagementController() {
        int skillInfoManagementChoice = view.SkillInformationManagement();
        switch (skillInfoManagementChoice) {
            case 1: {
                ArrayList<String> listSkills = FileHandler.getAllDataInFile("skill.txt");
                String skillName = SKillView.InputSkillInformation();
                Skill skill = new Skill();
                skill.setSkillID(listSkills.size() + 1);
                skill.setSkillName(skillName);
                listSkills.add(skill.saveFormat());
                FileHandler.writeFile("skill.txt", listSkills);
            }
            break;
            case 2: {
                ArrayList<String> listSkills = FileHandler.getAllDataInFile("skill.txt");
                ArrayList<String> listCandidateSkills = FileHandler.getAllDataInFile("skill candidate.txt");
                int skillID = SKillView.GetSkillIdToUpdate(listSkills);
                String oldSkill = null;
                String newSkill = null;
                for (String skill : listSkills) {
                    if (Integer.parseInt(skill.split("\\|")[0]) == skillID) {
                        oldSkill = skill.split("\\|")[1];
                        newSkill = SKillView.InputSkillInformation();
                        Skill skillUpdated = new Skill();
                        skillUpdated.setSkillID(skillID);
                        skillUpdated.setSkillName(newSkill);
                        listSkills.set(skillID - 1, skillUpdated.saveFormat());
                        for (int i = 0; i < listCandidateSkills.size(); i++) {
                            listCandidateSkills.set(i, listCandidateSkills.get(i).replaceAll(oldSkill, newSkill));
                        }
                        break;
                    }
                }
                FileHandler.writeFile("skill.txt", listSkills);
                FileHandler.writeFile("skill candidate.txt", listCandidateSkills);
                System.out.println("Update successfully!");
            }
            break;
            case 3: {
                ArrayList<String> listSkills = FileHandler.getAllDataInFile("skill.txt");
                ArrayList<String> listCandidateSkills = FileHandler.getAllDataInFile("skill candidate.txt");
                ArrayList<String> listCandidateSkillsUpdated = new ArrayList<>();
                int skillID = SKillView.GetSkillIdToDelete(listSkills);
                String skillNameRemove = null;
                for (String skill : listSkills) {
                    if (Integer.parseInt(skill.split("\\|")[0]) == skillID) {
                        skillNameRemove = skill.split("\\|")[1];
                        listSkills.remove(skillID - 1);
                        break;
                    }
                }
                for (int i = skillID - 1; i < listSkills.size(); i++) {
                    String skillUpdated = (i + 1) + listSkills.get(i).substring(listSkills.get(i).indexOf("|"));
                    listSkills.set(i, skillUpdated);
                }
                for (int i = 0; i < listCandidateSkills.size(); i++) {
                    if (!listCandidateSkills.get(i).split("\\|")[1].equalsIgnoreCase(skillNameRemove)) {
                        listCandidateSkillsUpdated.add(listCandidateSkills.get(i));
                    }
                }
                FileHandler.writeFile("skill.txt", listSkills);
                FileHandler.writeFile("skill candidate.txt", listCandidateSkillsUpdated);
                System.out.println("Delete successfully!");
            }
            break;
        }
    }
}
