package trying_web;

import java.util.*;

public class GameLogic {
    Random rd = new Random();

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
    private int rollDx(int D){
        return rd.nextInt(D) + 1;
    }

    public HashMap<String, Object> getPLayerAndEnemy(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("pname", player.getName());
        result.put("ename", enemies.get(ei).getName());
        result.put("php", player.getHp());
        result.put("ehp", enemies.get(ei).getHp());
        result.put("pdmg", player.getDmg());
        result.put("edmg", enemies.get(ei).getDmg());
        result.put("plvl", player.getLevel());
        result.put("elvl", enemies.get(ei).getLevel());
        result.put("pgold", player.getGold());
        result.put("egold", enemies.get(ei).getGold());
        return result;
    }

}
