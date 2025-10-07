public abstract class AbstractState implements State {
    private String state;

    public AbstractState(String state) {
        this.state = state;
    }

    public abstract void execute(Enemy enemy);

    public void printStats(Enemy enemy) {
        System.out.println("Status " + enemy.getName());
        System.out.println("HP: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
        System.out.println("Energia: " + enemy.getEnergy() + "/" + enemy.getMaxEnergy());
        if(enemy instanceof Healer healer)
        {
            System.out.println("Mana: " + healer.getMana());
        }
        if(enemy instanceof Bruiser bruiser)
        {
            if(bruiser.getFury())
            {
            System.out.println(("ESTÁ FURIOSO"));
            }
        }
        System.out.println("\n");
    }

    @Override
    public void enter(Enemy enemy) {
        System.out.println(enemy.getName() + " entra no estado " + state + ".");
    }

    @Override
    public void leave(Enemy enemy) {
        System.out.println(enemy.getName() + " sai do estado " + state + ".");
    }
}