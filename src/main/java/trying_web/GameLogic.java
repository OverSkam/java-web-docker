package trying_web;

import java.util.*;

public class GameLogic {
    Random rd = new Random();
    int roll = rollDx(20);

    private ArrayList<Entity> enemies = new ArrayList<Entity>(
            Arrays.asList(
                    new Entity("Wild Hog", 35, 8, 16, 2),
                    new Entity("Giant Bird", 60, 6, 57, 5),
                    new Entity("Draw Ranger", 12, 35, 86, 8),
                    new Entity("Skeleton King", 60, 24, 168, 15),
                    new Entity("Warlock", 10, 100, 45, 4),
                    new Entity("Stone Golem", 80, 40, 55, 6)
                    )
    );

    static Entity player = new Entity("Skam", 1, 1, 1, 1);
    int ei = rd.nextInt(enemies.size() - 1) + 1;
    Entity currentEnemy = enemies.get(ei);

    private int rollDx(int D){
        return rd.nextInt(D) + 1;
    }

    public HashMap<String, Object> getPLayerAndEnemy(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("pname", player.getName());
        result.put("ename", currentEnemy.getName());
        result.put("php", player.getHp());
        result.put("ehp", currentEnemy.getHp());
        result.put("pdmg", player.getDmg());
        result.put("edmg", currentEnemy.getDmg());
        result.put("plvl", player.getLevel());
        result.put("elvl", currentEnemy.getLevel());
        result.put("pgold", player.getGold());
        result.put("egold", currentEnemy.getGold());
        result.put("roll", roll);
        return result;
    }

    public int[] attackEnemy(){
        roll = rollDx(20);
        boolean success = roll > 8;
        currentEnemy.setHp(success ?
                currentEnemy.getHp() - player.getDmg() : currentEnemy.getHp());
        return new int[]{roll, success ? 1 : 0};
    }

    public int[] healPlayer(){
        roll = rollDx(20);
        boolean success = roll > 12;
        player.setHp(success ?
                player.getHp() + 15 : player.getHp());
        return new int[]{roll, success ? 1 : 0};
    }

}
