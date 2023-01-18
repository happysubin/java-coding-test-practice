package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;

import java.util.List;

public interface Player {
    void printCardListAndTotalScore();
    String getName();
    List<Card> getCardList();
}
