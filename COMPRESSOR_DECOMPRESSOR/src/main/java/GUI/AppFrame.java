/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setTitle("Compressor and Decompressor");
        
        compressButton = new JButton("Select file to Compress");
        compressButton.setBounds(100, 100, 200, 30); //Set dimension of button
        compressButton.setFocusable(false); //Stops bordering text
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select file to Decompress");
        decompressButton.setBounds(430, 100, 200, 30); //Set dimension of button
        decompressButton.setFocusable(false); //Stops bordering text
        decompressButton.addActionListener(this);
        
        this.add(compressButton); //Add button inside frame
        this.add(decompressButton); //Add button inside frame
        this.setLayout(null); // Stops from distortion
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black); //Frame will be in center of screen
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
