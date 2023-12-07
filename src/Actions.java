public class Actions {
    /**
     * เมื่อ tank กับ mage ต้องการ attack กันทั้งคู่ เมื่อ player1 เลือก tank player2 เลือก mage
     * effect: ถ้าค่าเปอร์เซ็นต์ของการทำ damage ของฝ่ายใดฝ่ายหนึ่งมากกว่าอีกฝ่ายหนึ่ง ค่า damage และ hp ของอีกฝ่ายที่น้อยกว่าจะถูกลดและ level ฝ่ายที่มีค่ามากกว่าจะเพิ่มขึ้น
     * @param t ฮีโร่ class tank 1 ตัว
     * @param m ฮีโร่ class mage 1 ตัว
     */
    static void attackAndAttack(Tank t,Mage m){
        double a = t.percentOfMakeDamage();
        double b = m.percentOfMakeDamage();
        double diff = Math.abs(a-b);
        if(a > b){
            m.dmg = (m.dmg*(100-diff))/100;
            m.hp-=50;
            t.level++;
        }else{
            t.dmg = (t.dmg*(100-diff))/100;
            t.hp-=50;
            m.level++;
        }
        t.showStatus();
        m.showStatus();
    }

    /**
     * เมื่อ tank กับ mage ต้องการ attack กันทั้งคู่ เมื่อ player1 เลือก mage player2 เลือก tank
     * effect: ถ้าค่าเปอร์เซ็นต์ของการทำ damage ของฝ่ายใดฝ่ายหนึ่งมากกว่าอีกฝ่ายหนึ่ง ค่า damage และ hp ของอีกฝ่ายที่น้อยกว่าจะถูกลด
     * @param t ฮีโร่ class tank 1 ตัว
     * @param m ฮีโร่ class mage 1 ตัว
     */
    static void attackAndAttack(Mage m,Tank t){
        double a = m.percentOfMakeDamage();
        double b = t.percentOfMakeDamage();
        double diff = Math.abs(a-b);
        if(a > b){
            t.dmg = (t.dmg*(100-diff))/100;
            t.hp-=50;
        }else{
            m.dmg = (m.dmg*(100-diff))/100;
            m.hp-=50;
        }
        m.showStatus();
        t.showStatus();
    }

    /**
     * เมื่อ mage ต้องการโจมตี และ support ต้องการป้องกัน เมื่อ player1 เลือก mage player2 เลือก support
     * effect: ถ้าฝ่าย mage มีเปอร์เซ็นต์การทำ damage มากกว่าเปอร์เซ็นต์การรับ damage ได้ของฝ่าย support hp ฝ่าย support จะลดและ level ฝ่าย mage จะเพิ่ม
     * @param p ฮีโร่ class support 1 ตัว
     * @param m ฮีโร่ class mage 1 ตัว
     */
    static void attackAndDefend(Mage m,Support p){
        double a = m.percentOfMakeDamage();
        double b = p.percentOfTakeDamage();
        double diff = Math.abs(a-b);
        if(a > b){
            p.hp = (p.hp*(100-diff))/100;
            m.level++;
        }
        m.showStatus();
        p.showStatus();
    }

    /**
     * เมื่อ mage ต้องการโจมตี และ tank ต้องการป้องกัน เมื่อ player1 เลือก mage player2 เลือก tank
     * effect: ถ้าฝ่าย mage มีเปอร์เซ็นต์การทำ damage มากกว่าเปอร์เซ็นต์การรับ damage ได้ของฝ่าย tank hp ฝ่าย tank จะลดและ level ฝ่าย mage จะเพิ่ม
     * @param t ฮีโร่ class tank 1 ตัว
     * @param m ฮีโร่ class mage 1 ตัว
     */
    static void attackAndDefend(Mage m,Tank t){
        double a = m.percentOfMakeDamage();
        double b = t.percentOfTakeDamage();
        double diff = Math.abs(a-b);
        if(a > b){
            t.hp = (t.hp*(100-diff))/100;
            m.level++;
        }
        m.showStatus();
        t.showStatus();
    }

    /**
     * เมื่อ tank ต้องการโจมตี และ support ต้องการป้องกัน เมื่อ player1 เลือก tank player2 เลือก support
     * effect: ถ้าฝ่าย tank มีเปอร์เซ็นต์การทำ damage มากกว่าเปอร์เซ็นต์การรับ damage ได้ของฝ่าย tank hp ฝ่าย tank จะลดและ level ฝ่าย mage จะเพิ่ม
     * @param t ฮีโร่ class tank 1 ตัว
     * @param p ฮีโร่ class support 1 ตัว
     */
    static void attackAndDefend(Tank t,Support p){
        double a = t.percentOfMakeDamage();
        double b = p.percentOfTakeDamage();
        double diff = Math.abs(a-b);
        if(a > b){
            p.hp = (p.hp*(100-diff))/100;
            t.level++;
        }
    }
    /**
     * เมื่อ tank ต้องการป้องกัน และ mage ต้องการโจมตี เมื่อ player1 เลือก tank player2 เลือก mage
     * effect: ถ้าฝ่าย tank มีเปอร์เซ็นต์การรับ damage น้อยกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย mage hp ฝ่าย tank จะลดและ level ฝ่าย mage จะเพิ่ม
     * @param t ฮีโร่ class tank 1 ตัว
     * @param m ฮีโร่ class mage 1 ตัว
     */
    static void defendAndAttack(Tank t,Mage m){
        double a = t.percentOfTakeDamage();
        double b = m.percentOfMakeDamage();
        double diff = Math.abs(a-b);
        if(a < b){
            t.hp = (t.hp*(100-diff))/100;
            m.level++;
        }
        t.showStatus();
        m.showStatus();
    }
    /**
     * เมื่อ support ต้องการป้องกัน และ mage ต้องการโจมตี เมื่อ player1 เลือก support player2 เลือก mage
     * effect: ถ้าฝ่าย support มีเปอร์เซ็นต์การรับ damage น้อยกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย mage hp ฝ่าย support จะลดและ level ฝ่าย mage จะเพิ่ม
     * @param p ฮีโร่ class support 1 ตัว
     * @param m ฮีโร่ class mage 1 ตัว
     */
    static void defendAndAttack(Support p,Mage m){
        double a = p.percentOfTakeDamage();
        double b = m.percentOfMakeDamage();
        double diff = Math.abs(a-b);
        if(a < b){
            p.hp = (p.hp*(100-diff))/100;
            m.level++;
        }
        p.showStatus();
        m.showStatus();
    }
    /**
     * เมื่อ support ต้องการป้องกัน และ tank ต้องการโจมตี เมื่อ player1 เลือก support player2 เลือก tank
     * effect: ถ้าฝ่าย support มีเปอร์เซ็นต์การรับ damage น้อยกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย tank hp ฝ่าย support จะลดและ level ฝ่าย tank จะเพิ่ม
     * @param p ฮีโร่ class support 1 ตัว
     * @param t ฮีโร่ class tank 1 ตัว
     */
    static void defendAndAttack(Support p,Tank t){
        double a = p.percentOfTakeDamage();
        double b = t.percentOfMakeDamage();
        double diff = Math.abs(a-b);
        if(a < b){
            p.hp = (p.hp*(100-diff))/100;
            t.level++;
        }
        p.showStatus();
        t.showStatus();
    }
    /**
     * เมื่อ tank ต้องการป้องกัน และ mage ต้องการโจมตี เมื่อ player1 เลือก support player2 เลือก tank
     * effect: ถ้าฝ่าย tank มีอัตราการป้องกัน damage มากกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย mage damage และ hp ฝ่าย mage จะลดและ level ฝ่าย tank จะเพิ่มแต่ถ้าฝ่าย tank มีอัตราการป้องกัน damage น้อยกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย mage defend และ hp ฝ่าย tank และ level ฝ่าย mage จะเพิ่ม
     * @param t ฮีโร่ class tank 1 ตัว
     * @param m ฮีโร่ class mage 1 ตัว
     */
    static void protectAndAttack(Tank t,Mage m){
        double a = t.protectRate();
        double b = m.percentOfMakeDamage();
        double diff = Math.abs(a-b);
        if(a > b){
            m.dmg = (m.dmg*(100-diff))/100;
            m.hp-=50;
            t.level++;
        }else{
            t.dfn = (t.dfn*(100-diff))/100;
            t.hp-=50;
            m.level++;
        }
        t.showStatus();
        m.showStatus();
    }
    /**
     * เมื่อ suppoprt ต้องการป้องกัน และ mage ต้องการโจมตี เมื่อ player1 เลือก support player2 เลือก mage
     * effect: ถ้าฝ่าย support มีอัตราการป้องกัน damage มากกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย mage damage และ hp ฝ่าย mage จะลดและ level ฝ่าย support จะเพิ่มแต่ถ้าฝ่าย support มีอัตราการป้องกัน damage น้อยกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย mage defend และ hp ฝ่าย support จะลดและ level ฝ่าย mage จะเพิ่ม
     * @param p ฮีโร่ class support 1 ตัว
     * @param m ฮีโร่ class mage 1 ตัว
     */
    static void protectAndAttack(Support p,Mage m){
        double a = p.protectRate();
        double b = m.percentOfMakeDamage();
        double diff = Math.abs(a-b);
        if(a > b){
            m.dmg = (m.dmg*(100-diff))/100;
            m.hp-=50;
            p.level++;
        }else{
            p.dfn = (p.dfn*(100-diff))/100;
            p.hp-=50;
            m.level++;
        }
        p.showStatus();
        m.showStatus();
    }
    /**
     * เมื่อ support ต้องการป้องกัน และ tank ต้องการโจมตี เมื่อ player1 เลือก support player2 เลือก tank
     * effect: ถ้าฝ่าย support มีอัตราการป้องกัน damage มากกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย tank damage และ hp ฝ่าย tank จะลดและ level ฝ่าย support จะเพิ่มแต่ถ้าฝ่าย support มีอัตราการป้องกัน damage น้อยกว่าเปอร์เซ็นต์การทำ damage ได้ของฝ่าย tank defend และ hp ฝ่าย support จะลดและ level ฝ่าย tank จะเพิ่ม
     * @param p ฮีโร่ class support 1 ตัว
     * @param t ฮีโร่ class tank 1 ตัว
     */
    static void protectAndAttack(Support p,Tank t){
        double a = p.protectRate();
        double b = t.percentOfMakeDamage();
        double diff = Math.abs(a-b);
        if(a > b){
            t.dmg = (t.dmg*(100-diff))/100;
            t.hp-=50;
            p.level++;
        }else{
            p.dfn = (p.dfn*(100-diff))/100;
            p.hp-=50;
            t.level++;
        }
        p.showStatus();
        t.showStatus();
    }
    /**
     * เมื่อ tank ต้องการโจมตี และ support ต้องการป้องกัน เมื่อ player1 เลือก tank player2 เลือก support
     * effect: ถ้าฝ่าย tank มีเปอร์เซ็นต์การทำ damage น้อยกว่าอัตราการป้องกัน damage ของฝ่าย support damage และ hp ฝ่าย tank จะลดและ level ฝ่าย support จะเพิ่มแต่ถ้าฝ่าย tank มีเปอร์เซ็นต์การทำ damage มากกว่าอัตราการป้องกัน damage ของฝ่าย support defend และ hp ฝ่าย support จะลดและ level ฝ่าย tank จะเพิ่ม
     * @param t ฮีโร่ class tank 1 ตัว
     * @param p ฮีโร่ class support 1 ตัว
     */
    static void attackAndProtect(Tank t,Support p){
        double a = t.percentOfMakeDamage();
        double b = p.protectRate();
        double diff = Math.abs(a-b);
        if(a < b){
            t.dmg = (t.dmg*(100-diff))/100;
            t.hp-=50;
            p.level++;
        }else{
            p.dfn = (p.dfn*(100-diff))/100;
            p.hp-=50;
            t.level++;
        }
    }
    /**
     * เมื่อ mage ต้องการโจมตี และ support ต้องการป้องกัน เมื่อ player1 เลือก mage player2 เลือก support
     * effect: ถ้าฝ่าย mage มีเปอร์เซ็นต์การทำ damage น้อยกว่าอัตราการป้องกัน damage ของฝ่าย support damage และ hp ฝ่าย mage จะลดและ level ฝ่าย support จะเพิ่มแต่ถ้าฝ่าย mage มีเปอร์เซ็นต์การทำ damage มากกว่าอัตราการป้องกัน damage ของฝ่าย support defend และ hp ฝ่าย support จะลดและ level ฝ่าย mage จะเพิ่ม
     * @param m ฮีโร่ class mage 1 ตัว
     * @param p ฮีโร่ class support 1 ตัว
     */
    static void attackAndProtect(Mage m,Support p){
        double a = m.percentOfMakeDamage();
        double b = p.protectRate();
        double diff = Math.abs(a-b);
        if(a < b){
            m.dmg = (m.dmg*(100-diff))/100;
            m.hp-=50;
            p.level++;
        }else{
            p.dfn = (p.dfn*(100-diff))/100;
            p.hp-=50;
            m.level++;
        }
        m.showStatus();
        p.showStatus();
    }
    /**
     * เมื่อ mage ต้องการโจมตี และ tank ต้องการป้องกัน เมื่อ player1 เลือก mage player2 เลือก tank
     * effect: ถ้าฝ่าย mage มีเปอร์เซ็นต์การทำ damage น้อยกว่าอัตราการป้องกัน damage ของฝ่าย tank damage และ hp ฝ่าย mage จะลดและ level ฝ่าย tank จะเพิ่มแต่ถ้าฝ่าย mage มีเปอร์เซ็นต์การทำ damage มากกว่าอัตราการป้องกัน damage ของฝ่าย support defend และ hp ฝ่าย tank จะลดและ level ฝ่าย mage จะเพิ่ม
     * @param m ฮีโร่ class mage 1 ตัว
     * @param t ฮีโร่ class tank 1 ตัว
     */
    static void attackAndProtect(Mage m,Tank t){
        double a = m.percentOfMakeDamage();
        double b = t.protectRate();
        double diff = Math.abs(a-b);
        if(a < b){
            m.dmg = (m.dmg*(100-diff))/100;
            m.hp-=50;
            t.level++;
        }else{
            t.dfn = (t.dfn*(100-diff))/100;
            t.hp-=50;
            m.level++;
        }
        m.showStatus();
        t.showStatus();
    }
}
