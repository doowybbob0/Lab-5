import java.io.Serializable;
import java.util.Scanner;

public class Script implements Serializable {
    public static SpaceMarine Scan2(Scanner scan) {
        try {
            String name = scan.nextLine();
            Integer x = scan.nextInt();
            Integer y = scan.nextInt();
            Integer healthInt = scan.nextInt();
            scan.nextLine();
            
            
            Integer heightInt = scan.nextInt();
            scan.nextLine();
            
            Integer in = scan.nextInt();
            Weapon categ = null;
            if (in == 1) {  categ = Weapon.PLASMA_GUN; }
            if (in == 2) { categ = Weapon.FLAMER; }
            if (in == 3) { categ = Weapon.GRAV_GUN; }
            if (in == 4) { categ = Weapon.GRENADE_LAUNCHER; }
            if (in == 5) { categ = Weapon.MULTI_MELTA; }
            Weapon categ1 = categ;
            scan.nextLine();
            
            Integer in1 = scan.nextInt();
            MeleeWeapon mwcateg = null;
            if (in1 == 1) {  mwcateg = MeleeWeapon.CHAIN_SWORD; }
            if (in1 == 2) { mwcateg = MeleeWeapon.MANREAPER; }
            if (in1 == 3) { mwcateg = MeleeWeapon.POWER_BLADE; }
            MeleeWeapon categ2=mwcateg;
            scan.nextLine();
            
            String name2 = scan.nextLine();
            String name3 = scan.nextLine();

            
            SpaceMarine abc = new SpaceMarine(name, new Coordinates(x, y), healthInt, heightInt, categ1, categ2, new Chapter(name2, name3));
            return abc;
        }
        catch (Exception ex) {
            System.out.println("Данные заполнены неверно,в следующий раз будьте аккуратны при заполнении");
        }
        return null;
    }
}