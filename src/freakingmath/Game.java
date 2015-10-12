package freakingmath;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class Game extends javax.swing.JFrame {

    Container bg = getContentPane();
    GameOver over;

    public static final int EASY = 1;
    public static final int NORMAL = 2;
    public static final int HARD = 3;
    public static final int ASIAN = 4;
    public static final int CONG = 1;
    public static final int TRU = 2;
    public static final int NHAN = 3;

    int mode = EASY;     //1-easy ; 2-normal; 3-hard; 4-asian;
    int thoiGian = 700;
    int doKho = 2;
    int score = 0;
    int best = 0;
    int value;
    int hienThi;
    //timer thanh thoi gian
    Timer time = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (value > 0) {
                value -= 10;
                bar.setValue(value);
            } else {
                time.stop();
                gameOver();
            }
        }
    });
    //timer do kho
    Timer tmDokho = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            doKho += 1;
        }
    });
    PhepTinh pheptinh = new PhepTinh();

    public Game(int best, int mode) {
        setUndecorated(true);
        setSize(400, 600);
        initComponents();
        centreWindow(this);
        pheptinh.taoPhepTinh(CONG, doKho);
        hienThiPhepTinh();
        setBgColor();
        this.best = best;
        this.mode = mode;
        //set thoi gian theo mode
        if (mode == EASY) {
            thoiGian = 1500;
        } else if (mode == NORMAL || mode == HARD || mode == ASIAN) {
            thoiGian = 700;
        }
    }

    private Game() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void hienThiPhepTinh() {
        if (pheptinh.getPhepTinh() == CONG) {
            lblPhepTinh.setText(pheptinh.getA() + "+" + pheptinh.getB());
        } else if (pheptinh.getPhepTinh() == TRU) {
            lblPhepTinh.setText(pheptinh.getA() + "-" + pheptinh.getB());
        } else if (pheptinh.getPhepTinh() == NHAN) {
            lblPhepTinh.setText(pheptinh.getA() + "x" + pheptinh.getB());
        }
        hienThi = pheptinh.getHienThi();
        if ((hienThi == 1) || (hienThi == 2)) {
            lblKQ.setText("=" + pheptinh.getKq());
        } else if (hienThi == 3) {
            lblKQ.setText("=" + pheptinh.getKqFake1());
        } else if (hienThi == 4) {
            lblKQ.setText("=" + pheptinh.getKqFake2());
        }
    }

    void chayTimebar() {
        value = thoiGian;
        bar.setMaximum(value);
        bar.setValue(value);
        time.start();
        bar.setValue(value);
    }

    void chayDokho() {
        tmDokho.start();
        if (mode == EASY) {
            tmDokho.setDelay(tmDokho.getDelay() + 400);
        } else if (mode == NORMAL) {
            tmDokho.setDelay(tmDokho.getDelay() + 600);
        } else if (mode == HARD) {
            tmDokho.setDelay(tmDokho.getDelay() + 1000);
        } else if (mode == ASIAN) {
            tmDokho.setDelay(tmDokho.getDelay() + 1500);
        }
    }

    void setBest() {
        if (score > best) {
            best = score;
        }
    }

    void gameOver() {
        time.stop();
        over = new GameOver(score, best, mode);
        over.setVisible(true);
        setEnabled(false);
        dispose();
    }

    void setBgColor() {
        Color mTim = new Color(144, 67, 174);
        Color mVang = new Color(255, 193, 0);
        Color mCam = new Color(255, 93, 2);
        Color mDo = new Color(239, 24, 30);
        Color mLam = new Color(0, 129, 206);
        Color mLuc = new Color(0, 144, 32);
        Color mXam1 = new Color(152, 152, 152);
        Color mXam2 = new Color(49, 72, 92);
        Color mNau1 = new Color(133, 105, 69);
        Color mNau2 = new Color(120, 56, 47);
        Random rand = new Random();
        int mau = rand.nextInt(10) + 1;
        if (mau == 1) {
            bg.setBackground(mTim);
        } else if (mau == 2) {
            bg.setBackground(mVang);
        } else if (mau == 3) {
            bg.setBackground(mCam);
        } else if (mau == 4) {
            bg.setBackground(mDo);
        } else if (mau == 5) {
            bg.setBackground(mLam);
        } else if (mau == 6) {
            bg.setBackground(mLuc);
        } else if (mau == 7) {
            bg.setBackground(mXam1);
        } else if (mau == 8) {
            bg.setBackground(mXam2);
        } else if (mau == 9) {
            bg.setBackground(mNau1);
        } else if (mau == 10) {
            bg.setBackground(mNau2);
        }
    }

    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2.0D);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2.0D);
        frame.setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bar = new javax.swing.JProgressBar();
        btnSai = new javax.swing.JButton();
        btnDung = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        lblKQ = new javax.swing.JLabel();
        lblPhepTinh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        btnSai.setBackground(new java.awt.Color(255, 255, 255));
        btnSai.setFont(btnSai.getFont().deriveFont(btnSai.getFont().getSize()+78f));
        btnSai.setForeground(new java.awt.Color(214, 72, 58));
        btnSai.setText("✖");
        btnSai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaiActionPerformed(evt);
            }
        });

        btnDung.setBackground(new java.awt.Color(255, 255, 255));
        btnDung.setFont(btnDung.getFont().deriveFont(btnDung.getFont().getSize()+78f));
        btnDung.setForeground(new java.awt.Color(47, 145, 207));
        btnDung.setText("✔");
        btnDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDungActionPerformed(evt);
            }
        });

        lblScore.setFont(new java.awt.Font(".VnAvant", 0, 24)); // NOI18N
        lblScore.setForeground(new java.awt.Color(255, 255, 255));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScore.setText("0");

        lblKQ.setFont(new java.awt.Font(".VnAvant", 0, 100)); // NOI18N
        lblKQ.setForeground(new java.awt.Color(255, 255, 255));
        lblKQ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKQ.setText("=2");

        lblPhepTinh.setFont(new java.awt.Font(".VnAvant", 0, 100)); // NOI18N
        lblPhepTinh.setForeground(new java.awt.Color(255, 255, 255));
        lblPhepTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhepTinh.setText("1+1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblKQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPhepTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDung, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(btnSai, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lblPhepTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSai, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDung, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
void taoPhepTinh() {

        chayTimebar();
        chayDokho();
        score += 1;
        setBest();
        lblScore.setText(String.valueOf(score));
        if (mode == EASY || mode == NORMAL) {   // easy, normal - phep cong
            pheptinh.taoPhepTinh(CONG, doKho);
        } else if (mode == HARD) {         // hard - phep cong, tru
            Random rand = new Random();
            int phep = rand.nextInt(2) + 1;
            if (phep == 1) {
                pheptinh.taoPhepTinh(CONG, doKho);
            } else {
                pheptinh.taoPhepTinh(TRU, doKho);
            }
        } else if (mode == ASIAN) {         // asian = phep cong, tru, nhan
            Random rand = new Random();
            int phep = rand.nextInt(4) + 1;
            if (phep == 1 || phep == 2) {
                pheptinh.taoPhepTinh(CONG, doKho);
            } else if (phep == 3) {
                pheptinh.taoPhepTinh(TRU, doKho);
            } else if (phep == 4) {
                pheptinh.taoPhepTinh(NHAN, doKho);
            }
        }
    }
    private void btnDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDungActionPerformed
        if ((hienThi == 1) || (hienThi == 2)) {
            taoPhepTinh();
            hienThiPhepTinh();
            setBgColor();
        } else {
            gameOver();
        }
    }//GEN-LAST:event_btnDungActionPerformed

    private void btnSaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaiActionPerformed
        if ((hienThi == 3) || (hienThi == 4)) {
            taoPhepTinh();
            hienThiPhepTinh();
            setBgColor();
        } else {
            gameOver();
        }
    }//GEN-LAST:event_btnSaiActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bar;
    private javax.swing.JButton btnDung;
    private javax.swing.JButton btnSai;
    private javax.swing.JLabel lblKQ;
    private javax.swing.JLabel lblPhepTinh;
    private javax.swing.JLabel lblScore;
    // End of variables declaration//GEN-END:variables
}
