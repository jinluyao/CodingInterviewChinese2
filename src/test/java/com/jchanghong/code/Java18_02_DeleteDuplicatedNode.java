/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题18（二）：删除链表中重复的结点
 * // 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
 * // 结点被删除之后，链表如图3.4（b）所示。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.LinkListUtil;
import com.jchanghong.code.util.LinkNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class Java18_02_DeleteDuplicatedNode {

    public LinkNode removeDeplicated(LinkNode head) {
        Set<Integer> set = new HashSet<>();
        LinkNode node = head;
        while (node != null) {
            if (set.contains(node.values)) {
                node = remove_next(head, node);
            }
            else {
                set.add(node.values);
            }
            node = node.next;
        }
        return head;
    }

    LinkNode remove_next(LinkNode head, LinkNode node) {
        LinkNode pre = head;
        while (pre.next != node) {
            pre = pre.next;
        }
        pre.next = node.next;
        return node.next;
    }

    @Test
    public void test() throws Exception {
        LinkNode linkNode = LinkListUtil.construct(1, 2, 3, 4);
        Assert.assertTrue(LinkListUtil.equels(linkNode, removeDeplicated(linkNode)));
        LinkNode linkNode2 = LinkListUtil.construct(1, 2, 2, 3, 4);
        Assert.assertTrue(LinkListUtil.equels(removeDeplicated(linkNode2), linkNode));
    }
}
