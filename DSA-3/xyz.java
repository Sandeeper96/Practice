package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
     Node rootNode;
  static class Node{
        Node leftChild;
        int data;
        Node rightChild;
        Node(int data){
            this.data=data;
            rightChild=leftChild=null;
        }
    }
    private void printTree(){
         if(rootNode==null){
              System.out.println("Tree is Empty!");
              return;
         }
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");

            if(temp.leftChild!=null){
                queue.add(temp.leftChild);
            }
            if (temp.rightChild!=null){
                queue.add(temp.rightChild);
            }

        }

    }
    private void  Insertion(int data){
      Node newNode = new Node(data);
      if(rootNode==null){
          rootNode=newNode;
          return;

      }

      Queue<Node> queue = new LinkedList<>();
      queue.add(rootNode);

      Node temp;
      while (!queue.isEmpty()){
         temp= queue.poll();

         if(temp.leftChild==null){
             temp.leftChild=newNode;
             break;
         }else {
             queue.add(temp.leftChild);
         }
         if(!queue.isEmpty()){
             temp.rightChild=newNode;
             break;
         }else {
             queue.add(temp.rightChild);
         }
      }

    }
    public static void main(String[] args) {

          Tree tree = new Tree();
//        tree.rootNode= new Node(10);
//        tree.rootNode.leftChild = new Node(20);
//        tree.rootNode.rightChild = new Node(30);
//        tree.rootNode.leftChild.leftChild= new Node(40);
//        tree.rootNode.leftChild.rightChild=new Node(50);
//        tree.rootNode.rightChild.leftChild= new Node(60);
//        tree.rootNode.rightChild.rightChild = new Node(70);
        for(int i=0; i<10; i++){
            int rdnNumber = (int)(Math.random()*100);
           System.out.println("intserting " + rdnNumber+" tree");
            tree.Insertion(rdnNumber);
        }

        tree.printTree();

    }
}
