package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {

    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        for (Player player1 : this.getPlayers()) {
            if (player1.getUsername().equalsIgnoreCase(player.getUsername())) {
                throw new IllegalArgumentException(String.format("Player %s already exists!", player.getUsername()));
            }
        }
        this.players.add(player);

    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        } else {
            this.players.remove(player);
            return true;
        }

    }

    @Override
    public Player find(String name) {
        Player player1 = null;
        for (Player player : this.players) {
            if (player.getUsername().equalsIgnoreCase(name)) {
                player1 = player;
                break;
            }
        }
        return player1;
    }
}
