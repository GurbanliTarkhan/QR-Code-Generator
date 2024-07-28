package com.tarkhan.qrcode.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.tarkhan.qrcode.model.student.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class QRCodeGenerator {

    @Value("${qrcode.path}")
    private String qrCodePath;

    public void generateQRCode(Student student) throws IOException, WriterException {
        Path pathToDirectory = FileSystems.getDefault().getPath(qrCodePath);
        if (Files.notExists(pathToDirectory)) {
            Files.createDirectories(pathToDirectory);
        }
        String qrCodeName = qrCodePath
                + student.getFirstName()
                + student.getId()
                + "-QRCODE.png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: " + student.getId()
                        + "\n"
                        + "Firstname: " + student.getFirstName()
                        + "\n"
                        + "Lastname: " + student.getLastName()
                        + "\n"
                        + "Email: " + student.getEmail()
                        + "\n"
                        + "Mobile: " + student.getMobile(),
                BarcodeFormat.QR_CODE, 400, 400
        );

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
