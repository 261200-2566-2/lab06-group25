public class Mage implements attackedTeam,Shoes{
    protected double hp;
    protected double dmg;
    protected int level;
    public Mage(){
        hp = 200;
        dmg = 250;
        level = 1;
    }

    /**
     * แสดงค่าสถานะทั้งหมดที่ player ควรรู้
     * effect: ปริ้นต์เมื่อ method นี้ถูกเรียก
     */
    public void showStatus(){
        System.out.println("Mage level " + level + " HP: " + hp + " DMG: " + dmg);
    }

    /**
     *คำนวณเปอร์เซ็นต์ของความเสียหายที่ฮีโร่ mage สามารถใช้ได้
     * @return ค่าเปอร์เซ็นต์ของความเสียหายที่ mage ใช้ได้
     */
    public double percentOfMakeDamage() {
        return dmg*((1+6.5*level)/100);
    }

    /**
     * คำนวณเปอร์เซ็นต์ของค่าความเสียหายที่เพิ่มขึ้นเมื่อ mage สวมใส่รองเท้า
     * @return เปอร์เซ็นต์ของค่าความเสียหายที่ควรเพิ่มขึ้นจากเดิม
     */
    public double percentOfDamageUp(){
        return 1.13;
    }

    /**
     * ฮีโร่ mage เลือกที่จะสวมใส่รองเท้าเป็น accessory
     * @return ค่าความเสียหายที่เพิ่มขึ้น 1.13 เปอร์เซ็นต์จากเดิม
     */
    public double wearingShoes(){
        return dmg*=percentOfDamageUp();
    }
}
