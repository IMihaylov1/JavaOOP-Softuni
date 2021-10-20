package CounterStriker.repositories;

import CounterStriker.models.players.Player;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {
    private List<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.players;
    }

    @Override
    public void add(Player model) {
        if(model == null){
            throw  new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        this.players.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return this.players.remove(model);
    }

    @Override
    public Player findByName(String name) {
        for (Player player : players) {
            if(player.getUsername().equals(name)){
                return player;
            }
        }
        return null;
    }
}
