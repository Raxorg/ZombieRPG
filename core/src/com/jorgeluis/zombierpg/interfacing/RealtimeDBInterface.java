package com.jorgeluis.zombierpg.interfacing;

import com.jorgeluis.zombierpg.utils.listeners.ChangeListener;

public interface RealtimeDBInterface {

    void fetchVersionInRealtime(ChangeListener<String> listener);
}
