package net.sta;

import java.util.logging.Logger;

public interface Debugging {
    default Logger debug(){
        return Logger.getLogger(getClass().getName());
    }
}
