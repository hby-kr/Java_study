package com.tj703.study;

import java.util.ArrayList;
import java.util.List;

public class L02ArrayType {
    public static void main(String[] args) {

        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;

        // 배열은 자바의 기본 데이터 구조로, Object 클래스를 상속하지만 Collection 인터페이스와는 관계가 없습니다.
        // List, Set, Queue 등은 모두 Collection 인터페이스를 상속받고 있습니다.
        /*
        List 인터페이스
        List는 순서가 있는 데이터를 저장하며, 중복을 허용합니다.
            ArrayList, LinkedList, Vector, Stack

        Set 인터페이스
        Set은 순서가 없고, 중복된 요소를 허용하지 않는 자료구조입니다.
            HashSet, LinkedHashSet, TreeSet

        Queue 인터페이스
        Queue는 선입선출(FIFO) 구조를 가지며, 주로 데이터 처리에서 사용됩니다.
            PriorityQueue, LinkedList (List와 Queue 인터페이스를 모두 구현), ArrayDeque

        Deque 인터페이스
        Deque는 양쪽 끝에서 데이터를 추가하거나 제거할 수 있는 자료구조로, Queue의 특수한 형태입니다.
        ArrayDeque, LinkedList (Deque와 List 인터페이스를 모두 구현)

        Map 인터페이스 (Note: Map은 Collection의 하위 인터페이스는 아니지만, 자주 함께 사용됩니다.)
        Map은 키-값 쌍으로 데이터를 저장합니다.
        Map 자체는 Collection의 하위 인터페이스는 아니지만, 컬렉션 프레임워크에서 중요한 역할을 합니다.
        HashMap, LinkedHashMap, TreeMap, Hashtable, WeakHashMap
         */


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // list.toArray(Integer[]);  /오류남/ js에서는 타입자체가 매개변수로 사용가능
        Integer[] numArr = list.toArray(new Integer[0]);
        // 나는 타입만 정하고 싶은데, 타입만 매개변수로 넣을 수 없어서, 객체를 명시하는 것
        for (int num : numArr) {
            System.out.println(num);
        }

        // 리스트
        List<String[]> strList = new ArrayList<>();
        strList.add(new String[]{"1", "2"});
        strList.add(new String[]{"3", "4"});
        strList.add(new String[]{"5", "6"});

        // 배열
        String[][] strArr = new String[3][2];
        strArr[0][0] = "1";
        strArr[0][1] = "2";
        strArr[1][0] = "3";
        strArr[1][1] = "4";
        strArr[2] = new String[]{"5", "6"};

        // new Jtable ( columns:[] ,  data:[][] )  // 약속이다. 그래서 매개변수로 배열을 넣어야 함.
        // 위에서 리스트의 제네릭을 String으로 한정했으므로, 배열로 바꾼 결과물도 String이어야 함.
        // 그래서 스트링 리스트를 스트링 배열로 바꿔야 하는데.....
        Object[][] data = strList.toArray(new Object[0][0]);
        // 이렇게 하면 Object 배열로 만들어지니..
        // 제네릭을 사용했는데도, 매개변수로 toArray로 반환할 타입을 객체로 확인 중
        // 아래와 같이 해서 String 배열로 변환해야 함.
        String[][] strdata = strList.toArray(new String[0][0]);
    }
}
