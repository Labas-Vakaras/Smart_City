package labasvakaras.smartcity.qrutils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;

/**
 *
 * @author Vasilis Naskos
 */
public class QRGenerator {

    /**
     * The base URL path where the platform is running
     * Used on creating QR links
     */
    public final static String PLATFORM_BASE_URL = "http://localhost:8082";
    
    /**
     * QR images are rectangular
     * this size represents the rectangle dimension
     */
    protected final static int QR_SIZE = 125;
    
    protected final String cityItemId;
    
    public QRGenerator(String cityItemId) {
        this.cityItemId = cityItemId;
    }
    
    /**
     * Generates QR from the given ID
     * 
     * @return Returns the temp path of the generated QR image
     * @throws Exception 
     */
    public String generate() throws Exception {
        String contentText = PLATFORM_BASE_URL + "/item/report?id=" + cityItemId;
        
        File qrImagePath = File.createTempFile("smaci", ".png");
        qrImagePath.deleteOnExit();
        
        String filePath = qrImagePath.getAbsolutePath();
        String fileType = "png";
        File qrFile = new File(filePath);
        createQRImage(qrFile, contentText, QR_SIZE, fileType);
        System.out.println("DONE");
        
        return filePath;
    }

    private static void createQRImage(File qrFile, String qrCodeText, int size,
            String fileType) throws WriterException, IOException {
        // Create the ByteMatrix for the QR-Code that encodes the given String
        Hashtable hintMap = new Hashtable();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText,
                BarcodeFormat.QR_CODE, size, size, hintMap);
        // Make the BufferedImage that are to hold the QRCode
        int matrixWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth,
                BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        // Paint and save the image using the ByteMatrix
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        ImageIO.write(image, fileType, qrFile);
    }
}
