
import javax.swing.*;
import java.awt.*;

class MainForm extends JFrame {
    private int width = 800;
    private int height = 400;
    private String[] tables;
    private String[] queries = {"SELECT", "DELETE", "UPDATE"};
//    private String url = "jdbc:mysql://localhost:3306/larablog?useLegacyDatetimeCode=false&serverTimezone=Europe/Kiev";
//    private String username = "root";
//    private String pass = "";

    MainForm() {
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

        // Комбобоксы
        JTextArea txtArea = new JTextArea();
        JComboBox comboTable = new JComboBox();
        JComboBox comboColumn = new JComboBox();
        JComboBox comboQuery = new JComboBox(queries);
        JLabel labelQuery = new JLabel("Запрос");
        JLabel labelTable = new JLabel("Таблица");
        JLabel labelColumn = new JLabel("Где");

        JTextField textField = new JTextField();
        JLabel labelWhere = new JLabel(" = ");

        JButton jButton1 = new JButton("Выполнить");

        JPanel jPanel = new JPanel();
        JPanel jPanelCombo = new JPanel();

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(jButton1);

        jPanelCombo.setLayout(new BoxLayout(jPanelCombo, BoxLayout.X_AXIS));
        jPanelCombo.add(labelQuery);
        jPanelCombo.add(comboQuery);
        jPanelCombo.add(labelTable);
        jPanelCombo.add(comboTable);
        jPanelCombo.add(labelColumn);
        jPanelCombo.add(comboColumn);
        jPanelCombo.add(labelWhere);
        jPanelCombo.add(textField);

        // DATABASE Init
//        CDatabase db = new CDatabase(url, username, pass);
//        try
//        {
//            db.connect();
//            for(String s : db.getTables())
//            {
//                comboTable.addItem(s);
//            }
//            comboColumn.addItem(comboTable.getItemAt(0));
//
//        }
//        catch (Exception e)
//        {
//            txtArea.setText(e.getMessage());
//
//        }
//        finally
//        {
//
//        }
        CDatabase db = new CDatabase();
        String[] tablesList = db.runQuery("show tables in larablog;");
        for (int i = 0; i < tablesList.length; i++)
        {
            comboTable.addItem(tablesList[i]);
        }

        String[] columnList = db.runQuery("DESCRIBE " + comboTable.getItemAt(comboTable.getSelectedIndex()) + ";");
        for(int i = 0; i < columnList.length; i++)
        {
            comboColumn.addItem(columnList[i]);
        }
        db.disconnect();

        // пункт меню Закрыть
        jmiClose.addActionListener(e -> {

        });

        // пункт меню Открыть
        jmiOpen.addActionListener(e -> {

        });

        // комбо выбор таблицы
        comboTable.addActionListener( e -> {
            CDatabase db1 = new CDatabase();
            comboColumn.removeAllItems();
            String[] columnList1 = db1.runQuery("DESCRIBE " + comboTable.getItemAt(comboTable.getSelectedIndex()) + ";");
            for (int i = 0; i < columnList1.length; i++)
            {
                comboColumn.addItem(columnList1[i]);
            }
            db1.disconnect();
        });


        // кнопка Выполнить
        jButton1.addActionListener(e -> {
            String textQuery = CMakeQuery.getTextQuery
                    (
                            comboTable.getItemAt(comboTable.getSelectedIndex()).toString(),
                            comboColumn.getItemAt(comboColumn.getSelectedIndex()).toString(),
                            comboQuery.getItemAt(comboQuery.getSelectedIndex()).toString(),
                            textField.getText()
                    );

            txtArea.setText( textQuery );
        });

        this.setJMenuBar(jMenuBar);
        this.setLayout(new BorderLayout());
        this.add(txtArea);
        this.add(jPanel, BorderLayout.SOUTH);
        this.add(jPanelCombo, BorderLayout.NORTH);
    }


}
