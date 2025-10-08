public class AreaHeal extends AbstractState{
    public AreaHeal() {
        super("curando em area");




    }


    @Override
    public void execute(Enemy enemy) {
        if(!(enemy instanceof Healer healer))
        {
            return;
        }

        if(healer.getMana() < 5)
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


        healer.loseMana(5);
        ally.addHealth(5);
        healer.addHealth(5);
        System.out.println(healer.getName() + " curou " + ally.getName());

        printStats(healer);
        if (healer.getAlly().getHealth() < (healer.getAlly().getMaxHealth() / 4))
        {
            healer.changeState(new Sacrifice());
        }
        else if(healer.getAlly().getHealth() <= (healer.getAlly().getMaxHealth() / 2) || healer.getHealth() < (healer.getMaxHealth() / 2))
        {
            healer.changeState(new Healing());
        }

    }
}
