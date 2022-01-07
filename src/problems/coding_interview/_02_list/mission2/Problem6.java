package problems.coding_interview._02_list.mission2;

public class Problem6 {
    //    주어진 연결 리스트가 원형 연결 리스트인지 단일 연결 리스트인지 확인하는 함수를 구현하라.
    //    예)1->2->3->1 =>true 예)1->2->3->2 =>true 예) 1 -> 2 -> 3 => false
    public static void main(String[] args) {
        LinkedNodeList list = new LinkedNodeList();

        list.add(new LinkedNode("a"));
        LinkedNode b = new LinkedNode("b");
        list.add(b);
        list.add(new LinkedNode("c"));
        list.add(new LinkedNode("d"));
        list.add(b);

        if (list.findCirculatory()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
