import javax.swing.*;
import java.awt.*;

class TForm1 extends JFrame {
    private int width = 800;
    private int height = 400;
    private String[] columnNames = {"Номер п/п", "Фамилия", "Группа"};
    private String[][] data = {{"1", "test1", "test01"},{"2", "test2", "test02"}};

    TForm1() {
        super("LAB1 - DB");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(this.width, this.height);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu jmFile = new JMenu("Файл");

        JMenuItem jmiOpen = new JMenuItem("Открыть");
        JMenuItem jmiSave = new JMenuItem("Сохранить");
        JMenuItem jmiClose = new JMenuItem("Закрыть");

        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.add(jmiClose);

        jMenuBar.add(jmFile);

        JMenu jmEdit = new JMenu("Редактировать");

        JMenuItem jmiCopy = new JMenuItem("Копировать");
        JMenuItem jmiDelete = new JMenuItem("Удалить");
        JMenuItem jmiPaste = new JMenuItem("Вставить");

        jmEdit.add(jmiCopy);
        jmEdit.add(jmiDelete);
        jmEdit.add(jmiPaste);

        jMenuBar.add(jmEdit);

        JMenu jmWindow = new JMenu("Окно");

        JMenuItem jmiCascade = new JMenuItem("Каскадом");
        JMenuItem jmiShowAll = new JMenuItem("Показать все");
        JMenuItem jmiCloseAll = new JMenuItem("Закрыть все");

        jmWindow.add(jmiCascade);
        jmWindow.add(jmiShowAll);
        jmWindow.add(jmiCloseAll);

        jMenuBar.add(jmWindow);

        JTextArea txtArea = new JTextArea();
        JComboBox comboTable = new JComboBox();
        JComboBox comboColumn = new JComboBox();
        JComboBox comboQuery = new JComboBox();
        JLabel labelTable = new JLabel("Таблица");
        JLabel labelColumn = new JLabel("Поле");
        JLabel labelQuey = new JLabel("Тип запроса");

        JButton jButton1 = new JButton("Выполнить");

        JPanel jPanel = new JPanel();
        JPanel jPanelCombo = new JPanel();

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(jButton1);

        jPanelCombo.setLayout(new BoxLayout(jPanelCombo, BoxLayout.X_AXIS));
        jPanelCombo.add(labelTable); jPanelCombo.add(comboColumn);
        jPanelCombo.add(labelColumn); jPanelCombo.add(comboTable);
        jPanelCombo.add(labelQuey); jPanelCombo.add(comboQuery);

        jmiCloseAll.addActionListener(e -> {

        });

        jButton1.addActionListener(e -> {
            txtArea.setText("You query must be here!");
        });


        this.setJMenuBar(jMenuBar);
        this.setLayout(new BorderLayout());
        this.add(txtArea);
        this.add(jPanel, BorderLayout.SOUTH);
        this.add(jPanelCombo, BorderLayout.NORTH);
    }


}
