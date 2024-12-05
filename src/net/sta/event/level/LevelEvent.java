package net.sta.event.level;

import net.sta.managers.LevelManager;

@SuppressWarnings("unused")
public class LevelEvent extends LevelManager {
    Boolean bool;
    public LevelEvent(Boolean voice){
        this.bool = voice;
    }
   public void startLevel(){
        LevelManager manager = new LevelManager();
        manager.XpTimer();
        if (Boolean.TRUE.equals(bool))
            manager.VoiceXpTimer();
   }
}
