package finder;

import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FinderApplikation {

  /**
   * Main klasse der SnifferAPP.
   * 
   */
  public static void main(String[] args) {

    String[] steps = new String[99999];

    SteamKeyFinder guiFinder = new SteamKeyFinder();

    // Erzeuge Fenster
    JFrame frame = new JFrame("SteamKeyFinder by JDAIN");

    // Applikation beenden, wenn das Fenster geschlossen wird.
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });

    // Erzeuge Panel, füge es dem Fenster hinzu.
    JPanel panel = new JPanel();

    frame.add(panel);

    // Erzeuge 8x20 Textfeld mit Umbruch, großer Schrift.
    JTextArea textfeld = new JTextArea(8, 20);
    textfeld.setFont(textfeld.getFont().deriveFont(textfeld.getFont().getSize() * 2.0f));
    textfeld.setLineWrap(true);
    textfeld.setWrapStyleWord(true);

    // Erzeuge ScrollPane um Textfeld und füge es dem Panel hinzu
    JScrollPane scrollpane = new JScrollPane(textfeld);
    panel.add(scrollpane);

    // Erzeuge SteamKeyFinder-Button, binde Action, füge zum Panel hinzu
    JButton sniffButton = new JButton("find Steamkeys");
    sniffButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        String before = textfeld.getText();
        steps[SteamKeyFinder.useCounter] = before;
        String after = guiFinder.findSteamKeys(before);
        textfeld.setText(after);

      }
    });
    panel.add(sniffButton);

    // Erzeuge archiSniff-Button, binde Action, füge zum Panel hinzu
    JButton archiSniffButton = new JButton(" Archi !redeem");
    archiSniffButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        String before = textfeld.getText();
        steps[SteamKeyFinder.useCounter] = before;
        String after = guiFinder.findSteamKeys(before);
        textfeld.setText("!redeem " + after);
      }
    });

    // Erzeuge Revert-Button, binde Action, füge zum Panel hinzu
    JButton copyToClipboard = new JButton(" copy  ");
    copyToClipboard.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        String before = textfeld.getText();
        StringSelection stringSelection = new StringSelection(before);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);

      }
    });

    panel.add(copyToClipboard);

    // Erzeuge Revert-Button, binde Action, füge zum Panel hinzu
    JButton revert = new JButton("  revert Step  ");
    revert.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (SteamKeyFinder.useCounter != 0) {

          SteamKeyFinder.useCounter--;
          textfeld.setText(steps[SteamKeyFinder.useCounter]);

        }

      }
    });

    panel.add(revert);

    // Layout ergänzen (optional)
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(scrollpane)
        .addGroup(layout.createParallelGroup(Alignment.CENTER)

            .addComponent(sniffButton).addComponent(archiSniffButton).addComponent(revert)
            .addComponent(copyToClipboard)));
    layout.setVerticalGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(scrollpane)
        .addGroup(layout.createSequentialGroup().addComponent(sniffButton)
            .addComponent(archiSniffButton).addComponent(revert).addComponent(copyToClipboard)));

    // Optimiere Frame und mache sichtbar
    frame.pack();
    frame.setVisible(true);
  }
}
