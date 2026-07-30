//6821600937 ขวัญชัย อ้อมกลาง
//6821601381 วงศธร เชื้อจีน
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
    public static final int MAX_BOOK = 100;
    private Object[] books ;
    private int size_books = 0;

    // AF = Array แทนข้อมูลใน stack โดยเรียงจากล่างขึ้นบน
    //
    // RI = Array ไม่เป็น null
    //      1.size_books ต้องไม่เป็นลบ
    //      2.size_books ต้องไม่เกิน max_books
    //      3.0 <= size_books <= max_books
    //      
    // Safety from rep exposure
    //  Representation 
    //  ถูกซ่อนไว้ด้วยprivate ทำให้ไม่สามารถเข้าถึึงหรือแก้ไขอาร์เรย์dataได้โดยตรง
    //  และไม่มีเมธอดใดคืนค่าอาร์เรย์ภายใน จึงไม่เกิดRepresentation exposure 

    /**
     *  books !=null
     *  size_books >= 0
     *  size_books <= max_books
     */
    private void checkRep(){
        assert books != null;
        assert size_books >= 0;
        assert size_books <=MAX_BOOK;

        for (int i = 0; i < size_books; i++) {
        Object b = books[i];
        assert b != null : "book must not contain null";
        assert b instanceof String : "book must contain only Strings";
        assert !((String)b).isEmpty() : "book must not contain empty strings";
        }
    }

    // =======Creator=======
    /**
     * สร้างstackว่าง
     */
    public Boundedstack(){
        this.books = new Object[MAX_BOOK];
        checkRep();
    }
    
    public Boundedstack(String... name_book){//รับค่าStringกี่ตัวก็ได้{
    if(name_book == null){
        throw new IllegalArgumentException("book must not contain null");
    }
    this.books = new Object[MAX_BOOK];

    for(int i=0;i<name_book.length;i++){
        if(name_book[i] == null || name_book[i].equals("")){
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
        this.books[i] = name_book[i];
    }
    this.size_books = name_book.length;
    checkRep();
}
    public Boundedstack(Boundedstack other) {//Copy Constructor
    if (other == null) {
        throw new IllegalArgumentException();
    }

    this.books = new Object[MAX_BOOK];
    this.size_books = other.size_books;

    for (int i = 0; i < size_books; i++) {
        this.books[i] = other.books[i];
    }
    checkRep();
}
    //เพิ่มmethodตามในnote

    /**
     * เพิ่มหนังสือใหม่ลงในstack
     * 
     * @param name_Book ชื่อหนังสือต้องไม่เป็น null หรือว่าง
     * @return ture ถ้าเพิ่มสำเร็จ false ถ้า stack เต็มแล้วไม่สามารถเพิ่มได้
     * @throws IllegalArgumentException ถ้า name_Book เป็น null หรือสตริงว่าง
     */
    
    public boolean push(String name_Book){
    if(name_Book == null || name_Book.isEmpty()) {
        throw new IllegalArgumentException("Book cannot be null or empty");
    }
    if(size_books >= MAX_BOOK) {
        return false;
    }
    if(contains(name_Book)) {
        return false;
    }
    books[size_books++] = name_Book;
    checkRep();
    return true;
}
    /**
     * ส่งค่าบนสุดและลบค่านั้นออก
     * 
     * @return ดึงชื่อหนังสือที่อยู่บนสุดของ stack ลบจำนวนออกจาก stack
     * @throws IllegalArgumentException ถ้า stack ว่าง
     */
    public String pop(){
        if (size_books == 0) throw new IllegalArgumentException();
        size_books--;
        String BookAbove = (String) books[size_books];
        books[size_books] = null;
        checkRep();
        return BookAbove;
    }

    /**
     * ดูข้อมูลด้านบนสุดแต่ไม่ลบค่านั้น
     * 
     * stack ต้องมีค่าและไม่เป็น null
     * @return ค่าบนสุด แต่ไม่ลบค่าเดิมออกไป
     * @throws IllegalArgumentException ถ้า Stack ว่าง
     */
    public String peek(){
    if(size_books == 0){
        throw new IllegalArgumentException();
    }
    return (String) books[size_books - 1];
}
    /**
     * บอกจำนวนที่อยู่ในstackตอนนี้
     * 
     * @return
     */
    public int size(){
        return size_books;
    }
    /**
     * บอกว่า stack ว่างหรือไม่
     * @return ture ถ้า stack ว่าง false ถ้า stack มีข้อมูล
     */
    public boolean isEmpty(){
        if (size_books != 0) return false;
        return true;
    }
    /**
     * บอกว่า stack เต็มหรือไม่
     * @return ส่ง ture ถ้า stack เต็ม false ถ้า stack ยังมีที่ว่าง
     */
    public boolean isFull(){
        return size_books == MAX_BOOK;
    }
    /**
     * ชื่อหนังสือที่อยู่ใน stack ซ้ำกัน
     * @param check_book ชื่อหนังสือที่ต้องการตรวจสอบ
     * @return true ถ้า stack มีหนังสือชื่อนี้ ,false ถ้าไม่
     */
    public boolean contains(String check_book){
        for (int i = 0; i < size_books; i++) {
            if (books[i].equals(check_book)) {
                return true;
            }
        }
        return false;
    }
    public boolean clear(){
    if(size_books == 0){
        return false;
    }
    for(int i = 0; i < size_books; i++){
        books[i] = null;
    }
    size_books = 0;
    checkRep();
    return true;
}

}
