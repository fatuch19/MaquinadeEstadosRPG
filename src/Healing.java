public class Healing extends AbstractState{
    public Healing() {
        super("curando");
    }

    @Override
    public void execute(Enemy enemy) {
        if(!(enemy instanceof Healer healer))
        {
            return;
        }

        if(healer.getMana() < 10)
        {
            System.out.println(healer.getName() + " está sem mana para curar.");
            if (healer.getAlly().getHealth() < (healer.getAlly().getMaxHealth() / 4))
            {
                healer.changeState(new Sacrifice());
            }
            else
            {
                healer.changeState(new Resting());
            }
        }

        Enemy ally = healer.getAlly();

        Enemy target = ally.getHealth() < healer.getHealth() ? ally : healer;
        healer.loseMana(10);
        target.addHealth(20);
        System.out.println(healer.getName() + " curou " + target.getName());

        printStats(healer);
        if (healer.getAlly().getHealth() < (healer.getAlly().getMaxHealth() / 4))
        {
            healer.changeState(new Sacrifice());
        }
        else
        {
        healer.changeState(new AreaHeal());
        }
    }
}
