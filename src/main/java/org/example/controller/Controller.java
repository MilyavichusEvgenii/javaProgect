package org.example.controller;
import org.example.model.Store;
import org.example.model.Toy;
import org.example.model.User;

import java.util.ArrayList;

public class Controller implements ServiceController{

    @Override
    public void start() {
        Store store = new Store();
        User user = new User(1000, new ArrayList<Toy>());
        store.fillerOfStore(5,5,5,10,7,5);
        store.game(user);



    }
}
