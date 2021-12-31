package com.example.demo1;

import javafx.scene.Group;

public class PauseMenu extends Group {
    public static Group pauseMenu;
    PauseMenu(Group pauseMenu){
        this.pauseMenu = pauseMenu;
    }

    public static Group getPauseMenu() {
        return pauseMenu;
    }
}
