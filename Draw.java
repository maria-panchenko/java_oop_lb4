import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw extends JFrame implements ActionListener {
    private JMenuBar menuBar; // меню-бар
    private JMenu fileMenu, editMenu; // меню "Файл" и "Правка"
    private JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem; // пункты меню "Новый", "Открыть", "Сохранить", "Выход"
    private JMenuItem colorMenuItem, thicknessMenuItem; // пункты меню "Цвет" и "Толщина"
    private JPanel drawingPanel; // панель для рисования
    private Color currentColor; // текущий цвет
    private int currentThickness; // текущая толщина линии

    public Draw() {
        setTitle("Рисуй"); // заголовок окна
        setSize(800, 600); // размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // операция закрытия окна

        // создание меню-бара
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // создание меню "Файл"
        fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);

        newMenuItem = new JMenuItem("Новый"); // пункт меню "Новый"
        fileMenu.add(newMenuItem);

        openMenuItem = new JMenuItem("Открыть"); // пункт меню "Открыть"
        fileMenu.add(openMenuItem);

        saveMenuItem = new JMenuItem("Сохранить"); // пункт меню "Сохранить"
        fileMenu.add(saveMenuItem);

        exitMenuItem = new JMenuItem("Выход"); // пункт меню "Выход"
        fileMenu.add(exitMenuItem);

        // создание меню "Правка"
        editMenu = new JMenu("Правка");
        menuBar.add(editMenu);

        colorMenuItem = new JMenuItem("Цвет"); // пункт меню "Цвет"
        editMenu.add(colorMenuItem);

        thicknessMenuItem = new JMenuItem("Толщина"); // пункт меню "Толщина"
        editMenu.add(thicknessMenuItem);

        // создание панели для рисования
        drawingPanel = new JPanel();
        drawingPanel.setBackground(Color.WHITE); // установка фона панели
        add(drawingPanel);

        // установка цвета и толщины линии по умолчанию
        currentColor = Color.BLACK;
        currentThickness = 1;

        // добавление обработчиков событий
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        colorMenuItem.addActionListener(this);
        thicknessMenuItem.addActionListener(this);
        drawingPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Graphics g = drawingPanel.getGraphics();
                g.setColor(currentColor);
                ((Graphics2D) g).setStroke(new BasicStroke(currentThickness));
                g.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
            }
        });
        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = drawingPanel.getGraphics();
                g.setColor(currentColor);
                ((Graphics2D) g).setStroke(new BasicStroke(currentThickness));
                g.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newMenuItem) {
            //
        } else if (e.getSource() == openMenuItem) {
            //
        } else if (e.getSource() == saveMenuItem) {
            //
        } else if (e.getSource() == exitMenuItem) {
            System.exit(0);
        } else if (e.getSource() == colorMenuItem) {
            currentColor = JColorChooser.showDialog(this, "Выберите цвет", currentColor);
        } else if (e.getSource() == thicknessMenuItem) {
            String input = JOptionPane.showInputDialog(this, "Введите толщину (1-10):", currentThickness);
            try {
                int thickness = Integer.parseInt(input);
                if (thickness >= 1 && thickness <= 10) {
                    currentThickness = thickness;
                } else {
                    JOptionPane.showMessageDialog(this, "Некорректное значение толщины", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Некорректное значение толщины", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Draw app = new Draw();
        app.setVisible(true);
    }
}