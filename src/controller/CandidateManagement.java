/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.DataInput;
import common.FileHandler;
import java.util.ArrayList;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.Skill;
import view.CandidateView;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class CandidateManagement {

    private static final InterfaceView view = new InterfaceView();
    private static final CandidateView candidateView = new CandidateView();

    public static void CandidateManagementController() {
        int CandidateManagementChoice = view.CandidateManagement();
        switch (CandidateManagementChoice) {
            case 1: {
                ArrayList<Experience> listExperiences = FileHandler.getExperience();
                ArrayList<Fresher> listFreshers = FileHandler.getFresher();
                ArrayList<Intern> listInterns = FileHandler.getIntern();
                candidateView.listExperiences(listExperiences);
                candidateView.listFreshers(listFreshers);
                candidateView.listInterns(listInterns);
            }
            break;
            case 2: {
                ArrayList<String> listCandidates = FileHandler.getAllDataInFile("candidate.txt");
                ArrayList<String> listCandidateSkills = FileHandler.getAllDataInFile("skill candidate.txt");
                Candidate candidate = candidateView.InputCandidateInformation(listCandidates);
                listCandidates.add(candidate.saveFormat());
                for (Skill skill : candidate.getListSkills()) {
                    listCandidateSkills.add(candidate.getId() + "|" + skill.getSkillName() + "|" + skill.getYearOfExp());
                }
                FileHandler.writeFile("candidate.txt", listCandidates);
                FileHandler.writeFile("skill candidate.txt", listCandidateSkills);
                System.out.println("Add successfully!");
            }
            break;
            case 3: {
                ArrayList<String> listCandidates = FileHandler.getAllDataInFile("candidate.txt");
                ArrayList<String> listCandidateSkills = FileHandler.getAllDataInFile("skill candidate.txt");
                ArrayList<String> listCandidateSkillsUpdated = new ArrayList<>();
                int candidateID = DataInput.checkInputIntLimit("Enter candidate ID to update: ", 1, listCandidates.size());
                for (String candidate : listCandidates) {
                    if (Integer.parseInt(candidate.split("\\|")[0]) == candidateID) {
                        Candidate candidateInfo = candidateView.InputCandidateInformation(listCandidates);
                        String candidateUpdated = candidateID + candidateInfo.saveFormat().substring(candidate.indexOf("|"));
                        listCandidates.set(candidateID - 1, candidateUpdated);
                        for (String candidateSkill : listCandidateSkills) {
                            if (Integer.parseInt(candidateSkill.split("\\|")[0]) != candidateID) {
                                listCandidateSkillsUpdated.add(candidateSkill);
                            }
                        }
                        for (Skill skill : candidateInfo.getListSkills()) {
                            listCandidateSkillsUpdated.add(candidateID + "|" + skill.getSkillName() + "|" + skill.getYearOfExp());
                        }
                        break;
                    }
                }
                FileHandler.writeFile("candidate.txt", listCandidates);
                FileHandler.writeFile("skill candidate.txt", listCandidateSkillsUpdated);
                System.out.println("Update successfully!");
            }
            break;
            case 4: {
                ArrayList<String> listCandidates = FileHandler.getAllDataInFile("candidate.txt");
                ArrayList<String> listCandidateSkills = FileHandler.getAllDataInFile("skill candidate.txt");
                ArrayList<String> listCandidateSkillsUpdated = new ArrayList<>();
                int candidateID = DataInput.checkInputIntLimit("Enter candidate ID to delete: ", 1, listCandidates.size());
                for (String candidate : listCandidates) {
                    if (Integer.parseInt(candidate.split("\\|")[0]) == candidateID) {
                        listCandidates.remove(candidateID - 1);
                        break;
                    }
                }
                for (int i = candidateID - 1; i < listCandidates.size(); i++) {
                    String candidateUpdated = (i + 1) + listCandidates.get(i).substring(listCandidates.get(i).indexOf("|"));
                    listCandidates.set(i, candidateUpdated);
                }
                for (String candidateSkill : listCandidateSkills) {
                    if (Integer.parseInt(candidateSkill.split("\\|")[0]) != candidateID) {
                        listCandidateSkillsUpdated.add(candidateSkill);
                    }
                }
                FileHandler.writeFile("candidate.txt", listCandidates);
                FileHandler.writeFile("skill candidate.txt", listCandidateSkillsUpdated);
                System.out.println("Delete successfully!");
            }
            break;
        }
    }
}
