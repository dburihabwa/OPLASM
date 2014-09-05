package instrumentation;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class BugFix extends ParameterAdapter {

	public BugFix(ClassWriter writer) {
		super(writer);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		MethodVisitor methodVisitor = super.visitMethod(access, name, desc,
				signature, exceptions);
		if (name.equalsIgnoreCase("nextY")) {
			methodVisitor = new BugFixMethodVisitor(methodVisitor);
		}

		return methodVisitor;
	}

	@Override
	public void visitSource(String arg0, String arg1) {
		// TODO Auto-generated method stub
		super.visitSource(arg0, arg1);
	}

}
