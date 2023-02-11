package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

import java.util.List;

public abstract class AbstractPlayer implements Player {

    protected Cards cards;
    protected PlayerInfo playerInfo;
    protected State state;
    protected PlayerObserver observer;

    public AbstractPlayer(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        this.state = State.RUNNING;
        this.cards = new Cards();
        this.observer = new PlayerObserver(this);
    }

    /**
     * 테스트에서 사용할 생성자다.
     */
    public AbstractPlayer(Cards cards, PlayerInfo playerInfo, State state) {
        this.cards = cards;
        this.playerInfo = playerInfo;
        this.state = state;
        this.observer = new PlayerObserver(this);
    }

    @Override
    public String getName() {
        return playerInfo.getName();
    }

    @Override
    public List<Card> getCardList() {
        return cards.getCards();
    }

    @Override
    public void printCardListAndTotalScore() {
        observer.printCardListAndTotalScore();
    }


    @Override
    public int calculateCardsPoint() {
        int sum = 0;
        for (Card card : cards.getCards()) {
            sum = card.getCumulativeScore(sum);
        }
        return sum;
    }

    @Override
    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void printCardList() {
        observer.printCardList();
    }

    @Override
    public void firstDrawTwoCard(Deck deck) {
        for (int i = 0; i < 2; i++) {
            cards.addCard(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        this.state = StateFactory.firstExtractState(calculateCardsPoint());
    }
}
