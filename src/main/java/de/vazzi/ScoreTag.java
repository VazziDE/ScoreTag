package de.vazzi;

import cn.nukkit.plugin.PluginBase;

public class ScoreTag extends PluginBase {

    public static ScoreTag instance;
    public static String PreTag;

    public static ScoreTag getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        saveConfig();
        PreTag = getConfig().getString("display-tag", "&c%health% &7| &a%food% &7| &e%ping%")
                .replaceAll("&", "§");
        getServer().getScheduler().scheduleRepeatingTask(new UpdateTask(), 10);
    }




}
