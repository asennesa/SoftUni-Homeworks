package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards);
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }
        for (Card player1 : this.getCards()) {
            if (player1.getName().equalsIgnoreCase(card.getName())) {
                throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
            }
        }
        this.cards.add(card);

    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        } else {
            this.cards.remove(card);
            return true;
        }
    }

    @Override
    public Card find(String name) {
        Card player1 = null;
        for (Card player : this.cards) {
            if (player.getName().equalsIgnoreCase(name)) {
                player1 = player;
                break;
            }
        }
        return player1;
    }
}
