package trying_web;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Entity {
    private String name;
    private int hp;
    private int dmg;
    private int gold;
    private int level;

    public Entity(String name, int hp, int dmg, int gold, int level) {
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.gold = gold;
        this.level = level;
    }
}
