


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
    private final int MAX_BOOK = 100;
    private Object[] book ;
    private int size_book = 0;

    // AF = Array แทนข้อมูลใน stack โดยเรียงจากล่างขึ้นบน
    //
    // RI = Array ไม่เป็น null
    //      size_stackต้อง>=0&&size_stack<=max_stack
    //      
    // Safety from rep exposure
    //  Representation ถูกซ่อนไว้ด้วยprivate ทำให้ไม่สามารถเข้าถึึงหรือแก้ไขอาร์เรย์dataได้โดยตรง
    //  และไม่มีเมธอดใดคืนค่าอาร์เรย์ภายใน จึงไม่เกิดRepresentation exposure

    /**
     *  book !=null
     *  size_book >= 0
     *  size_book <= max_stack
     */
    private void checkRep(){
        assert book != null;
        assert size_book >= 0;
        assert size_book <=MAX_BOOK;
    }

    // Creator
    /**
     * สร้างstackว่าง
     */
    public Boundedstack(){
        this.book = new Object[MAX_BOOK];
        checkRep();
    }
    public Boundedstack(String name_book){
        this.book = new String[MAX_BOOK];
        for(int i=0;i<book.length;i++ ){
            this.book[i]=book[i];
        }
        checkRep();
    }
    //เพิ่มmethodตามในnote
    public boolean push(String name_Book){
        return false;
    }
    public String pop(){
        return "fsff" ;
    }
    public String peek(){
        return "sdasdf";
    }
    public int size(){
        return 0;
    }
    public boolean isEmpty(){
        return false    ;
    }
    public boolean isFull(){
        return false;
    }
    public boolean contains(String check_book){
        return false;
    }
    public void clear(){

    }

}
