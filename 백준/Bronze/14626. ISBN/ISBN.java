import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] isbn = new int[13];
        int x = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                x = i;
            }
            else isbn[i] = str.charAt(i) - '0';
        }

        System.out.println((x == isbn.length - 1)?calculateNum(isbn):recoverNum(isbn, x));
    }

    static int calculateNum(int[] isbn) {
        int validation = 0;
        for (int i = 0 ; i < isbn.length - 1; i++) {
            validation += (i%2==0)?isbn[i]:isbn[i]*3;
        }
        validation %= 10;
        return (10-validation)%10;
    }

    static int recoverNum(int[] isbn, int x) {
        for (int i = 0 ; i < 10; i++) {
            isbn[x] = i;
            if (calculateNum(isbn) == isbn[12]) return i;
        }
        return -1;
    }
}
