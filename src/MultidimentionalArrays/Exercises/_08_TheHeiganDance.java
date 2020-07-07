// TODO: 29.06.2020 г. Judge not ready 90/100

package MultidimentionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _08_TheHeiganDance {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double heroDamage = Double.parseDouble(s.nextLine());
        String[][] chamber = generateChamber();
        int heroHP = 18500;
        double bossHP = 3000000;
        int[] heroLocation = {7, 7};
        boolean markDamagedCells = true;
        String lastSpell = "";

        while (true) {

            bossHP -= heroDamage;

            if (lastSpell.equals("Cloud")) {
                heroHP -= 3500;
            }

            if (bossHP <= 0 || heroHP <= 0) {
                break;
            }
            String[] attackTokens = s.nextLine().split("\\s+");
            String spell = attackTokens[0];

            prepareChamber(chamber, attackTokens, markDamagedCells);

            String heroStatus = checkHeroStatus(chamber, heroLocation, attackTokens);

            switch (heroStatus) {

                case "Hero is pinned":
                    heroHP = takeDamage(heroHP, spell);
                    lastSpell = spell;
                    break;

                case "Hero is in danger":
                    int[] newLocation = moveHero(chamber, heroLocation);
                    boolean heroDodgesTheSpell = !Arrays.equals(heroLocation, newLocation);

                    if (heroDodgesTheSpell) {
                        heroLocation = newLocation;
                    } else {
                        heroHP = takeDamage(heroHP, spell);
                        lastSpell = spell;

                    }
                    break;
            }

            if (heroHP <= 0) {
                break;
            }

            markDamagedCells = false;
            prepareChamber(chamber, attackTokens, markDamagedCells);
            markDamagedCells = true;

        }

        boolean heroWins = bossHP <= 0;
        boolean bossWins = heroHP <= 0;

        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";

        String bossState = heroWins ? "Heigan: Defeated!" : String.format("Heigan: %.2f", bossHP);
        String heroState = bossWins ? String.format("Player: Killed by %s", lastSpell) : String.format("Player: %d", heroHP);
        String heroLastPosition = String.format("Final position: %d, %d", heroLocation[0], heroLocation[1]);

        System.out.println(bossState);
        System.out.println(heroState);
        System.out.println(heroLastPosition);

    }

    private static String[][] generateChamber() {
        String[][] chamber = new String[15][15];
        for (String[] row : chamber) {
            Arrays.fill(row, "o");
        }
        return chamber;
    }

    private static void prepareChamber(String[][] chamber, String[] attackTokens, boolean markDamagedCells) {
        int attackRow = Integer.parseInt(attackTokens[1]);
        int attackColumn = Integer.parseInt(attackTokens[2]);
        for (int row = attackRow - 1; row <= attackRow + 1; row++) {
            boolean rowInsideChamber = row >= 0 && row <= chamber.length - 1;
            if (rowInsideChamber) {
                for (int column = attackColumn - 1; column <= attackColumn + 1; column++) {
                    boolean columnInsideChamber = column >= 0 && column <= chamber[0].length - 1;
                    if (columnInsideChamber) {
                        if (markDamagedCells) {
                            chamber[row][column] = "x";
                        } else {
                            chamber[row][column] = "o";
                        }
                    }
                }
            }
        }
    }

    private static String checkHeroStatus(String[][] chamber, int[] heroLocation, String[] attackTokens) {
        int heroRow = heroLocation[0];
        int heroColumn = heroLocation[1];
        int attackRow = Integer.parseInt(attackTokens[1]);
        int attackColumn = Integer.parseInt(attackTokens[2]);
        boolean heroIsPinned = heroRow == attackRow && heroColumn == attackColumn;
        boolean heroIsInDanger = chamber[heroRow][heroColumn].equals("x");

        if (heroIsPinned) {
            return "Hero is pinned";
        } else if (heroIsInDanger) {
            return "Hero is in danger";
        } else {
            return "Spell missed";
        }
    }

    private static int[] moveHero(String[][] chamber, int[] heroLocation) {
        int[] newPosition = heroLocation.clone();
        int heroRow = heroLocation[0];
        int heroColumn = heroLocation[1];

        boolean canMoveUp = heroRow - 1 >= 0 && chamber[heroRow - 1][heroColumn].equals("o");
        boolean canMoveRight = heroColumn + 1 <= chamber[0].length - 1 && chamber[heroRow][heroColumn + 1].equals("o");
        boolean canMoveDown = heroRow + 1 <= chamber.length - 1 && chamber[heroRow + 1][heroColumn].equals("o");
        boolean canMoveLeft = heroColumn - 1 >= 0 && chamber[heroRow][heroColumn - 1].equals("o");

        if (canMoveUp) {
            newPosition[0] = heroRow - 1;
            newPosition[1] = heroColumn;
        } else if (canMoveRight) {
            newPosition[0] = heroRow;
            newPosition[1] = heroColumn + 1;
        } else if (canMoveDown) {
            newPosition[0] = heroRow + 1;
            newPosition[1] = heroColumn;
        } else if (canMoveLeft) {
            newPosition[0] = heroRow;
            newPosition[1] = heroColumn - 1;
        }
        return newPosition;
    }

    private static int takeDamage(int heroLive, String spell) {
        int currentHealthPoints = heroLive;
        switch (spell) {
            case "Cloud":
                currentHealthPoints -= 3500;
                break;
            case "Eruption":
                currentHealthPoints -= 6000;
        }
        return currentHealthPoints;
    }

}
