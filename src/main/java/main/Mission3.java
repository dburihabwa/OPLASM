package main;

import instrumentation.Julia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class Mission3 {
	public static void main(String[] args) throws IOException {
		String path = "src/main/data/Mandelbrot.class";
		FileInputStream fis = new FileInputStream(path);
		int length = fis.available();
		byte[] input = new byte[length];
		fis.read(input);
		fis.close();

		ClassReader reader = new ClassReader(input);
		ClassWriter writer = new ClassWriter(reader, 0);

		ClassVisitor julia = new Julia(writer);
		reader.accept(julia, 0);

		FileOutputStream fout = new FileOutputStream("Mandelbrot.class");
		byte[] data = writer.toByteArray();
		fout.write(data);
		fout.close();
	}
}
