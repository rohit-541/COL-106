package Lab.Lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import Lab.LinkedList.Node;
import Lab.LinkedList.linkedList;


public class TextEditor {

    public linkedList<String> Editor;
    public Node<String> cursor;
    public int totalWords;
    public int totalLines;
    public Node<String> endNode;
    public int latestVersion;

    //Initialize the list
    TextEditor(){
        this.Editor = new linkedList<>(); 
        latestVersion = 1;
    }

    //FileName -> text -> text ..... -> end

    public void create(String fileName){
        this.Editor.head = new Node<String>(fileName);
        cursor = this.Editor.head;
        this.totalWords = 0;
        this.totalLines = 0;
    }

    public void Write(String txt){
        //Head is already initialised with fileName
        Node<String> newNode = new Node<String>(txt);
        if(Editor.head == null){
            //Create the new Node and rename it
            Editor.head = new Node<String>("newdocument");
            cursor = Editor.head;
        }
        newNode.next = cursor.next;

        if(cursor.next != null){
            cursor.next.prev = newNode;
        }else{
            //Store last written node
            endNode = cursor;
        }

        newNode.prev = cursor;
        cursor.next = newNode;
        cursor = newNode;

    }

    public void delete(int k){

        Node<String> currCursor = cursor;

        while(cursor != null && k-- >0){
            cursor = cursor.prev;
        }

        //List has reached the end
        // Mark the head of list as currCursor->next
        //Can be Null
        if(cursor == null){
            Editor.head = currCursor.next;
            return;
        }

        cursor.next = currCursor.next;
        if(currCursor.next != null){
            currCursor.prev = cursor;
        }else{
            //Store end node
            endNode = currCursor;
        }
    }

    public void moveCursor(int k){
        if(k == 0){
            return;
        }

        if(k < 0){
            while(cursor.prev != null && k++ < 0){
                cursor = cursor.prev;
            }
        }else{
            while(cursor.next != null && k-- > 0){
                cursor = cursor.next;
            }
        }
    }

    public void moveEnd(){
        cursor = this.endNode;
    }

    public void Save(){
        try {
            
            if(this.Editor.head == null){
                this.Editor.head = new Node<String>("Newdocument");
            }
            String outputFile = "./Lab/Lab2/versions/" + this.Editor.head.value + "-(" +(this.latestVersion) +").java";

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile,false));
            Node<String> temp = Editor.head.next;

            while(temp != null){
                writer.write(temp.value);
                temp = temp.next;
            }
            latestVersion++;
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to save the file");
        }
    }

    public void rename(String newName){
        if(Editor.head == null){
            Editor.head = new Node<String>(newName);
        }else{
            Editor.head = new Node<String>(newName);
        }
    }   

    public static void main(String[] args) {
        TextEditor myEditor = new TextEditor();
        myEditor.create("myFile");
        
    }
}
