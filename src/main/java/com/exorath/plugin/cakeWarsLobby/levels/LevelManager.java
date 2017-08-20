package com.exorath.plugin.cakeWarsLobby.levels;

import com.exorath.exoHUD.DisplayPackage;
import com.exorath.exoHUD.DisplayProperties;
import com.exorath.exoHUD.HUDPackage;
import com.exorath.exoHUD.plugin.HudAPI;
import com.exorath.lib.gameLevel.GameLevelLib;
import com.exorath.lib.gameLevel.LevelsConfig;
import com.exorath.lib.gameLevel.hud.LevelBarText;
import com.exorath.lib.gameLevel.hud.LevelText;
import com.exorath.plugin.base.manager.ListeningManager;
import com.exorath.plugin.cakeWarsLobby.Main;
import com.exorath.service.gamelevel.api.GameLevelServiceAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;

import static com.exorath.exoHUD.removers.NeverRemover.never;

/**
 * For now no level rewards
 * Created by toonsev on 8/17/2017.
 */
public class LevelManager implements ListeningManager {
    private GameLevelServiceAPI gameLevelServiceAPI;
    private GameLevelLib gameLevelLib;

    public LevelManager(GameLevelServiceAPI gameLevelServiceAPI, Integer slot) {
        this.gameLevelServiceAPI = gameLevelServiceAPI;
        LevelsConfig levelsConfig = new LevelsConfig("CakeWars", Main.CAKEWARS_GAME_ID);
        gameLevelLib = new GameLevelLib(gameLevelServiceAPI, Main.getInstance(), levelsConfig, slot);
        Bukkit.getPluginManager().registerEvents(gameLevelLib, Main.getInstance());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        System.out.println(Main.CAKEWARS_GAME_ID);
        System.out.println(event.getPlayer().getUniqueId().toString());
        HUDPackage hudPackage = HUDPackage.create(Arrays.asList(
                new LevelText(Main.CAKEWARS_GAME_ID, gameLevelServiceAPI, event.getPlayer()),
                new LevelBarText(Main.CAKEWARS_GAME_ID, gameLevelServiceAPI, event.getPlayer())));
        DisplayPackage displayPackage = new DisplayPackage(hudPackage, DisplayProperties.create(2.15, never()));
        HudAPI.getInstance().getHudPlayer(event.getPlayer()).getScoreboardLocation().addDisplayPackage(displayPackage);
    }

    public GameLevelLib getGameLevelLib() {
        return gameLevelLib;
    }
}
