package com.jorgeluis.zombierpg.utils.listeners;

public abstract class ChangeListener<A> {

    public abstract void onDataFetched(A data);

    public abstract void onCancelled(String message);
}