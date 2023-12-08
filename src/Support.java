public class Support implements rescuedTeam,protectedTeam,Wings{
    protected double hp;
    protected double dfn;
    protected int level;
    public Support(){
        hp = 230;
        dfn = 250;
        level = 1;
    }

    /**
     * แสดงค่าสถานะทั้งหมดที่ player ควรรู้
     *
     */
    public void showStatus(){
        System.out.println("Sup level " + level + " HP: " + hp + " DFN: " + dfn);
    }

    /**
     * คำนวณอัตราการป้องกันที่ support สามารถเรียกออกมาใช้ได้
     * @return อัตราการป้องกันที่ support เรียกออกมาใช้
     */
    public double protectRate() {
        return dfn*((1+4.5*level)/100);
    }

    /**
     * คำนวณเปอร์เซ็นต์ของความเสียหายที่ support รับได้โดยไม่ป้องกัน
     * @return ปอร์เซ็นต์ของความเสียหายที่ support รับได้
     */
    public double percentOfTakeDamage() {
        return dfn*((1+4.3*level)/100);
    }

    /**
     * คำนวณอัตราการฟื้นฟูที่ support สามารถฟื้นฟูได้
     * @return ค่า hp ที่เพิ่มขึ้นจากเดิม 1.25 เท่า
     */
    public double healRate() {
        return hp*=1.25;
    }

    /**
     * คำนวณเปอร์เซ็นต์ของค่าการป้องกันที่เพิ่มขึ้นเมื่อ support สวมใส่ปีก
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
