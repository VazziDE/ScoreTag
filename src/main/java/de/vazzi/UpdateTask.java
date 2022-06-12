package de.vazzi;

import cn.nukkit.Player;
import cn.nukkit.scheduler.Task;

public class UpdateTask extends Task {

    @Override
    public void onRun(int i) {
        for (Player player:
        ScoreTag.getInstance().getServer().getOnlinePlayers().values()
             ) {
            player.setScoreTag(
                    ScoreTag.PreTag.
                            replaceAll(
                            "%health%", Math.round(player.getHealth() * 10) / 10.0d + "/" + player.getMaxHealth() +"❤"
                            )
                            .replaceAll(
                                    "%food%", Math.round(player.getFoodData().getLevel()) + "/" + player.getFoodData().getMaxLevel()
                            )
                            .replaceAll(
                                    "%ping%", Math.round(player.getPing()) + "ms"
                            )
                    );
        }
    }

}
