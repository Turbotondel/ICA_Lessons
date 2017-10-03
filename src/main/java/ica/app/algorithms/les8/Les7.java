package ica.app.algorithms.les8;

public class Les7 {
    public static void main(String[] args) {
        BinaryNode<String> multiNode1 = new BinaryNode<String>("*");
        BinaryNode<String> multiNode2 = new BinaryNode<String>("*");

        BinaryNode<String> valueNode1 = new BinaryNode<String>("1");
        BinaryNode<String> valueNode2 = new BinaryNode<String>("2");
        BinaryNode<String> valueNode3 = new BinaryNode<String>("3");

        multiNode1.setLeft(valueNode1);
        multiNode1.setRight(multiNode2);
        multiNode2.setLeft(valueNode2);
        multiNode2.setRight(valueNode3);
    }

//    public static BinaryNode postfixToTree(String s) {
//        HANStack<BinaryNode> stree = new HANStack<BinaryNode>();
//        for (char ch : s.toCharArray()) {
//            myInsert(ch, stree);
//        }
//        return stree.pop();
//    }

//    public static void myInsert(char ch, HANStack<BinaryNode> s) {
//        if (Character.isDigit(ch)) {
//            s.push(new BinaryNode(ch, null, null));
//        } else {
//            BinaryNode tParent = new BinaryNode(ch, null, null);
//            tParent.setRight(s.pop());
//            tParent.setLeft(s.pop());
//            s.push(tParent);
//        }
//    }

    public static int calc(BinaryNode<String> node) {
        if (node.getValue().equals("*")) {
            return calc(node.getLeft()) * calc(node.getRight());
        } else if (node.getValue().equals("/")) {
            return calc(node.getLeft()) * calc(node.getRight());
        } else if (node.getValue().equals("+")) {
            return calc(node.getLeft()) * calc(node.getRight());
        } else if (node.getValue().equals("-")) {
            return calc(node.getLeft()) * calc(node.getRight());
        }
        return Integer.parseInt(node.getValue());
    }
}
