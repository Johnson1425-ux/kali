
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Counter extends Frame {
    private Label lblCount;
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;

    public Counter() {
        setLayout(new FlowLayout());
        lblCount = new Label("Counter");
        add(lblCount);
        tfCount = new TextField(count + "", 10);
        tfCount.setEditable(false);
        add(tfCount);
        btnCount = new Button("Count");
        add(btnCount);
        class BtnCountLIistener {
            BtnCountListener Listener = new BtnCountListener();

            public void actionPerformed(ActionEvent e) {
                btnCount.addActionListener(Listener);
                setSize(300, 100);
                setVisible(true);
            }

            public static void main (String[] args) {
                Counter app = new Counter();
            }

            private class BtnCountListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ++count;

                    tfCount.setText(count + "");
                }
            }
        }
    }
}