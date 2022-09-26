package com.lowleveldesign.projects.texteditor;

public class Node {
    String line;
    Node next;
    Node previous;
    public Node() {}
    public Node(String line) {
        this.line = line;
    }
}
