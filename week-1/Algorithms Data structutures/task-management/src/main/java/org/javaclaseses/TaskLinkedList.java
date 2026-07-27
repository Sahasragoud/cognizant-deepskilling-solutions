package org.javaclaseses;

public class TaskLinkedList {

    // Internal Node class
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // 1. ADD TASK (Appends to the end of the list)
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 2. SEARCH TASK BY ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task; // Found
            }
            current = current.next;
        }
        return null; // Not found
    }

    // 3. TRAVERSE & PRINT ALL TASKS
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks found in the list.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // 4. DELETE TASK BY ID
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }

        // Case 1: Task to delete is at head
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }

        // Case 2: Search for node preceding the target node
        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        // If target was found, bypass it
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }

        return false; // Task not found
    }

    // Main method for testing
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Adding tasks
        taskList.addTask(new Task(1, "Design UI Mockups", "Completed"));
        taskList.addTask(new Task(2, "Develop REST API", "In Progress"));
        taskList.addTask(new Task(3, "Write Unit Tests", "Pending"));

        System.out.println("--- All Tasks ---");
        taskList.traverseTasks();

        // Searching
        System.out.println("\n--- Searching for Task ID 2 ---");
        Task searched = taskList.searchTask(2);
        System.out.println(searched != null ? "Found: " + searched : "Task not found.");

        // Deleting
        System.out.println("\n--- Deleting Task ID 2 ---");
        boolean isDeleted = taskList.deleteTask(2);
        System.out.println("Deletion success: " + isDeleted);

        System.out.println("\n--- Tasks After Deletion ---");
        taskList.traverseTasks();
    }
}
