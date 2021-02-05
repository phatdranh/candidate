/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.DataInput;
import common.FileHandler;
import java.util.ArrayList;

/**
 *
 * @author Dang Phat
 */
public class SKillView {

    public static String InputSkillInformation() {
        return DataInput.checkInputString("Enter skill name: ");        
    }
    
    public static int GetSkillIdToUpdate(ArrayList<String> listSkills){
        return DataInput.checkInputIntLimit("Enter skill ID to update: ", 1, listSkills.size());
    }
    
    public static int GetSkillIdToDelete(ArrayList<String> listSkills){
        return DataInput.checkInputIntLimit("Enter skill ID to delete: ", 1, listSkills.size()); 
    }
}
