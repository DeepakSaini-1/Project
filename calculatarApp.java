import java.util.ArrayList;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class calculatarApp extends Frame implements ActionListener{
    String s,s2;
    char ch;
    double num1 = 0, num2 = 0, num3 = 1, p = 0;
    ArrayList<Double> listn = new ArrayList<>();
    ArrayList<Character> lists = new ArrayList<>();

    // for user interface
    Button nc, np, nl,ndi, n1, n2, n3, na, n4, n5, n6, ns, n7, n8, n9, nm, n, n0, nd, ne;
    TextField enter, ans;

    calculatarApp(){

        enter = new TextField();
        ans = new TextField();
        ans.setEditable(false);
        nc = new Button("C");
        np = new Button("%");
        nl = new Button("<=");
        ndi = new Button("/");
        n1 = new Button("1");
        n2 = new Button("2");
        n3 = new Button("3");
        na = new Button("+");
        n4 = new Button("4");
        n5 = new Button("5");
        n6 = new Button("6");
        ns = new Button("-");
        n7 = new Button("7");
        n8 = new Button("8");
        n9 = new Button("9");
        nm = new Button("*");
        n = new Button("00");
        n0 = new Button("0");
        nd = new Button(".");
        ne = new Button("=");

        // setting position of cmponents in frame

        enter.setBounds(99, 50, 200, 50);
        ans.setBounds(99, 130, 200, 45);
        nc.setBounds(0, 200, 75, 60);
        np.setBounds(75, 200, 75, 60);
        nl.setBounds(150, 200, 75, 60);
        ndi.setBounds(225, 200, 75, 60);
        n1.setBounds(0, 260, 75, 60);
        n2.setBounds(75, 260, 75, 60);
        n3.setBounds(150, 260, 75, 60);
        na.setBounds(225, 380, 75, 60);
        n4.setBounds(0, 320, 75, 60);
        n5.setBounds(75, 320, 75, 60);
        n6.setBounds(150, 320, 75, 60);
        ns.setBounds(225, 320, 75, 60);
        n7.setBounds(0, 380, 75, 60);
        n8.setBounds(75, 380, 75, 60);
        n9.setBounds(150, 380, 75, 60);
        nm.setBounds(225, 260, 75, 60);
        n.setBounds(0, 440, 75, 60);
        n0.setBounds(75, 440, 75, 60);
        nd.setBounds(150, 440, 75, 60);
        ne.setBounds(225, 440, 75, 60);
        // 

        // adding components to frame

        add(nc);
        add(np);
        add(nl);
        add(ndi);
        add(n1);
        add(n2);
        add(n3);
        add(na);
        add(n4);
        add(n5);
        add(n6);
        add(ns);
        add(n7);
        add(n8);
        add(n9);
        add(nm);
        add(n);
        add(n0);
        add(nd);
        add(ne);
        add(enter);
        add(ans);

        // Adding action listener

        nc.addActionListener(this);
        np.addActionListener(this);
        nl.addActionListener(this);
        ndi.addActionListener(this);
        n1.addActionListener(this);
        n2.addActionListener(this);
        n3.addActionListener(this);
        na.addActionListener(this);
        n4.addActionListener(this);
        n5.addActionListener(this);
        n6.addActionListener(this);
        ns.addActionListener(this);
        n7.addActionListener(this);
        n8.addActionListener(this);
        n9.addActionListener(this);
        nm.addActionListener(this);
        n.addActionListener(this);
        n0.addActionListener(this);
        nd.addActionListener(this);
        ne.addActionListener(this);

        // Setting size, layout and visibility of frame

        setSize(300, 500);
        setTitle("Calculater");
        setLayout(null);
        setVisible(true);

    }

    // defining the actioPerformed method to generate an event on button

    public void actionPerformed(ActionEvent e) {
        s=enter.getText();
        if (e.getSource( ) == nc) {
            enter.setText(null);
            ans.setText(null);
        }
        else if (e.getSource() == np) {
            // enter.setText(s+"%");
        } else if (e.getSource() == nl) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(s.length() - 1);
            enter.setText(sb.toString());
        } else if (e.getSource() == ndi) {
            enter.setText(s+"/");
        } else if (e.getSource() == n1) {
            enter.setText(s+"1");
        } else if (e.getSource() == n2) {
            enter.setText(s+"2");
        } else if (e.getSource() == n3) {
            enter.setText(s+"3");
        } else if (e.getSource() == na) {
            enter.setText(s+"+");
        } else if (e.getSource() == n4) {
            enter.setText(s+"4");
        } else if (e.getSource() == n5) {
            enter.setText(s+"5");
        } else if (e.getSource() == n6) {
            enter.setText(s+"6");
        } else if (e.getSource() == ns) {
            enter.setText(s+"-");
        } else if (e.getSource() == n7) {
            enter.setText(s+"7");
        } else if (e.getSource() == n8) {
            enter.setText(s+"8");
        } else if (e.getSource() == n9) {
            enter.setText(s+"9");
        } else if (e.getSource() == nm) {
            enter.setText(s+"*");
        } else if (e.getSource() == n) {
            enter.setText(s+"00");
        } else if (e.getSource() == n0) {
            enter.setText(s+"0");
        } else if (e.getSource() == nd) {
            enter.setText(s+".");
        } else if (e.getSource() == ne) {
            string_to_char(s);
            int i = (int) num1;
            if (num1 == i)
                s = String.valueOf(i);
            else
                s = String.valueOf(num1);
            ans.setText(s);
            listn.clear();
            lists.clear();
            num1 = num2 = p = 0;
            num3 = 1;
        }
    }

    void string_to_char(String s) {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 && c[i] == '-') || c[i] == '.') {
                if (c[i] == '.') {
                    p = 10;
                    continue;
                } else {
                    num3 = -1;
                    continue;
                }
            }
            if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/') {
                num2 *= num3;
                if (p != 0)
                    num2 /= p / 10;
                listn.add(num2);
                lists.add(c[i]);
                p = num2 = 0;
                num3 = 1;
            } else {
                char[] a = { c[i] };
                String s3 = new String(a);
                double d = Double.parseDouble(s3);
                num2 = num2 * 10 + d;
                p *= 10;
            }
        }
        listn.add(num2);
        pro();
    }

    void pro() {
        double n;
        num1 = listn.get(0);
        num3 = num1;
        for (int i = 0; i < lists.size(); i++) {
            ch = lists.get(i);
            num2 = listn.get(i + 1);
            if (ch == '+') {
                num1 = num1 + num2;
                num3 = num2;
            }
            if (ch == '-') {
                num1 = num1 - num2;
                num3 = num2;
            }
            if (ch == '*') {
                n = num2 * num3;
                num1 = num1 + n - num3;
                num3 = n;
            }
            if (ch == '/') {
                n = num3 / num2;
                num1 = num1 + n - num3;
                num3 = n;
            }
        }
    }
    public static void main(String[] args) {
        new calculatarApp();
    }
}
