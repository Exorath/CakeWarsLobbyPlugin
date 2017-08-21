package com.exorath.plugin.cakeWarsLobby.currency;

import com.exorath.exoHUD.DisplayProperties;
import com.exorath.exoHUD.plugin.HudAPI;
import com.exorath.plugin.base.manager.ListeningManager;
import com.exorath.plugin.cakeWarsLobby.Main;
import com.exorath.service.currency.api.CurrencyHUDText;
import com.exorath.service.currency.api.CurrencyServiceAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.exorath.exoHUD.removers.NeverRemover.never;

/**
 * Created by toonsev on 8/21/2017.
 */
public class CurrencyManager implements ListeningManager{
    private CurrencyServiceAPI currencyServiceAPI;

    public CurrencyManager(CurrencyServiceAPI currencyServiceAPI) {
        this.currencyServiceAPI = currencyServiceAPI;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        HudAPI.getInstance().getHudPlayer(event.getPlayer()).getScoreboardLocation().addText(
                new CurrencyHUDText(currencyServiceAPI, Main.CURRENCY_NAME, Main.CURRENCY_ID, event.getPlayer()),
                DisplayProperties.create(0, never())
        );
    }

}
