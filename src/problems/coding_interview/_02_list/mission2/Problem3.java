package problems.coding_interview._02_list.mission2;

public class Problem3 {

    // 링크드 리스트의 중간 노드를 찾는 코드

    public static void main(String[] args) {
        LinkedNodeList list = new LinkedNodeList();
        list.add(new LinkedNode("apple"));
        list.add(new LinkedNode("kiwi"));
        list.add(new LinkedNode("mango"));
        list.add(new LinkedNode("banana")); // mid Node
        list.add(new LinkedNode("orange"));
        list.add(new LinkedNode("strawberry"));
        list.add(new LinkedNode("cherry"));

        LinkedNode midNode = list.findMid();
        System.out.println("midNode = " + midNode.v);
    }
}
