package problems.coding_interview._02_list.mission2;

public class Problem4 {
    /**
     * 정렬된 링크드 리스트에서 중복된 노드를 제거하는 방법
     * <p>
     * input : 'a' -> 'b' -> 'b' -> 'c' -> 'c' -> 'd'
     * output : 'a' -> 'b' -> 'c' -> 'd'
     */
    public static void main(String[] args) {
        LinkedNodeList list = new LinkedNodeList();
        list.add(new LinkedNode("a"));
        list.add(new LinkedNode("b"));
        list.add(new LinkedNode("b"));
        list.add(new LinkedNode("b"));
        list.add(new LinkedNode("c"));
        list.add(new LinkedNode("c"));
        list.add(new LinkedNode("d"));
        list.add(new LinkedNode("a"));


//        list.removeDuplicate1();
//        list.print();

        list.removeDuplicate2();
        list.print();
        list.removeDuplicate3();
        list.print();

    }

}
