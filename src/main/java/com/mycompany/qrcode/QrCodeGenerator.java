package com.mycompany.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author renato
 */
public class QrCodeGenerator {

    //Ajuste de largura e altura da imagem do QrCode
    int width = 200;
    int heidth = 200;

    public BufferedImage gerarQrCode(String input) {

        try {

            BitMatrix QrCode = new MultiFormatWriter().encode(input, BarcodeFormat.QR_CODE, width, heidth);
            return MatrixToImageWriter.toBufferedImage(QrCode);

        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Exibe o QR Code em uma janela.
    public void exibirQrcode(BufferedImage qrCode) {

        // Cria uma nova janela Swing com título "QrCode"
        JFrame frame = new JFrame("QrCode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria um painel personalizado que irá exibir a imagem do QR Code
        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                // Desenha a imagem do QR Code no painel
                g.drawImage(qrCode, 0, 0, null);
            }

        };
        // Define as dimensões preferenciais do painel com base na largura e altura da imagem
        panel.setPreferredSize(new Dimension(qrCode.getWidth(), qrCode.getHeight()));
        
        // Adiciona o painel à janela
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);// Centraliza a janela na tela
        frame.setVisible(true);// Torna a janela visível

    }

}
