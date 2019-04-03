import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NetherRealms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] allDemons = reader.readLine().split(",\\s*");

        Pattern alphabet = Pattern.compile("[^\\d\\-+*/.]");
        Pattern digits = Pattern.compile("[-+]?\\d*\\.?\\d+");

        List<Demon> demons= new ArrayList<>();

        for (String currentDemon:allDemons) {
            currentDemon = currentDemon.trim();
            Matcher matchAlphabet = alphabet.matcher(currentDemon);
            Matcher matchDigits = digits.matcher(currentDemon);

            int healthSum = 0;
            double damage = 0.0;

            while (matchAlphabet.find()) {
                healthSum += matchAlphabet.group(0).charAt(0);
            }

            while (matchDigits.find()) {
                damage += Double.parseDouble(matchDigits.group());
            }
            for (int i = 0; i < currentDemon.length(); i++) {
                if (currentDemon.charAt(i) == '*') {
                    damage *= 2;
                } else if (currentDemon.charAt(i) == '/') {
                    if (damage != 0) {
                        damage /= 2;
                    }
                }
            }
            Demon demon = new Demon(currentDemon, healthSum, damage);
            demons.add(demon);
        }

            demons.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).forEach(e->{
                System.out.println(e);
            });


        }



    }

class Demon{
    private String name;
    private Integer health;
    private Double damage;

    public Demon(String name, Integer health, Double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public Double getDamage() {
        return damage;
    }
    @Override

    public  String toString(){
        return  String.format("%s - %d health, %.2f damage",this.getName(),this.getHealth(),this.getDamage());
    }
}
