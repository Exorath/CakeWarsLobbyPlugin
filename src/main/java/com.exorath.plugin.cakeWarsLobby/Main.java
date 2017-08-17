package com.exorath.plugin.cakeWarsLobby;

import com.exorath.plugin.cakeWarsLobby.levels.LevelManager;
import com.exorath.service.gamelevel.api.GameLevelServiceAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by toonsev on 8/17/2017.
 */
public class Main extends JavaPlugin {
    public static final String CAKEWARS_GAME_ID = "cakewars";
    private static Main instance;

    private LevelManager levelManager;

    @Override
    public void onEnable() {
        Main.instance = this;
        this.levelManager = new LevelManager(new GameLevelServiceAPI(getGameLevelServiceAddress()), getLevelItemSlot());
    }

    private Integer getLevelItemSlot() {
        return getConfig().contains("levelItemSlot") ? getConfig().getInt("levelItemSlot") : null;
    }

    private String getGameLevelServiceAddress() {
        String address = System.getenv("GAMELEVEL_SERVICE_ADDRESS");
        if (address == null || address.equals(""))
            Main.terminate("Env GAMELEVEL_SERVICE_ADDRESS has no value.");
        return address;
    }

    public static Main getInstance() {
        return instance;
    }

    public static void terminate(String error) {
        System.out.println("CakeWarsLobby is terminating...");
        if (error != null)
            System.out.println("ERROR: " + error);
        Bukkit.shutdown();
        System.out.println("Termination failed, force exiting system...");
        System.exit(1);
    }
}
