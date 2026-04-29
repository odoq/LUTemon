package com.example.lutemon;
//
public class BattleField {

    public String fight(Lutemon attacker, Lutemon defender) {

        StringBuilder log = new StringBuilder();

        Lutemon A = attacker;
        Lutemon B = defender;

        log.append("Taistelu alkaa!\n\n");

        while (true) {


            log.append("A: ").append(A.getName())
                    .append(" HP: ").append(A.getHealth()).append("/").append(A.getMaxHealth()).append("\n");
            log.append("B: ").append(B.getName())
                    .append(" HP: ").append(B.getHealth()).append("/").append(B.getMaxHealth()).append("\n\n");


            log.append(A.getName()).append(" hyökkää ").append(B.getName()).append(" kimppuun!\n");

            int damage = A.getAttack() - B.getDefence();
            if (damage < 0) damage = 0;

            B.takeDamage(damage);

            log.append("Vahinko: ").append(damage).append("\n");
            log.append(B.getName()).append(" HP nyt: ").append(B.getHealth()).append("\n");


            if (B.getHealth() <= 0) {
                log.append(B.getName()).append(" kuoli!\n");
                log.append(A.getName()).append(" voitti taistelun!");

                Storage.getInstance().setLocation(B, "dead");

                return log.toString();
            }


            log.append(B.getName()).append(" onnistui välttämään kuoleman!\n");

            Lutemon temp = A;
            A = B;
            B = temp;
        }
    }
}

