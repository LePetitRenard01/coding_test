import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        ArrayDeque<Character> one = new ArrayDeque<>();
        ArrayDeque<Character> other = new ArrayDeque<>();
        String str = br.readLine();
        for (char c : str.toCharArray()) one.add(c);
        boolean flag = true;
        int res = 0;
        while(flag) {
            flag = quack(one, other);
            ++res;
            if (!flag) {
                res = -1;
                break;
            }
            if(other.isEmpty()) break;

            flag = quack(other, one);
            ++res;
            if (!flag) {
                res = -1;
                break;
            }
            if (one.isEmpty()) break;
        }
        bw.write(res+"");

        bw.flush();
        bw.close();
        br.close();

    }

    private static boolean quack(ArrayDeque<Character> one, ArrayDeque<Character> other) throws IOException {

        char[] order = {'q','u','a','c','k'};
        int size = one.size();
        if (one.peek() != 'q') return false;
        int i = 0;
        while(!one.isEmpty()) {
            char c = one.poll();

            i %= 5;
            if(c != order[i++]) {
                other.add(c);
                i--;
            }
        }

        if(size == other.size() || (size - other.size())%5 != 0) return false;

        return true;

    }
}
