import java.util.Hashtable;

public class test {
    public static void main(String[] args) {
        Hashtable x = new Hashtable();
        x.put(1, "1");
        x.put(2, "2");
        boolean res = x.containsValue("2");
        System.out.println(x.get(1));
    }
}
