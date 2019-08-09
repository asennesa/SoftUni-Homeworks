package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }
        playerStatsIncreaseBaseOnType(attackPlayer);
        playerStatsIncreaseBaseOnType(enemyPlayer);
        healthBoost(attackPlayer);
        healthBoost(enemyPlayer);

        while (true){
            int attackerDamagePoints = attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
            int enemyDamagePoints = enemyPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
            enemyPlayer.takeDamage(attackerDamagePoints);
            if(enemyPlayer.isDead()){
                break;
            }
            attackPlayer.takeDamage(enemyDamagePoints);
            if(attackPlayer.isDead()){
                break;
            }
        }


    }

    private void healthBoost(Player player) {
        int sum = player.getCardRepository().getCards().stream().mapToInt(Card::getHealthPoints).sum();
        player.setHealth(player.getHealth() + sum);
    }

    private void playerStatsIncreaseBaseOnType(Player player) {
        if (player.getClass().getSimpleName().equalsIgnoreCase(Beginner.class.getSimpleName())) {
            player.setHealth(player.getHealth() + 40);
            player.getCardRepository().getCards().forEach(e -> e.setDamagePoints(e.getDamagePoints() + 30));
        }

    }
}
