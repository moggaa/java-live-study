import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {


    public void bfs(Node node){
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);
        while (!nodeQueue.isEmpty()){
            Node currentNode = nodeQueue.poll();
            if (currentNode.getLeft()!=null){
                nodeQueue.offer(currentNode.getLeft());
            }
            System.out.println("value : " + currentNode.getValue());
            if (currentNode.getRight()!=null){
                nodeQueue.offer(currentNode.getRight());
            }
        }

    }
    public void dfs(Node node){
        if (node != null){
            dfs(node.getLeft());
            System.out.println("value : " + node.getValue());
            dfs(node.getRight());
        }
    }
}
