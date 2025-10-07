import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bruiser bruiser = new Bruiser("Bruna");
        Healer healer = new Healer("Heitor");

        bruiser.setAlly(healer);
        healer.setAlly(bruiser);

        Random rand = new Random();

        for(int i = 1; i < 11; i++)
        {
            System.out.println("=====================INICIO DO CICLO " + i + " =======================");
            Enemy target = rand.nextBoolean() ? bruiser : healer;
            if(target.getHealth() <= 0)
            {
                target = target.getAlly();
            }
            int randomDamage = rand.nextInt(15)+15;
            target.loseHealth(randomDamage);
            System.out.println("Jogador causou " + randomDamage + " de dano em " + target.getName() + "\n");

            healer.update();
            bruiser.update();


            if(bruiser.getHealth() <= 0 && healer.getHealth() <= 0)
            {
                System.out.println("Ambos inimigos morreram, vitória do jogador, interrompendo repetição");
                break;
            }

            Thread.sleep(3000);

        }
        System.out.println("Fim da repetição. Jogador Perdeu!");
    }
}
