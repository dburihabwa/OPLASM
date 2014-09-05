package main;

import instrumentation.BugFix;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class Mission2 {
	public static void main(String[] args) throws IOException {
		String path = "src/main/data/Mandelbrot.class";
		FileInputStream fis = new FileInputStream(path);
		int length = fis.available();
		byte[] input = new byte[length];
		int bytesRead = fis.read(input);
		if (bytesRead != length) {
			if (fis != null) {
				fis.close();
			}
			throw new IOException(
					"Number of bytes read does not match length of file");
		}
		fis.close();

		ClassReader reader = new ClassReader(input);
		ClassWriter writer = new ClassWriter(reader, 0);

		ClassVisitor bugfix = new BugFix(writer);
		reader.accept(bugfix, 0);

		byte[] output = writer.toByteArray();
		System.out.println("(" + input.length + ")");
		System.out.println("(" + output.length + ")");

		FileOutputStream fout = new FileOutputStream(
				"/home/dorian/Mandelbrot.class");
		byte[] data = writer.toByteArray();
		fout.write(data);
		fout.close();
	}
}
