import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {

    private JTextField txtNama;
    private JTextField txtNim;
    private JLabel lblOutput;
    private JButton btnProses;
    private JButton btnReset;

    public MainFrame() {
        setTitle("Eksplorasi GUI PBO - F1D02510013");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        initComponents();
    }

    private void initComponents() {
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        txtNama = new JTextField();
        txtNim = new JTextField();
        lblOutput = new JLabel("Status: Silakan isi data.");

        panelForm.add(new JLabel("Nama Mahasiswa:"));
        panelForm.add(txtNama);
        panelForm.add(new JLabel("NIM:"));
        panelForm.add(txtNim);
        panelForm.add(new JLabel("Keterangan:"));
        panelForm.add(lblOutput);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnProses = new JButton("Tampilkan");
        btnReset = new JButton("Reset");

        panelTombol.add(btnProses);
        panelTombol.add(btnReset);

        btnProses.addActionListener(this);
        btnReset.addActionListener(this);

        btnProses.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnProses.setToolTipText("Klik untuk memproses data mahasiswa");
            }
        });

        add(panelForm, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnProses) {
            String nama = txtNama.getText().trim();
            String nim = txtNim.getText().trim();

            if (nama.isEmpty() || nim.isEmpty()) {
                lblOutput.setText("Nama dan NIM wajib diisi!");
            } else {
                lblOutput.setText(nama + " (" + nim + ")");
            }
        } else if (e.getSource() == btnReset) {
            txtNama.setText("");
            txtNim.setText("");
            lblOutput.setText("Status: Silakan isi data.");
        }
    }
}