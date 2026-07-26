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
        check(null, false);


        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);

    }




}
