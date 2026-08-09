import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CurrencyConverter extends JFrame implements ActionListener {
    JTextField amt, res;
    JComboBox<String> from, to;
    JButton btn;
    CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Amount:"));
        amt = new JTextField();
        add(amt);
        add(new JLabel("From:"));
        String[] c = {"USD", "EUR", "INR", "GBP"};
        from = new JComboBox<>(c);
        add(from);
        add(new JLabel("To:"));
        to = new JComboBox<>(c);
        add(to);
        add(new JLabel("Result:"));
        res = new JTextField();
        res.setEditable(false);
        add(res);
        btn = new JButton("Convert");
        btn.addActionListener(this);
        add(btn);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(amt.getText());
            String f = (String) from.getSelectedItem();
            String t = (String) to.getSelectedItem();
            double rf = 1, rt = 1;
            if (f.equals("EUR")) rf = 0.865;
            else if (f.equals("INR")) rf = 88.0;
            else if (f.equals("GBP")) rf = 0.75;
            if (t.equals("EUR")) rt = 0.865;
            else if (t.equals("INR")) rt = 88.0;
            else if (t.equals("GBP")) rt = 0.75;
            double ans = a * rt / rf;
            res.setText(String.format("%.2f " + t, ans));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this, "Enter a valid amount");
        }
    }
    public static void main(String[] args) {
        new CurrencyConverter();
    }
}