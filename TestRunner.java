
public class TestRunner {

    static int pass=0,fail=0;

    static void check(String name , boolean ok){
        if(ok){ pass++; System.out.println(" [PASS] "+name);}
        else  { fail++; System.out.println(" [FAIL] "+name);}
    }
    public static void main(String[]a){
        Boolean ea = false;
        assert ea = true;
        if(!ea) System.out.println("************* assertion ปิดอยู่ ******************");
        
        System.out.println("============== Boundedstack ==================");

        //เขียนที่จะเทส
        testCreators();
        testMutators();
        testClear();
        testObservers();
        testProducer();
        testExposure();


        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);

    }
    
    private static void testCreators(){
        System.out.println("--------Test Creators---------");
    Boundedstack empty = new Boundedstack();
    check("new()-->empty1",empty.size()==0);
    check("new()--empty2",!empty.contains("abdc"));

    Boundedstack p = new Boundedstack("abc","def","ghf");
    check("new(p)--size",p.size()==3);
    check("new(p)--contains abc",p.contains("abc"));

    boolean threwNull = false;
    try {
        new Boundedstack("A",null);
    } catch (IllegalArgumentException e) {
        threwNull=true;
    }
    check("threwNull--new stack with null", threwNull);

    boolean threwNullAll = false;
    try{
        new Boundedstack(null,null);
    } catch (IllegalArgumentException e) {
        threwNullAll=true;
    }
    check("threwNullAll--null all", threwNullAll);
    }

    //----------test mutators---------
    private static void testMutators(){
        System.out.println("----------Mutators---------");

    Boundedstack a = new Boundedstack();
    check("push(A)--return true",a.push("A"));
    check("push(A)--size",a.size()==1);
    check("push(A)--contains",a.contains("A"));
    
    a.push("B");
    a.push("C");
    //หนังสือซ้ำไม่errorคืนfalseเฉยๆ
    check("push duplicate book--return false ",!a.push("A"));
    check("size of (A) After push",a.size()==3);

    //inputผิดเงื่อนไขต้องโยนexception
    boolean threwInput=false;
    try {
        new Boundedstack("");
    } catch (IllegalArgumentException e) {
        threwInput = true;
    }
    check("push empty String--threw IllegalArgumentException", threwInput);

    boolean threwpushNull=false;
    try {
    a.push(null);
    } catch (IllegalArgumentException e) {
        threwpushNull = true;
    }
    check("push null (A)--threw IllegalArgumentException", threwpushNull);
    check("Fail push unchanged",a.size()==3);

    Boundedstack full = new Boundedstack();
    for(int i=0;i<Boundedstack.MAX_BOOK;i++){
        full.push("book "+i);
    }
    check("can fill up to MAX_BOOK", full.size()==Boundedstack.MAX_BOOK);
    check("push when full--Return false", !full.push("one more"));
    check("full book stay max_book",full.size()==Boundedstack.MAX_BOOK);
    }

    //Mutator
    private static void testClear(){
    System.out.println("---test clear----");
    
    Boundedstack c = new Boundedstack("A","B","C");
    check("clear--book", c.clear());
    check("clear--size after clear",c.size()==0);
    check("clear--clear on empty book",!c.clear());
    }

    // --- Observer ต้องไม่มี side effect ---
    private static void testObservers(){
        System.out.println("-------test Observers---------");
    
    Boundedstack s = new Boundedstack("A","B");
    check("size reports =2",s.size()==2);
    check("contains find correct",s.contains("A"));
    check("contains find missing",!s.contains("Z"));
    check("peek--show B",s.peek().equals("B"));
    
    int before = s.size();
    s.size();
    s.contains("A");
    s.peek();
    check("observers have no side effects", s.size() == before);
    
    Boundedstack v = new Boundedstack();
    check("isEmpty --book is empty ",v.isEmpty());
    for(int i= 0 ; i < Boundedstack.MAX_BOOK ; i++){
        v.push("book"+i);
    }
    check("isFull--book is full",v.isFull());  
    }

    // --- Producer ต้องคืนตัวใหม่ ไม่แก้ตัวเดิม ---
    private static void testProducer(){
     System.out.println("-------test Producer-------");
    
    Boundedstack p = new Boundedstack("A","B");
    check("pop return top book",p.pop().equals("B"));
    check("size after pop", p.size()==1);
    p.pop();
    //popตอนที่ว่างจะโยนexception
    boolean threw=false;    
    try {
    p.pop();
    } catch (IllegalArgumentException e) {
        threw=true;
    }
    check("pop on empty book", threw);
    }

    // --- ทดสอบว่าไม่เกิด representation exposure ---
    private static void testExposure(){
        System.out.println("-- Representation Exposure --");
    
    Boundedstack a1 = new Boundedstack("A","B");
    Boundedstack a2 = new Boundedstack(a1);
    //แก้ตัวต้นฉบับต้องไม่กระทบตัวcopy
    a1.push("C");
    check("Change original not effect copy",a2.size()==2);
    check("Change original not effect copy2",!a2.contains("C"));
    //แก้ตัวcopy ต้องไม่กระทบต้นฉบับ
    a2.push("D");
    check("Change copy not effect original",!a1.contains("D"));

    }
    
}
