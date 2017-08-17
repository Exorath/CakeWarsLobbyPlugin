package com.exorath.plugin.cakeWarsLobby.levels;

import com.exorath.lib.gameLevel.GameLevelLib;
import com.exorath.lib.gameLevel.LevelsConfig;
import com.exorath.plugin.cakeWarsLobby.Main;
import com.exorath.service.gamelevel.api.GameLevelServiceAPI;
import org.bukkit.Bukkit;

/**
 * For now no level rewards
 * Created by toonsev on 8/17/2017.
 */
public class LevelManager {
    private GameLevelLib gameLevelLib;
    public LevelManager(GameLevelServiceAPI gameLevelServiceAPI, Integer slot) {
        LevelsConfig levelsConfig = new LevelsConfig("CakeWars", Main.CAKEWARS_GAME_ID);
         gameLevelLib = new GameLevelLib(gameLevelServiceAPI, Main.getInstance(), levelsConfig, slot);
        Bukkit.getPluginManager().registerEvents(gameLevelLib, Main.getInstance());
    }

    public GameLevelLib getGameLevelLib() {
        return gameLevelLib;
    }
}
