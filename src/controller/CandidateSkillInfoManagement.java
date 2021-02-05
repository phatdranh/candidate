/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.FileHandler;
import java.util.ArrayList;
import view.InterfaceView;
import view.CandidateSkillView;

/**
 *
 * @author Dang Phat
 */
public class CandidateSkillInfoManagement {

    private static final InterfaceView view = new InterfaceView();

    public static void CandidateSkillInformationController() {        
        int candidateSkillInfoChoice = view.CandidateSkillInformationManagement();
        switch (candidateSkillInfoChoice) {
            case 1: {
                ArrayList<String> listCandidateSkills = FileHandler.getAllDataInFile("skill candidate.txt");
                ArrayList<String> listCandidates = FileHandler.getAllDataInFile("candidate.txt");
                ArrayList<String> listSkills = FileHandler.getAllDataInFile("skill.txt");
                int candidateID = CandidateSkillView.GetCandidateId(listCandidates);
                boolean isContinue = true;
                while (isContinue) {                      
                    String skillName = CandidateSkillView.getSkillName(listSkills);
                    for (int i = 0; i < listSkills.size(); i++) {
                        if(skillName.equalsIgnoreCase(listSkills.get(i).split("\\|")[1])){
                            int yearOfExp = CandidateSkillView.getExperience(1000);
                            listCandidateSkills.add(candidateID + "|" + skillName + "|" + yearOfExp);
                            isContinue = false;
                        }
                    }
                    if (isContinue) {
                        System.out.println("Do not have this skill! Please enter again!");
                    }
                }
                FileHandler.writeFile("skill candidate.txt", listCandidateSkills);
            }
            break;
            case 2: {
                ArrayList<String> listCandidateSkills = FileHandler.getAllDataInFile("skill candidate.txt");
                ArrayList<String> listCandidates = FileHandler.getAllDataInFile("candidate.txt");
                ArrayList<String> listSkills = FileHandler.getAllDataInFile("skill.txt");
                int candidateID = CandidateSkillView.GetCandidateId(listCandidates);
                boolean isContinue = true;
                while (isContinue) {                      
                    String skillName = CandidateSkillView.getSkillName(listSkills);
                    for (int i = 0; i < listCandidateSkills.size(); i++) {
                        if(candidateID == Integer.parseInt(listCandidateSkills.get(i).split("\\|")[0]) 
                                && skillName.equalsIgnoreCase(listCandidateSkills.get(i).split("\\|")[1])){
                            int yearOfExp = CandidateSkillView.getExperience(1000);
                            listCandidateSkills.set(i, candidateID + "|" + skillName + "|" + yearOfExp);
                            isContinue = false;
                        }
                    }
                    if (isContinue) {
                        System.out.println("Candidate does not have this skill! Please enter again!");
                    }
                }              
                FileHandler.writeFile("skill candidate.txt", listCandidateSkills);
            }
            break;
            case 3: {
                ArrayList<String> listCandidateSkills = FileHandler.getAllDataInFile("skill candidate.txt");
                ArrayList<String> listCandidates = FileHandler.getAllDataInFile("candidate.txt");
                ArrayList<String> listSkills = FileHandler.getAllDataInFile("skill.txt");
                int candidateID = CandidateSkillView.GetCandidateId(listCandidates);
                boolean isContinue = true;
                while (isContinue) {                      
                    String skillName = CandidateSkillView.getSkillName(listSkills);
                    for (int i = 0; i < listCandidateSkills.size(); i++) {
                        if(candidateID == Integer.parseInt(listCandidateSkills.get(i).split("\\|")[0]) 
                                && skillName.equalsIgnoreCase(listCandidateSkills.get(i).split("\\|")[1])){
                            listCandidateSkills.remove(i);
                            isContinue = false;
                        }
                    }
                    if (isContinue) {
                        System.out.println("Candidate does not have this skill! Please enter again!");
                    }
                }              
                FileHandler.writeFile("skill candidate.txt", listCandidateSkills);
                System.out.println("Delete successfully!");                
            }
            break;
        }

    }
}