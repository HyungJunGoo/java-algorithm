package problems.coding_interview._02_list.mission2;

public class Problem2 {
    // 뒤에서 n번쨰 노드를 구하라

    public static void main(String[] args) {
        LinkedNodeList list = new LinkedNodeList();
        list.add(new LinkedNode("apple"));
        list.add(new LinkedNode("kiwi"));
        list.add(new LinkedNode("banana"));
        list.add(new LinkedNode("orange"));
        list.add(new LinkedNode("mango"));
        list.add(new LinkedNode("strawberry"));

        String v1 = list.findFromLast1(3);
        System.out.println("v = " + v1);
        String v2 = list.findFromLast2(3);
        System.out.println("v = " + v2);
        String v3 = list.findFromLast3(3);
        System.out.println("v = " + v3);
    }
}
