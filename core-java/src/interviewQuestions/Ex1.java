package interviewQuestions;

public class Ex1 {
    public static void main(String[] args) {
        Test t = new Test();

        StringBuffer Sb = new StringBuffer("java");
        String S = new String("java");

        System.out.println(Sb.append("builder"));
        System.out.println(Sb.insert(2,"builder"));
        System.out.println(S.concat("builder"));

    }
    }

class Test {
    protected int x, y;
    public int a;
}
