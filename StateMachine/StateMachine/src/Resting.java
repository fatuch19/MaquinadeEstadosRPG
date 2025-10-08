public class Resting extends AbstractState{

    public Resting() {
        super("descansando");
    }

    @Override
    public void execute(Enemy enemy) {
        if(enemy.getHealth() <= 0)
        {
            return;
        }
        if(enemy instanceof Bruiser)
        {
            enemy.addEnergy(10);

            System.out.println(enemy.getName() + " descansou recuperando " + 10 + " de energia");
            if (enemy.getEnergy() >= enemy.getMaxEnergy())
            {
                enemy.changeState(new Attacking());
            }
        }
        if(enemy instanceof Healer)
        {
            Healer healer = (Healer) enemy;
            healer.addMana(5);
            System.out.println(enemy.getName() + " descansou recuperando " + 5 + " de energia");
            if (healer.getAlly().getHealth() < (healer.getAlly().getMaxHealth() / 4))
            {
                healer.changeState(new Sacrifice());
            }
            else if(healer.getAlly().getHealth() <= (healer.getAlly().getMaxHealth() / 2) || healer.getHealth() < (healer.getMaxHealth() / 2))
            {
                healer.changeState(new Healing());
            }
            else {
                healer.changeState(new AreaHeal());
            }

        }


        printStats(enemy);


    }
}
