package pract2;

import java.util.*;

public class Poker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос количества игроков
        System.out.print("Введите количество игроков: ");
        int n = scanner.nextInt();

        // Проверка возможности раздачи
        if (n * 5 > 52) {
            System.out.println("Слишком много игроков! Максимум можно раздать " + (52 / 5) + " игрокам.");
            return;
        }

        // Создание и перемешивание колоды
        String[] deck = createShuffledDeck();

        // Раздача карт
        int cardIndex = 0;
        for (int player = 1; player <= n; player++) {
            System.out.println("Игрок " + player + ":");
            for (int card = 0; card < 5; card++) {
                System.out.println(deck[cardIndex++]);
            }
            System.out.println();
        }
    }

    // Создание перемешанной колоды карт без мастей
    private static String[] createShuffledDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] deck = new String[52];

        // Формирование колоды (каждая карта представлена 4 раза, как в реальной колоде)
        int index = 0;
        for (String rank : ranks) {
            for (int i = 0; i < 4; i++) {
                deck[index++] = rank;
            }
        }

        // Перемешивание колоды
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        return deck;
    }
}