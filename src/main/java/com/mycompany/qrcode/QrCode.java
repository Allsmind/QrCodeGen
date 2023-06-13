package com.mycompany.qrcode;

import java.awt.image.BufferedImage;



/** 
*
 * @author renato
 */
public class QrCode {

    public static void main(String[] args) throws Exception {
        
        QrCodeGenerator genQrCode = new QrCodeGenerator();
        
        BufferedImage QrCodeImg = genQrCode.gerarQrCode("HelloWord");
        genQrCode.exibirQrcode(QrCodeImg);
        
        
    }
}
