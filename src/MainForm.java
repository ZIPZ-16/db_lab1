import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame
{
    private JButton sendBtn;
    private JTextArea text1;
    private JPanel rootPanel;
    private JComboBox comboBox1;

    public MainForm()
    {
        add(rootPanel);
        setTitle("LAB1");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        sendBtn.addActionListener(this::sendClick);
    }

    private void sendClick(ActionEvent event)
    {
        text1.setText("Clicked");
    }
}
