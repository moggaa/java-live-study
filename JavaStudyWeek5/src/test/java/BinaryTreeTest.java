import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    Node root;
    BinaryTree binaryTree = new BinaryTree();

    @BeforeEach
    void 트리초기화(){
        root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node (5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));

    }

    @Test
    void dfsTest(){
        binaryTree.dfs(root);
    }

    @Test
    void bfsTest(){
        binaryTree.bfs(root);
    }

}