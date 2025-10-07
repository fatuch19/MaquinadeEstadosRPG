public class Healer extends Enemy{
    private int mana;

    public Healer(String name)
    {
        super(name, 70, 40);
        this.mana = 80;
        changeState(new AreaHeal());
    }

    public int getMana()
    {
        return mana;
    }
    public void addMana(int amount)
    {
        mana += amount;
        if(mana > 80)
        {
            mana = 80;
        }
    }
    public void loseMana(int amount)
    {
        mana -= amount;
        if(mana < 0)
        {
            mana = 0;
        }
    }
}
