package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.username = username;
        setHealth(health);
        this.cardRepository = cardRepository;
        this.isDead =this.isDead();
    }


    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero. ");
        }

        this.health = healthPoints;

    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        } else {
            int newHealth = this.getHealth() - damagePoints;
            if (newHealth <= 0) {
                newHealth = 0;
                this.isDead = true;
            }
            setHealth(newHealth);
        }

    }

    private void setUsername(String username) {
        if (username != null && username.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        } else {
            this.username = username;
        }
    }
}
