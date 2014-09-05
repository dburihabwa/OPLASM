package instrumentation;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

public class ParameterAdapter extends ClassVisitor {

	public ParameterAdapter(ClassWriter writer) {
		super(Opcodes.ASM5, writer);
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc,
			String signature, Object value) {
		if (name.equalsIgnoreCase("MAX_ITER")) {
			value = new Integer(570);
		} else if (name.equalsIgnoreCase("ZOOM")) {
			value = new Double(150.0);
		}
		return super.visitField(access, name, desc, signature, value);
	}
}
