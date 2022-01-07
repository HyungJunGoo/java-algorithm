package problems.coding_interview._02_list.mission2;

public class Problem5 {

    // 문제, 정렬된 연결 리스트에서 중복되는 모든 노드 제거하는 코드를 작성하라.
    // 예) 1 -> 2 -> 2 -> 3   =>  1 -> 3

    public static void main(String[] args) {
        LinkedNodeList list = new LinkedNodeList();
        list.add(new LinkedNode("1"));
        list.add(new LinkedNode("2"));
        list.add(new LinkedNode("2"));
        list.add(new LinkedNode("3"));
        list.add(new LinkedNode("3"));
        list.add(new LinkedNode("5"));

        list.removeAllDuplicates();
        list.print();
    }
}
