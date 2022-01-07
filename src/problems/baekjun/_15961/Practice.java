package problems.baekjun._15961;

import java.io.*;
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String address = scanner.next();
        int age = scanner.nextInt();
        double score = scanner.nextDouble();
        System.out.println(name + address + age + score);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int number1 = Integer.valueOf(line[0]);
        int number2 = Integer.valueOf(line[1]);

        bw.write(String.valueOf(number1 + number2));
        bw.flush();
        bw.close();

    }
}
