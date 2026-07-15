package Bar;


class Expectiminimax {

    static class Node {
        int value;
        Node left, right;
    };

    static Node maxMove(Node node) {
        if (node.right == null) {
            return node;
        }
        else {
            return maxMove(Math.max(node.left, node.right));
        }
    }

    static Node minMove(Node node) {
        if (node.left == null) {
            return node;
        }
        else {
            return minMove(Math.min(node.left, node.right));
        }
    }

    static Node chanceMove(Node node) {
        int totalProbability = 0;
        float expectedValue = 0;
        for (Node child : node.children) {
            totalProbability += child.probability;
            expectedValue += child.value * child.probability;
        }
        node.value = expectedValue;
        return node;
    }

    static void expectimax(Node node, boolean isMaximizer) {
        if (node.left == null && node.right == null) {
            return;
        }

        if (isMaximizer) {
            node.value = maxMove(node).value;
        }
        else {
            node.value = minMove(node).value;
        }

        if (node.isChanceNode()) {
            node = chanceMove(node);
        }

//        if (isMaximizer) {
//            for (Node child : node.children) {
//                expectimax(child, false);
//            }
//        }
//        else {
//            for (Node child : node.children) {
//                expectimax(child, true);
            }
        }
    }