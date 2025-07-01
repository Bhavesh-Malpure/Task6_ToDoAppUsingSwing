# Task6_ToDoAppUsingSwing

📝 Java Swing ToDo App
This is a simple Java Swing-based ToDo List Application that allows users to add, view, and delete tasks with a user-friendly graphical interface.

Each task can include a title and description, and the UI is designed to be clean, interactive, and visually appealing.

🔧 Features Implemented
✏️ Add task using a popup dialog with a title and description field

✅ Tasks are auto-numbered and formatted as:
"1. Task Title – Description"

🎯 Title is bold and slightly larger, description is smaller

🧾 Tasks are displayed in a scrollable list

🗑️ Delete a selected task with a confirmation popup

🎨 Selected task is highlighted with a light background color

🧭 Task list is titled "Tasks", centered, and displayed in a large font

🧠 What We Learned
How to use JList with custom JPanel items instead of plain text

How to implement a custom ListCellRenderer for better styling

How to use JDialog for creating modular input forms

How to handle event-driven behavior with ActionListener

The difference between layout managers like BorderLayout and GridLayout

Managing component styling using Font, Color, and BorderFactory

🚧 Challenges Faced
1. 🕳️ Nothing Visible After Clicking "Add Task"
Initially, the app launched with the frame and buttons, but entering tasks didn't seem to do anything. The issue was that:

JList used custom JPanel items, which didn’t display anything unless rendered properly.

We resolved it by using a custom cell renderer with setCellRenderer(...) and visually differentiating the selected row.

2. 🎨 Making Task Appearance Better
We wanted the task title to stand out, and also have a visual difference for description. This required:

Creating a custom layout inside a JPanel

Using BoxLayout and separate JLabels with custom fonts

3. 🗃️ Adding Dialog to Enter Task Info
Implementing a pop-up dialog with JTextFields for title and description required proper layout and closing behavior. We used:

JDialog with GridLayout

Added button to capture inputs and safely close the dialog

4. 🚦 Selection Highlight and Confirmation
By default, JList didn’t highlight selected JPanels. We handled it by:

Adding a custom background color on selection

Adding a confirmation dialog before deletion with JOptionPane

🚀 How to Run
Make sure you have JDK installed

Navigate to your project folder

Compile and run:

javac Task_6/TodoApp.java
java Task_6.TodoApp
