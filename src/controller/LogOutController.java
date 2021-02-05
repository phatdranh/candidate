/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.DataInput;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class LogOutController {

    private static final InterfaceView view = new InterfaceView();

    public static boolean LogOut() {        
        return !DataInput.checkInputYN("Do you want to log out? (Y/N): ");
    }
}
