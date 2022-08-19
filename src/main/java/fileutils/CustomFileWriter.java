package fileutils;

import date.Datee;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.time.LocalDate;
import java.util.*;

public class CustomFileWriter {
    private static byte[] convertObjectToBytes(List<Datee> obj) throws IOException {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(obj);
            return boas.toByteArray();
        }
    }
    public static boolean write(List<Datee> dateeList, String path) {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw")) {
            FileChannel fileChannel = randomAccessFile.getChannel();
            byte[] bytes = convertObjectToBytes(dateeList);
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            fileChannel.write(byteBuffer);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
