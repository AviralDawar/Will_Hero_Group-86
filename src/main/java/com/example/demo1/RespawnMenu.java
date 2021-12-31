package com.example.demo1;

import javafx.scene.Group;

public class RespawnMenu extends Group {
    private Group respawnMenu;
    RespawnMenu(Group respawnMenu){
        this.respawnMenu = respawnMenu;
    }
    public Group getRespawnMenu() {
        return respawnMenu;
    }

}

