import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private static List<Task> tasks = new ArrayList<>();

    private static int nextTaskId = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create task");
            System.out.println("2. Update task");
            System.out.println("3. Delete task");
            System.out.println("4. View tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: \n");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    createTask(input);
                    break;
                case 2:
                    updateTask(input);
                    break;
                case 3:
                    deleteTask(input);
                    break;
                case 4:
                    viewTasks();
                    break;
                case 5:
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    public static void createTask(Scanner userTaskInput) {
        System.out.print("Enter task description: ");
        String description = userTaskInput.next();

        Task newTask = new Task(nextTaskId, description);
        tasks.add(newTask);
        nextTaskId++;
        System.out.println("Task created. ID: " + newTask.getId());
    }

    public static void updateTask(Scanner updateTaskInput) {
        System.out.print("Enter task ID: ");
        int taskId = updateTaskInput.nextInt();
        updateTaskInput.nextLine();

        Task taskToUpdate = getTaskById(taskId);
        if (taskToUpdate != null) {
            System.out.print("Enter new task description: ");
            String newDescription = updateTaskInput.nextLine();

            taskToUpdate.setDescription(newDescription);
            System.out.println("Task updated.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public static void deleteTask(Scanner deleteUserInput) {
        System.out.print("Enter task ID: ");
        int taskId = deleteUserInput.nextInt();

        Task taskToDelete = getTaskById(taskId);
        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (Task task : tasks) {
                System.out.println("ID: " + task.getId() + ", Description: " + task.getDescription());
            }
        }
    }

    public static Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }
}

class Task {
    private int id;
    private String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}





