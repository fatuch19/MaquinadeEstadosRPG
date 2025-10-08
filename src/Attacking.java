public class Attacking extends AbstractState {
    public Attacking() {
        super("atacando");
    }

    @Override
    public void execute(Enemy enemy) {
        if(!(enemy instanceof Bruiser bruiser))
        {
            return;
        }

        Enemy ally = bruiser.getAlly();
        if(ally.getHealth() <= 0)
        {
            bruiser.setFury();
        }

        int baseDamage = 10;
        int damage = bruiser.getFury() ? baseDamage * 2 : baseDamage;
        bruiser.loseEnergy(10);

        System.out.println(enemy.getName() + " atacou causando " + damage + " de dano");
        if(bruiser.getEnergy() <= 0)
        {
            bruiser.changeState(new Resting());
        }


        printStats(enemy);
    }

}
