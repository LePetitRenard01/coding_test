import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   static class Node {
       int num;
       Node left, right;

       Node(int num) { this.num = num; }

       void insert(int n) {
           if (n < this.num) {
               if (this.left == null)
                   this.left = new Node(n);
               else this.left.insert(n);
           } else {
               if (this.right == null)
                   this.right = new Node(n);
               else this.right.insert(n);
           }
       }
   }

   public static void main(String[] args) throws IOException{
       Node root = new Node(Integer.parseInt(br.readLine()));
       String input;
       while (true) {
           input = br.readLine();
           if (input == null || input.equals(""))
               break;
           root.insert(Integer.parseInt(input));
       }
       postOrder(root);
       bw.flush();
       bw.close();
       br.close();
   }

   static void postOrder(Node node) throws IOException {
       if (node.left != null) postOrder(node.left);
       if (node.right != null) postOrder(node.right);
       bw.write(node.num +"\n");
   }
}
