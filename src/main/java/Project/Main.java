package Project;

import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random ran = new Random();
    Pokemon player = null;
    int choose = -1;

    try {
      System.out.print("��J�ʺ�:");
      String s = sc.next().toString();
      player = new Pokemon(s, 10, 30);
      System.out.println("�����T");
      player.getMyRole();
    } catch (Exception e) {
      System.out.println(e.toString());
      sc.close();
    }

    try {
      while (true) {
        printChoice();
        choose = -1;
        choose = sc.nextInt();
        if (choose == 0)
          break;
        else if (choose == 1) {
          Pokemon enemy = new Pokemon("enemy", player.strength() * (ran.nextInt(100) + 50) / 100,
              player.health() * (ran.nextInt(100) + 50) / 100);
          if (player.battle(enemy) == player) {
            System.out.println("��o�F36�I�g��");
            player.gainExp(36);
          } else {
            System.out.println("��o�F9�I�g��");
            player.gainExp(9);
          }
        } else if (choose == 2) {
          System.out.println("��o�F18�I�g��");
          player.gainExp(18);
        } else {
          throw new Exception();
        }
      }
    } catch (Exception e) {
      System.out.println("�п�J���T���ﶵ");
    }
  }

  public static void printChoice() {
    System.out.println("0.���}");
    System.out.println("1.�԰�");
    System.out.println("2.�צ�");
  }
}
