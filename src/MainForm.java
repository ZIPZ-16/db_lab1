import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame
{
    private JButton sendBtn;
    private JTextArea textQuery;
    private JPanel rootPanel;
    private JComboBox comboField;
    private JComboBox comboTable;
    private JComboBox comboQuery;

    public MainForm()
    {
        initForm();
    }

    private void sendClick(ActionEvent ev)
    {
        textQuery.setText("Clicked");
    }

    private void initForm()
    {
        add(rootPanel);
        setTitle("LAB1");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        sendBtn.addActionListener(this::sendClick);
    }
}
