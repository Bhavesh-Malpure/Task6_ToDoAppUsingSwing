package Task_6;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class TodoApp {
    static int taskCounter = 1;

    public static void main(String[] args) {
        JFrame Myframe = new JFrame("ToDo App");
        Myframe.setSize(400, 550);
        Myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Myframe.setLayout(new BorderLayout());

        JLabel heading = new JLabel("Tasks", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 24));
        heading.setBorder(new EmptyBorder(10, 0, 10, 0));
        Myframe.add(heading, BorderLayout.NORTH);

        DefaultListModel<JPanel> taskModel = new DefaultListModel<>();
        JList<JPanel> taskList = new JList<>(taskModel);
        taskList.setCellRenderer((list, panel, index, isSelected, cellHasFocus) -> { // lambda ex- helps to set looking of each task and highlighting on selection
            panel.setBackground(isSelected ? new Color(220, 240, 255) : Color.WHITE);
            panel.setOpaque(true);
            return panel;
        });

        JScrollPane scrollPane = new JScrollPane(taskList);
        Myframe.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        Myframe.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            JDialog dialog = new JDialog(Myframe, "Add New Task", true);
            dialog.setSize(300, 200);
            dialog.setLayout(new GridLayout(3, 2, 10, 10));

            JLabel titleLabel = new JLabel("Title:");
            JTextField titleField = new JTextField();

            JLabel descLabel = new JLabel("Description:");
            JTextField descField = new JTextField();

            JButton submitButton = new JButton("Add");

            dialog.add(titleLabel);
            dialog.add(titleField);
            dialog.add(descLabel);
            dialog.add(descField);
            dialog.add(new JLabel());
            dialog.add(submitButton);

            submitButton.addActionListener(ev -> {
                String title = titleField.getText().trim();
                String desc = descField.getText().trim();
                if (!title.isEmpty()) {
                    JPanel taskPanel = new JPanel();
                    taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
                    taskPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

                    JLabel numberedTitle = new JLabel(taskCounter++ + ". " + title);
                    numberedTitle.setFont(new Font("SansSerif", Font.BOLD, 14));

                    JLabel descLabelContent = new JLabel(desc);
                    descLabelContent.setFont(new Font("SansSerif", Font.PLAIN, 12));

                    taskPanel.add(numberedTitle);
                    if (!desc.isEmpty()) taskPanel.add(descLabelContent);

                    taskModel.addElement(taskPanel);
                    dialog.dispose();
                }
            });

            dialog.setLocationRelativeTo(Myframe);
            dialog.setVisible(true);
        });

        deleteButton.addActionListener(e -> {
            int selected = taskList.getSelectedIndex();
            if (selected != -1) {
                int confirm = JOptionPane.showConfirmDialog(
                    Myframe,
                    "Are you sure you want to delete this task?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    taskModel.remove(selected);
                }
            } else {
                JOptionPane.showMessageDialog(Myframe, "Please select a task to delete.");
            }
        });

        Myframe.setVisible(true);
    }
}















// 📝 Java Swing ToDo App
// This is a simple Java Swing-based ToDo List Application that allows users to add, view, and delete tasks with a user-friendly graphical interface.

// Each task can include a title and description, and the UI is designed to be clean, interactive, and visually appealing.

// 🔧 Features Implemented
// ✏️ Add task using a popup dialog with a title and description field

// ✅ Tasks are auto-numbered and formatted as:
// "1. Task Title – Description"

// 🎯 Title is bold and slightly larger, description is smaller

// 🧾 Tasks are displayed in a scrollable list

// 🗑️ Delete a selected task with a confirmation popup

// 🎨 Selected task is highlighted with a light background color

// 🧭 Task list is titled "Tasks", centered, and displayed in a large font

// 🧠 What We Learned
// How to use JList with custom JPanel items instead of plain text

// How to implement a custom ListCellRenderer for better styling

// How to use JDialog for creating modular input forms

// How to handle event-driven behavior with ActionListener

// The difference between layout managers like BorderLayout and GridLayout

// Managing component styling using Font, Color, and BorderFactory

// 🚧 Challenges Faced
// 1. 🕳️ Nothing Visible After Clicking "Add Task"
// Initially, the app launched with the frame and buttons, but entering tasks didn't seem to do anything. The issue was that:

// JList used custom JPanel items, which didn’t display anything unless rendered properly.

// We resolved it by using a custom cell renderer with setCellRenderer(...) and visually differentiating the selected row.

// 2. 🎨 Making Task Appearance Better
// We wanted the task title to stand out, and also have a visual difference for description. This required:

// Creating a custom layout inside a JPanel

// Using BoxLayout and separate JLabels with custom fonts

// 3. 🗃️ Adding Dialog to Enter Task Info
// Implementing a pop-up dialog with JTextFields for title and description required proper layout and closing behavior. We used:

// JDialog with GridLayout

// Added button to capture inputs and safely close the dialog

// 4. 🚦 Selection Highlight and Confirmation
// By default, JList didn’t highlight selected JPanels. We handled it by:

// Adding a custom background color on selection

// Adding a confirmation dialog before deletion with JOptionPane

// 🚀 How to Run
// Make sure you have JDK installed

// Navigate to your project folder

// Compile and run:

// bash
// Copy
// Edit
// javac Task_6/TodoApp.java
// java Task_6.TodoApp