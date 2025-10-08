public class Sacrifice extends AbstractState{
    public Sacrifice() {
        super("Se Sacrificando");
    }

    @Override
    public void execute(Enemy enemy) {
        if(!(enemy instanceof Healer healer))
        {
            return;
        }

        Enemy ally = healer.getAlly();


        healer.loseHealth(-100);
        ally.addHealth(100);
        System.out.println(healer.getName() + " Se sacrificou por " + ally.getName());

        printStats(healer);


    }
}
