package com.lowleveldesign.projects.texteditor;

public class Dll {
    private Node head;
    private Node tail;
    private DllStateManager dllStateManager;
    private DllClipBoard dllClipBoard;
    public Dll() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
        this.dllStateManager = new DllStateManager();
        this.dllClipBoard = new DllClipBoard();
    }

    public void appendLast(String line) {
        this.dllStateManager.storeState(this);
        Node newNode = new Node(line);
        Node tailPrev = tail.previous;
        tailPrev.next = newNode;
        newNode.previous = tailPrev;
        newNode.next = tail;
        tail.previous = newNode;
    }

    public void displayAllContents() {
        StringBuilder str = new StringBuilder();
        Node start = head.next;
        while(start != tail) {
            str.append(start.line);
            str.append("\n");
            start = start.next;
        }

        System.out.println(str.toString());
    }

    public void displayLines(int start, int end) {
        if(start > end || start <= 0)
            return;

        StringBuilder str = new StringBuilder();
        int currPos = 1;
        Node curr = head.next;
        while(curr != tail) {
            if(currPos >= start) {
                str.append(curr.line);
                str.append("\n");
            }

            currPos++;
            curr = curr.next;

            if(currPos > end)
                break;
        }

        System.out.println(str.toString());
    }

    public void insert(String line, int position) {
        this.dllStateManager.storeState(this);
        //code for insertion in DLL
    }

    public void delete(int start, int end) {
        this.dllStateManager.storeState(this);
        //code for deletion in DLL
    }

    public void paste(int position) {
        this.dllStateManager.storeState(this);
        this.dllClipBoard.pasteContents(this, position);
    }

    public void copy(int start, int end) {
        this.dllClipBoard.setClipboardContents(this, start, end);
    }

    public void undo() {
        this.reset();
        this.dllStateManager.restoreToPreviousState(this);
    }

    private void reset() {
        head.next = tail;
        tail.previous = head;
    }
}
