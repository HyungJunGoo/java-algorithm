package problems.coding_interview._01_array;

public class ReverseStringSolution {

    // 문제
    // 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
    private char[] solution1(char[] message) {

        char[] reversedChars = new char[message.length];
        for (int i = message.length-1; i >= 0; i--) {
            reversedChars[message.length - 1 - i] = message[i];
        }
        return reversedChars;
    }
    // Time complexity : O(n)
    // Space complexity : O(n)

    private char[] solution2(char[] message) {

        for (int i = 0; i < message.length / 2; i++) {
            char temp = message[i];
            message[i] = message[message.length - 1 - i];
            message[message.length - 1 - i] = temp;
        }
        return message;
    }
    // Time complexity : O(n)
    // Space complexity : O(1)
    public static void main(String[] args) {
        ReverseStringSolution reverseStringSolution = new ReverseStringSolution();
        char[] chars = reverseStringSolution.solution1(new char[]{'h', 'e', 'l', 'l', 'o'});
        for (char c : chars) {
            System.out.println(c);
        }
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.reverse();
        System.out.println("stringBuilder = " + stringBuilder);
    }
}
