public class TaskLinkedList {
    private Task head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added successfully.");
    }

    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId().equalsIgnoreCase(taskId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks found in the system.");
            return;
        }
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Error: Task management list is empty.");
            return;
        }

        if (head.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task current = head;
        Task previous = null;

        while (current != null && !current.getTaskId().equalsIgnoreCase(taskId)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Error: Task not found.");
            return;
        }

        previous.next = current.next;
        System.out.println("Task deleted successfully.");
    }
}

public class Main {
    public static void main(String[] args) {
        TaskLinkedList tl = new TaskLinkedList();

        Task t1 = new Task("T001", "Database Backup", "Pending");
        Task t2 = new Task("T002", "API Integration", "In Progress");
        Task t3 = new Task("T003", "UI Code Review", "Completed");

        tl.addTask(t1);
        tl.addTask(t2);
        tl.addTask(t3);

        System.out.println("\n--- Current Task List ---");
        tl.traverseTasks();

        System.out.println("\n--- Searching for Task T002 ---");
        Task found = tl.searchTask("T002");
        System.out.println(found != null ? "Found: " + found : "Not Found");

        System.out.println("\n--- Deleting Task T002 ---");
        tl.deleteTask("T002");

        System.out.println("\n--- Final Task List ---");
        tl.traverseTasks();
    }
}