public class Tank implements protectedTeam, attackedTeam,Shoes,Wings {
    protected double hp;
    protected double dmg;
    protected double dfn;
    protected int level;
    public Tank(){
        hp = 250;
        dmg = 200;
        dfn = 250;
        level = 1;
    }

    /**
     * แสดงค่าสถานะทั้งหมดที่ player ควรรู้
     * effect: ปริ้นต์เมื่อ method นี้ถูกเรียก
     */
    public void showStatus(){
        System.out.println("Tank level " + level + " HP: " + hp + " DMG: " + dmg + " DFN: " + dfn);
    }

    /**
     * คำนวณเปอร์เซ็นต์ของความเสียหายที่ฮีโร่ tank สามารถใช้ได้
     * @return ค่าเปอร์เซ็นต์ของความเสียหายที่ tank ใช้ได้
     */
    public double percentOfMakeDamage() {
        return dmg*((1+5.5*level)/100);
    }

    /**
     * คำนวณอัตราการป้องกันที่ tank สามารถเรียกออกมาใช้ได้
     * @return อัตราการป้องกันที่ tank เรียกออกมาใช้
     */
    public double protectRate() {
        return dfn*((1+7.5*level)/100);
    }

    /**
     * คำนวณเปอร์เซ็นต์ของความเสียหายที่ tank รับได้โดยไม่ป้องกัน
     * @return เปอร์เซ็นต์ของความเสียหายที่ tank รับได้
     */
    public double percentOfTakeDamage() {
        return dfn*((1+3.3*level)/100);
    }

    /**
     * คำนวณเปอร์เซ็นต์ของค่าความเสียหายที่เพิ่มขึ้นเมื่อ tank สวมใส่รองเท้า
     * @return เปอร์เซ็นต์ของค่าความเสียหายที่ควรเพิ่มขึ้นจากเดิม
     */
    public double percentOfDamageUp(){
        return 1.2;
    }

    /**
     * ฮีโร่ tank เลือกที่จะสวมใส่รองเท้าเป็น accessory
     * @return ค่าความเสียหายที่เพิ่มขึ้น 1.2 เปอร์เซ็นต์จากเดิม
     */
    public double wearingShoes(){
        return dmg*=percentOfDamageUp();
    }

    /**
     * คำนวณเปอร์เซ็นต์ของค่าการป้องกันที่เพิ่มขึ้นเมื่อ tank สวมใส่ปีก
     * @return เปอร์เซ็นต์ของค่าการป้องกันที่ควรเพิ่มขึ้นจากเดิม
     */
    public double percentOfDefendUp(){
        return 1.2;
    }

    /**
     * ฮีโร่ tank เลือกที่จะสวมใส่ปีกเป็น accessory
     * @return ค่าความเสียหายที่เพิ่มขึ้น 1.2 เปอร์เซ็นต์จากเดิม
     */
    public double wearingWings(){
        return dfn*=percentOfDefendUp();
    }
}
