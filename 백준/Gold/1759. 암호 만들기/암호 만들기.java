import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int l, c;
    static char[] alphabet;
    static boolean[] isVowel;
    static StringBuilder sb;
    static int[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static int[] stack;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alphabet = new char[c];
        isVowel = new boolean[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);
        for (int i = 0; i < c; i++) {
            isVowel[i] = isVowel(alphabet[i]);
        }

        sb = new StringBuilder();
        stack = new int[l];
        backtracking(0,0);
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isVowel(int ch) {
        for (int i : vowels) {
            if (ch == i) return true;
        }
        return false;
    }

    private static void backtracking(int idx, int cnt) { //idx = alphabet 인덱스, cnt = stack 인덱스
        if(cnt == l){
            if (!checkCondition()) return;
            for(int i : stack){
                sb.append(alphabet[i]);
            }
            sb.append("\n");
            return;
        }

        // alphabet 내의 인덱스를 스택에 추가
        for (int i = idx; i < alphabet.length; i++) {
            stack[cnt] = i;
            backtracking(i + 1, cnt + 1);
        }
    }

    private static boolean checkCondition(){
        int vowel = 0;
        int consonant = 0;
        for (int i = 0; i < l; i++){
            if(isVowel[stack[i]]) vowel++;
            else consonant++;
        }
        if (vowel >= 1 && consonant >= 2) return true;
        else return false;
    }
}
