package org.suurhans.algorithms.questions;

import org.suurhans.algorithms.linkedlist.LinkedList;
import org.suurhans.algorithms.linkedlist.NodeIterator;

public class MissingNatural {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.append(10);
        linkedList.append(6);
        linkedList.append(4);
        linkedList.append(7);
        linkedList.append(9);

        NodeIterator<Integer> iterator = linkedList.iterator();
        Integer smallest = null;
        Integer bigger = null;

        while(iterator.hasNext()) {
            Integer current = iterator.next();

            if (smallest == null || current < smallest) {
                smallest = current;
            } else if (bigger == null || (current > smallest && current < bigger)) {
                bigger = current;
            }
        }

        if (bigger - smallest > 1) {
            System.out.println(smallest + 1);
        }
    }

}
