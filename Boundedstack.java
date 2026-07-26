


/**
 * Playlist — ADT BoundedStack เป็นโครงสร้างข้อมูลแบบสแตกที่มีความจุจำกัด
 *
 * ค่านามธรรม (A): ลำดับของข้อมูลเรียงตามหลักLIFO เข้าทีหลังออกก่อน
 *
 * ตัวอย่างการใช้งาน:
 *    BoundedStack b = new BoundedStack();
 *    b.push("10");
 *    System.out.println(b.size()); //1
 * 
 */

public class Boundedstack {
    

    // ===== representation =====
    private final int MAX_STACK = 100;
    private Object[] data ;
    private int size_Stack = 0;

    // AF = Array แทนข้อมูลใน stack โดยเรียงจากล่างขึ้นบน
    //
    // RI = Array ไม่เป็น null
    //      size_stackต้อง>=0&&size_stack<=max_stack
    //      
    // Safety from rep exposure
    //  Representation ถูกซ่อนไว้ด้วยprivate ทำให้ไม่สามารถเข้าถึึงหรือแก้ไขอาร์เรย์dataได้โดยตรง
    //  และไม่มีเมธอดใดคืนค่าอาร์เรย์ภายใน จึงไม่เกิดRepresentation exposure

    /**
     *  data !=null
     *  size_stack >= 0
     *  size_stack <= max_stack
     */
    private void checkRep(){
        assert data != null;
        assert size_Stack >= 0;
        assert size_Stack <=MAX_STACK;
    }

    // Creator
    /**
     * สร้างstackว่าง
     */
    public Boundedstack(){
        this.data = new Object[MAX_STACK];
        checkRep();
    }


    //เพิ่มmethodตามในnote
}
