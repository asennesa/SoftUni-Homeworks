package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;




public class ManagerControllerImpl extends ConstantMessages implements ManagerController {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;


    public ManagerControllerImpl() {
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        CardRepository cardRepository = new CardRepositoryImpl();
        if (Beginner.class.getSimpleName().equalsIgnoreCase(type)) {
            Player player = new Beginner(cardRepository, username);
            this.playerRepository.add(player);
        } else if (Advanced.class.getSimpleName().equalsIgnoreCase(type)) {
            Player player = new Advanced(cardRepository, username);
            this.playerRepository.add(player);
        }
        return String.format("Successfully added player of type %s with username: %s", type, username);
    }

    @Override
    public String addCard(String type, String name) {
        if (type.equalsIgnoreCase("Magic")) {
            Card card = new MagicCard(name);
            this.cardRepository.add(card);
        } else if (type.equalsIgnoreCase("Trap")){
            Card card = new TrapCard(name);
            this.cardRepository.add(card);
        }
            return String.format(SUCCESSFULLY_ADDED_CARD,type,name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Card card = this.cardRepository.find(cardName);
        Player player = this.playerRepository.find(username);
        player.getCardRepository().add(card);
        return String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS,cardName,username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = this.playerRepository.find(attackUser);
        Player enemy = this.playerRepository.find(enemyUser);

        this.battlefield.fight(attacker,enemy);
        return String.format(FIGHT_INFO,attacker.getHealth(),enemy.getHealth());
    }


    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Player player : this.playerRepository.getPlayers()) {
            sb.append(String.format(PLAYER_REPORT_INFO,player.getUsername(),player.getHealth(),player.getCardRepository().getCards().size()));
            sb.append(System.lineSeparator());
            for (Card card : player.getCardRepository().getCards()) {
                sb.append(String.format(CARD_REPORT_INFO,card.getName(), card.getDamagePoints()));
                sb.append(System.lineSeparator());
            }
            sb.append(DEFAULT_REPORT_SEPARATOR);
            sb.append(System.lineSeparator());

        }
        return sb.toString().trim();
    }
}
