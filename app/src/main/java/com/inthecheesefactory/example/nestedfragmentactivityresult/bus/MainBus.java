package com.inthecheesefactory.example.nestedfragmentactivityresult.bus;

import com.squareup.otto.Bus;

/**
 * Created by nuuneoi on 3/12/2015.
 */
public class MainBus extends Bus {

    private static MainBus instance;

    public static MainBus getInstance() {
        if (instance == null)
            instance = new MainBus();
        return instance;
    }

}
