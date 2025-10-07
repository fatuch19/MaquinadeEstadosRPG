public interface State {

    void execute(Enemy enemy);
    void enter(Enemy enemy);
    void leave(Enemy enemy);
}