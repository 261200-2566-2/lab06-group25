// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {
    //สาธิต 2 ตัวละครคือ Tank กับ Support
    static String[] actions = new String[2];

    /**
     * แสดงการกระทำที่ tank และ support สามารถเล่นได้
     * @param s ค่าที่ player พิมพ์เข้ามา
     * effects: รับ String จาก Scanner โดยผ่าน method .nextline() เข้ามาใส่ใน actions array
     * effects: ปริ้นการกระทำทั้งหมดที่ tank สามารถทำได้
     * effects: ปริ้นการกระทำทั้งหมดที่ support สามารถทำได้
     */
    static void playConsoleForTP(Scanner s){
        System.out.println("Press number for your actions : [1]Attack [2]Shoes [3]Wings");
        System.out.print("Tank: ");
        actions[0] = s.nextLine();
        System.out.println("Press number for your actions : [1]Defend [2]Protect [3]Wings [4]Heal");
        System.out.print("Sup: ");
        actions[1] = s.nextLine();
    }

    /**
     * เรียกการกระทำต่าง ๆ ใน class Actions
     * @param t ฮีโร่ class tank 1 ตัว
     * @param a การกระทำของ tank ที่เลือก Type เป็น String
     * @param p ฮีโร่ class support 1 ตัว
     * @param b การกระทำของ support ที่เลือก Type เป็น String
     * effect: สำหรับ tank เมื่อรับ String การกระทำเข้ามาตรงกับเงื่อนไขที่กำหนดไว้ ก็จะเรียกใช้ class Actions
     *         หรือจาก class tank โดยตรงตามการกระทำที่ต้องการ
     * effect: สำหรับ support เมื่อรับ String การกระทำเข้ามาตรงกับเงื่อนไขที่กำหนดไว้ ก็จะเรียกใช้ class Actions
     *         หรือจาก class support โดยตรงตามการกระทำที่ต้องการ
     */
    static void pickActionsForTP(Tank t,String a,Support p,String b){
        if(a.equalsIgnoreCase("1") && b.equalsIgnoreCase("1")){
            Actions.attackAndDefend(t,p);
        }else if(a.equalsIgnoreCase("1") && b.equalsIgnoreCase("2")){
            Actions.attackAndProtect(t,p);
        }
        if(a.equalsIgnoreCase("2")){
            t.wearingShoes();
        }else if(a.equalsIgnoreCase("3")){
            t.wearingWings();
        }
        if(b.equalsIgnoreCase("3")){
            p.wearingWings();
        }else if(b.equalsIgnoreCase("4")){
            p.healRate();
        }
        t.showStatus();
        p.showStatus();
    }
    static boolean victory = true;

    public static void main(String[] args) {
        System.out.println("สาธิต 2 ตัวละครคือ Tank กับ Support และเมื่อคนใดคนหนึ่งกดเลือก accessories หรือทำการ heal ในตานั้นจะถือว่าการโจมตีถือเป็นโมฆะ");
        Scanner s = new Scanner(System.in);
        Tank t = new Tank();
        Support p = new Support();
        while (victory) {
            playConsoleForTP(s);
            pickActionsForTP(t, actions[0], p, actions[1]);
            if(t.hp < 1|| p.hp < 1) victory = false;
        }
        if(t.hp > 1) System.out.println("The winner is TANK!!!");
        else if(p.hp > 1) System.out.println("The winner is Support!!!");
    }
}