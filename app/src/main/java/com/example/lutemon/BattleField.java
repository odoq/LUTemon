package com.example.lutemon;
//
public class BattleField {

    public String fight(Lutemon attacker, Lutemon defender) {

        StringBuilder log = new StringBuilder();

        Lutemon A = attacker;
        Lutemon B = defender;

        if (attacker.id == defender.id) {
            log.append("Lutemon ei voi taistella itseään vastaan!");
        } else {

            log.append("Taistelu alkaa!\n\n");

            while (true) {

                log.append("A: ").append(A.getName())
                        .append(" HP: ").append(A.getHealth()).append("/").append(A.getMaxHealth()).append("\n");
                log.append("B: ").append(B.getName())
                        .append(" HP: ").append(B.getHealth()).append("/").append(B.getMaxHealth()).append("\n\n");


                log.append(A.getName()).append(" hyökkää ").append(B.getName()).append(" kimppuun!\n");

                int damageA = A.getAttack() - B.getDefence();
                if (damageA < 0) damageA = 0;

                B.takeDamage(damageA);

                log.append("Vahinko: ").append(damageA).append("\n");
                log.append(B.getName()).append(" HP nyt: ").append(B.getHealth()).append("\n");


                if (B.getHealth() <= 0) {
                    log.append(B.getName()).append(" kuoli!\n");
                    log.append(A.getName()).append(" voitti taistelun!\n");
                    log.append(A.getName()).append(" Ansaitsi kokemuspisteen!");

                    Storage.getInstance().removeLutemon(B.id);
                    A.train();

                    break;

                } else {
                    log.append(B.getName()).append(" onnistui välttämään kuoleman!\n\n");
                }

                log.append("\n");

                log.append(B.getName()).append(" hyökkää ").append(A.getName()).append(" kimppuun!\n");

                int damageB = B.getAttack() - A.getDefence();
                if (damageB <= 0) damageB = 0;

                A.takeDamage(damageB);

                log.append("Vahinko: ").append(damageB).append("\n");
                log.append(A.getName()).append(" HP nyt: ").append(A.getHealth()).append("\n");


                if (A.getHealth() <= 0) {
                    log.append(A.getName()).append(" kuoli!\n");
                    log.append(B.getName()).append(" voitti taistelun!\n");
                    log.append(B.getName()).append(" Ansaitsi kokemuspisteen!");

                    Storage.getInstance().removeLutemon(A.id);
                    B.train();

                    break;

                } else {
                    log.append(A.getName()).append(" onnistui välttämään kuoleman!\n\n");
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                /*
                Lutemon temp = A;
                A = B;
                B = temp;

                 */
            }
        }
        return log.toString();
    }
}

