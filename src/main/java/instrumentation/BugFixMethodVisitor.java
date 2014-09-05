package instrumentation;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class BugFixMethodVisitor extends MethodVisitor {
	public BugFixMethodVisitor(MethodVisitor visitor) {
		super(Opcodes.ASM5, visitor);
	}

	@Override
	public void visitLdcInsn(Object cst) {
		Object value = null;
		if (cst instanceof Double && ((Double) cst) == 3.0) {
			value = new Double(2.0);
		} else {
			value = cst;
		}
		super.visitLdcInsn(value);
	}
}
