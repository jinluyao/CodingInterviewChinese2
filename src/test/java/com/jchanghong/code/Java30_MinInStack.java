/**
 * //==================================================================
 * // ����ָOffer�����������Թپ������ͱ���⡷����
 * // ���ߣ��κ���
 * //==================================================================
 * <p>
 * // ������30������min������ջ
 * // ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min
 * // �������ڸ�ջ�У�����min��push��pop��ʱ�临�Ӷȶ���O(1)��
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Java30_MinInStack extends UtilAssert {

    @Test
    public void test() throws Exception {
        MyStack myStack = new MyStack();
        myStack.push(1);
        eq(myStack.min(), 1);
        eq(myStack.pop(), 1);
        myStack.push(2);
        myStack.push(3);
        eq(myStack.min(), 3);
        myStack.pop();
        eq(myStack.min(), 2);
    }

    //实现下面3个函数
    static class MyStack {
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> dequemin = new LinkedList<>();
        public void push(int i) {
            deque.addFirst(i);
            Integer pop = dequemin.peekFirst();

            if (pop==null||i < pop) {
                dequemin.addFirst(i);
            }
            else {
                dequemin.addFirst(pop);
            }
        }

        public int pop() {
            dequemin.pollFirst();
            return deque.pollFirst();

        }

        public int min() {
            return dequemin.peekFirst();
        }

    }
}
