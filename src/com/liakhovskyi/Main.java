package com.liakhovskyi;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println(arrayList);
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(300);
        arrayList.add(400);
        System.out.println(arrayList);


        System.out.println("____________\n");

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(50);
        System.out.println(((LinkedList<Integer>) linkedList).print());
        linkedList.remove(2);
        System.out.println(((LinkedList<Integer>) linkedList).print());
        linkedList.remove(0);
        System.out.println(((LinkedList<Integer>) linkedList).print());
    }
}
