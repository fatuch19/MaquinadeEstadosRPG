public abstract class Enemy {
    private String name;
    private int health;
    private int maxHealth;
    private int energy;
    private int maxEnergy;

    private State currentState;
    private Enemy ally;

    public Enemy(String name, int health, int energy)
    {
        this.name = name;
        this.health = health;
        maxHealth = health;
        this.energy = energy;
        maxEnergy = energy;
    }

    public void setAlly(Enemy enemy)
    {
        ally = enemy;
    }

    public Enemy getAlly()
    {
        return ally;
    }

    public String getName()
    {
        return name;
    }
    public int getHealth()
    {
        return health;
    }
    public int  getMaxHealth()
    {
        return maxHealth;
    }
    public int getEnergy()
    {
        return energy;
    }
    public int getMaxEnergy()
    {
        return maxEnergy;
    }

    public void loseHealth(int amount)
    {
        health -= amount;
        if  (health <= 0)
        {
            health = 0;
        }
        System.out.println(name + " recebeu " + amount + " de dano");
    }
    public void addHealth(int amount)
    {
        health += amount;
        if (health > maxHealth)
        {
            health = maxHealth;
        }
        System.out.println(name + " recebeu " + amount + " de cura");
    }
    public void loseEnergy(int amount)
    {
        energy -= amount;
        if(energy <= 0)
        {
            energy = 0;
        }
    }
    public void addEnergy(int amount)
    {
        energy += amount;
        if (energy > maxEnergy)
        {
            energy = maxEnergy;
        }
    }


    public void changeState(State state)
    {
        if(currentState != null)
        {
            currentState.leave(this);
        }
        currentState = state;
        state.enter(this);
    }
    public void update()
    {
        if(getHealth() > 0)
        {
            currentState.execute(this);
        }
    }

}
