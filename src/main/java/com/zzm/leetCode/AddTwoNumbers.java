package com.zzm.leetCode;

import java.util.List;
import java.util.Objects;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description Add Two Numbers
 * @encoding UTF-8
 * @date 2019/5/15
 * @time 22:43
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);

        ListNode middle = new ListNode(4);

        listNode.next = middle;

        ListNode lastNode = new ListNode(3);

        middle.next = lastNode;

        ListNode secondNode = new ListNode(5);


        ListNode secondMiddle = new ListNode(6);

        secondNode.next = secondMiddle;
//        ListNode secondLast = new ListNode(4);
//
//        secondMiddle.next = secondLast;

        ListNode res =  addTwoNumbers(listNode,secondNode);
        System.out.println("===");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        int carry = 0;


        while(Objects.nonNull(l1) ||Objects.nonNull(l2)){


            int x = null != l1 ? l1.val :0;

            int y = null != l2 ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;

            currentNode.next = new ListNode(sum % 10);

            currentNode = currentNode.next;

            if (Objects.nonNull(l1)){
                l1 = l1.next;
            }

            if (Objects.nonNull(l2)){
                l2 = l2.next;
            }


        }

        if (carry >0 ){
            currentNode.next = new ListNode(carry);
        }

       return head.next;

    }


}
