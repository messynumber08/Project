package Project;

import java.util.Random;

public class Pokemon {
  private String name = null;
  private int health = 0;
  private int strength = 0;
  private int level = 1;
  private int exp = 0;

  public Pokemon(String name, int strength, int health) throws Exception {

    if (health < 1 || health > 1023 || strength < 1 || strength > 1023) {
      throw new Exception();
    }

    this.name = name;
    this.health = health;
    this.strength = strength;
  }

  public Pokemon battle(Pokemon enemy) {
    Random ran = new Random();
    int health1 = this.health;
    int health2 = enemy.health;
    System.out.println(this.name + "��" + enemy.name + "�o�_�F�D��");
    do {

      int attack1 = ran.nextInt(this.strength) + (int) (this.strength * 0.2);
      health2 -= attack1;
      System.out.println(this.name + "����," + enemy.name + "����" + attack1 + "�I�ˮ`");
      if (health2 <= 0)
        break;

      int attack2 = ran.nextInt(enemy.strength) + (int) (enemy.strength * 0.4);
      health1 -= attack2;
      System.out.println(enemy.name + "����," + this.name + "����" + attack2 + "�I�ˮ`");
      if (health1 <= 0)
        break;
    } while (true);

    if (health1 < 1) {
      System.out.println(this.name + "�ԱѤF," + enemy.name + "�٦�" + health2 + "�I��q");
      return enemy;
    } else {
      System.out.println(this.name + "�ӧQ�F," + this.name + "�٦�" + health1 + "�I��q");
      return this;
    }
  }

  public void getMyRole() {
    System.out.println("�W��:" + this.name);
    System.out.println("����" + this.strength);
    System.out.println("��q" + this.health);
    System.out.println("����" + this.level);
    System.out.println("�g���" + this.exp);
  }

  public int gainExp(int exp) {
    this.exp += exp;
    if (this.exp >= (Math.pow(this.level, 3) + 60) * 3 - 150) {
      this.levelUp();
    }
    return this.exp;
  }

  public int levelUp() {
    this.exp -= (Math.pow(this.level, 3) + 60) * 3 - 150;
    this.level++;
    this.strength += 5;
    this.health += 15;
    System.out.println("level up");
    this.getMyRole();
    return this.level;
  }

  public int strength() {
    return this.strength;
  }

  public int health() {
    return this.health;
  }

}
