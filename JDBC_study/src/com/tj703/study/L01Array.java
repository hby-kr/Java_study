package com.tj703.study;

import java.util.*;

public class L01Array {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        // 순서와 인덱스가 있는 자료 객체
        System.out.println(nums[0]);
        // [] : Array라는 표현. 고정 길이 배열이다.
        // nums[5] = 6;  / 오류가 뜬다. 왜 고정길이니까. 처음 선언한 길이에 고정된다.

        int [] nums2 = new int[5];
        System.out.println(nums2[0]);
        System.out.println(Arrays.toString(nums2)); // {0,0,0,0,0,0}  기본적으로 0이 들어간다. null이 아니라. 왜 null이 아닌가?

        String [] strs = new String[5];
        System.out.println(Arrays.toString(strs)); // {null,null,null,null,null}
        // => 왜 0이고, 왜 null 인가?
        // 자료형type의 문제다. 원시형의 없음은 0이고, 자료형의 참조없음은 null이므로.


        // 이중배열 이차배열
        int [][] nums3 = new int[2][5]; // { {0,0,0,0,0} , {0,0,0,0,0} }
        System.out.println(Arrays.toString(nums3));

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡfor 반복문 / 배열안에 번호 바꾸기");
        int n = 0;
        for (int i = 0;    i < nums3.length;   i++) {
            int [] arr = nums3[i]; // 각 배열 뭉치 {0,0,0,0,0} 하나씩 가리키겠다.

            for (int j = 0;    j < nums3[i].length;   j++) {
                // {0,0,0,0,0} 안에 있는 각 0을 순회하겠다는 의미
                int num = nums3[i][j];
                // == int num = arr[j]
                arr[j] = (++n);
            }
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡfor iterator / 배열 안에 번호 노출하기");
        for (int [] arr : nums3) {
            for(int num : arr) {
                System.out.println(num + ",");
            }
        }


        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 실습
        Object [][] data = {{10001, "경민", true}, {10002, "기원", false}, {10003, "승엽", false}};
        // Object를 쓴 이유는 여러 데이터 타입이 들어가므로.
        // Object o = 11;    /(기본형 데이터)/  new Integer(11) > new Object()
        //      / 자료형이 기본형이므로, 랩퍼클래스가 만들어지고, 이미 랩퍼 객체 안에 OB를 가지고 있는 것.
        // Object s = "안녕"; /(참조형 데이터)/  ["안녕" : new String() > new Object() ]
        //      / 자료형이 참조형이므로, 이미 있는 Object 객체를 가지고 있으므로, 변수가 그 Object객체를 참조한다.

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡfor iterator");
        for (Object [] data1 : data) {
            System.out.println(Arrays.toString(data1));

            for (Object data2 : data1) {
                System.out.println(data2);
            }
        }

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡfor 반복문");
        for (int a = 0; a < data.length; a++) {
            System.out.println(Arrays.toString(data[a]));

            for (int b = 0; b < data[a].length; b++) {
                System.out.println(data[a][b]);
            }
        }


        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        // 배열은 줄 서 있는 사람과 같음 (순서가 있고,인덱스도 있음)
        // 데이터가 빠지면 뒤쪽에 모든 데이터를 앞으로 이동시킨다.
        List list = new ArrayList();  // list의 타입을 (ArrayList가 아니라) List로 설정하면

        // LinkedList는 (번호표를 받은 사람들과 비슷. 줄 서있을 필요 없이, 1번째와 2번째의 참조만 되어있음.
        // 데이터가 앞에서 하나 빠져도, 전체 데이터를 전체 앞으로 하나씩 옮길 필요 없음. 다음이 연결되어 있으니까.
        // for 면접을 위해 알고 있어야.
        list = new LinkedList();
        // LinkedList는 각 요소는 Node 객체로 저장되며, 각 노드는 자신이 저장하는 값과 다음 노드를 가리키는 포인터를 포함


        // 객체가 부모타입의 변수를 참조가능한 것 = 타입의 다형성


        // ArrayList == Js의 Array
        // 출력도 되고, 길이도 유동적
        list.add(10);
        list.add(20);
        list.add("30");
        list.add(true);
        list.add(new Date());
        System.out.println("리스트 출력");
        System.out.println(list);
        // List는 기본으로 Object를 참조한다.

        //ArrayList는 빠른 랜덤 접근이 필요하고, 주로 조회가 많은 경우에 유리합니다. 삽입이나 삭제가 자주 일어나면 비효율적일 수 있습니다.
        //LinkedList는 삽입과 삭제가 빈번한 경우에 유리하지만, 인덱스를 통한 접근이 느립니다.


        // ㅡㅡㅡㅡ Generic
        // 그런데 데이터 타입을 고정할 수 있다. : Generic <>  (타입을 고정할 때 자료형만 가능)
        List<Integer> nums4 = new ArrayList<>();
        nums4.add(1);
        nums4.add(2);
        nums4.add(3);
        // nums4.add(true); 못 넣음

        // ㅡㅡㅡㅡ iterable가 내장되어 있음
        for (int i = 0; i < nums4.size(); i++) {
            System.out.println(nums4.get(i));
        }

        int nn = Integer.valueOf(10);
        // nn = 10 ;
        for (Integer num : nums4) {
            System.out.println(num +",");
        }

        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        List<int[]> numArr = new ArrayList<>();
        // numArr.add({1,2,3,4});
        numArr.add(new int[]{1,2,3,4});

        int[] nums5 = new int[]{5,6,7,8,9,10};
        // 선언즉시 대입할 때는 new int [] 를 (써야하는데) 생략해도 됨.
        numArr.add(nums5);
        numArr.add(new int[]{11,12,13,14});



/*
1. 배열 (Array)
- 배열은 고정된 크기를 가진 데이터 구조로, 배열의 크기는 한 번 생성되면 변경할 수 없습니다.
- 동일한 타입의 요소들이 연속적으로 저장되는 자료구조입니다.
- 배열의 요소는 인덱스를 사용해 빠르게 접근

 */











    }
}
