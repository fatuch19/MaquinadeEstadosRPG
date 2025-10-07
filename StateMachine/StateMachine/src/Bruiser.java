public class Bruiser extends Enemy{
    private boolean fury = false;
    public Bruiser(String name)
    {
        super(name, 100, 50);
        changeState(new Attacking());
    }
    public boolean getFury() {
        return fury;
    }
    public void setFury()
    {
        if(!getFury())
        {
            fury = true;

            System.out.println(getName() + " entrou em Fúria!!!!!");
        }
    }
}
